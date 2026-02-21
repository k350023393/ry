package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TProjectInfo;

/**
 * 项目信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-02-21
 */
public interface TProjectInfoMapper 
{
    /**
     * 查询项目信息
     * 
     * @param id 项目信息主键
     * @return 项目信息
     */
    public TProjectInfo selectTProjectInfoById(Long id);

    /**
     * 查询项目信息列表
     * 
     * @param tProjectInfo 项目信息
     * @return 项目信息集合
     */
    public List<TProjectInfo> selectTProjectInfoList(TProjectInfo tProjectInfo);

    /**
     * 新增项目信息
     * 
     * @param tProjectInfo 项目信息
     * @return 结果
     */
    public int insertTProjectInfo(TProjectInfo tProjectInfo);

    /**
     * 修改项目信息
     * 
     * @param tProjectInfo 项目信息
     * @return 结果
     */
    public int updateTProjectInfo(TProjectInfo tProjectInfo);

    /**
     * 删除项目信息
     * 
     * @param id 项目信息主键
     * @return 结果
     */
    public int deleteTProjectInfoById(Long id);

    /**
     * 批量删除项目信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTProjectInfoByIds(Long[] ids);
}
