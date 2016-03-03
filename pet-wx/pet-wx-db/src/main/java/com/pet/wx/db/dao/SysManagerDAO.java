package com.pet.wx.db.dao;

import java.util.List;
import java.util.Map;

import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.SysMenuInfo;
import com.pet.wx.db.model.SysUserInfo;


public interface SysManagerDAO {
    /**
     * 根据账号和密码获取用户信息
     * 
     * @param sysUser
     * @return
     */
    public SysUserInfo getSysUserByUsernameAndPwd(SysUserInfo sysUser);

    

    /**
     * 插入管理员信息
     * 
     * @param sysUser
     * @return
     */
    public int insertSysUser(SysUserInfo sysUser);

    /**
     * 修改管理员信息
     * 
     * @param sysUser
     * @return
     */
    public int updateSysUser(SysUserInfo sysUser);

    /**
     * 根据ID获取管理员信息 
     * 
     * @param id
     * @return
     */
    public SysUserInfo getSysUserById(String id);

    /**
     * 查询管理员列表
     * 
     * @param searchDto
     * @return
     */
    public List<SysUserInfo> querySysUser(SysSearchDto searchDto);

    /**
     * 查询管理员列表数
     * 
     * @param searchDto
     * @return
     */
    public int countSysUser(SysSearchDto searchDto);

    /**
     * 获取菜单列表
     * 
     * @return
     */
    public List<SysMenuInfo> querySysMenu(Map<String, String> params);
}