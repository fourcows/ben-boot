package ben.system.controller;

import ben.common.web.controller.BaseController;
import ben.common.web.vo.QueryParam;
import ben.common.web.vo.R;
import ben.system.dto.SysRolePermDTO;
import ben.system.entity.SysPerm;
import ben.system.service.SysPermService;
import ben.system.service.SysRolePermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("perms")
public class SysPermController extends BaseController<SysPerm> {
    private final SysRolePermService sysRolePermService;

    @Autowired
    public SysPermController(SysPermService service, SysRolePermService sysRolePermService) {
        super(service);
        this.sysRolePermService = sysRolePermService;
    }

    @GetMapping("myPerms")
    public R<?> myPerms() {
        return R.ok(sysRolePermService.queryList(new QueryParam<>(), SysRolePermDTO.builder().roleId("1").build()));
    }
}
