# SpringBootLoginSystemTeaching
### SpringBoot登录系统编写教学
- 我们在日常开发中经常需要实现用户的登录和注册和鉴权的功能，这里我们使用SpringBoot来实现一个简单的登录系统举例
- 本教程可以让大家了解SpringBoot的基本使用，以及使用SpringBoot来实现一个简单的登录系统的思路和流程
- 这个教程中使用Sa-token来实现鉴权功能，Sa-token是一个轻量级的Java权限认证框架，可以让我们快速的实现鉴权功能，具体使用方法可以参考官方文档：[Sa-token官方文档](https://sa-token.cc/doc.html)
- 本教程中使用的数据库是MySQL，使用的数据库连接池是HikariCP，使用的ORM框架是Mybatis，使用的数据库版本是8.0.23，使用的JDK版本是1.8，使用的IDE是IDEA2023，使用的Maven版本是3.6.3，使用的SpringBoot版本是2.7.5，使用的Sa-token版本是1.34.0
- 前端界面中不使用任何样式框架，只使用了axios用来发送请求

##### 预计实现功能
  - [x] 用户登录
  - [x] 用户注册
  - [x] 用户当前是否登录判断
  - [x] 用户权限判断
  - [x] 用户角色判断

##### 准备工作 技术选型和思考实现思路
  - 数据库选用MySQL，使用HikariCP作为数据库连接池，使用Mybatis作为ORM框架
  - 常见的Java项目中使用的鉴权框架有Shiro、SpringSecurity、Sa-token等，这里我们使用Sa-token来实现鉴权功能
  - 在开发过程中,我们使用标准的SpringBoot项目开发流程,使用Maven来管理项目依赖
  - 以前后端不分离的全栈项目的形式开发
  - 前后端的交互使用JSON格式的数据

##### 第一步 设计建立数据库表
  - 创建数据库
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%88%9B%E5%BB%BA%E6%95%B0%E6%8D%AE%E5%BA%93.png)
  - 创建表（id为主键 自增）
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%BB%BA%E8%A1%A8.png)
  - 添加了一个字段用来保存权限
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%B7%BB%E5%8A%A0%E4%BA%86%E4%B8%80%E4%B8%AA%E5%AD%97%E6%AE%B5%E7%94%A8%E6%9D%A5%E5%8C%BA%E5%88%86%E6%9D%83%E9%99%90.png)

##### 第二步 创建项目并引入所需依赖
  - 引入依赖第1页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%BC%95%E5%85%A5%E4%BE%9D%E8%B5%961.png)
  - 引入依赖第2页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%BC%95%E5%85%A5%E4%BE%9D%E8%B5%962.png)

##### 第三步 配置数据库连接信息、配置鉴权框架
  - 配置数据库连接信息
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E9%85%8D%E7%BD%AE%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E4%BF%A1%E6%81%AF.png)
   - 配置鉴权框架
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E9%85%8D%E7%BD%AE%E9%89%B4%E6%9D%83%E6%A1%86%E6%9E%B6.png) 
  - 鉴权配置类第1页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E9%89%B4%E6%9D%83%E9%85%8D%E7%BD%AE%E7%B1%BB1.png) 
  - 鉴权配置类第2页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E9%89%B4%E6%9D%83%E9%85%8D%E7%BD%AE%E7%B1%BB2.png) 
  - 如果想使用注解来鉴权可以配置这个拦截器
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E9%85%8D%E7%BD%AE%E6%8B%A6%E6%88%AA%E5%99%A8%E4%BB%A5%E6%94%AF%E6%8C%81%E6%B3%A8%E8%A7%A3.png) 

##### 第四步 建立表对应的实体类、DAO层、Service层
  - User表对应的实体类
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E7%94%A8%E6%88%B7%E5%AE%9E%E4%BD%93%E7%B1%BB.png)
  - 配置扫描Mapper包
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%89%AB%E6%8F%8FMapper%E5%8C%85.png)
  - 建立Dao层的UserMapper并使用注解给方法绑定SQL语句
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%BB%BA%E7%AB%8BDao%E5%B1%82%E7%9A%84Mapper.png)
  - 创建Service层接口：实现登录、注册、更改权限等功能，其中登录实现方式是向数据库中根据账号和密码进行查找，找到了就登录成功、其中注册会先检查数据库中是否有重复的用户名，没有的话才会注册成功、更改权限就是直接修改数据库中的权限字段
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%88%9B%E5%BB%BAService%E5%B1%82%E6%8E%A5%E5%8F%A3.png)
  - 创建Service层实现类并实现接口中的方法第1页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/Service%E5%AE%9E%E7%8E%B0%E7%B1%BB1.png)
  - 创建Service层实现类并实现接口中的方法第2页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/Services%E5%AE%9E%E7%8E%B0%E7%B1%BB2.png)

##### 第五步 建立Controller层提供Api
  - 创建Controller实现登录、注册、改变权限的Api第一页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/controller1.png)
  - 创建Controller实现登录、注册、改变权限的Api第二页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/controller2.png)
  - 创建测试用的Controller
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%B5%8B%E8%AF%95%E7%94%A8controller.png)

##### 第七步 修改Controller层的Api逻辑实现判断登录状态、判定是否具有权限
  - 启用登录功能
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%90%AF%E7%94%A8%E7%99%BB%E5%BD%95%E5%8A%9F%E8%83%BD.png)
  - 修改权限的逻辑中判断是否登录
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%88%A4%E6%96%AD%E6%98%AF%E5%90%A6%E7%99%BB%E5%BD%95.png)
  - 注解鉴权
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%B3%A8%E8%A7%A3%E9%89%B4%E6%9D%83.png)
  - 添加一个判断是否登录的api
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%88%A4%E6%96%AD%E6%98%AF%E5%90%A6%E7%99%BB%E5%BD%95api.png)

##### 第八步 编写前端页面
  - 简易功能目录
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%8A%9F%E8%83%BD%E7%9B%AE%E5%BD%95.png)
  - 登录界面：点击登录按钮就会获得输入框中的内容并且向后端发送请求，请求内容执行成功就跳转到检验是否登录的而界面，请求失败就弹出错误信息
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E7%99%BB%E5%BD%95%E7%95%8C%E9%9D%A2.png)
  - 注册界面：点击注册按钮就会获得输入框内容向后端发送请求，请求内容执行成功就跳转到登录界面，请求失败就弹出错误信息
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%B3%A8%E5%86%8C%E7%95%8C%E9%9D%A2.png)

##### 第九步 测试和使用
  - 未登录的之后进入检查是否登录的界面显示未登录
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%9C%AA%E7%99%BB%E5%BD%95.png)
  - 进入若未登录就跳转到登陆界面之后进行登录
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E7%99%BB%E5%BD%95%E6%88%90%E5%8A%9F.png)
  - 登录完成之后访问是否登录的api就会显示已登录
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%B7%B2%E7%BB%8F%E7%99%BB%E9%99%86.png)
  - 测试注册功能：注册成功
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%B3%A8%E5%86%8C%E6%88%90%E5%8A%9F.png)
  - 测试t1：因为当前ID0没有t1权限，所以无法调用
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E8%B0%83%E7%94%A8t1%E5%A4%B1%E8%B4%A5.png)
  - 测试t2：因为已经登陆，可以调用
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/t2%E6%B5%8B%E8%AF%95.png)
  - 测试t3：因为ID0具有admin角色，可以调用
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/t3%E6%B5%8B%E8%AF%95.png)
  - 给ID0添加t1权限
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%B7%BB%E5%8A%A0t1%E6%9D%83%E9%99%90.png)
  - 再次测试t1：因为ID0具有t1权限，可以调用
   ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E6%B5%8B%E8%AF%95t1%E6%88%90%E5%8A%9F.png)

By：tyza66