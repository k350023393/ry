package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TProjectInfo;
import com.ruoyi.system.service.ITProjectInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目信息Controller
 * 
 * @author ruoyi
 * @date 2026-02-21
 */
@RestController
@RequestMapping("/system/project")
public class TProjectInfoController extends BaseController
{
    @Autowired
    private ITProjectInfoService tProjectInfoService;

    /**
     * 查询项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(TProjectInfo tProjectInfo)
    {
        startPage();
        List<TProjectInfo> list = tProjectInfoService.selectTProjectInfoList(tProjectInfo);
        return getDataTable(list);
    }

    /**
     * 导出项目信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:export')")
    @Log(title = "项目信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TProjectInfo tProjectInfo)
    {
        List<TProjectInfo> list = tProjectInfoService.selectTProjectInfoList(tProjectInfo);
        ExcelUtil<TProjectInfo> util = new ExcelUtil<TProjectInfo>(TProjectInfo.class);
        util.exportExcel(response, list, "项目信息数据");
    }

    /**
     * 获取项目信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tProjectInfoService.selectTProjectInfoById(id));
    }

    /**
     * 新增项目信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:add')")
    @Log(title = "项目信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProjectInfo tProjectInfo)
    {
        return toAjax(tProjectInfoService.insertTProjectInfo(tProjectInfo));
    }

    /**
     * 修改项目信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "项目信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProjectInfo tProjectInfo)
    {
        return toAjax(tProjectInfoService.updateTProjectInfo(tProjectInfo));
    }

    /**
     * 删除项目信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:remove')")
    @Log(title = "项目信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tProjectInfoService.deleteTProjectInfoByIds(ids));
    }
}
