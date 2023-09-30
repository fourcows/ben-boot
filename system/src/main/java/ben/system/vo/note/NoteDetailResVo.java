package ben.system.vo.note;

import ben.system.dto.NoteDTO;
import ben.system.vo.label.LabelListResVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDetailResVo {
    private Integer noteId;
    private String content;
    private List<LabelListResVo> labels;

    public static NoteDetailResVo toVo(NoteDTO noteDTO) {
        List<LabelListResVo> labelVOs = noteDTO.getLabels().stream().map(LabelListResVo::toVO).collect(Collectors.toList());
        return NoteDetailResVo.builder()
                .noteId(noteDTO.getNoteId())
                .content(noteDTO.getContent())
                .labels(labelVOs)
                .build();
    }

}
