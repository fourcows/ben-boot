package ben.system.vo.menu;

import ben.system.entity.SysMenu;
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
public class MenuTree {
    private String menuId;
    private String menuName;
    private String parentId;
    private String path;
    private String component;
    private String remark;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MenuTree> children;


    public static List<MenuTree> toTree(final List<SysMenu> entities) {
        Queue<MenuTree> queue = new LinkedList<>();
        MenuTree root = MenuTree.builder().menuId("0").build();
        queue.add(root);
        while (!queue.isEmpty()) {
            MenuTree parent = queue.remove();
            List<MenuTree> children = entities.stream().filter(item -> item.getParentId().equals(parent.getMenuId())).map(MenuTree::toTree).collect(Collectors.toList());
            parent.setChildren(children);
            if (!children.isEmpty()) queue.addAll(children);
        }
        return root.getChildren();
    }

    public static MenuTree toTree(final SysMenu entity) {
        MenuTree result = new MenuTree();
        BeanUtil.copyProperties(entity, result);
        return result;
    }

}
