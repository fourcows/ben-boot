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

    public void valid() {
        if (num == null || size == null) {
            throw new RuntimeException("分页参数必传");
        }
        if (size > 200) {
            throw new RuntimeException("分页大小超出最大条数限制");
        }
    }
}
