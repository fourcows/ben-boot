package ben.common.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用响应实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {

    private String code;
    private T data;
    private String msg;

    public static <T> R<T> ok(T data) {
        return new R<T>("0", data, null);
    }

    public static <T> R<T> ok() {
        return new R<T>("0", null, null);
    }
}
