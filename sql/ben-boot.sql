CREATE DATABASE `ben-boot` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use `ben-boot`;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `dept_id`     bigint      NOT NULL AUTO_INCREMENT,
    `dept_name`   varchar(64) NOT NULL,
    `parent_id`   bigint               DEFAULT NULL,
    `create_by`   bigint               DEFAULT NULL,
    `create_time` datetime             DEFAULT NULL,
    `update_by`   bigint               DEFAULT NULL,
    `update_time` datetime             DEFAULT NULL,
    `status`      tinyint     NOT NULL DEFAULT '0',
    `is_deleted`  tinyint     NOT NULL DEFAULT '0',
    `remark`      varchar(255)         DEFAULT NULL,
    PRIMARY KEY (`dept_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='部门表';

--
-- Dumping data for table `sys_dept`
--

INSERT INTO `sys_dept`
VALUES (1, 'test', NULL, NULL, '2022-10-18 20:47:48', NULL, '2022-10-18 20:48:02', 0, 0, 'test');
INSERT INTO `sys_dept`
VALUES (2, 'test2', NULL, NULL, '2022-10-18 20:47:52', NULL, '2022-10-18 20:47:57', 0, 0, '');
INSERT INTO `sys_dept`
VALUES (3, 'test3', 1, NULL, '2022-10-18 21:19:45', NULL, NULL, 0, 0, NULL);

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `menu_id`     bigint      NOT NULL AUTO_INCREMENT,
    `menu_name`   varchar(64) NOT NULL,
    `parent_id`   bigint               DEFAULT NULL,
    `path`        varchar(64)          DEFAULT NULL,
    `component`   varchar(64)          DEFAULT NULL,
    `redirect`    varchar(255)         DEFAULT NULL,
    `title`       varchar(64)          DEFAULT NULL,
    `update_time` datetime             DEFAULT NULL,
    `status`      tinyint     NOT NULL DEFAULT '0',
    `is_deleted`  tinyint     NOT NULL DEFAULT '0',
    `create_by`   bigint               DEFAULT NULL,
    `create_time` datetime             DEFAULT NULL,
    `update_by`   bigint               DEFAULT NULL,
    `visible`     tinyint              DEFAULT NULL,
    `icon`        varchar(64)          DEFAULT NULL,
    `remark`      varchar(255)         DEFAULT NULL,
    PRIMARY KEY (`menu_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='菜单表';

--
-- Dumping data for table `sys_menu`
--

INSERT INTO `sys_menu`
VALUES (1, '首页', NULL, '/dashboard', '/dashboard/analysis/index', NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL,
        'ant-design:home-outlined', NULL);
INSERT INTO `sys_menu`
VALUES (2, '系统管理', NULL, '/system', 'LAYOUT', '/system/user', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL,
        'ant-design:setting-outlined', NULL);
INSERT INTO `sys_menu`
VALUES (3, '用户管理', 2, '/user', '/system/user/index', NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL,
        'ant-design:user-outlined', NULL);
INSERT INTO `sys_menu`
VALUES (4, '部门管理', 2, '/dept', '/system/dept/index', NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL,
        'ant-design:apartment-outlined', NULL);
INSERT INTO `sys_menu`
VALUES (5, '角色管理', 2, '/role', '/system/role/index', NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL,
        'ant-design:team-outlined', NULL);
INSERT INTO `sys_menu`
VALUES (6, '菜单管理', 2, '/menu', '/system/menu/index', NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL,
        'ant-design:menu-outlined', NULL);
INSERT INTO `sys_menu`
VALUES (7, 'About Me', NULL, '/about', '/sys/about/index', NULL, NULL, NULL, 0, 0, NULL, NULL, NULL, NULL,
        'simple-icons:about-dot-me', NULL);

--
-- Table structure for table `sys_perm`
--

DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm`
(
    `perm_id`     bigint      NOT NULL AUTO_INCREMENT,
    `perm_name`   varchar(64) NOT NULL,
    `menu_id`     bigint               DEFAULT NULL,
    `url_perm`    varchar(64)          DEFAULT NULL,
    `btn_perm`    varchar(64)          DEFAULT NULL,
    `create_time` datetime             DEFAULT NULL,
    `update_by`   bigint               DEFAULT NULL,
    `update_time` datetime             DEFAULT NULL,
    `status`      tinyint     NOT NULL DEFAULT '0',
    `is_deleted`  tinyint     NOT NULL DEFAULT '0',
    `create_by`   bigint               DEFAULT NULL,
    PRIMARY KEY (`perm_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='权限表';

--
-- Dumping data for table `sys_perm`
--
INSERT INTO `sys_perm`
VALUES (1, '用户列表', 3, 'GET:/system/users', 'system:users:list', null, null, '2022-10-29 00:34:17', 0, 0, null);
INSERT INTO `sys_perm`
VALUES (2, '用户详情', 3, 'GET:/system/users/*', 'system:users:detail', null, null, '2022-10-29 00:33:41', 0, 0, null);
INSERT INTO `sys_perm`
VALUES (3, '新增用户', 3, 'POST:/system/users', 'system:users:add', null, null, '2022-10-29 00:33:32', 0, 0, null);
INSERT INTO `sys_perm`
VALUES (4, '修改用户', 3, 'PUT:/system/users/*', 'system:users:edit', null, null, null, 0, 0, null);
INSERT INTO `sys_perm`
VALUES (5, '删除用户', 3, 'DELETE:/system/users/*', 'system:users:delete', null, null, null, 0, 0, null);

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `role_id`     bigint      NOT NULL AUTO_INCREMENT,
    `role_name`   varchar(64) NOT NULL,
    `role_key`    varchar(64)          DEFAULT NULL,
    `remark`      varchar(64)          DEFAULT NULL,
    `create_by`   bigint               DEFAULT NULL,
    `create_time` datetime             DEFAULT NULL,
    `update_by`   bigint               DEFAULT NULL,
    `update_time` datetime             DEFAULT NULL,
    `status`      tinyint     NOT NULL DEFAULT '0',
    `is_deleted`  tinyint     NOT NULL DEFAULT '0',
    PRIMARY KEY (`role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色表';

--
-- Dumping data for table `sys_role`
--

INSERT INTO `sys_role`
VALUES (1, 'admin', 'admin', NULL, NULL, NULL, NULL, NULL, 0, 0);

--
-- Table structure for table `sys_role_dept`
--

DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`
(
    `user_id` bigint NOT NULL AUTO_INCREMENT,
    `dept_id` bigint NOT NULL,
    `role_id` bigint DEFAULT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='菜单表';

--
-- Dumping data for table `sys_role_dept`
--


--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `role_id` bigint DEFAULT NULL,
    `menu_id` bigint DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色-菜单关系表';

--
-- Dumping data for table `sys_role_menu`
--

INSERT INTO `sys_role_menu`
VALUES (1, 1);
INSERT INTO `sys_role_menu`
VALUES (1, 2);
INSERT INTO `sys_role_menu`
VALUES (1, 3);
INSERT INTO `sys_role_menu`
VALUES (1, 4);
INSERT INTO `sys_role_menu`
VALUES (1, 5);
INSERT INTO `sys_role_menu`
VALUES (1, 6);
INSERT INTO `sys_role_menu`
VALUES (1, 7);

--
-- Table structure for table `sys_role_perm`
--

DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm`
(
    `role_id` bigint NOT NULL,
    `perm_id` bigint DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='角色权限关系表';

--
-- Dumping data for table `sys_role_perm`
--


--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `user_id`     bigint      NOT NULL AUTO_INCREMENT,
    `username`    varchar(64) NOT NULL,
    `password`    varchar(64)          DEFAULT NULL,
    `nick_name`   varchar(64)          DEFAULT NULL,
    `create_by`   bigint               DEFAULT NULL,
    `create_time` datetime             DEFAULT NULL,
    `update_by`   bigint               DEFAULT NULL,
    `update_time` datetime             DEFAULT NULL,
    `status`      tinyint     NOT NULL DEFAULT '0',
    `is_deleted`  tinyint     NOT NULL DEFAULT '0',
    `email`       varchar(64)          DEFAULT NULL,
    `gender`      tinyint              DEFAULT NULL,
    `avatar`      varchar(255)         DEFAULT NULL,
    `remark`      varchar(255)         DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `sys_user_user_name_uindex` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户表';

--
-- Dumping data for table `sys_user`
--

INSERT INTO `sys_user`
VALUES (1, 'ben', '123456', 'ben', NULL, NULL, NULL, '2022-10-18 21:18:18', 0, 0, '123', NULL, NULL, NULL);

--
-- Table structure for table `sys_user_dept`
--

DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept`
(
    `user_id` bigint NOT NULL,
    `dept_id` bigint DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户部门关系表';

--
-- Dumping data for table `sys_user_dept`
--

INSERT INTO `sys_user_dept`
VALUES (1, 1);

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `user_id` bigint NOT NULL,
    `role_id` bigint DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='用户角色关系表';

--
-- Dumping data for table `sys_user_role`
--

INSERT INTO `sys_user_role`
VALUES (1, 1);
