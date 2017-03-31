heaven-createLicense模块用来生成授权证书。

开发的软件产品在交付使用的时候，往往会授权一段时间的试用期，这个时候license就派上用场了。不同于在代码中直接加上时间约束，需要重新授权的时候使用license可以避免修改源码，改动部署，授权方直接生成一个新的license发送给使用方替换掉原来的license文件即可。

#### heaven-createLicense特点：

* 使用truelicense来实现license
* 授权者保留私钥，使用私钥对包含授权信息（如使用截止日期，MAC地址等）的license进行数字签名。
* 公钥给使用者（放在验证的代码中使用），用于验证license是否符合使用条件。

#### 使用实例

##### 生成密钥对

通过KeyTool工具来生成私钥库：

```
$ keytool -genkey -alias privatekey -keystore privateKeys.store -validity 3650
输入密钥库口令:
再次输入新口令:
您的名字与姓氏是什么?
  [Unknown]:  tony
您的组织单位名称是什么?
  [Unknown]:  tony
您的组织名称是什么?
  [Unknown]:  tony
您所在的城市或区域名称是什么?
  [Unknown]:  china
您所在的省/市/自治区名称是什么?
  [Unknown]:  dalian
该单位的双字母国家/地区代码是什么?
  [Unknown]:  china
CN=tony, OU=tony, O=tony, L=china, ST=dalian, C=china是否正确?
  [否]:  y

输入 <privatekey> 的密钥口令
	(如果和密钥库口令相同, 按回车):
再次输入新口令:
```

-alias别名 –validity 3650表示10年有效

这里输入密钥口令：tony456 

这个时候，创建出一个文件，privateKeys.store

##### 把私钥库内的证书导出到文件：

```
$ keytool -export -alias privatekey -file certfile.cer -keystore privateKeys.store
输入密钥库口令:
存储在文件 <certfile.cer> 中的证书
```

这里设置的口令：tony123

这个时候，创建出一个文件，certfile.cer

##### 把证书文件导入到公钥库

```
$ keytool -import -alias publiccert -file certfile.cer -keystore publicCerts.store
输入密钥库口令:
再次输入新口令:
所有者: CN=noryar, OU=noryar, O=noryar, L=china, ST=dalian, C=china
发布者: CN=noryar, OU=noryar, O=noryar, L=china, ST=dalian, C=china
序列号: 55159070
有效期开始日期: Fri Mar 31 14:50:50 CST 2017, 截止日期: Mon Mar 29 14:50:50 CST 2027
证书指纹:
	 MD5: 43:B2:A7:57:3A:C8:C7:4D:1F:8D:B5:6B:1C:0C:A2:77
	 SHA1: 7A:31:D4:56:9E:A8:4A:CC:7D:63:E3:AF:36:8C:E4:DF:F0:73:CD:0C
	 SHA256: 9D:35:29:36:D7:59:84:2A:5B:E0:16:CB:13:2C:81:62:64:B3:E2:FE:A5:78:8F:99:CB:4C:E1:63:DF:33:8C:94
	 签名算法名称: SHA1withDSA
	 版本: 3

扩展:

#1: ObjectId: 2.5.29.14 Criticality=false
SubjectKeyIdentifier [
KeyIdentifier [
0000: 49 0C 81 33 2F 20 72 24   94 11 49 C0 A9 E2 E4 93  I..3/ r$..I.....
0010: 9C 79 B8 EE                                        .y..
]
]

是否信任此证书? [否]:  y
证书已添加到密钥库中
```

这里使用上面设置的口令：tony123

最后生成文件privateKeys.store、publicCerts.store拷贝出来备用。



将privateKeys.store拷入工程的resources目录

```
public void testCreate() throws Exception { 
    ParamBean paramBean = new ParamBean();
    SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
    paramBean.setKeyAlias("privatekey");
    paramBean.setPriKeyPwd("tony456");
    paramBean.setStorePwd("tony123");
    paramBean.setSubJect("tony");
    paramBean.setStorePath("/privateKeys.store");
    paramBean.setLicPath("license.lic");
    paramBean.setIssuedTime(formate.parse("2017-03-31"));
    paramBean.setNotBefore(formate.parse("2017-03-31"));
    paramBean.setNotAfter(formate.parse("2017-04-01"));
    paramBean.setConsumerType("user");
    paramBean.setConsumerAmount(1);
    paramBean.setInfo("测试");

    CreateLicense createLicense = new CreateLicense();
    createLicense.create(paramBean);
}
```

即可在工程目录下生成license.lic文件