package ben.common.web.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageParam<E> {
    private Integer num = 1;
    private Integer size = 10;

    public Page<E> toPage() {
        return new Page<>(num, size);
    }
}
