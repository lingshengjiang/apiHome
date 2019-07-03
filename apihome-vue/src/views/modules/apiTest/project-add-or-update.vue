<template>
  <el-dialog
    :title="!dataForm.projectId ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
      <el-form-item label="项目名称" prop="projectName">
        <el-input v-model="dataForm.projectName" placeholder="项目名称"></el-input>
      </el-form-item>
      <el-form-item label="类型" prop="projectType">
        <el-input v-model="dataForm.projectType" placeholder="类型"></el-input>
      </el-form-item>
      <el-form-item label="版本号" prop="projectVersion">
        <el-input v-model="dataForm.projectVersion" placeholder="版本号"></el-input>
      </el-form-item>
      <el-form-item label="负责人" prop="operator">
        <el-input v-model="dataForm.operator" placeholder="负责人"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="remark">
        <el-input type="textarea" :rows="3" v-model="dataForm.remark" placeholder="备注"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          projectId: 0,
          projectName: '',
          projectType: '',
          projectVersion: '1.0.0',
          operator: '',
          remark: ''
        },
        dataRule: {
          projectName: [
            { required: true, message: '项目名称不能为空', trigger: 'blur' }
          ],
          projectType: [
            { required: true, message: '项目类型不能为空', trigger: 'blur' }
          ],
          projectVersion: [
            { required: true, message: '项目版本号不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (projectId) {
        this.dataForm.projectId = projectId || 0;
        this.visible = true;
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields();
          if (this.dataForm.projectId) {
            this.$http({
              url: this.$http.adornUrl(`/apiTest/project/info/${this.dataForm.projectId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.projectName = data.config.projectName;
                this.dataForm.projectType = data.config.projectType;
                this.dataForm.projectVersion = data.config.projectVersion;
                this.dataForm.operator = data.config.operator;
                this.dataForm.remark = data.config.remark
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/apiTest/project/${!this.dataForm.projectId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'projectId': this.dataForm.projectId || undefined,
                'projectName': this.dataForm.projectName,
                'projectType': this.dataForm.projectType,
                'projectVersion': this.dataForm.projectVersion,
                'operator': this.dataForm.operator,
                'remark': this.dataForm.remark
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 500,
                  onClose: () => {
                    this.visible = false;
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
