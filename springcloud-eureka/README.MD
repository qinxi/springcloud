spring cloud eureka 服务注册中心



```
gradle buildDocker

docker run --name=springcloud-eureka --link=config-server:config-server -p 8888:8888 -d qinxi/springcloud-eureka:1.0-SNAPSHOT 
```