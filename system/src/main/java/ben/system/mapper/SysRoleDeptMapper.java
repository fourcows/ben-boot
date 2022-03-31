package ben.system.mapper;

import ben.common.web.mapper.BaseMapper2;
import ben.system.dto.SysRoleDeptDTO;
import ben.system.entity.SysRoleDept;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleDeptMapper extends BaseMapper2<SysRoleDept, SysRoleDeptDTO> {
    String SQL = """
            select sys_role.role_id, sys_role.role_name, sys_dept.dept_id, sys_dept.dept_name
            from sys_role
                     left join sys_role_dept on sys_role.role_id = sys_role_dept.role_id
                     left join sys_dept on sys_role_dept.dept_id = sys_dept.dept_id
                        ${ew.customSqlSegment}
            """;

    @Select(SQL)
    IPage<SysRoleDeptDTO> queryPage(Page<SysRoleDeptDTO> page, @Param(Constants.WRAPPER) Wrapper<SysRoleDeptDTO> query);

    @Select(SQL)
    List<SysRoleDeptDTO> queryList(@Param(Constants.WRAPPER) Wrapper<SysRoleDeptDTO> query);
}
