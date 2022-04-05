package ben.system.controller;

import ben.common.web.controller.BaseController2;
import ben.system.dto.SysRolePermDTO;
import ben.system.entity.SysRolePerm;
import ben.system.service.SysRolePermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rolePerms")
public class SysRolePermController extends BaseController2<SysRolePerm, SysRolePermDTO> {
    @Autowired
    public SysRolePermController(SysRolePermService service) {
        super(service);
    }


}
