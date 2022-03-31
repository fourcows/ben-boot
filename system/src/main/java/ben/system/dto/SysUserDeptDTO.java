package ben.system.dto;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.system.entity.SysDept;
import ben.system.entity.SysUser;
import lombok.Data;

@Data
public class SysUserDeptDTO {
    @Query(type = QueryType.IN, table = SysUser.class)
    private String userId;
    private String userName;
    @Query(type = QueryType.IN, table = SysDept.class)
    private String deptId;
    private String deptName;
}
