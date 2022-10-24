package ben.system.controller;

import ben.common.web.vo.R;
import ben.system.entity.SysUser;
import ben.system.service.SysUserService;
import ben.system.vo.login.LoginReqVo;
import ben.system.vo.login.LoginResVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class SysAuthController {
    private final SysUserService sysUserService;
    private final RedisTemplate<String, Object> redisTemplate;

    @PostMapping("login")
    public R<LoginResVo> login(@RequestBody LoginReqVo loginReqVo) {
        SysUser sysUser = sysUserService.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, loginReqVo.getUsername())
                .eq(SysUser::getPassword, loginReqVo.getPassword())
        );
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForHash().put("token", token, sysUser);
        return sysUser != null ? R.ok(LoginResVo.builder().token(token).build()) : R.fail("用户名/密码错误");
    }

    @GetMapping("logout")
    public R<?> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        //清除token
        redisTemplate.opsForHash().delete("token", token);
        return R.ok();
    }
}
