# waterloo-hipster-ui

类似JHipster可以自动生成Java后端项目和代码的自动化工具，适合创建Spring Boot和Spring Cloud微服务项目。

## 概述

项目[waterloo-hipster](https://github.com/waterlu/waterloo-hipster) 提供了自动生成代码和文档的核心实现；项目[waterloo-hipster-ui](https://github.com/waterlu/waterloo-hipster-ui) 通过Web页面来使用waterloo-hipster核心类库。

### 创建项目

启动waterloo-hipster-ui，打开http://localhost:8080 页面，填写项目相关信息，点击“生成微服务工程代码”按钮自动生成项目工程和源代码到本地磁盘目录，以下为一个自动生成的典型项目结构。

```shell
[service-demo]
	[src]
		[main]
			[java]
				[entity]
					Demo.java
				[mapper]
					DemoMapper.java
				[service]
					[impl]
						DemoServiceImpl.java
					DemoService.java
             	[vo]
             		DemoDTO.java
             		DemoQueryDTO.java
             		DemoVO.java
             	[web]
             		DemoController.java
             	DemoApplication.java
			[resources]
            	[mybatis]
            		[mapper]
            			DemoMapper.xml
            	[templates]
            		doc.ftl
            	application.properties
            	application-dev.properties
            	application-test.properties
            	bootstrap.properties
            	log4j2.xml
            	hipster-config.json
		[test]
			[java]
				DemoApplicationTests.java
	.gitignore
    pom.xml
```

### 重新生成代码

执行DemoApplicationTests类的generateSourceCode()方法可以根据hipster-config.json配置重新生成代码。

以下代码和文件将重新生成，并覆盖原文件。**注意：DemoMapper.xml文件能够实现自动合并，但是.java文件只能覆盖，如果已经改动过.java文件，请注意在重新生成代码前做好备份工作。**

```shell
[service-demo]
	[src]
		[main]
			[java]
				[entity]
					Demo.java
				[mapper]
					DemoMapper.java
				[service]
					[impl]
						DemoServiceImpl.java
					DemoService.java
             	[vo]
             		DemoDTO.java
             		DemoQueryDTO.java
             		DemoVO.java
             	[web]
             		DemoController.java
			[resources]
            	[mybatis]
            		[mapper]
            			DemoMapper.xml
```

### 生成接口文档

执行DemoApplicationTests类的generateDoc()方法可以根据Swagger注解自动生成Markdown格式的接口文档，生成的接口文档默认在doc目录下。

```shell
[service-demo]
	[doc]
		swagger.json
		demo-POST.md
		demo-{id}-PUT.md
	[src]
```

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