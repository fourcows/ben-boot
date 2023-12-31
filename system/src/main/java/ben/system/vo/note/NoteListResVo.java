package ben.system.vo.note;

import ben.system.dto.NoteDTO;
import ben.system.vo.label.LabelListResVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteListResVo {
    private Integer noteId;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private List<LabelListResVo> labels;

    public static NoteListResVo toVo(NoteDTO noteDTO) {
        List<LabelListResVo> labelVOs = noteDTO.getLabels().stream().map(LabelListResVo::toVO).collect(Collectors.toList());
        return NoteListResVo.builder()
                .noteId(noteDTO.getNoteId())
                .content(noteDTO.getContent())
                .updateTime(noteDTO.getUpdateTime())
                .labels(labelVOs)
                .build();
    }

}
