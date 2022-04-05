package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.entity.BaseEntity;
import ben.common.web.enums.QueryType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends BaseEntity {
    @TableId
    @Query(type = QueryType.IN)
    private String userId;
    @Query(type = QueryType.LIKE)
    private String username;

    private String password;

    @Query(type = QueryType.LIKE)
    private String nickName;
    @Query(type = QueryType.LIKE)
    private String email;
    @Query(type = QueryType.IN)
    private String gender;

    /**
     * 头像
     */
    private String avatar;
}
