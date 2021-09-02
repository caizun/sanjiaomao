use sanjiaomao;
drop table if exists account;
create table account
(
    id       bigint unsigned primary key auto_increment comment 'id',
    account  varchar(20)               not null comment '用户名',
    password varchar(20)               not null comment '密码',
    nickname varchar(20)               not null comment '别名'
) comment '账号';

drop table if exists sys_user;
create table sys_user
(
    id       bigint unsigned primary key auto_increment comment 'id',
    name     varchar(20)  not null comment '姓名',
    gender   int unsigned not null comment '性别',
    birthday datetime     not null comment '生日',
    id_card  varchar(20)  not null comment '身份证件',
    account_id  bigint unsigned  not null comment 'accountId'
) comment '用户';

