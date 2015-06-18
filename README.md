#spring-boot-mybatis-sample

此sample主要展示的是在一个用Spring-Boot搭建的工程里，同时用2种方式连接2种关系型数据库：
1. 用Spring-Data-Jpa连接数据库1(在配置文件中spring.datasource配置)
2. 用Mybatis连接数据库2(在配置文件中lxy.datasource配置)

由于想利用Spring-Boot的自动根据数据库连接URL判断DriverClass的机制,所以从Spring-Boot中拿出了DatabaseDriver类型(原DatabaseDriver是包内可见)

联系方式：QQ：123219399 小翼
2015-06-18