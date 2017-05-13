添加了断路器的 spring cloud eureka 服务消费者



```
gradle buildDocker

docker run --name=ribbon-eureka-hystrix --link=config-server:config-server --link=eureka-service:eureka-service --link=springcloud-eureka:springcloud-eureka  -p 8080:8080  qinxi/ribbon-eureka-hystrix:1.0-SNAPSHOT
```