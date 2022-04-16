package ben.system.vo.role;

import ben.system.entity.SysRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDetailResVo {
    private String roleId;
    private String roleKey;
    private String roleName;
    private String remark;

    public static RoleDetailResVo parse(SysRole entity) {
        return RoleDetailResVo.builder()
                .roleId(entity.getRoleId())
                .roleKey(entity.getRoleKey())
                .roleName(entity.getRoleName())
                .remark(entity.getRemark())
                .build();
    }
}
