use sanjiaomao;
drop table if exists account;
create table account
(
    id           bigint unsigned primary key comment 'id',
    account_name varchar(20) not null comment '用户名',
    password     varchar(20) not null comment '密码',
    nickname     varchar(20) not null comment '别名',
    is_deleted   integer unsigned default 0 comment '0未删除',
    unique (account_name)
) charset = utf8mb4,comment '账号';

drop table if exists user;
create table user
(
    id         bigint unsigned primary key comment 'id',
    name       varchar(20)     not null comment '姓名',
    gender     int unsigned    not null comment '性别',
    birthday   datetime        not null comment '生日',
    id_card    varchar(20)     not null comment '身份证件',
    account_id bigint unsigned not null comment 'accountId',
    is_deleted integer unsigned default 0 comment '0未删除',
    unique (id_card)
) charset = utf8mb4,comment '用户';


drop table if exists role;
create table role
(

    id         bigint unsigned comment 'id'
        primary key,
    role_code  varchar(20) not null comment '角色编码',
    role_name  varchar(20) not null comment '角色名称',
    is_deleted integer unsigned default 0 comment '0未删除',
    unique (role_code)
) charset = utf8mb4, comment '角色';

insert into role(id, role_code, role_name)
values (1, 'ADMIN', '管理员');

insert into role(id, role_code, role_name)
values (2, 'NORMAL', '一般用户');

drop table if exists account_role_rel;
create table account_role_rel
(
    id         bigint unsigned comment 'id'
        primary key,
    account_id bigint unsigned not null comment 'accountId',
    role_id    bigint unsigned not null comment 'roleId',
    is_deleted integer unsigned default 0 comment '0未删除',
    unique (account_id, role_id)
) charset = utf8mb4,comment '账号-角色';

drop table if exists plant;
create table if not exists plant
(
    id            bigint unsigned comment 'id' primary key,
    plant_name    varchar(20)     not null comment '计划名称',
    plant_date    datetime        not null comment '计划开始时间',
    plant_key     varchar(50)     not null comment '计划摘要',
    plant_content text            not null comment '计划内容',
    account_id    bigint unsigned not null comment '计划创建人id',
    is_deleted    integer unsigned default 0 comment '0未删除'
) charset = utf8mb4, comment '计划表';
