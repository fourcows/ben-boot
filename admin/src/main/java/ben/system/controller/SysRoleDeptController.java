package ben.system.controller;

import ben.common.web.controller.BaseController2;
import ben.system.dto.SysRoleDeptDTO;
import ben.system.entity.SysRoleDept;
import ben.system.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roleDepts")
public class SysRoleDeptController extends BaseController2<SysRoleDept, SysRoleDeptDTO> {
    @Autowired
    public SysRoleDeptController(SysRoleDeptService service) {
        super(service);
    }
}
