package com.heaventony.license;


import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 下午12:04
 */
@Data
public class ParamBean {
    //创建证书时为私钥别名,验证证书是为公钥别名
    private String keyAlias ;
    //生成密钥对的密码
    private String priKeyPwd ;
    //密钥库的访问密码
    private String storePwd ;
    //唯一识别码
    private String subJect ;
    //证书的地址
    private String licPath ;
    //创建证书时为密钥库地址，验证证书是为公钥库地址
    private String storePath;
    //发布日期
    private Date issuedTime;
    //有效开始日期
    private Date notBefore ;
    //有效截止日期
    private Date notAfter ;

    private String consumerType;
    private int consumerAmount ;
    private String info ;

}
