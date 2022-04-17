package ben.system.service;

import ben.common.web.service.BaseService;
import ben.system.entity.SysDept;
import ben.system.mapper.SysDeptMapper;
import ben.system.vo.dept.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysDeptService extends BaseService<SysDeptMapper, SysDept> {
    @Transactional(rollbackFor = Exception.class)
    public void add(DeptCreateReqVo vo) {
        SysDept entity = vo.toEntity();
        this.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void edit(DeptUpdateReqVo vo) {
        SysDept entity = vo.toEntity();
        this.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<String> ids) {
        this.removeByIds(ids);
    }

    public DeptDetailResVo detail(String id) {
        return DeptDetailResVo.parse(this.getById(id));
    }

    public List<DeptListResVo> queryList(DeptListReqVo vo) {
        return DeptListResVo.toVo(this.queryList(vo.toQueryParam(), vo.toEntity()));
    }

    public IPage<DeptListResVo> queryPage(DeptListReqVo vo) {
        return DeptListResVo.toPage(this.queryPage(vo.toQueryParam(), vo.toEntity()));
    }

    public List<DeptTree> tree(DeptListReqVo vo) {
        return DeptTree.toTree(this.queryList(vo.toQueryParam(), vo.toEntity()));
    }
}
