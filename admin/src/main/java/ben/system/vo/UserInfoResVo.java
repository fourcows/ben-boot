package ben.system.vo;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.system.dto.SysUserRoleDTO;
import ben.system.entity.SysRole;
import ben.system.entity.SysUser;
import ben.system.entity.SysUserRole;
import cn.hutool.core.bean.BeanUtil;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UserInfoResVo {
    private String userId;
    private String username;
    private String nickName;
    private String avatar;

    private List<RoleInfoResVo> roles;

    public static UserInfoResVo parse(List<SysUserRoleDTO> dtoList){
        if(dtoList.isEmpty()) return UserInfoResVo.builder().build();
        if(dtoList.stream().map(SysUserRoleDTO::getUserId).distinct().count()>1) throw new RuntimeException("参数不满足规则");
        List<RoleInfoResVo> roles = dtoList.stream().map(item -> RoleInfoResVo.builder().value(item.getRoleId()).roleName(item.getRoleName()).build()).collect(Collectors.toList());
        UserInfoResVo result = UserInfoResVo.builder().build();
        SysUserRoleDTO first = dtoList.get(0);
        BeanUtil.copyProperties(first,result);
        result.setRoles(roles);
        return result;
    }
}
