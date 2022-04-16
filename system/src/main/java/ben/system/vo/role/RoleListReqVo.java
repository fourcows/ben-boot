package ben.system.vo.role;

import ben.common.web.vo.OrderParam;
import ben.common.web.vo.PageParam;
import ben.common.web.vo.QueryParam;
import ben.system.entity.SysRole;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoleListReqVo {
    private String roleKey;
    private String roleName;

    private List<OrderParam> orders = new ArrayList<>();
    /**
     * 分页参数，为空时不分页
     */
    private PageParam<SysRole> page;

    public QueryParam<SysRole> toQueryParam() {
        return QueryParam.<SysRole>builder().page(page).orders(orders).build();
    }

    public SysRole toEntity() {
        return SysRole.builder().roleKey(roleKey).roleName(roleName).build();
    }
}
