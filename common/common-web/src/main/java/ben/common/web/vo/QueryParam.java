package ben.common.web.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryParam<E> {
    private List<OrderParam> orders = new ArrayList<>();
    private PageParam<E> page = new PageParam<>();
}
