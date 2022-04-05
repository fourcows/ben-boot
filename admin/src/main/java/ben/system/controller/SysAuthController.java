package ben.system.controller;

import ben.common.web.vo.R;
import ben.system.entity.SysUser;
import ben.system.service.SysUserService;
import ben.system.vo.LoginReqVo;
import ben.system.vo.LoginResVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class SysAuthController {
    private final SysUserService sysUserService;

    @PostMapping("login")
    public R<LoginResVo> login(@RequestBody LoginReqVo loginReqVo) {
        SysUser sysUser = sysUserService.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, loginReqVo.getUsername())
                .eq(SysUser::getPassword, loginReqVo.getPassword())
        );
        return sysUser != null ? R.ok(LoginResVo.builder().token(UUID.randomUUID().toString()).build()) : R.fail("用户名/密码错误");
    }
}
