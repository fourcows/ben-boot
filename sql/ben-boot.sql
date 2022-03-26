CREATE DATABASE  `ben-boot` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use `ben-boot`;

create table sys_user
(
    user_id bigint auto_increment
        primary key,
    user_name varchar(64) not null,
    email varchar(64) null,
    gender tinyint null,
    create_by bigint null,
    create_time datetime null,
    update_by bigint null,
    update_time datetime null,
    status tinyint default 0 not null,
    is_deleted tinyint default 0 not null,
    constraint sys_user_user_name_uindex
        unique (user_name)
)
    comment '用户表';

