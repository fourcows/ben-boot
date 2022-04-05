package ben.system.dto;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.system.entity.SysMenu;
import ben.system.entity.SysRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenuDTO {
    @Query(type = QueryType.IN, table = SysRole.class)
    private String roleId;
    private String roleName;
    @Query(type = QueryType.IN,table = SysMenu.class)
    private String menuId;
    private String menuName;
    @Query(type = QueryType.IN)
    private String parentId;

    private String path;
    private String component;
    private String redirect;
    private String status;

    private String visible;
    private String sort;
    private String title;
    private String icon;
}
