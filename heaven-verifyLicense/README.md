heaven-verifyLicense模块提供证书验证功能。

#### heaven-verifyLicense特点：

* 依赖spring mvc、heaven-exception、truelicense
* 通过@checkLicense注解来设置是否需要验证授权
* 验证失败拒绝访问，并返回标准json信息

#### 使用实例

###### 1、添加依赖

Maven项目添加依赖如下：

```
<dependency>
      <groupId>com.heaventony</groupId>
      <artifactId>heaven-verifyLicense</artifactId>
      <version>1.0.0</version>
</dependency>
```

Gradle项目添加依赖如下：

```
dependencies {
  compile 'com.heaventony:heaven-auth:1.0.0'
}
```

###### 2、部署license文件

将[heaven-createLicense](heaven-createLicense/README.md)生成的证书文件license.lic拷入项目根目录

将heaven-createLicense生成的公钥库文件拷入项目的resources目录下

###### 3、配置校验配置信息

在resources目录下添加param.properties

```
#alias
public.alias=publiccert
#STOREPWD
key.store.pwd=tony123
#SUBJECT
subject=tony
#licPath
license.path=./license.lic
#pubPath
public.store.path=/publicCerts.store
```

###### 4、获取配置

因为我是使用直接用 @Value("${name}") 来取配置的值，所以需要配置 PropertySourcesPlaceholderConfigurer 用来引入properties文件，这里用的spring boot

```
@Configuration
public class PropertiesConfig {
    @Bean
    public PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
        ClassPathResource resource = new ClassPathResource("param.properties");
        PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(resource);
        return propertyPlaceholderConfigurer;
    }
}
```

如果使用Spring xml来配置

```
<bean id="configProperties" class="org.springframework.beans.factory.config.PropertiesFactoryBean">  
       <property name="locations">  
           <list>  
               <value>classpath:param.properties</value>  
           </list>  
       </property>  
    </bean>  
    <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer">  
        <property name="properties" ref="configProperties" />  
    </bean>
```

那么就要重写com.heaventony.license.verify.ParamProperty了，取值改为

```
@Value("#{configProperties['public.alias']}")
private String publicAlias;
```

###### 5、配置拦截器

```
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Resource
    LicenseInterceptor licenseInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(licenseInterceptor);
    }
}
```

###### 6、添加注解

在需要校验的接口上添加注解即可

```
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "{v}", method = RequestMethod.GET)
    @IgnoreToken
    @CheckLicense
    public String test(@PathVariable String v){
        return "test: " + v;
    }
}
```



当然可以在需要校验授权的地方添加如下代码也行：

```
verifyLicense.verify()
```



