package ben.system.vo.user;

import ben.system.entity.SysUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListResVo {
    private String userId;
    private String username;
    private String nickName;
    private String email;
    private String remark;

    public static List<UserListResVo> toVo(List<SysUser> entities) {
        return entities.stream().map(UserListResVo::toVo).collect(Collectors.toList());
    }

    public static Page<UserListResVo> toPage(IPage<SysUser> page) {
        return new Page<UserListResVo>(page.getCurrent(), page.getSize(), page.getTotal()).setRecords(
                UserListResVo.toVo(page.getRecords())
        );
    }

    public static UserListResVo toVo(SysUser entity) {
        return UserListResVo.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .nickName(entity.getNickName())
                .email(entity.getEmail())
                .remark(entity.getRemark())
                .build();
    }


}
