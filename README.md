# big-event
big-event from itheima

# 大事件管理系统 (BigEvent) - 后端 API
## 📖 项目简介
本项目是基于 Spring Boot + MyBatis 开发的后台管理系统（大事件管理系统）后端接口。项目实现了用户注册登录、JWT 令牌鉴权、文章分类管理、文章发布与管理等核心业务功能，并集成了参数校验、统一响应结果、全局异常处理等企业级开发规范。

## 🛠 技术栈
- **核心框架**：Spring Boot 3.x, Spring Framework 6.x
- **持久层框架**：MyBatis 3.x
- **数据库**：MySQL 8.0
- **身份认证**：JWT (JSON Web Token)
- **加密算法**：MD5 (密码加密)
- **数据校验**：Spring Validation
- **构建工具**：Maven
- **开发工具**：IntelliJ IDEA

## ✨ 核心功能
1. **用户模块**
    - 用户注册（MD5 密码加密，参数合法性校验）
    - 用户登录（生成 JWT Token）
    - 获取当前登录用户信息
2. **文章分类模块**
    - 新增分类、更新分类
    - 获取分类列表、获取分类详情
    - 删除分类
3. **文章管理模块**
    - 发布文章、更新文章
    - 分页查询文章列表（支持条件筛选）
    - 获取文章详情、删除文章
4. **系统级功能**
    - 全局异常处理器（统一捕获参数校验异常及系统异常）
    - JWT 登录拦截器（拦截未授权访问）
    - 统一响应结果封装（`Result<T>`）

## 📂 项目结构
```text
src/main/java/com/itheima/
├── config          # 配置类 (如 WebConfig 拦截器配置)
├── controller      # 控制层 (接收请求、返回结果)
├── exception       # 全局异常处理
├── interceptor     # 拦截器 (LoginInterceptor 等)
├── mapper          # 数据访问层 (MyBatis 接口)
├── pojo            # 实体类 (User, Article, Result 等)
├── service         # 业务逻辑接口
│   └── impl        # 业务逻辑实现类
└── utils           # 工具类 (JwtUtil, Md5Util 等)
```

🚀 快速启动指南
1. 环境准备
   确保已安装 JDK 17 或以上版本。

确保已安装 MySQL 8.0 并启动服务。

确保已安装 Maven 并配置好镜像源。

2. 数据库初始化
   在 MySQL 中创建一个名为 big_event 的数据库。

将项目根目录下的 big_event.sql 脚本导入该数据库中。

3. 修改配置文件
   打开 src/main/resources/application.yml，将数据库连接配置修改为你自己的账号密码：

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/big_event?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8
    username: root       # 替换为你的数据库用户名
    password: 2005       # 替换为你的数据库密码
```
4. 启动项目
   在 IDEA 中找到 BigEventApplication.java 启动类，右键点击运行即可。项目默认启动在 8080 端口。