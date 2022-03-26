package ben.common.web.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderParam implements Serializable {
    private String col;
    private Boolean isAsc = true;
}
