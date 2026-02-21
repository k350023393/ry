-- 用户昵称字段 nick_name 改为 user_name（升级脚本，已有库执行）
ALTER TABLE sys_user CHANGE COLUMN nick_name user_name varchar(30) NOT NULL COMMENT '用户名称';
