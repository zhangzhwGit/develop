package com.zzw.login.service.impl;

import com.zzw.login.dao.SysUserMapper;
import com.zzw.login.pojo.SysUser;
import com.zzw.login.service.SysUserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name SysUserManagerServiceImpl
 * @description
 * @date 2019-08-29
 */
@Service
public class SysUserManagerServiceImpl implements SysUserManagerService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 通过username获取用户信息
     *
     * @param username
     * @return
     * @throws DataAccessException
     */
    @Override
    public SysUser getSysUserByName(String username) throws DataAccessException {
        return sysUserMapper.queryUserByName(username);
    }

    /**
     * 通过username获取角色列表
     *
     * @param userId
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<String> getSysRoleByUserId(Integer userId) throws DataAccessException {
        return sysUserMapper.queryRolesByUserId(userId);
    }

    /**
     * 通过角色列表获取权限
     *
     * @param userId
     * @return
     * @throws DataAccessException
     */
    @Override
    public List<String> getSysPermissionByUserId(Integer userId) throws DataAccessException {
        List<Integer> roleIdList = sysUserMapper.queryRoleIdsByUserId(userId);
        return sysUserMapper.queryPermissionsByRoles(roleIdList);
    }

    /**
     * 该URI权限表中是否有维护，若没有维护，不进行拦截
     *
     * @param url
     * @return
     * @throws DataAccessException
     */
    @Override
    public Boolean needInterceptor(String url) throws DataAccessException {
        return sysUserMapper.countRequestUri(url) > 0;
    }

    @Override
    public List<String> getMenuListByUserId(Integer userId) throws DataAccessException {
        return sysUserMapper.queryMenusByUserId(userId);
    }
}
