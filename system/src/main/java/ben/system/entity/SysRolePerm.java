package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.entity.BaseEntity;
import ben.common.web.enums.QueryType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class SysRolePerm {

    @TableId
    @Query(type = QueryType.IN)
    private String id;

    @Query(type = QueryType.IN)
    private String roleId;
    @Query(type = QueryType.IN)
    private String permId;

}
