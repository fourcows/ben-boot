package ben.system.dto;

import ben.system.entity.Label;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabelDTO {
    private Integer labelId;
    private String labelName;

    public static LabelDTO create(Label label) {
        return LabelDTO.builder().labelId(label.getLabelId()).labelName(label.getLabelName()).build();
    }

}
