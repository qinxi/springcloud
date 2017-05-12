springcloud demo


1. [config](./config) 分布式配置文件
2. [config-server](./config-server) 分布式配置服务器
3. [config-server-test](./config-server-test) 测试分布式配置生效
4. [springcloud-eureka](./springcloud-eureka) 服务注册中心
5. [eureka-service](./eureka-service) 服务提供者
6. [eureka-test](./eureka-test) 服务消费者
6. [ribbon-eureka](./ribbon-eureka) 服务消费者(负载均衡)
7. [ribbon-eureka-hystrix](./ribbon-eureka-hystrix) 添加了断路器的服务消费者

环境 :

1. jdk1.8+
2. gradle 3.0

编译 

    gradle build 
    
----    

docker 运行 

gradle buildDocker

docker run qinxi/config-server


docker run --name=xxx --link=xxxx -d -p 8888:8888 qinxi/xxxxx


```
    --name=xxx 别名
    --link=xxx 用户在该容器内访问其他容器
    --d 后台运行
    -p localport:containerPort 端口映射

```


