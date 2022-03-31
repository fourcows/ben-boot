package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import lombok.Data;

@Data
public class SysUserDept {
    @Query(type = QueryType.IN)
    private String userId;

    @Query(type = QueryType.IN)
    private String deptId;

}
