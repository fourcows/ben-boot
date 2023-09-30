package ben.system.vo.note;

import ben.system.entity.Note;
import ben.system.entity.NoteLabel;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class NoteUpdateReqVo {
    private Integer noteId;
    private String content;
    private List<Integer> labelIds;

    public Note toNote() {
        return Note.builder()
                .noteId(noteId)
                .content(content)
                .build();
    }

    public List<NoteLabel> toNoteLabel() {
        return labelIds.stream().map(item -> NoteLabel.builder().noteId(noteId).labelId(item).build()).collect(Collectors.toList());
    }

}
