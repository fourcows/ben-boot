package ben.system.vo.role;

import ben.system.entity.SysRole;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleListResVo {
    private String roleId;
    private String roleKey;
    private String roleName;
    private String remark;

    public static List<RoleListResVo> toVo(List<SysRole> entities) {
        return entities.stream().map(RoleListResVo::toVo).collect(Collectors.toList());
    }

    public static Page<RoleListResVo> toPage(IPage<SysRole> page) {
        return new Page<RoleListResVo>(page.getCurrent(), page.getSize(), page.getTotal()).setRecords(
                RoleListResVo.toVo(page.getRecords())
        );
    }

    public static RoleListResVo toVo(SysRole entity) {
        return RoleListResVo.builder()
                .roleId(entity.getRoleId())
                .roleKey(entity.getRoleKey())
                .roleName(entity.getRoleName())
                .remark(entity.getRemark())
                .build();
    }


}
