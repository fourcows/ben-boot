## 框架简介

ben系列框架采用最新的技术栈开发，底层封装通用的逻辑，可减少大量重复代码，可帮助您快速开发ERP、OA、CRM等后台管理系统

> 友情提示：
> - 后端项目 [ben-boot](https://github.com/fourcows/ben-boot)
> - 前端项目 [ben-ui](https://github.com/fourcows/ben-ui)
> - 项目文档 [ben-doc](https://fourcows.github.io/ben-doc)

## 技术栈

### ben-boot

* jdk17、Spring Boot、Lombok、Hutool、Druid

### ben-ui

* 基于vben-admin开发(ts + vue3 + vite)

## 内置功能

- [x]  封装了通用的CRUD逻辑，可减少大量重复代码。

## todo

- [ ]  java17最新语法的实践
- [ ]  集成Spring Security，并实现可统一动态配置功能权限的功能
- [ ]  细粒度的数据权限，具体到角色下某个功能可单独配置，比如可以实现某个角色能查看所有部门的数据、审核本部门的数据、删除自己创建的数据
- [ ]  支持一个用户从属多个部门
- [ ]  支持多列排序、与or或条件检索
- [ ]  数据字典的实现
- [ ]  站内通知（websocket）
- [ ]  工作流（flowable）
