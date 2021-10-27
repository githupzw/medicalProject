drop database if exists witmed_db;
create database witmed_db character set utf8mb4;
use witmed_db;

-- 创建系统用户身份信息表：sys_identity
drop table if exists sys_identity;
create table sys_identity(
    id varchar(100) not null comment '主键',
    name varchar(100) not null comment '身份名称',
    code varchar(100) not null comment '身份编码',
    tableName varchar(100) not null comment '对应数据库表名',
    status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
    createUser varchar(100) comment '创建人',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateUser varchar(100) comment '修改人',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='系统用户身份信息表';