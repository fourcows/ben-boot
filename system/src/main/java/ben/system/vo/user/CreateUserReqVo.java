package ben.system.vo.user;

import ben.system.entity.SysUser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CreateUserReqVo {
    private String username;
    private List<String> roleIds = new ArrayList<>();
    private List<String> deptIds = new ArrayList<>();
    private String nickName;
    private String email;
    private String remark;

    public SysUser toEntity() {
        return SysUser.builder()
                .username(username).nickName(nickName).email(email).remark(remark)
                .build();
    }
}
