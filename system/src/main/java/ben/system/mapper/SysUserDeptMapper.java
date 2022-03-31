package ben.system.mapper;

import ben.common.web.mapper.BaseMapper2;
import ben.system.dto.SysUserDeptDTO;
import ben.system.entity.SysUserDept;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserDeptMapper extends BaseMapper2<SysUserDept, SysUserDeptDTO> {
    String SQL = """
            select sys_user.user_id, sys_user.user_name, sys_dept.dept_id, sys_dept.dept_name
            from sys_user
                     left join sys_user_dept on sys_user.user_id = sys_user_dept.user_id
                     left join sys_dept on sys_user_dept.dept_id = sys_dept.dept_id
                        ${ew.customSqlSegment}
            """;

    @Select(SQL)
    IPage<SysUserDeptDTO> queryPage(Page<SysUserDeptDTO> page, @Param(Constants.WRAPPER) Wrapper<SysUserDeptDTO> query);

    @Select(SQL)
    List<SysUserDeptDTO> queryList(@Param(Constants.WRAPPER) Wrapper<SysUserDeptDTO> query);
}
