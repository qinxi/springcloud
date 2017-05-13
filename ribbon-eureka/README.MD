spring cloud eureka 服务消费者

存在问题:
    如果启动多个不同端口的 服务提供者,但是有一个服务提供者服务不可用时,
    就会返回错误信息,而不是继续使用还在也运行的其他可用服务.

所以 有了 [ribbon-eureka-hystrix](../ribbon-eureka-hystrix)  项目的出现


```
gradle buildDocker

docker run --name=ribbon-eureka --link=config-server:config-server --link=eureka-service:eureka-service --link=springcloud-eureka:springcloud-eureka  -p 8080:8080  qinxi/ribbon-eureka:1.0-SNAPSHOT
```