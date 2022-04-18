package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.entity.BaseEntity;
import ben.common.web.enums.QueryType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysMenu extends BaseEntity {

    @TableId
    @Query(type = QueryType.IN)
    private String menuId;
    @Query(type = QueryType.LIKE)
    private String menuName;

    @Query(type = QueryType.IN)
    private String parentId;
    private String path;

    private String component;
    private String redirect;

    private String title;
    private String visible;
    private String icon;
    private String remark;
}
