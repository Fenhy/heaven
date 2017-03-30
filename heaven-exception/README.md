heaven-exception模块封装了异常的基本处理

#### heaven-exception特点：

* 依赖springmvc heaven-common
* 封装标准的异常返回

#### 使用实例：

Maven项目添加依赖如下：

```
<dependency>
      <groupId>com.heaventony</groupId>
      <artifactId>heaven-exception</artifactId>
      <version>1.0.0</version>
</dependency>
```

Gradle项目添加依赖如下：

```
dependencies {
  compile 'com.heaventony:heaven-exception:1.0.0'
}
```



 比如在验证token不通过的地方使用

```
throw new AuthExcetpion();
```

前端会返回如下信息：

```
HTTP/1.1 401 
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Thu, 30 Mar 2017 02:54:13 GMT
Connection: close

{"message":"authorization failed","code":10001,"data":null}
```

