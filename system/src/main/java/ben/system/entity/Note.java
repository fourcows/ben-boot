package ben.system.entity;

import ben.common.web.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Note extends BaseEntity {
    @TableId
    private Integer noteId;
    private String content;
}
