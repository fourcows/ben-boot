package ben.system.dto;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.system.entity.SysDept;
import ben.system.entity.SysRole;
import lombok.Data;

@Data
public class SysRoleDeptDTO {
    @Query(type = QueryType.IN, table = SysRole.class)
    private String roleId;
    private String roleName;
    @Query(type = QueryType.IN, table = SysDept.class)
    private String deptId;
    private String deptName;
}
