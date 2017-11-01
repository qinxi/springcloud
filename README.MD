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
    
     -e "deep=purple" 环境变量

```

配置中心与注册中心互相依赖:
    
    注册中心 依赖 配置中心 的配置文件
    配置中心 依赖 注册中心 做高可用

    先启动配置中心. 当查找不到注册中心时会有错误.但是不致命,返回配置文件的服务正常
    然后在启动注册中心 去配置中心获取 配置文件 .
    
    注册中心启动完成 配置中心 发起重试 去注册中心注册服务
    
    主要体现在 配置中心 的discovery.enabled=true 并且配置 注册中心的地址
    
    第三方服务 启动途径: 加载 bootstrap.yml 去注册中心查找配置中心的服务 , 
    调用配置中心,加载配置. 去配置中心获取的配置文件的注册中心 查找/注册 服务
    
----

docker两个容器之间的互相依赖

[参考1](https://stackoverflow.com/questions/27563460/let-two-containers-getting-linked-to-eachother)

[参考2](https://stackoverflow.com/questions/25324860/how-to-create-a-bidirectional-link-between-containers)

1. 先创建一个虚拟网络 `docker network create net1`
2. 启动A容器 `docker run --name=config-server --net=net1 --net-alias=config-server  -p 8082:8082 -d qinxi/config-server:1.0-SNAPSHOT`
3. 启动B容器 `docker run --name=springcloud-eureka --net=net1 --net-alias=springcloud-eureka -p 8888:8888 -d qinxi/springcloud-eureka:1.0-SNAPSHOT`


    --net-alias 相当于 --name的作用
    
    
* 引申: Class 与 Object 的关系: [R大知乎答案](https://www.zhihu.com/question/30301819)