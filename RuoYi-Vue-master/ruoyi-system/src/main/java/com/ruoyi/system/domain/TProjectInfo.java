package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目信息对象 t_project_info
 * 
 * @author ruoyi
 * @date 2026-02-21
 */
public class TProjectInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectCode;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目全称 */
    @Excel(name = "项目全称")
    private String projectFullName;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 项目性质 */
    @Excel(name = "项目性质")
    private String projectKind;

    /** 项目大类 */
    @Excel(name = "项目大类")
    private String projectClass;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 实际结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actEndDate;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 项目经理编号 */
    @Excel(name = "项目经理编号")
    private String managerId;

    /** 客户项目经理编号 */
    @Excel(name = "客户项目经理编号")
    private String custManagerId;

    /** 项目进度(0-100) */
    @Excel(name = "项目进度(0-100)")
    private Long progress;

    /** 项目预算 */
    @Excel(name = "项目预算")
    private BigDecimal budget;

    /** 预计已投入工作量（人时） */
    @Excel(name = "预计已投入工作量", readConverterExp = "人=时")
    private Long preWorkloadByhour;

    /** 累计已投入工作量（人时） */
    @Excel(name = "累计已投入工作量", readConverterExp = "人=时")
    private Long actWorkloadByhour;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setProjectCode(String projectCode) 
    {
        this.projectCode = projectCode;
    }

    public String getProjectCode() 
    {
        return projectCode;
    }

    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }

    public void setProjectFullName(String projectFullName) 
    {
        this.projectFullName = projectFullName;
    }

    public String getProjectFullName() 
    {
        return projectFullName;
    }

    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }

    public void setProjectKind(String projectKind) 
    {
        this.projectKind = projectKind;
    }

    public String getProjectKind() 
    {
        return projectKind;
    }

    public void setProjectClass(String projectClass) 
    {
        this.projectClass = projectClass;
    }

    public String getProjectClass() 
    {
        return projectClass;
    }

    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }

    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    public void setActEndDate(Date actEndDate) 
    {
        this.actEndDate = actEndDate;
    }

    public Date getActEndDate() 
    {
        return actEndDate;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setManagerId(String managerId) 
    {
        this.managerId = managerId;
    }

    public String getManagerId() 
    {
        return managerId;
    }

    public void setCustManagerId(String custManagerId) 
    {
        this.custManagerId = custManagerId;
    }

    public String getCustManagerId() 
    {
        return custManagerId;
    }

    public void setProgress(Long progress) 
    {
        this.progress = progress;
    }

    public Long getProgress() 
    {
        return progress;
    }

    public void setBudget(BigDecimal budget) 
    {
        this.budget = budget;
    }

    public BigDecimal getBudget() 
    {
        return budget;
    }

    public void setPreWorkloadByhour(Long preWorkloadByhour) 
    {
        this.preWorkloadByhour = preWorkloadByhour;
    }

    public Long getPreWorkloadByhour() 
    {
        return preWorkloadByhour;
    }

    public void setActWorkloadByhour(Long actWorkloadByhour) 
    {
        this.actWorkloadByhour = actWorkloadByhour;
    }

    public Long getActWorkloadByhour() 
    {
        return actWorkloadByhour;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectCode", getProjectCode())
            .append("projectName", getProjectName())
            .append("projectFullName", getProjectFullName())
            .append("projectType", getProjectType())
            .append("projectKind", getProjectKind())
            .append("projectClass", getProjectClass())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("actEndDate", getActEndDate())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("managerId", getManagerId())
            .append("custManagerId", getCustManagerId())
            .append("progress", getProgress())
            .append("budget", getBudget())
            .append("preWorkloadByhour", getPreWorkloadByhour())
            .append("actWorkloadByhour", getActWorkloadByhour())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
