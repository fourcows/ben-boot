package ben.system.service;

import ben.system.dto.LabelDTO;
import ben.system.dto.NoteDTO;
import ben.system.dto.NoteLabelDTO;
import ben.system.entity.Note;
import ben.system.entity.NoteLabel;
import ben.system.mapper.NoteMapper;
import ben.system.params.LabelParam;
import ben.system.params.NoteLabelParam;
import ben.system.params.NoteQueryIdsParam;
import ben.system.vo.note.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteService extends ServiceImpl<NoteMapper, Note> {

    private final LabelService labelService;
    private final NoteLabelService noteLabelService;

    @Transactional(rollbackFor = Exception.class)
    public NoteDetailResVo add(NoteCreateReqVo vo) {
        Note note = vo.toNote();
        this.save(note);
        if (CollectionUtils.isEmpty(vo.getLabelIds())) {
            return this.detail(note.getNoteId());
        }
        List<NoteLabel> noteLabels = vo.getLabelIds().stream().map(item -> NoteLabel.builder().noteId(note.getNoteId()).labelId(item).build()).collect(Collectors.toList());
        noteLabelService.saveBatch(noteLabels);
        return this.detail(note.getNoteId());
    }

    @Transactional(rollbackFor = Exception.class)
    public NoteDetailResVo edit(NoteUpdateReqVo vo) {
        Note note = vo.toNote();
        this.updateById(note);
        noteLabelService.remove(new LambdaQueryWrapper<NoteLabel>().eq(NoteLabel::getNoteId, vo.getNoteId()));
        if (CollectionUtils.isEmpty(vo.getLabelIds())) {
            return this.detail(note.getNoteId());
        }
        List<NoteLabel> noteLabels = vo.getLabelIds().stream().map(item -> NoteLabel.builder().noteId(note.getNoteId()).labelId(item).build()).collect(Collectors.toList());
        noteLabelService.saveBatch(noteLabels);
        return this.detail(note.getNoteId());
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> ids) {
        this.removeByIds(ids);
        noteLabelService.remove(new LambdaQueryWrapper<NoteLabel>().in(NoteLabel::getNoteId, ids));
    }

    public List<NoteListResVo> queryList(NoteListReqVo vo) {
        if (vo.notValid()) {
            return new ArrayList<>();
        }
        List<Integer> noteIds = this.baseMapper.queryNoteIds(new QueryWrapper<NoteQueryIdsParam>()
                .in(!CollectionUtils.isEmpty(vo.getLabelIds()), "note_label.label_id", vo.getLabelIds())
                .like(StringUtils.hasText(vo.getContent()), "note.content", vo.getContent())
        );
        if (CollectionUtils.isEmpty(noteIds)) {
            return new ArrayList<>();
        }
        List<NoteDTO> noteDTOS = toDtoList(this.listByIds(noteIds));
        return noteDTOS.stream().map(NoteListResVo::toVo).collect(Collectors.toList());
    }

    public IPage<NoteListResVo> queryPage(NotePageReqVo vo) {
        vo.validPage();
        IPage<Integer> pageData = this.baseMapper.queryNoteIdsByPage(new QueryWrapper<NoteQueryIdsParam>()
                        .in(!CollectionUtils.isEmpty(vo.getLabelIds()), "note_label.label_id", vo.getLabelIds())
                        .like(StringUtils.hasText(vo.getContent()), "note.content", vo.getContent())
                        .eq("note.is_deleted", 0)
                ,
                new Page<>(vo.getPage().getNum(), vo.getPage().getSize())
        );
        if (pageData.getTotal() == 0) {
            return new Page<NoteListResVo>(vo.getPage().getNum(), vo.getPage().getSize()).setRecords(new ArrayList<>());
        }
        List<NoteDTO> noteDTOS = toDtoList(this.listByIds(pageData.getRecords()));
        List<NoteListResVo> noteVOs = noteDTOS.stream().map(NoteListResVo::toVo).sorted(Comparator.comparing(NoteListResVo::getUpdateTime).reversed()).collect(Collectors.toList());
        return new Page<NoteListResVo>(pageData.getCurrent(), pageData.getSize(), pageData.getTotal()).setRecords(noteVOs);
    }

    private List<NoteDTO> toDtoList(List<Note> notes) {
        if (CollectionUtils.isEmpty(notes)) {
            return new ArrayList<>();
        }
        List<Integer> noteIds = notes.stream().map(Note::getNoteId).distinct().collect(Collectors.toList());
        List<NoteLabelDTO> noteLabelDTOS = noteLabelService.queryList(NoteLabelParam.builder().noteIds(noteIds).build());
        List<Integer> labelIds = noteLabelDTOS.stream().map(NoteLabelDTO::getLabelId).distinct().collect(Collectors.toList());
        Map<Integer, List<Integer>> noteLabelMap = noteLabelDTOS.stream().collect(Collectors.groupingBy(NoteLabelDTO::getNoteId, Collectors.mapping(NoteLabelDTO::getLabelId, Collectors.toList())));
        List<LabelDTO> labelDTOS = labelService.queryList(LabelParam.builder().labelIds(labelIds).build());
        Map<Integer, LabelDTO> labelMap = labelDTOS.stream().collect(Collectors.toMap(LabelDTO::getLabelId, item -> item, (v1, v2) -> v1));
        return notes.stream().map(note -> {
            List<LabelDTO> labelDTOs = noteLabelMap.getOrDefault(note.getNoteId(), new ArrayList<>()).stream().map(labelMap::get).collect(Collectors.toList());
            return NoteDTO.builder().noteId(note.getNoteId()).content(note.getContent()).updateTime(note.getUpdateTime()).labels(labelDTOs).build();
        }).collect(Collectors.toList());
    }

    public NoteDetailResVo detail(int id) {
        Note note = this.getById(id);
        if (note == null) {
            return null;
        }
        return NoteDetailResVo.toVo(toDtoList(Collections.singletonList(note)).get(0));
    }

}
