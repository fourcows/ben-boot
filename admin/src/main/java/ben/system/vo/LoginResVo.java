package ben.system.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResVo {
    private String token;
}
