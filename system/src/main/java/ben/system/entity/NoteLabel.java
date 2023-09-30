package ben.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteLabel {
    @TableId
    private Integer id;
    private Integer noteId;
    private Integer labelId;
}
