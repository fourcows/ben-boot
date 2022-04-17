package ben.system.vo.dept;

import ben.system.entity.SysDept;
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
public class DeptListResVo {
    private String deptId;
    private String deptName;
    private String parentId;
    private String remark;

    public static List<DeptListResVo> toVo(List<SysDept> entities) {
        return entities.stream().map(DeptListResVo::toVo).collect(Collectors.toList());
    }

    public static Page<DeptListResVo> toPage(IPage<SysDept> page) {
        return new Page<DeptListResVo>(page.getCurrent(), page.getSize(), page.getTotal()).setRecords(
                DeptListResVo.toVo(page.getRecords())
        );
    }

    public static DeptListResVo toVo(SysDept entity) {
        return DeptListResVo.builder()
                .deptId(entity.getDeptId())
                .deptName(entity.getDeptName())
                .parentId(entity.getParentId())
                .remark(entity.getRemark())
                .build();
    }


}
