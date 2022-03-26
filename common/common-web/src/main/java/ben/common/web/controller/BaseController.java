package ben.common.web.controller;

import ben.common.web.service.BaseService;
import ben.common.web.vo.QueryParam;
import ben.common.web.vo.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<T> {
    public BaseController(BaseService<?, T> service) {
        this.service = service;
    }

    protected final BaseService<?, T> service;

    @GetMapping
    public R<?> list(QueryParam<T> queryParam, T entity) {
        return R.ok(service.queryPage(queryParam, entity));
    }

    @PostMapping
    public R<?> add(@RequestBody T entity) {
        service.save(entity);
        return R.ok(entity);
    }

    @PutMapping
    public R<?> edit(@RequestBody T entity) {
        service.updateById(entity);
        return R.ok(entity);
    }

    @DeleteMapping
    public R<?> delete(@RequestBody List<String> ids) {
        service.removeByIds(ids);
        return R.ok();
    }
}
