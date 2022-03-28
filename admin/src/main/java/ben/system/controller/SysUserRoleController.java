package ben.system.controller;

import ben.common.web.controller.BaseController2;
import ben.system.dto.SysUserRoleDTO;
import ben.system.entity.SysUserRole;
import ben.system.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userRoles")
public class SysUserRoleController extends BaseController2<SysUserRole, SysUserRoleDTO> {
    @Autowired
    public SysUserRoleController(SysUserRoleService service) {
        super(service);
    }
}
