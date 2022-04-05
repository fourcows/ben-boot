package ben.system.mapper;

import ben.common.web.mapper.BaseMapper2;
import ben.system.dto.SysRoleMenuDTO;
import ben.system.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMenuMapper extends BaseMapper2<SysRoleMenu, SysRoleMenuDTO> {
    String SQL = """
            select sys_role.role_id, sys_role.role_name, sys_menu.*
            from sys_role
                     left join sys_role_menu on sys_role.role_id = sys_role_menu.role_id
                     left join sys_menu on sys_role_menu.menu_id = sys_menu.menu_id
                        ${ew.customSqlSegment}
            """;

    @Select(SQL)
    IPage<SysRoleMenuDTO> queryPage(Page<SysRoleMenuDTO> page, @Param(Constants.WRAPPER) Wrapper<SysRoleMenuDTO> query);

    @Select(SQL)
    List<SysRoleMenuDTO> queryList(@Param(Constants.WRAPPER) Wrapper<SysRoleMenuDTO> query);
}
