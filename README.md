# SpringBootLoginSystemTeaching
### SpringBoot登录系统编写教学
- 我们在日常开发中经常需要实现用户的登录和注册和鉴权的功能，这里我们使用SpringBoot来实现一个简单的登录系统举例
- 本教程可以让大家了解SpringBoot的基本使用，以及使用SpringBoot来实现一个简单的登录系统的思路和流程
- 这个教程中使用Sa-token来实现鉴权功能，Sa-token是一个轻量级的Java权限认证框架，可以让我们快速的实现鉴权功能，具体使用方法可以参考官方文档：[Sa-token官方文档](https://sa-token.cc/doc.html)
- 本教程中使用的数据库是MySQL，使用的数据库连接池是HikariCP，使用的ORM框架是Mybatis，使用的数据库版本是8.0.23，使用的JDK版本是1.8，使用的IDE是IDEA2023，使用的Maven版本是3.6.3，使用的SpringBoot版本是2.7.5，使用的Sa-token版本是1.34.0
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
  - 创建Service层接口
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/%E5%88%9B%E5%BB%BAService%E5%B1%82%E6%8E%A5%E5%8F%A3.png)
  - 创建Service层实现类并实现接口中的方法第1页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/Service%E5%AE%9E%E7%8E%B0%E7%B1%BB1.png)
  - 创建Service层实现类并实现接口中的方法第2页
    ![Alt text](./%E6%95%99%E7%A8%8B%E5%9B%BE%E7%89%87/Services%E5%AE%9E%E7%8E%B0%E7%B1%BB2.png)

##### 第五步 建立Controller层提供Api

##### 第六步 引入鉴权框架 

##### 第七步 修改Controller层的Api逻辑实现判断登录状态、判定是否具有权限

##### 第八步 编写前端页面

##### 第九步 测试和使用

By：tyza66