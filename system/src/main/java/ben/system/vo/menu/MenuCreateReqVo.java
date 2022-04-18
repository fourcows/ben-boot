package ben.system.vo.menu;

import ben.system.entity.SysMenu;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class MenuCreateReqVo {
    private String menuName;
    private String parentId;
    private String path;
    private String component;
    private String redirect;
    private String visible;
    private String icon;
    private String remark;

    public SysMenu toEntity() {
        SysMenu result = new SysMenu();
        BeanUtils.copyProperties(this, result);
        return result;
    }
}
