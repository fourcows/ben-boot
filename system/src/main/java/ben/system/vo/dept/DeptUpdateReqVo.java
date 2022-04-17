package ben.system.vo.dept;

import ben.system.entity.SysDept;
import lombok.Data;

@Data
public class DeptUpdateReqVo {
    private String deptId;
    private String deptName;
    private String parentId;
    private String remark;

    public SysDept toEntity() {
        return SysDept.builder()
                .deptId(deptId).deptName(deptName).parentId(parentId).remark(remark)
                .build();
    }
}
