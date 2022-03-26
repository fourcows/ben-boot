package ben.common.web.utils;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.common.web.vo.QueryParam;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class QueryUtil {
    public static <EV> QueryWrapper<EV> buildQueryWrapper(QueryParam<EV> queryParam, EV entity) {
        QueryWrapper<EV> result = new QueryWrapper<>();
        List<Field> fields = FieldUtil.getFieldsByAnnotation(entity.getClass(), Query.class);
        for (Field field : fields) {
            Query query = field.getAnnotation(Query.class);
            if (query.type() == QueryType.LIKE) {
                result.like(
                        ReflectUtil.getFieldValue(entity, field) != null && StrUtil.isNotBlank(String.valueOf(ReflectUtil.getFieldValue(entity, field))),
                        StrUtil.toUnderlineCase(field.getName()),
                        ReflectUtil.getFieldValue(entity, field));
            } else if (query.type() == QueryType.IN) {
                result.in(
                        ReflectUtil.getFieldValue(entity, field) != null && StrUtil.isNotBlank(String.valueOf(ReflectUtil.getFieldValue(entity, field))),
                        StrUtil.toUnderlineCase(field.getName()),
                        Arrays.asList(String.valueOf(ReflectUtil.getFieldValue(entity, field)).split(",")));
            }
        }

        queryParam.getOrders().forEach(orderParam ->
                result.orderBy(
                        StrUtil.isNotBlank(orderParam.getCol()),
                        orderParam.getIsAsc(),
                        StrUtil.toUnderlineCase(orderParam.getCol())
                )
        );

        return result;
    }

}
