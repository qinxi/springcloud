use spring cloud config server test



```
gradle buildDocker

docker run --name=config-server-test --link=config-server:config-server -p 8084:8084 -d qinxi/config-server-test:1.0-SNAPSHOT 
```