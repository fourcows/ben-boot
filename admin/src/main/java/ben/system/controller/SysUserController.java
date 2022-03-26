package ben.system.controller;

import ben.common.web.controller.BaseController;
import ben.system.entity.SysUser;
import ben.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class SysUserController extends BaseController<SysUser> {
    @Autowired
    public SysUserController(SysUserService service) {
        super(service);
    }
}
