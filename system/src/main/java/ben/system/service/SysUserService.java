package ben.system.service;

import ben.common.web.service.BaseService;
import ben.system.entity.SysUser;
import ben.system.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends BaseService<SysUserMapper, SysUser> {
}
