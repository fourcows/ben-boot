package ben.system.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleInfoResVo {
    private String roleName;
    private String value;
}
