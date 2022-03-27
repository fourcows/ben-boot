package ben.system.controller;

import ben.common.web.controller.BaseController;
import ben.system.entity.SysRole;
import ben.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class SysRoleController extends BaseController<SysRole> {
    @Autowired
    public SysRoleController(SysRoleService service) {
        super(service);
    }
}
