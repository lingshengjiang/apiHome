package apihome.modules.apitest.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * Created by zyanycall@gmail.com on 2019-07-02 15:09.
 */
@Data
@TableName("api_test_project")
public class ApiTestProjectEntity {

    /**
     * 项目id
     */
    @TableId
    private Long projectId;

    /**
     * 项目名称
     */
    @NotBlank(message="项目名称不能为空")
    private String projectName;

    /**
     * 项目状态  0：正常状态（默认状态）  1：禁止关闭
     */
    private Integer status = 0;

    /**
     * 项目类型
     */
    @NotBlank(message="项目类型不能为空")
    private String projectType;

    /**
     * 项目版本号，用来进一步区分项目
     */
    private String projectVersion;

    /**
     * 项目负责人
     */
    private String operator;

    /**
     * 项目描述
     */
    private String remark;

    /**
     * 提交用例的人
     */
    private String createBy;

    /**
     * 修改用例的人
     */
    private String modifyBy;

    /**
     * 提交的时间
     */
    private Date gmtCreate;

    /**
     * 更新的时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModify;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(String projectVersion) {
        this.projectVersion = projectVersion;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}
