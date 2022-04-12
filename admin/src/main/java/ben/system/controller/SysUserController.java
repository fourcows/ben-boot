package ben.system.controller;

import ben.common.web.vo.R;
import ben.system.entity.SysUser;
import ben.system.service.SysUserService;
import ben.system.vo.user.CreateUserReqVo;
import ben.system.vo.user.UserDetailResVo;
import ben.system.vo.user.UserListReqVo;
import ben.system.vo.user.UserUpdateReqVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("system/users")
public class SysUserController {
    private final SysUserService service;

    @GetMapping("myUserInfo")
    public R<UserDetailResVo> myUserInfo() {
        return R.ok(service.detail("1"));
    }

    @PostMapping("usernameExist")
    public R<?> usernameExist(String username) {
        return service.count(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username)) == 0 ? R.ok() : R.fail("该用户名已存在");
    }

    @GetMapping
    public R<?> list(UserListReqVo vo) {
        return R.ok(vo.getPage() != null ? service.queryPage(vo) : service.queryList(vo));
    }

    @GetMapping("{id}")
    public R<?> detail(@PathVariable String id) {
        return R.ok(service.detail(id));
    }

    @PostMapping
    public R<?> add(@RequestBody CreateUserReqVo vo) {
        service.add(vo);
        return R.ok();
    }

    @PutMapping
    public R<?> edit(@RequestBody UserUpdateReqVo vo) {
        service.edit(vo);
        return R.ok();
    }

    @DeleteMapping
    public R<?> delete(@RequestBody List<String> ids) {
        service.delete(ids);
        return R.ok();
    }
}
