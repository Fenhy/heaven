heaven-auth模块提供基本的访问验证功能。

#### heaven-auth特点：

* 依赖spring mvc、heaven-exception
* 通过@IgnoreToken注解设置是否需要验证token
* 验证失败拒绝访问，返回标准json信息



#### 使用实例：

Maven项目添加依赖如下：

```
<dependency>
      <groupId>com.heaventony</groupId>
      <artifactId>heaven-auth</artifactId>
      <version>1.0.0</version>
</dependency>
```

Gradle项目添加依赖如下：

```
dependencies {
  compile 'com.heaventony:heaven-auth:1.0.0'
}
```

添加依赖之后，拦截器AuthInterceptor会拦截除OPTIONS外的所有请求，如果没有加@IgnoreToken注解，就都需要验证token。

在controller类上添加注解：

```
@RestController
@RequestMapping("test")
@IgnoreToken
public class TestController {
 .........
```

作用于类上，则这个Controller下所有的方法都不用再验证token

在方法上添加注解：

```
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "{v}", method = RequestMethod.GET)
    @IgnoreToken
    public String test(@PathVariable String v){
        return "test: " + v;
    }
}
```

作用于方法上，则test接口不需要验证token