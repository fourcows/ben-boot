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
    private String remark;

    /**
     *  path: '/system',
     *   name: 'System',
     *   component: 'LAYOUT',
     *   redirect: '/system/account',
     *   meta: {
     *     icon: 'ion:settings-outline',
     *     title: 'routes.demo.system.moduleName',
     *   },
     *   children: [
     *     {
     *       path: 'account',
     *       name: 'AccountManagement',
     *       meta: {
     *         title: 'routes.demo.system.account',
     *         ignoreKeepAlive: true,
     *       },
     *       component: '/demo/system/account/index',
     *     },
     */
}
