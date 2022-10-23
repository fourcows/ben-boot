package ben.system.controller;

import ben.common.web.vo.R;
import ben.system.entity.SysUser;
import ben.system.service.SysUserService;
import ben.system.vo.login.LoginReqVo;
import ben.system.vo.login.LoginResVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("auth")
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

    @GetMapping("logout")
    public R<?> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        // todo 清除token
        return R.ok();
    }
}
