package ben.system.controller;

import ben.common.web.controller.BaseController2;
import ben.system.dto.SysUserDeptDTO;
import ben.system.entity.SysUserDept;
import ben.system.service.SysUserDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userDepts")
public class SysUserDeptController extends BaseController2<SysUserDept, SysUserDeptDTO> {
    @Autowired
    public SysUserDeptController(SysUserDeptService service) {
        super(service);
    }
}
