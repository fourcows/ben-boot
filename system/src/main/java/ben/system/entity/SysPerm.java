package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.entity.BaseEntity;
import ben.common.web.enums.QueryType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysPerm extends BaseEntity {
    @TableId
    @Query(type = QueryType.IN)
    private String permId;
    @Query(type = QueryType.LIKE)
    private String permName;
    @Query(type = QueryType.IN)
    private String menuId;

    private String urlPerm;
    private String btnPerm;
}
