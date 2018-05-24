# waterloo-hipster-ui

类似JHipster可以自动生成Java后端项目和代码的自动化工具，适合创建Spring Boot和Spring Cloud微服务项目。

## 概述

项目[waterloo-hipster](https://github.com/waterlu/waterloo-hipster) 提供了自动生成代码和文档的核心实现；项目[waterloo-hipster-ui](https://github.com/waterlu/waterloo-hipster-ui) 通过Web页面来使用waterloo-hipster核心类库。

### 创建项目

启动waterloo-hipster-ui，打开http://localhost:8080 页面，填写项目相关信息，点击“生成微服务工程代码”按钮自动生成项目工程和源代码到本地磁盘目录。

### 生成MVC源代码

引入waterloo-hipster，调用方法根据数据库表生成Controller/Service/Mapper/Entity/DTO/VO类和mapper.xml文件。

```xml
<dependency>
    <groupId>cn.waterlu</groupId>
    <artifactId>waterloo-hipster</artifactId>
</dependency>
```

### 生成接口文档

引入waterloo-hipster，调用方法访问/v2/api-docs读取json文件并生成markdown接口文档。

## 定制化

(1) 请根据实际情况修改/resources/static/js/controllers/project.js文件更改页面默认配置

- $scope.groupId - 默认组织名称
- $scope.artifactId - 默认项目名称
- $scope.springBootVersion - SpringBoot版本（默认1.5.13.RELEASE）
- $scope.author - 默认作者
- $scope.basePackage - 默认基础包目录
- $scope.projectDir - 默认生成项目所在目录
- $scope.dbIP - 默认连接数据库地址（读取库表结构用）
- $scope.dbUsername - 默认连接数据库用户名
- $scope.dbPassword - 默认连接数据库密码
- $scope.controllerPackage - Controller类所在包名称（默认web）
- $scope.daoPackage - Mapper类所在包名称（默认mapper）
- $scope.entityPackage - 实体类所在包名称（默认entity）
- $scope.dtoPackage - DTO类所在包名称（默认vo）
- $scope.voPackage - VO类所在包名称（默认vo）