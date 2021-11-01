-- 创建并使用数据库：medical_db
drop database if exists medical_db;
create database medical_db character set utf8mb4;
use medical_db;

-- 创建数据源值域代码类别信息表：sys_data_code_category
drop table if exists sys_data_code_category;
create table sys_data_code_category(
    id varchar(100) not null comment '数据代码类别主键',
    name varchar(100) not null comment '数据代码类别名称',
    code varchar(100) not null comment '数据代码类别编码',
    status varchar(2) not null default 1 comment '系统状态：0-禁用，1-启用',
    createUser varchar(100) comment '创建人',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateUser varchar(100) comment '修改人',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='创建数据源值域代码类别信息表';

-- 创建数据源值域代码信息表：sys_data_code
drop table if exists sys_data_code;
create table sys_data_code(
    id varchar(100) not null comment '数据代码主键',
    dataCategory varchar(100) not null comment '所属代码类别',
    name varchar(100) not null comment '数据代码名称',
    code varchar(100) not null comment '数据代码编码',
    status varchar(2) not null default 1 comment '系统状态：0-禁用，1-启用',
    createUser varchar(100) comment '创建人',
    createTime timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
    updateUser varchar(100) comment '修改人',
    updateTime timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
    primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='创建数据源值域代码信息表';