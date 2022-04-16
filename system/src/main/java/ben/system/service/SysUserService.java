package ben.system.service;

import ben.common.web.service.BaseService;
import ben.system.entity.SysUser;
import ben.system.entity.SysUserDept;
import ben.system.entity.SysUserRole;
import ben.system.mapper.SysUserMapper;
import ben.system.vo.user.*;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SysUserService extends BaseService<SysUserMapper, SysUser> {
    private final SysUserRoleService sysUserRoleService;
    private final SysUserDeptService sysUserDeptService;

    @Transactional(rollbackFor = Exception.class)
    public void add(CreateUserReqVo vo) {
        SysUser entity = vo.toEntity();
        this.save(entity);
        List<SysUserRole> userRoles = vo.getRoleIds().stream().map(roleId -> SysUserRole.builder().userId(entity.getUserId()).roleId(roleId).build()).collect(Collectors.toList());
        sysUserRoleService.saveBatch(userRoles);
        List<SysUserDept> userDepts = vo.getDeptIds().stream().map(deptId -> SysUserDept.builder().userId(entity.getUserId()).deptId(deptId).build()).collect(Collectors.toList());
        sysUserDeptService.saveBatch(userDepts);
    }

    @Transactional(rollbackFor = Exception.class)
    public void edit(UserUpdateReqVo vo) {
        SysUser entity = vo.toEntity();
        this.updateById(entity);
        sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, entity.getUserId()));
        List<SysUserRole> userRoles = vo.getRoleIds().stream().map(roleId -> SysUserRole.builder().userId(entity.getUserId()).roleId(roleId).build()).collect(Collectors.toList());
        sysUserRoleService.saveBatch(userRoles);
        sysUserDeptService.remove(new LambdaQueryWrapper<SysUserDept>().eq(SysUserDept::getUserId, entity.getUserId()));
        List<SysUserDept> userDepts = vo.getDeptIds().stream().map(deptId -> SysUserDept.builder().userId(entity.getUserId()).deptId(deptId).build()).collect(Collectors.toList());
        sysUserDeptService.saveBatch(userDepts);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(List<String> ids) {
        this.removeByIds(ids);
        sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().in(SysUserRole::getUserId, ids));
        sysUserDeptService.remove(new LambdaQueryWrapper<SysUserDept>().in(SysUserDept::getUserId, ids));
    }

    public UserDetailResVo detail(String id) {
        UserDetailResVo result = UserDetailResVo.parse(this.getById(id));
        List<String> roleIds = sysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>().select(SysUserRole::getRoleId).eq(SysUserRole::getUserId, id)).stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        result.setRoleIds(roleIds);
        List<String> deptIds = sysUserDeptService.list(new LambdaQueryWrapper<SysUserDept>().select(SysUserDept::getDeptId).eq(SysUserDept::getUserId, id)).stream().map(SysUserDept::getDeptId).collect(Collectors.toList());
        result.setDeptIds(deptIds);
        return result;
    }

    public List<?> queryList(UserListReqVo vo) {
        return (List<?>) queryUsers(vo, false);
    }

    public IPage<?> queryPage(UserListReqVo vo) {
        return (IPage<?>) queryUsers(vo, true);
    }

    private Object queryUsers(UserListReqVo vo, boolean isPage) {
        Set<String> roleRelUserIds = new HashSet<>();
        if (!vo.getRoleIds().isEmpty()) {
            roleRelUserIds = sysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>().in(SysUserRole::getRoleId, vo.getRoleIds()))
                    .stream().map(SysUserRole::getUserId).collect(Collectors.toSet());
            if (roleRelUserIds.isEmpty()) return isPage ? new Page<>() : new ArrayList<>();
        }
        Set<String> deptRelUserIds = new HashSet<>();
        if (!vo.getDeptIds().isEmpty()) {
            deptRelUserIds = sysUserDeptService.list(new LambdaQueryWrapper<SysUserDept>().in(SysUserDept::getDeptId, vo.getDeptIds()))
                    .stream().map(SysUserDept::getUserId).collect(Collectors.toSet());
            if (deptRelUserIds.isEmpty()) return isPage ? new Page<>() : new ArrayList<>();
        }
        // roleRelUserIds 和 deptRelUserIds 都有值的情况下，取交集，其他情况取并集
        Set<String> filterUserIds = (!roleRelUserIds.isEmpty() && !deptRelUserIds.isEmpty()) ? Sets.intersection(roleRelUserIds, deptRelUserIds) : Sets.union(roleRelUserIds, deptRelUserIds);
        SysUser queryEntity = vo.toEntity();
        queryEntity.setUserId(StrUtil.join(",", filterUserIds));
        return isPage ? UserListResVo.toPage(this.queryPage(vo.toQueryParam(), queryEntity)) : UserListResVo.toVo(this.queryList(vo.toQueryParam(), queryEntity));
    }

}
