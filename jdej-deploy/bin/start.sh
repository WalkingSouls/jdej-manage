#!/usr/bin/env bash
java -Xms128m -Xmn128m -Xmx128m -jar mcollege-portal.jar --spring.profiles.active=test &

## 测试环境启动脚本示例，最后的spring.profiles.active 启动项根据环境配置枚举值为 dev,test,prod
## 优先采用外部传参的方式，其次在application.yml中指定
