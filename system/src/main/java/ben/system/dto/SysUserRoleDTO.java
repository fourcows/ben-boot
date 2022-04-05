package ben.system.dto;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.system.entity.SysRole;
import ben.system.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRoleDTO {
    @Query(type = QueryType.IN, table = SysUser.class)
    private String userId;
    private String username;
    private String nickName;
    private String email;
    private String gender;
    private String avatar;
    @Query(type = QueryType.IN, table = SysRole.class)
    private String roleId;
    private String roleName;
}
