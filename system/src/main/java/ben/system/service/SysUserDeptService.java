package ben.system.service;

import ben.common.web.service.BaseService2;
import ben.system.dto.SysUserDeptDTO;
import ben.system.entity.SysUserDept;
import ben.system.mapper.SysUserDeptMapper;
import org.springframework.stereotype.Service;

@Service
public class SysUserDeptService extends BaseService2<SysUserDeptMapper, SysUserDept, SysUserDeptDTO> {
}
