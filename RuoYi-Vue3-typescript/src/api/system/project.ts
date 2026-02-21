import request from '@/utils/request'
import type { AjaxResult, TableDataInfo } from '@/types'

// 查询项目信息列表
export function listProject(query?: any): Promise<TableDataInfo<TProjectInfo[]>> {
  return request({
    url: '/system/project/list',
    method: 'get',
    params: query
  })
}

// 查询项目信息详细
export function getProject(id: number): Promise<AjaxResult<TProjectInfo>> {
  return request({
    url: '/system/project/' + id,
    method: 'get'
  })
}

// 新增项目信息
export function addProject(data: TProjectInfo): Promise<AjaxResult> {
  return request({
    url: '/system/project',
    method: 'post',
    data: data
  })
}

// 修改项目信息
export function updateProject(data: TProjectInfo): Promise<AjaxResult> {
  return request({
    url: '/system/project',
    method: 'put',
    data: data
  })
}

// 删除项目信息
export function delProject(id: number | number[]): Promise<AjaxResult> {
  return request({
    url: '/system/project/' + id,
    method: 'delete'
  })
}
