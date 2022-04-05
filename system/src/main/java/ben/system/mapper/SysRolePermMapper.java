package ben.system.mapper;

import ben.common.web.mapper.BaseMapper2;
import ben.system.dto.SysRolePermDTO;
import ben.system.entity.SysRolePerm;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRolePermMapper extends BaseMapper2<SysRolePerm, SysRolePermDTO> {
    String SQL = """
            select sys_role.role_id, sys_role.role_name, sys_perm.*
            from sys_role
                     left join sys_role_perm on sys_role.role_id = sys_role_perm.role_id
                     left join sys_perm on sys_role_perm.perm_id = sys_perm.perm_id
                        ${ew.customSqlSegment}
            """;

    @Select(SQL)
    IPage<SysRolePermDTO> queryPage(Page<SysRolePermDTO> page, @Param(Constants.WRAPPER) Wrapper<SysRolePermDTO> query);

    @Select(SQL)
    List<SysRolePermDTO> queryList(@Param(Constants.WRAPPER) Wrapper<SysRolePermDTO> query);
}
