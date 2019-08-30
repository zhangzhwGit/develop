package com.zzw.login.dao;

import com.zzw.login.pojo.SysMenuPermission;
import com.zzw.login.pojo.SysMenuPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuPermissionMapper {
    long countByExample(SysMenuPermissionExample example);

    int deleteByExample(SysMenuPermissionExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(SysMenuPermission record);

    int insertSelective(SysMenuPermission record);

    List<SysMenuPermission> selectByExample(SysMenuPermissionExample example);

    SysMenuPermission selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") SysMenuPermission record, @Param("example") SysMenuPermissionExample example);

    int updateByExample(@Param("record") SysMenuPermission record, @Param("example") SysMenuPermissionExample example);

    int updateByPrimaryKeySelective(SysMenuPermission record);

    int updateByPrimaryKey(SysMenuPermission record);
}