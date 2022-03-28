package ben.system.mapper;

import ben.common.web.mapper.BaseMapper2;
import ben.system.dto.SysUserRoleDTO;
import ben.system.entity.SysUserRole;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserRoleMapper extends BaseMapper2<SysUserRole, SysUserRoleDTO> {
    String SQL = """
            select sys_user.user_id, sys_user.user_name, sys_role.role_id, sys_role.role_name
            from sys_user
                     left join sys_user_role on sys_user.user_id = sys_user_role.user_id
                     left join sys_role on sys_user_role.role_id = sys_role.role_id
                        ${ew.customSqlSegment}
            """;

    @Select(SQL)
    IPage<SysUserRoleDTO> queryPage(Page<SysUserRoleDTO> page, @Param(Constants.WRAPPER) Wrapper<SysUserRoleDTO> query);

    @Select(SQL)
    List<SysUserRoleDTO> queryList(@Param(Constants.WRAPPER) Wrapper<SysUserRoleDTO> query);
}
