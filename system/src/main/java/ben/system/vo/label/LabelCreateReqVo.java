package ben.system.vo.label;

import ben.system.entity.Label;
import lombok.Data;

@Data
public class LabelCreateReqVo {
    private String labelName;

    public Label toEntity() {
        return Label.builder()
                .labelName(labelName)
                .build();
    }
}
