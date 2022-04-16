package ben.system.vo.role;

import ben.system.entity.SysRole;
import lombok.Data;

@Data
public class RoleCreateReqVo {
    private String roleKey;
    private String roleName;
    private String remark;

    public SysRole toEntity() {
        return SysRole.builder()
                .roleKey(roleKey).roleName(roleName).remark(remark)
                .build();
    }
}
