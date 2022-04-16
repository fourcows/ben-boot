package ben.system.controller;

import ben.common.web.vo.R;
import ben.system.service.SysRoleService;
import ben.system.vo.role.RoleCreateReqVo;
import ben.system.vo.role.RoleListReqVo;
import ben.system.vo.role.RoleUpdateReqVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("system/roles")
@RequiredArgsConstructor
public class SysRoleController {
    private final SysRoleService service;

    @GetMapping
    public R<?> list(RoleListReqVo vo) {
        return R.ok(vo.getPage() != null ? service.queryPage(vo) : service.queryList(vo));
    }

    @GetMapping("{id}")
    public R<?> detail(@PathVariable String id) {
        return R.ok(service.detail(id));
    }

    @PostMapping
    public R<?> add(@RequestBody RoleCreateReqVo vo) {
        service.add(vo);
        return R.ok();
    }

    @PutMapping
    public R<?> edit(@RequestBody RoleUpdateReqVo vo) {
        service.edit(vo);
        return R.ok();
    }

    @DeleteMapping
    public R<?> delete(@RequestBody List<String> ids) {
        service.delete(ids);
        return R.ok();
    }
}
