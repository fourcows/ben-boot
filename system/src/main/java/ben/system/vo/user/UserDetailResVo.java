package ben.system.vo.user;

import ben.system.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailResVo {
    private String userId;
    private String username;
    private List<String> roleIds;
    private List<String> deptIds;
    private String nickName;
    private String email;
    private String remark;

    public static UserDetailResVo parse(SysUser entity) {
        return UserDetailResVo.builder()
                .userId(entity.getUserId())
                .username(entity.getUsername())
                .nickName(entity.getNickName())
                .email(entity.getEmail())
                .remark(entity.getRemark())
                .build();
    }
}
