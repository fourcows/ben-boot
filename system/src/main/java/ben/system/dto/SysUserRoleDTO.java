package ben.system.dto;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.system.entity.SysRole;
import ben.system.entity.SysUser;
import lombok.Data;

@Data
public class SysUserRoleDTO {
    @Query(type = QueryType.IN, table = SysUser.class)
    private String userId;
    private String userName;
    @Query(type = QueryType.IN, table = SysRole.class)
    private String roleId;
    private String roleName;
}
