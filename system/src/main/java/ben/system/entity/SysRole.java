package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.entity.BaseEntity;
import ben.common.web.enums.QueryType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRole extends BaseEntity {
    @TableId
    @Query(type = QueryType.IN)
    private String roleId;
    @Query(type = QueryType.LIKE)
    private String roleKey;
    @Query(type = QueryType.LIKE)
    private String roleName;
    @Query(type = QueryType.LIKE)
    private String remark;
}
