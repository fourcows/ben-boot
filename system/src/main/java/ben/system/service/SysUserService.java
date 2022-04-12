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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, ids));
        sysUserDeptService.remove(new LambdaQueryWrapper<SysUserDept>().eq(SysUserDept::getUserId, ids));
    }

    public UserDetailResVo detail(String id) {
        UserDetailResVo result = UserDetailResVo.parse(this.getById(id));
        List<String> roleIds = sysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>().select(SysUserRole::getRoleId).eq(SysUserRole::getUserId, id)).stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        result.setRoleIds(roleIds);
        List<String> deptIds = sysUserDeptService.list(new LambdaQueryWrapper<SysUserDept>().select(SysUserDept::getDeptId).eq(SysUserDept::getUserId, id)).stream().map(SysUserDept::getDeptId).collect(Collectors.toList());
        result.setDeptIds(deptIds);
        return result;
    }

    public List<UserListResVo> queryList(UserListReqVo vo) {
        HashSet<String> filterUserIds = new HashSet<>();
        if (!vo.getRoleIds().isEmpty()) {
            List<String> userIds = sysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>().in(SysUserRole::getRoleId, vo.getRoleIds()))
                    .stream().map(SysUserRole::getUserId).collect(Collectors.toList());
            if (userIds.isEmpty()) return new ArrayList<>();
            filterUserIds.addAll(userIds);
        }
        if (!vo.getDeptIds().isEmpty()) {
            List<String> userIds = sysUserDeptService.list(new LambdaQueryWrapper<SysUserDept>().in(SysUserDept::getDeptId, vo.getDeptIds()))
                    .stream().map(SysUserDept::getUserId).collect(Collectors.toList());
            if (userIds.isEmpty()) return new ArrayList<>();
            filterUserIds.addAll(userIds);
        }
        SysUser queryEntity = vo.toEntity();
        queryEntity.setUserId(StrUtil.join(",", filterUserIds));
        return UserListResVo.toVo(this.queryList(vo.toQueryParam(), queryEntity));
    }

    public IPage<UserListResVo> queryPage(UserListReqVo vo) {
        HashSet<String> filterUserIds = new HashSet<>();
        if (!vo.getRoleIds().isEmpty()) {
            List<String> userIds = sysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>().in(SysUserRole::getRoleId, vo.getRoleIds()))
                    .stream().map(SysUserRole::getUserId).collect(Collectors.toList());
            if (userIds.isEmpty()) return new Page<>();
            filterUserIds.addAll(userIds);
        }
        if (!vo.getDeptIds().isEmpty()) {
            List<String> userIds = sysUserDeptService.list(new LambdaQueryWrapper<SysUserDept>().in(SysUserDept::getDeptId, vo.getDeptIds()))
                    .stream().map(SysUserDept::getUserId).collect(Collectors.toList());
            if (userIds.isEmpty()) return new Page<>();
            filterUserIds.addAll(userIds);
        }
        SysUser queryEntity = vo.toEntity();
        queryEntity.setUserId(StrUtil.join(",", filterUserIds));
        return UserListResVo.toPage(this.queryPage(vo.toQueryParam(), queryEntity));
    }
}
