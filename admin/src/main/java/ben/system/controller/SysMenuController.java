package ben.system.controller;

import ben.common.web.controller.BaseController;
import ben.common.web.vo.QueryParam;
import ben.common.web.vo.R;
import ben.system.dto.SysRoleMenuDTO;
import ben.system.entity.SysMenu;
import ben.system.service.SysMenuService;
import ben.system.service.SysRoleMenuService;
import ben.system.vo.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menus")
public class SysMenuController extends BaseController<SysMenu> {
    private final SysRoleMenuService sysRoleMenuService;

    @Autowired
    public SysMenuController(SysMenuService service, SysRoleMenuService sysRoleMenuService) {
        super(service);
        this.sysRoleMenuService = sysRoleMenuService;
    }


    @GetMapping("myMenus")
    public R<?> myMenus() {
        return R.ok(MenuTree.toTree(sysRoleMenuService.queryList(new QueryParam<>(), SysRoleMenuDTO.builder().roleId("1").build())));
    }
}
