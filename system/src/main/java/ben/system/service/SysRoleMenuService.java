package ben.system.service;

import ben.common.web.service.BaseService2;
import ben.system.dto.SysRoleMenuDTO;
import ben.system.entity.SysRoleMenu;
import ben.system.mapper.SysRoleMenuMapper;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMenuService extends BaseService2<SysRoleMenuMapper, SysRoleMenu, SysRoleMenuDTO> {
}
