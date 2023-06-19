# SpringBootLoginSystemTeaching
### SpringBoot登录系统编写教学
- 我们在日常开发中经常需要实现用户的登录和注册和鉴权的功能，这里我们使用SpringBoot来实现一个简单的登录系统举例
- 本教程可以让大家了解SpringBoot的基本使用，以及使用SpringBoot来实现一个简单的登录系统的思路和流程
- 这个教程中使用Sa-token来实现鉴权功能，Sa-token是一个轻量级的Java权限认证框架，可以让我们快速的实现鉴权功能，具体使用方法可以参考官方文档：[Sa-token官方文档](https://sa-token.cc/doc.html)
- 本教程中使用的数据库是MySQL，使用的数据库连接池是HikariCP，使用的ORM框架是Mybatis，使用的数据库版本是8.0.23，使用的JDK版本是1.8，使用的IDE是IDEA2023，使用的Maven版本是3.6.3，使用的SpringBoot版本是2.7.5，使用的Sa-token版本是1.24.0
- 前端界面中不使用任何样式框架，只使用了axios用来发送请求

##### 预计实现功能
  - [ ] 用户登录
  - [ ] 用户注册
  - [ ] 用户当前是否登录判断
  - [ ] 用户权限判断
  - [ ] 用户角色判断

##### 准备工作 技术选型和思考实现思路
  - 数据库选用MySQL，使用HikariCP作为数据库连接池，使用Mybatis作为ORM框架
  - 常见的Java项目中使用的鉴权框架有Shiro、SpringSecurity、Sa-token等，这里我们使用Sa-token来实现鉴权功能

##### 第一步 设计建立数据库表
  - 创建数据库
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%88%9B%E5%BB%BA%E6%95%B0%E6%8D%AE%E5%BA%93.png)
  - 创建表
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%BB%BA%E8%A1%A8.png)
##### 第二步 引入所需依赖

##### 第三步 配置数据库连接信息

##### 第四步 建立表对应的实体类、DAO层、Service层

##### 第五步 建立Controller层提供Api

##### 第六步 引入鉴权框架 

##### 第七步 修改Controller层的Api逻辑实现判断登录状态、判定是否具有权限

##### 第八步 编写前端页面

##### 第九步 测试和使用

By：tyza66