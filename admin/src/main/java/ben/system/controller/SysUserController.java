package ben.system.controller;

import ben.common.web.controller.BaseController;
import ben.common.web.vo.QueryParam;
import ben.common.web.vo.R;
import ben.system.dto.SysUserRoleDTO;
import ben.system.entity.SysUser;
import ben.system.service.SysUserRoleService;
import ben.system.service.SysUserService;
import ben.system.vo.UserInfoResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class SysUserController extends BaseController<SysUser> {
    private final SysUserRoleService sysUserRoleService;

    @Autowired
    public SysUserController(SysUserService service, SysUserRoleService sysUserRoleService) {
        super(service);
        this.sysUserRoleService = sysUserRoleService;
    }

    @GetMapping("myUserInfo")
    public R<UserInfoResVo> myUserInfo() {
        return R.ok(UserInfoResVo.parse(sysUserRoleService.queryList(new QueryParam<>(), SysUserRoleDTO.builder().userId("1").build())));
    }
}
