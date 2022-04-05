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

    private Integer code;
    private T result;
    private String message;

    public static <T> R<T> ok(T data) {
        return new R<T>(0, data, null);
    }

    public static <T> R<T> ok() {
        return new R<T>(0, null, null);
    }

    public static <T> R<T> fail(String msg) {
        return new R<T>(1, null, msg);
    }
}
