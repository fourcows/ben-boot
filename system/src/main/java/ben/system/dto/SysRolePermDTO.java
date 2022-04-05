package ben.system.dto;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.system.entity.SysDept;
import ben.system.entity.SysPerm;
import ben.system.entity.SysRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SysRolePermDTO {
    @Query(type = QueryType.IN, table = SysRole.class)
    private String roleId;
    private String roleName;

    @Query(type = QueryType.IN, table = SysPerm.class)
    private String permId;
    private String permName;

    @Query(type = QueryType.IN)
    private String menuId;


}
