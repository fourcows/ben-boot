package ben.common.web.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryParam<E> {
    private List<OrderParam> orders = new ArrayList<>();
    /**
     * 分页参数，为空时不分页
     */
    private PageParam<E> page;
}
