package ben.system.service;

import ben.common.web.service.BaseService2;
import ben.system.dto.SysUserRoleDTO;
import ben.system.entity.SysUserRole;
import ben.system.mapper.SysUserRoleMapper;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleService extends BaseService2<SysUserRoleMapper, SysUserRole, SysUserRoleDTO> {
}
