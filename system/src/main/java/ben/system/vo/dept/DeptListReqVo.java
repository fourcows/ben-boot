package ben.system.vo.dept;

import ben.common.web.vo.OrderParam;
import ben.common.web.vo.PageParam;
import ben.common.web.vo.QueryParam;
import ben.system.entity.SysDept;
import cn.hutool.core.util.StrUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeptListReqVo {
    private String deptName;
    private List<String> parentIds = new ArrayList<>();

    private List<OrderParam> orders = new ArrayList<>();
    /**
     * 分页参数，为空时不分页
     */
    private PageParam<SysDept> page;

    public QueryParam<SysDept> toQueryParam() {
        return QueryParam.<SysDept>builder().page(page).orders(orders).build();
    }

    public SysDept toEntity() {
        return SysDept.builder().deptName(deptName).parentId(StrUtil.join(",", parentIds)).build();
    }
}
