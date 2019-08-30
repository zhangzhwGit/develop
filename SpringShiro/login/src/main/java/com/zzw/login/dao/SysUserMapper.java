package com.zzw.login.dao;

import com.zzw.login.pojo.SysUser;
import com.zzw.login.pojo.SysUserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser queryUserByName(String username) throws DataAccessException;

    List<String> queryRolesByUserId(Integer userId) throws DataAccessException;

    List<Integer> queryRoleIdsByUserId(Integer userId) throws DataAccessException;

    List<String> queryPermissionsByRoles(List<Integer> roles) throws DataAccessException;

    int countRequestUri(@Param("url") String url) throws DataAccessException;

    List<String> queryMenusByUserId(Integer userId) throws DataAccessException;

}