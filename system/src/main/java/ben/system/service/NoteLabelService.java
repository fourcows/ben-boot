package ben.system.service;

import ben.common.web.service.BaseService;
import ben.system.dto.NoteLabelDTO;
import ben.system.entity.NoteLabel;
import ben.system.mapper.NoteLabelMapper;
import ben.system.params.NoteLabelParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteLabelService extends BaseService<NoteLabelMapper, NoteLabel> {

    public List<NoteLabelDTO> queryList(NoteLabelParam param) {
        if (param.notValid()) {
            return new ArrayList<>();
        }
        List<NoteLabel> noteLabels = this.list(new LambdaQueryWrapper<NoteLabel>()
                .in(!CollectionUtils.isEmpty(param.getNoteIds()), NoteLabel::getNoteId, param.getNoteIds())
                .in(!CollectionUtils.isEmpty(param.getLabelIds()), NoteLabel::getLabelId, param.getLabelIds()));
        return noteLabels.stream().map(NoteLabelDTO::create).collect(Collectors.toList());
    }

}
