package ben.system.vo.menu;

import ben.system.entity.SysMenu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDetailResVo {
    private String menuId;
    private String menuName;
    private String parentId;
    private String path;
    private String component;
    private String redirect;
    private String visible;
    private String icon;
    private String remark;

    public static MenuDetailResVo parse(SysMenu entity) {
        MenuDetailResVo result = new MenuDetailResVo();
        BeanUtils.copyProperties(entity, result);
        return result;
    }
}
