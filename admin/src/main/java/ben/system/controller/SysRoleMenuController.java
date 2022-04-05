package ben.system.controller;

import ben.common.web.controller.BaseController2;
import ben.system.dto.SysRoleMenuDTO;
import ben.system.entity.SysRoleMenu;
import ben.system.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roleMenus")
public class SysRoleMenuController extends BaseController2<SysRoleMenu, SysRoleMenuDTO> {
    @Autowired
    public SysRoleMenuController(SysRoleMenuService service) {
        super(service);
    }
}
