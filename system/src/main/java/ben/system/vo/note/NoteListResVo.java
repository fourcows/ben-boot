package ben.system.vo.note;

import ben.system.dto.NoteDTO;
import ben.system.entity.Note;
import ben.system.vo.label.LabelListResVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteListResVo {
    private Integer noteId;
    private String content;
    private List<LabelListResVo> labels;

    //todo
    public static List<NoteListResVo> toVo(List<Note> entities) {
        return new ArrayList<>();
    }

    public static Page<NoteListResVo> toPage(IPage<Note> page) {
        return new Page<NoteListResVo>(page.getCurrent(), page.getSize(), page.getTotal()).setRecords(
                NoteListResVo.toVo(page.getRecords())
        );
    }

    public static NoteListResVo toVo(NoteDTO noteDTO) {
        List<LabelListResVo> labelVOs = noteDTO.getLabels().stream().map(LabelListResVo::toVO).collect(Collectors.toList());
        return NoteListResVo.builder()
                .noteId(noteDTO.getNoteId())
                .content(noteDTO.getContent())
                .labels(labelVOs)
                .build();
    }

}
