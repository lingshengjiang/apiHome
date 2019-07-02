-- 接口测试项目表
CREATE TABLE `api_test_project` (
  `project_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) NOT NULL COMMENT '项目名称',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '状态  0：禁用   1：正常',
  `project_type` varchar(20) COMMENT '项目类型',
  `project_version` varchar(20) COMMENT '项目版本号',
  `operator` varchar(20) COMMENT '项目负责人',
  `remark` varchar(300) COMMENT '项目描述',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建格林尼治时间',
  `create_by` bigint(20) unsigned COMMENT '提交用户id',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改格林尼治时间',
  `modify_by` bigint(20) unsigned COMMENT '修改用户id',
  PRIMARY KEY (`project_id`),
  UNIQUE INDEX (`project_name`,`project_type`,`project_version`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='接口测试项目表';