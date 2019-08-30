package com.zzw.login.service;

import com.zzw.login.pojo.SysUser;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name SysUserManagerService
 * @description
 * @date 2019-08-29
 */
@Service
public interface SysUserManagerService {

    SysUser getSysUserByName(String username) throws DataAccessException;

    List<String> getSysRoleByUserId(Integer userId) throws DataAccessException;

    List<String> getSysPermissionByUserId(Integer userId) throws DataAccessException;

    Boolean needInterceptor(String url) throws DataAccessException;

    List<String> getMenuListByUserId(Integer userId) throws DataAccessException;

}
