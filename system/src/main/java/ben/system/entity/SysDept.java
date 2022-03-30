package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.entity.BaseEntity;
import ben.common.web.enums.QueryType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysDept extends BaseEntity {
    @TableId
    @Query(type = QueryType.IN)
    private String deptId;
    @Query(type = QueryType.LIKE)
    private String deptName;
    @Query(type = QueryType.IN)
    private String parentId;
    @Query(type = QueryType.IN)
    private String status;
}
