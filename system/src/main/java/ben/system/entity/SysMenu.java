package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.entity.BaseEntity;
import ben.common.web.enums.QueryType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenu extends BaseEntity {
    /**
     *  path: '/dashboard',
     *   name: 'Dashboard',
     *   component: 'LAYOUT',
     *   redirect: '/dashboard/analysis',
     */
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
    private String status;


    private String visible;
    private String sort;
    private String title;
    private String icon;
}
