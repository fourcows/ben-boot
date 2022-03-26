package ben.common.web.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper2<T, T2> extends BaseMapper<T> {
    IPage<T2> queryPage(Page<T2> page, @Param(Constants.WRAPPER) Wrapper<T2> query);

    List<T2> queryList(@Param(Constants.WRAPPER) Wrapper<T2> query);
}
