package ben.system.service;

import ben.common.web.service.BaseService2;
import ben.system.dto.SysRolePermDTO;
import ben.system.entity.SysRolePerm;
import ben.system.mapper.SysRolePermMapper;
import org.springframework.stereotype.Service;

@Service
public class SysRolePermService extends BaseService2<SysRolePermMapper, SysRolePerm, SysRolePermDTO> {
}
