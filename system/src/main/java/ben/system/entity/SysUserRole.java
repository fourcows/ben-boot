package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRole {
    @Query(type = QueryType.IN)
    private String userId;
    @Query(type = QueryType.IN)
    private String roleId;
}
