package ben.system.vo.menu;

import ben.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuListResVo {
    private String menuId;
    private String menuName;
    private String parentId;
    private String path;
    private String component;
    private String visible;
    private String remark;

    public static List<MenuListResVo> toVo(List<SysMenu> entities) {
        return entities.stream().map(MenuListResVo::toVo).collect(Collectors.toList());
    }

    public static Page<MenuListResVo> toPage(IPage<SysMenu> page) {
        return new Page<MenuListResVo>(page.getCurrent(), page.getSize(), page.getTotal()).setRecords(
                MenuListResVo.toVo(page.getRecords())
        );
    }

    public static MenuListResVo toVo(SysMenu entity) {
        MenuListResVo result = new MenuListResVo();
        BeanUtils.copyProperties(entity, result);
        return result;
    }


}
