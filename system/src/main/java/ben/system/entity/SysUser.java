package ben.system.entity;

import ben.common.web.annotation.Query;
import ben.common.web.entity.BaseEntity;
import ben.common.web.enums.QueryType;
import ben.common.web.vo.QueryParam;
import ben.system.dto.SysUserRoleDTO;
import ben.system.service.SysUserRoleService;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser extends BaseEntity implements UserDetails {
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

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return SpringUtil.getBean(SysUserRoleService.class).queryList(new QueryParam<>(), SysUserRoleDTO.builder().userId(userId).build()).stream().map(SysUserRoleDTO::getRoleName).map(item -> "ROLE_" + item).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
