package ben.system.vo;

import ben.system.dto.RouteMeta;
import ben.system.dto.SysRoleMenuDTO;
import ben.system.entity.SysMenu;
import cn.hutool.core.bean.BeanUtil;
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
    private String path;
    private String component;
    private RouteMeta meta;
    private String name;
    private String redirect;
    private List<MenuTree> children;


    public static List<MenuTree> toTree(final List<SysRoleMenuDTO> entities){
        Queue<MenuTree> queue = new LinkedList<>();
        MenuTree root = MenuTree.builder().menuId("0").build();
        queue.add(root);
        while(!queue.isEmpty()){
            MenuTree parent = queue.remove();
            List<MenuTree> children = entities.stream().filter(item -> item.getParentId().equals(parent.getMenuId())).map(MenuTree::toTree).collect(Collectors.toList());
            parent.setChildren(children);
            if(!children.isEmpty()) queue.addAll(children);
        }
        return root.getChildren();
    }

    public static MenuTree toTree(final SysRoleMenuDTO entity){
        MenuTree result = new MenuTree();
        BeanUtil.copyProperties(entity,result);
        result.setName(entity.getMenuName());
        RouteMeta routeMeta = new RouteMeta();
        BeanUtil.copyProperties(entity,routeMeta);
        result.setMeta(routeMeta);
        return result;
    }

}
