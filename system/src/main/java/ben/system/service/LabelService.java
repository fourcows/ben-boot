package ben.system.service;

import ben.common.web.service.BaseService;
import ben.system.dto.LabelDTO;
import ben.system.entity.Label;
import ben.system.mapper.LabelMapper;
import ben.system.params.LabelParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelService extends BaseService<LabelMapper, Label> {
    public List<LabelDTO> queryList(LabelParam param) {
        if (param.notValid()) {
            return new ArrayList<>();
        }
        List<Label> labels = this.list(new LambdaQueryWrapper<Label>().in(Label::getLabelId, param.getLabelIds()));
        return labels.stream().map(LabelDTO::create).collect(Collectors.toList());
    }
}
