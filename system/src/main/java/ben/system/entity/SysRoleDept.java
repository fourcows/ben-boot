package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import lombok.Data;

@Data
public class SysRoleDept {
    @Query(type = QueryType.IN)
    private String deptId;
    @Query(type = QueryType.IN)
    private String roleId;
}
