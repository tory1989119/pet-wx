package com.pet.wx.manager.system.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pet.wx.db.dao.SysManagerDAO;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.SysUserInfo;

@Service
public class SysManagerService {
    @Resource
    private SysManagerDAO sysManagerDAO;

    /**
     * 插入管理员信息
     * 
     * @param sysUserInfo
     * @return
     */
    public int insertSysUser(SysUserInfo sysUserInfo) {
        return sysManagerDAO.insertSysUser(sysUserInfo);
    }

    /**
     * 修改管理员信息
     * 
     * @param sysUserInfo
     * @return
     */
    public int updateSysUser(SysUserInfo sysUserInfo) {
        return sysManagerDAO.updateSysUser(sysUserInfo);
    }

    /**
     * 根据ID获取管理员信息 
     * 
     * @param id
     * @return
     */
    public SysUserInfo getSysUserById(String id) {
        return sysManagerDAO.getSysUserById(id);
    }

    /**
     * 查询管理员列表
     * 
     * @param searchDto
     * @return
     */
    public BaseResponseDto<Object> querySysUser(SysSearchDto searchDto) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        br.setContent(sysManagerDAO.querySysUser(searchDto));
        br.setPageCount(sysManagerDAO.countSysUser(searchDto));
        return br;
    }
}
