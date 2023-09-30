package ben.system.vo.label;

import ben.system.entity.Label;
import lombok.Data;

@Data
public class LabelUpdateReqVo {
    private Integer labelId;
    private String labelName;

    public Label toEntity() {
        return Label.builder()
                .labelId(labelId)
                .labelName(labelName)
                .build();
    }

}
