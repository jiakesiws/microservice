# micro service

> springcloud 微服务搭建

## 准备环境

**在host文件中添加如下内容：**
```
# springcloud
127.0.0.1 eureka8201.com
127.0.0.1 eureka8202.com
127.0.0.1 eureka8203.com
```

**添加SQL脚本，在script文件夹中**

## 普通启动顺序

- EurekaBootstrap8201
- EurekaBootstrap8202
- EurekaBootstrap8203
- ProviderBootstrap8001
- ProviderBootstrap8002
- ProviderBootstrap8003
- ConsumerFeignBootstrap

## 服务熔断启动顺序

- EurekaBootstrap8201
- EurekaBootstrap8202
- EurekaBootstrap8203
- ProviderBootstrapHystrix8001
- ConsumerFeignBootstrap

## 服务降级启动顺序

- EurekaBootstrap8201
- EurekaBootstrap8202
- EurekaBootstrap8203
- ProviderBootstrap8001
- ConsumerFeignBootstrap

## 服务可视化监控启动顺序

- EurekaBootstrap8201
- EurekaBootstrap8202
- EurekaBootstrap8203
- ProviderBootstrapHystrix8001
- HystrixDashboardBootstrap
- ConsumerFeignBootstrap

使用**127.0.0.1:9001/hystrix**打开可视化页面,再在可视化页面的输入框内输入**127.0.0.1:8001/hystrix.stream**即可监控8001服务的信息

## 其他知识

**服务熔断**

一般是某个服务故障或引起类似现实中的“保险丝”，当某个条件被触发时，直接熔断整个服务，而不是一直等待此服务超时。

**服务降级**

所谓降级，一般从整体负荷考虑。就是当某个服务熔断之后，服务器将不再调用，
此时客户端可以自己准备一个fallback回调，返回一个缺省值。虽然服务水平下降，但好歹可用，比直接挂掉要强。

**ACID分别是什么**

- A 代表 Aotmicity（原子性）
- C 代表 Consistency （一致性）
- I 代表 Isolation （独立性）
- D 代表 Durability (持久性)

**CAP又分别是什么**

- C：Consistency （强一致性）
- A：Available （可用性）
- P：Partition tolerance （分区容错性）
