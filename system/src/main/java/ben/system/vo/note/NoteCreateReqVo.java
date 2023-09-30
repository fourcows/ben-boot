package ben.system.vo.note;

import ben.system.entity.Note;
import lombok.Data;

import java.util.List;

@Data
public class NoteCreateReqVo {
    private String content;
    private List<Integer> labelIds;

    public Note toNote() {
        return Note.builder()
                .content(content)
                .build();
    }

}
