package ben.common.web.service;

import ben.common.web.utils.QueryUtil;
import ben.common.web.vo.QueryParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

public abstract class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    public IPage<T> queryPage(QueryParam<T> queryParam, T entity) {
        return this.page(queryParam.getPage().toPage(), QueryUtil.buildQueryWrapper(queryParam, entity));
    }

    public List<T> queryList(QueryParam<T> queryParam, T entity) {
        return this.list(QueryUtil.buildQueryWrapper(queryParam, entity));
    }
}

