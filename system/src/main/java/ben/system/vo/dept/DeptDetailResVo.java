package ben.system.vo.dept;

import ben.system.entity.SysDept;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDetailResVo {
    private String deptId;
    private String deptName;
    private String parentId;
    private String remark;

    public static DeptDetailResVo parse(SysDept entity) {
        return DeptDetailResVo.builder()
                .deptId(entity.getDeptId())
                .parentId(entity.getParentId())
                .deptName(entity.getDeptName())
                .remark(entity.getRemark())
                .build();
    }
}
