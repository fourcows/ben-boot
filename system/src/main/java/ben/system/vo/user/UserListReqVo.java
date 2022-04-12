package ben.system.vo.user;

import ben.common.web.vo.OrderParam;
import ben.common.web.vo.PageParam;
import ben.common.web.vo.QueryParam;
import ben.system.entity.SysUser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserListReqVo {
    private String username;
    private List<String> roleIds = new ArrayList<>();
    private List<String> deptIds = new ArrayList<>();
    private String nickName;

    private List<OrderParam> orders = new ArrayList<>();
    /**
     * 分页参数，为空时不分页
     */
    private PageParam<SysUser> page;

    public QueryParam<SysUser> toQueryParam() {
        return QueryParam.<SysUser>builder().page(page).orders(orders).build();
    }

    public SysUser toEntity() {
        return SysUser.builder().username(username).nickName(nickName).build();
    }
}
