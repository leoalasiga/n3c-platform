# 工程简介
> n3c的网关,只做转发

# 延伸阅读

##  Spring Cloud Gateway
### 需要的准备
+ JDK 1.8 or later
  
+  Gradle 4+ or Maven 3.2+

### 创建一个简单的路由
Spring cloud网关使用路由来处理对下游服务的请求。在本指南中，我们将把所有请求路由到HTTPBin。
路由可以通过多种方式配置，但在本指南中，我们将使用网关提供的JavaAPI。

首先,在`Application.java`里创建一个新的bean `RouteLocator` 

```java
@Bean
public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    return builder.routes().build();
}
```

上面的myRoutes方法采用RouteLocatorBuilder，可轻松用于创建路由。除了创建路由之外，RouteLocatorBuilder还允许您向路由添加
predicates 和filters ，以便您可以根据特定条件进行路由处理，并根据需要更改请求/响应。


让我们创建一个路由，将请求路由到https://httpbin.org/get ,当在/get向网关发出请求时。在我们对该路由的配置中，我们将添加一个
过滤器，在路由请求之前，将请求头Hello和值World添加到请求中。

To test our very simple Gateway, just run Application.java, it should be run on port 8080. Once the application is running, 
make a request to http://localhost:8080/get. You can do this using cURL by issuing the following command in your terminal.

为了测试你的简单网关,只要启动项目,端口8080,一旦应用启动,尝试访问http://localhost:8080/get.你可以在你的终端上使用curl
```shell script
$ curl http://localhost:8080/get
```

你会得到如下的响应
```html
{
  "args": {},
  "headers": {
    "Accept": "*/*",
    "Connection": "close",
    "Forwarded": "proto=http;host=\"localhost:8080\";for=\"0:0:0:0:0:0:0:1:56207\"",
    "Hello": "World",
    "Host": "httpbin.org",
    "User-Agent": "curl/7.54.0",
    "X-Forwarded-Host": "localhost:8080"
  },
  "origin": "0:0:0:0:0:0:0:1, 73.68.251.70",
  "url": "http://localhost:8080/get"
```


Notice that HTTPBin shows that the header Hello with the value World was sent in the request.
请注意，HTTPBin显示请求中包含了发送时带有值为World的头Hello