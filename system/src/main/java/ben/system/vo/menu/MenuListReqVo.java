package ben.system.vo.menu;

import ben.common.web.vo.OrderParam;
import ben.common.web.vo.PageParam;
import ben.common.web.vo.QueryParam;
import ben.system.entity.SysMenu;
import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuListReqVo {
    private String menuName;
    private List<String> parentIds = new ArrayList<>();

    private List<OrderParam> orders = new ArrayList<>();
    /**
     * 分页参数，为空时不分页
     */
    private PageParam<SysMenu> page;

    public QueryParam<SysMenu> toQueryParam() {
        return QueryParam.<SysMenu>builder().page(page).orders(orders).build();
    }

    public SysMenu toEntity() {
        return SysMenu.builder().menuName(menuName).parentId(StrUtil.join(",", parentIds)).build();
    }
}
