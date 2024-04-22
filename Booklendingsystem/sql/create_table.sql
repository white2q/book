-- 创建库
create database if not exists booklending;

-- 切换库
use booklending;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                       not null comment '账号',
    userPassword varchar(512)                       not null comment '密码',
    userName     varchar(256)                       null comment '用户昵称',
    createTime   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint  default 0                 not null comment '是否删除'
) comment '用户' collate = utf8mb4_unicode_ci;

-- 图书表
create table if not exists book
(
    id         bigint auto_increment comment 'id' primary key,
    bookName   varchar(256)                       not null comment '图书名称',
    status     tinyint  default 0                 not null comment '借阅状态',
    createTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 not null comment '是否删除'
) comment '图书' collate = utf8mb4_unicode_ci;
