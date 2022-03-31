package ben.system.service;

import ben.common.web.service.BaseService2;
import ben.system.dto.SysRoleDeptDTO;
import ben.system.entity.SysRoleDept;
import ben.system.mapper.SysRoleDeptMapper;
import org.springframework.stereotype.Service;

@Service
public class SysRoleDeptService extends BaseService2<SysRoleDeptMapper, SysRoleDept, SysRoleDeptDTO> {
}
