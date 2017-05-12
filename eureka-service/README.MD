spring cloud eureka 服务提供者


```
gradle buildDocker

docker run --name=eureka-service --link=config-server:config-server  -d qinxi/eureka-service:1.0-SNAPSHOT 
```