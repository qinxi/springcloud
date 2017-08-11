spring cloud config  server


```
gradle buildDocker

docker run --name=config-server -p 8082:8082 -d qinxi/config-server:1.0-SNAPSHOT 
```