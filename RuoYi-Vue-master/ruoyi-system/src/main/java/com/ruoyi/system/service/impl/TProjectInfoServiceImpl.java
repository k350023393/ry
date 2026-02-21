package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TProjectInfoMapper;
import com.ruoyi.system.domain.TProjectInfo;
import com.ruoyi.system.service.ITProjectInfoService;

/**
 * 项目信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-02-21
 */
@Service
public class TProjectInfoServiceImpl implements ITProjectInfoService 
{
    @Autowired
    private TProjectInfoMapper tProjectInfoMapper;

    /**
     * 查询项目信息
     * 
     * @param id 项目信息主键
     * @return 项目信息
     */
    @Override
    public TProjectInfo selectTProjectInfoById(Long id)
    {
        return tProjectInfoMapper.selectTProjectInfoById(id);
    }

    /**
     * 查询项目信息列表
     * 
     * @param tProjectInfo 项目信息
     * @return 项目信息
     */
    @Override
    public List<TProjectInfo> selectTProjectInfoList(TProjectInfo tProjectInfo)
    {
        return tProjectInfoMapper.selectTProjectInfoList(tProjectInfo);
    }

    /**
     * 新增项目信息
     * 
     * @param tProjectInfo 项目信息
     * @return 结果
     */
    @Override
    public int insertTProjectInfo(TProjectInfo tProjectInfo)
    {
        tProjectInfo.setCreateTime(DateUtils.getNowDate());
        return tProjectInfoMapper.insertTProjectInfo(tProjectInfo);
    }

    /**
     * 修改项目信息
     * 
     * @param tProjectInfo 项目信息
     * @return 结果
     */
    @Override
    public int updateTProjectInfo(TProjectInfo tProjectInfo)
    {
        tProjectInfo.setUpdateTime(DateUtils.getNowDate());
        return tProjectInfoMapper.updateTProjectInfo(tProjectInfo);
    }

    /**
     * 批量删除项目信息
     * 
     * @param ids 需要删除的项目信息主键
     * @return 结果
     */
    @Override
    public int deleteTProjectInfoByIds(Long[] ids)
    {
        return tProjectInfoMapper.deleteTProjectInfoByIds(ids);
    }

    /**
     * 删除项目信息信息
     * 
     * @param id 项目信息主键
     * @return 结果
     */
    @Override
    public int deleteTProjectInfoById(Long id)
    {
        return tProjectInfoMapper.deleteTProjectInfoById(id);
    }
}
