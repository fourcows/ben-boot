package ben.system.vo.dept;

import ben.system.entity.SysDept;
import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptTree {
    private String deptId;
    private String deptName;
    private String remark;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DeptTree> children;


    public static List<DeptTree> toTree(final List<SysDept> entities) {
        Queue<DeptTree> queue = new LinkedList<>();
        DeptTree root = DeptTree.builder().deptId("0").build();
        queue.add(root);
        while (!queue.isEmpty()) {
            DeptTree parent = queue.remove();
            List<DeptTree> children = entities.stream().filter(item -> item.getParentId().equals(parent.getDeptId())).map(DeptTree::toTree).collect(Collectors.toList());
            parent.setChildren(children);
            if (!children.isEmpty()) queue.addAll(children);
        }
        return root.getChildren();
    }

    public static DeptTree toTree(final SysDept entity) {
        DeptTree result = new DeptTree();
        BeanUtil.copyProperties(entity, result);
        return result;
    }

}
