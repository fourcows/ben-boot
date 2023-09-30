package ben.system.dto;

import ben.system.entity.NoteLabel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteLabelDTO {
    private Integer noteId;
    private Integer labelId;

    public static NoteLabelDTO create(NoteLabel noteLabel) {
        return NoteLabelDTO.builder().noteId(noteLabel.getNoteId()).labelId(noteLabel.getLabelId()).build();
    }
}
