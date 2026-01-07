# Spring Boot MyBatis Demo

这是一个基于 Spring Boot 3.2 + JDK 21 + MyBatis + MySQL 的示例项目。

## 技术栈

- Spring Boot 3.2.0
- JDK 21
- MyBatis 3.0.3
- MySQL
- Maven

## 项目结构

```
springboot-mybatis-demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── controller/     # 控制器层
│   │   │   ├── service/        # 服务层
│   │   │   ├── mapper/         # 数据访问层
│   │   │   ├── entity/         # 实体类
│   │   │   └── DemoApplication.java  # 主应用类
│   │   └── resources/
│   │       ├── application.yml         # 配置文件
│   │       └── mapper/                 # MyBatis XML 映射文件
│   └── test/
└── pom.xml
```

## 配置说明

在 `application.yml` 中配置数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/demo_db
    username: root
    password: root
```

## 数据库表结构

```sql
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

## API 接口

- `GET /api/users/{id}` - 根据ID查询用户
- `GET /api/users` - 查询所有用户
- `POST /api/users` - 创建用户
- `PUT /api/users/{id}` - 更新用户
- `DELETE /api/users/{id}` - 删除用户

## 运行项目

```bash
mvn spring-boot:run
```

## 测试接口

```bash
# 查询所有用户
curl http://localhost:8080/api/users

# 创建用户
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"username":"test","email":"test@example.com"}'
```
