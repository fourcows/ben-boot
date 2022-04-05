package ben.system.dto;

import ben.common.web.annotation.Query;
import ben.common.web.enums.QueryType;
import ben.system.entity.SysPerm;
import ben.system.entity.SysRole;
import lombok.Builder;
import lombok.Data;

@Data
public class RouteMeta {
    private String title;
    private String icon;
    private Boolean ignoreKeepAlive = false;
}
