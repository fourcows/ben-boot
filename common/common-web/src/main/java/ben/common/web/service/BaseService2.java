package ben.common.web.service;

import ben.common.web.mapper.BaseMapper2;
import ben.common.web.utils.QueryUtil;
import ben.common.web.vo.QueryParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

public abstract class BaseService2<M extends BaseMapper2<T, T2>, T, T2> extends ServiceImpl<M, T> {

    public IPage<T2> queryPage(QueryParam<T2> queryParam, T2 entity) {
        return this.baseMapper.queryPage(queryParam.getPage().toPage(), QueryUtil.buildQueryWrapper(queryParam, entity));
    }

    public List<T2> queryList(QueryParam<T2> queryParam, T2 entity) {
        return this.baseMapper.queryList(QueryUtil.buildQueryWrapper(queryParam, entity));
    }
}
