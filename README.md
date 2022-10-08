# LibrarySystem

#### 介绍
springboot+mybatis-plus，图书管理系统

#### 程序架构
前端：
HTML+CSS+JS+BootStrap+Thymeleaf

通过Thymeleaf模板引擎获取后端传递的数据，并呈现在网页中。

后端：

Controller层：接收前端的请求，将需求传递给Service层，得到Service层返回的数据并传递给前端。

Service层：接收Controller层的需求，调用Mapper层的函数获取数据，将数据返回给Controller层。

Mapper层：接收Service的调用，执行SQL语句，将从数据库中获取的数据返回给Service层。

### 程序功能
登陆：
管理员或读者登陆，否则会被拦截

读者：
+ 查询书籍，根据专业、年级、书籍类别查询热门书籍
+ 查看个人信息
+ 查看已经借阅和已经归还的书籍

管理员：
+ 添加书籍，增加书籍数量
+ 帮读者借阅书籍，帮读者归还书籍
+ 添加读者，更改读者信息

（可拓展，使用Shiro或Spring Security整合两个登录界面）

### 配置

默认管理员登录：
+ 账号：1001
+ 密码：123456

默认用户登录：
+ 账号：2016003225
+ 密码：123456

SQL配置（可在application.properties查看）：
+ username:root
+ password:0
+ SQL端口:3306
+ 表名：librarysystem

项目运行端口：11111

运行网址：http://localhost:11111
