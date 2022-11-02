# douyincloud-springboot-demo
本项目是抖音云平台基于java语言springboot框架的开发模版，模版通过使用Redis和MongoDB实现了简单的hello-world功能。\
抖音云平台支持基于Git代码和Docker镜像部署两种方式。其中，Dockerfile文件可以参考本项目中的Dockerfile文件。
部署在抖音云平台的服务日志需要重定向到标准输出，并在抖音云平台日志功能中查看。

## 目录结构
~~~
.
├── Dockerfile                  Dockerfile文件
├── HELP.md     
├── README.md                   Readme文件
├── douyincloud-demo.iml        项目配置文件
├── mvnw
├── mvnw.cmd
├── pom.xml                     maven配置文件
├── run.sh                      启动脚本
├── settings.xml                maven配置文件
├── src                         源代码
│ ├── main
│ │ ├── java
│ │ │ └── com
│ │ │     └── bytedance
│ │ │         └── douyinclouddemo
│ │ └── resources
│ │     └── application.yml     springboot文件
│ └── test                      
└── target
~~~

## 请求方法
前往抖音云托管平台「调试」功能界面，进行请求调试。

## API说明
### `GET /api/hello`
对组件打招呼

### 请求参数
- `target`：`string` 组件名：redis，mongodb

### 响应结果
```json
{
    "err_no": 0,
    "err_msg": "success",
    "data": "hello,redis"
}
```

### `POST /api/set_name`
给组件设置名称

### 请求参数
- `target`:`string` 组件名：redis，mongodb
- `name`:`string` 名称

### 响应结果
```json
{
    "err_no": 0,
    "err_msg": "success",
    "data": ""
}
```

### 组件使用注意事项
在抖音云托管平台上启用组件后，抖音云平台会自动将组件的地址，账号，密码以环境变量的方式注入到容器中。\
以Redis为例，在抖音云托管平台启用Redis组件后，平台会生成 `REDIS_ADDRESS`，`REDIS_USERNAME`，`REDIS_PASSWORD`三个环境变量，在业务配置中可以使用如下代码获取相应值。
```
  redis:
    url: redis://${REDIS_USERNAME}}:${REDIS_PASSWORD}@${REDIS_ADDRESS}
```

### 环境标识
抖音云托管平台上的环境分为dev和prod两种，分别对应开发环境（值为DEV）和生产环境（值为PROD）。抖音云平台会自动将服务运行的环境标识以环境
变量的方式注入到容器中。
```
cloud:
  env: ${CLOUD_ENV}
```

## License

This project is licensed under the [Apache-2.0 License](LICENSE).

