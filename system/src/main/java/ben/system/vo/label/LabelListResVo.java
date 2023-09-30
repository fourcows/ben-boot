package ben.system.vo.label;

import ben.system.dto.LabelDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LabelListResVo {
    private Integer labelId;
    private String labelName;

    public static LabelListResVo toVO(LabelDTO labelDTO) {
        return LabelListResVo.builder().labelId(labelDTO.getLabelId()).labelName(labelDTO.getLabelName()).build();
    }
}
