<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目编号" prop="projectCode">
        <el-input
          v-model="queryParams.projectCode"
          placeholder="请输入项目编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目全称" prop="projectFullName">
        <el-input
          v-model="queryParams.projectFullName"
          placeholder="请输入项目全称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目类型" prop="projectType">
        <el-select v-model="queryParams.projectType" placeholder="请选择项目类型" clearable>
          <el-option
            v-for="dict in p_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="项目性质" prop="projectKind">
        <el-select v-model="queryParams.projectKind" placeholder="请选择项目性质" clearable>
          <el-option
            v-for="dict in p_kind"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="项目大类" prop="projectClass">
        <el-select v-model="queryParams.projectClass" placeholder="请选择项目大类" clearable>
          <el-option
            v-for="dict in p_class"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="开始日期" prop="startDate">
        <el-date-picker clearable
          v-model="queryParams.startDate"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择开始日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结束日期" prop="endDate">
        <el-date-picker clearable
          v-model="queryParams.endDate"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实际结束日期" prop="actEndDate">
        <el-date-picker clearable
          v-model="queryParams.actEndDate"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择实际结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in p_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="项目经理编号" prop="managerId">
        <el-input
          v-model="queryParams.managerId"
          placeholder="请输入项目经理编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客户项目经理编号" prop="custManagerId">
        <el-input
          v-model="queryParams.custManagerId"
          placeholder="请输入客户项目经理编号"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目进度(0-100)" prop="progress">
        <el-input
          v-model="queryParams.progress"
          placeholder="请输入项目进度(0-100)"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目预算" prop="budget">
        <el-input
          v-model="queryParams.budget"
          placeholder="请输入项目预算"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预计已投入工作量" prop="preWorkloadByhour">
        <el-input
          v-model="queryParams.preWorkloadByhour"
          placeholder="请输入预计已投入工作量"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="累计已投入工作量" prop="actWorkloadByhour">
        <el-input
          v-model="queryParams.actWorkloadByhour"
          placeholder="请输入累计已投入工作量"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['system:project:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:project:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:project:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['system:project:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="projectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="项目编号" align="center" prop="projectCode" />
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="项目全称" align="center" prop="projectFullName" />
      <el-table-column label="项目类型" align="center" prop="projectType">
        <template #default="scope">
          <dict-tag :options="p_type" :value="scope.row.projectType"/>
        </template>
      </el-table-column>
      <el-table-column label="项目性质" align="center" prop="projectKind">
        <template #default="scope">
          <dict-tag :options="p_kind" :value="scope.row.projectKind"/>
        </template>
      </el-table-column>
      <el-table-column label="项目大类" align="center" prop="projectClass">
        <template #default="scope">
          <dict-tag :options="p_class" :value="scope.row.projectClass"/>
        </template>
      </el-table-column>
      <el-table-column label="开始日期" align="center" prop="startDate" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.startDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束日期" align="center" prop="endDate" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.endDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实际结束日期" align="center" prop="actEndDate" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.actEndDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
        <template #default="scope">
          <dict-tag :options="p_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="项目经理编号" align="center" prop="managerId" />
      <el-table-column label="客户项目经理编号" align="center" prop="custManagerId" />
      <el-table-column label="项目进度(0-100)" align="center" prop="progress" />
      <el-table-column label="项目预算" align="center" prop="budget" />
      <el-table-column label="预计已投入工作量" align="center" prop="preWorkloadByhour" />
      <el-table-column label="累计已投入工作量" align="center" prop="actWorkloadByhour" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:project:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:project:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改项目信息对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="projectRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目编号" prop="projectCode">
          <el-input v-model="form.projectCode" placeholder="请输入项目编号" />
        </el-form-item>
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="项目全称" prop="projectFullName">
          <el-input v-model="form.projectFullName" placeholder="请输入项目全称" />
        </el-form-item>
        <el-form-item label="项目类型" prop="projectType">
          <el-select v-model="form.projectType" placeholder="请选择项目类型">
            <el-option
              v-for="dict in p_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="项目性质" prop="projectKind">
          <el-select v-model="form.projectKind" placeholder="请选择项目性质">
            <el-option
              v-for="dict in p_kind"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="项目大类" prop="projectClass">
          <el-select v-model="form.projectClass" placeholder="请选择项目大类">
            <el-option
              v-for="dict in p_class"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable
            v-model="form.startDate"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束日期" prop="endDate">
          <el-date-picker clearable
            v-model="form.endDate"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际结束日期" prop="actEndDate">
          <el-date-picker clearable
            v-model="form.actEndDate"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择实际结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择状态">
            <el-option
              v-for="dict in p_status"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="项目经理编号" prop="managerId">
          <el-input v-model="form.managerId" placeholder="请输入项目经理编号" />
        </el-form-item>
        <el-form-item label="客户项目经理编号" prop="custManagerId">
          <el-input v-model="form.custManagerId" placeholder="请输入客户项目经理编号" />
        </el-form-item>
        <el-form-item label="项目进度(0-100)" prop="progress">
          <el-input v-model="form.progress" placeholder="请输入项目进度(0-100)" />
        </el-form-item>
        <el-form-item label="项目预算" prop="budget">
          <el-input v-model="form.budget" placeholder="请输入项目预算" />
        </el-form-item>
        <el-form-item label="预计已投入工作量" prop="preWorkloadByhour">
          <el-input v-model="form.preWorkloadByhour" placeholder="请输入预计已投入工作量" />
        </el-form-item>
        <el-form-item label="累计已投入工作量" prop="actWorkloadByhour">
          <el-input v-model="form.actWorkloadByhour" placeholder="请输入累计已投入工作量" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup lang="ts" name="Project">
import { listProject, getProject, delProject, addProject, updateProject } from "@/api/system/project"

const { proxy } = getCurrentInstance()
const { p_status, p_kind, p_class, p_type } = proxy.useDict('p_status', 'p_kind', 'p_class', 'p_type')

const projectList = ref([])
const open = ref(false)
const loading = ref(true)
const showSearch = ref(true)
const ids = ref([])
const single = ref(true)
const multiple = ref(true)
const total = ref(0)
const title = ref("")

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    projectCode: null,
    projectName: null,
    projectFullName: null,
    projectType: null,
    projectKind: null,
    projectClass: null,
    startDate: null,
    endDate: null,
    actEndDate: null,
    status: null,
    managerId: null,
    custManagerId: null,
    progress: null,
    budget: null,
    preWorkloadByhour: null,
    actWorkloadByhour: null,
  },
  rules: {
    projectCode: [
      { required: true, message: "项目编号不能为空", trigger: "blur" }
    ],
    projectName: [
      { required: true, message: "项目名称不能为空", trigger: "blur" }
    ],
    projectFullName: [
      { required: true, message: "项目全称不能为空", trigger: "blur" }
    ],
    projectType: [
      { required: true, message: "项目类型不能为空", trigger: "change" }
    ],
    projectKind: [
      { required: true, message: "项目性质不能为空", trigger: "change" }
    ],
    startDate: [
      { required: true, message: "开始日期不能为空", trigger: "blur" }
    ],
    status: [
      { required: true, message: "状态不能为空", trigger: "change" }
    ],
  }
})

const { queryParams, form, rules } = toRefs(data)

/** 查询项目信息列表 */
function getList() {
  loading.value = true
  listProject(queryParams.value).then(response => {
    projectList.value = response.rows
    total.value = response.total
    loading.value = false
  })
}

// 取消按钮
function cancel() {
  open.value = false
  reset()
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    projectCode: null,
    projectName: null,
    projectFullName: null,
    projectType: null,
    projectKind: null,
    projectClass: null,
    startDate: null,
    endDate: null,
    actEndDate: null,
    status: null,
    remark: null,
    managerId: null,
    custManagerId: null,
    progress: null,
    budget: null,
    preWorkloadByhour: null,
    actWorkloadByhour: null,
    createTime: null,
    updateTime: null,
    createBy: null,
    updateBy: null
  }
  proxy.resetForm("projectRef")
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1
  getList()
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef")
  handleQuery()
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id)
  single.value = selection.length != 1
  multiple.value = !selection.length
}

/** 新增按钮操作 */
function handleAdd() {
  reset()
  open.value = true
  title.value = "添加项目信息"
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset()
  const _id = row.id || ids.value
  getProject(_id).then(response => {
    form.value = response.data
    open.value = true
    title.value = "修改项目信息"
  })
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["projectRef"].validate((valid: boolean) => {
    if (valid) {
      if (form.value.id != null) {
        updateProject(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功")
          open.value = false
          getList()
        })
      } else {
        addProject(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功")
          open.value = false
          getList()
        })
      }
    }
  })
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value
  proxy.$modal.confirm('是否确认删除项目信息编号为"' + _ids + '"的数据项？').then(function() {
    return delProject(_ids)
  }).then(() => {
    getList()
    proxy.$modal.msgSuccess("删除成功")
  }).catch(() => {})
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('system/project/export', {
    ...queryParams.value
  }, `project_${new Date().getTime()}.xlsx`)
}

getList()
</script>
