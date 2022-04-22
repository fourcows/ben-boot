package ben.system.service;

import ben.common.web.service.BaseService;
import ben.system.entity.SysMenu;
import ben.system.mapper.SysMenuMapper;
import ben.system.vo.menu.*;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysMenuService extends BaseService<SysMenuMapper, SysMenu> {
    @Transactional(rollbackFor = Exception.class)
    public void add(MenuCreateReqVo vo) {
        SysMenu entity = vo.toEntity();
        this.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void edit(MenuUpdateReqVo vo) {
        SysMenu entity = vo.toEntity();
        this.update(entity, new LambdaUpdateWrapper<SysMenu>().set(SysMenu::getParentId, entity.getParentId()).eq(SysMenu::getMenuId, entity.getMenuId()));
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<String> ids) {
        this.removeByIds(ids);
    }

    public MenuDetailResVo detail(String id) {
        return MenuDetailResVo.parse(this.getById(id));
    }

    public List<MenuListResVo> queryList(MenuListReqVo vo) {
        return MenuListResVo.toVo(this.queryList(vo.toQueryParam(), vo.toEntity()));
    }

    public IPage<MenuListResVo> queryPage(MenuListReqVo vo) {
        return MenuListResVo.toPage(this.queryPage(vo.toQueryParam(), vo.toEntity()));
    }

    public List<MenuTree> tree(MenuListReqVo vo) {
        return MenuTree.toTree(this.queryList(vo.toQueryParam(), vo.toEntity()));
    }
}
