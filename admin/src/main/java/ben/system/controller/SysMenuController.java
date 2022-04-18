package ben.system.controller;

import ben.common.web.vo.QueryParam;
import ben.common.web.vo.R;
import ben.system.dto.SysRoleMenuDTO;
import ben.system.service.SysMenuService;
import ben.system.service.SysRoleMenuService;
import ben.system.vo.MenuTree;
import ben.system.vo.menu.MenuCreateReqVo;
import ben.system.vo.menu.MenuListReqVo;
import ben.system.vo.menu.MenuUpdateReqVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("system/menus")
@RequiredArgsConstructor
public class SysMenuController {
    private final SysMenuService service;
    private final SysRoleMenuService sysRoleMenuService;

    @GetMapping
    public R<?> list(MenuListReqVo vo) {
        return R.ok(vo.getPage() != null ? service.queryPage(vo) : service.queryList(vo));
    }

    @GetMapping("tree")
    public R<?> tree(MenuListReqVo vo) {
        return R.ok(service.tree(vo));
    }

    @GetMapping("myMenus")
    public R<?> myMenus() {
        return R.ok(MenuTree.toTree(sysRoleMenuService.queryList(new QueryParam<>(), SysRoleMenuDTO.builder().roleId("1").build())));
    }


    @GetMapping("{id}")
    public R<?> detail(@PathVariable String id) {
        return R.ok(service.detail(id));
    }

    @PostMapping
    public R<?> add(@RequestBody MenuCreateReqVo vo) {
        service.add(vo);
        return R.ok();
    }

    @PutMapping
    public R<?> edit(@RequestBody MenuUpdateReqVo vo) {
        service.edit(vo);
        return R.ok();
    }

    @DeleteMapping
    public R<?> delete(@RequestBody List<String> ids) {
        service.delete(ids);
        return R.ok();
    }
}
