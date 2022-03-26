package ben.common.web.controller;


import ben.common.web.service.BaseService2;
import ben.common.web.vo.QueryParam;
import ben.common.web.vo.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController2<T, T2> {
    public BaseController2(BaseService2<?, T, T2> service) {
        this.service = service;
    }

    protected final BaseService2<?, T, T2> service;

    @GetMapping
    public R<?> list(
            QueryParam<T2> queryParam, T2 entity) {
        return R.ok(service.queryPage(queryParam, entity));
    }

    @PostMapping
    public R<?> add(@RequestBody T entity) {
        service.save(entity);
        return R.ok(entity);
    }

    @PutMapping
    public R<?> update(@RequestBody T entity) {
        service.updateById(entity);
        return R.ok(entity);
    }

    @DeleteMapping
    public R<?> delete(@RequestBody List<String> ids) {
        service.removeByIds(ids);
        return R.ok();
    }
}
