package ben.system.controller;

import ben.common.web.vo.R;
import ben.system.service.SysDeptService;
import ben.system.vo.dept.DeptCreateReqVo;
import ben.system.vo.dept.DeptListReqVo;
import ben.system.vo.dept.DeptUpdateReqVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("system/depts")
@RequiredArgsConstructor
public class SysDeptController {
    private final SysDeptService service;

    @GetMapping
    public R<?> list(DeptListReqVo vo) {
        return R.ok(vo.getPage() != null ? service.queryPage(vo) : service.queryList(vo));
    }

    @GetMapping("tree")
    public R<?> tree(DeptListReqVo vo) {
        return R.ok(service.tree(vo));
    }

    @GetMapping("{id}")
    public R<?> detail(@PathVariable String id) {
        return R.ok(service.detail(id));
    }

    @PostMapping
    public R<?> add(@RequestBody DeptCreateReqVo vo) {
        service.add(vo);
        return R.ok();
    }

    @PutMapping
    public R<?> edit(@RequestBody DeptUpdateReqVo vo) {
        service.edit(vo);
        return R.ok();
    }

    @DeleteMapping
    public R<?> delete(@RequestBody List<String> ids) {
        service.delete(ids);
        return R.ok();
    }
}
