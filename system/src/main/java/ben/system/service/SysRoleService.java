package ben.system.service;

import ben.common.web.service.BaseService;
import ben.system.entity.SysRole;
import ben.system.mapper.SysRoleMapper;
import ben.system.vo.role.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysRoleService extends BaseService<SysRoleMapper, SysRole> {
    @Transactional(rollbackFor = Exception.class)
    public void add(RoleCreateReqVo vo) {
        SysRole entity = vo.toEntity();
        this.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void edit(RoleUpdateReqVo vo) {
        SysRole entity = vo.toEntity();
        this.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<String> ids) {
        this.removeByIds(ids);
    }

    public RoleDetailResVo detail(String id) {
        return RoleDetailResVo.parse(this.getById(id));
    }

    public List<RoleListResVo> queryList(RoleListReqVo vo) {
        return RoleListResVo.toVo(this.queryList(vo.toQueryParam(), vo.toEntity()));
    }

    public IPage<RoleListResVo> queryPage(RoleListReqVo vo) {
        return RoleListResVo.toPage(this.queryPage(vo.toQueryParam(), vo.toEntity()));
    }


}
