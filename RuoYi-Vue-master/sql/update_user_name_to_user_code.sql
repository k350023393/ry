-- 用户账号字段 user_name 改为 user_code（升级脚本，已有库执行）
ALTER TABLE sys_user CHANGE COLUMN user_name user_code varchar(30) NOT NULL COMMENT '用户账号';
ALTER TABLE sys_logininfor CHANGE COLUMN user_name user_code varchar(50) DEFAULT '' COMMENT '用户账号';
