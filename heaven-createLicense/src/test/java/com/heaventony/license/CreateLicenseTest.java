package com.heaventony.license;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;

/** 
* CreateLicense Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 31, 2017</pre> 
* @version 1.0 
*/ 
public class CreateLicenseTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: create(ParamBean param) 
* 
*/ 
@Test
public void testCreate() throws Exception { 
    ParamBean paramBean = new ParamBean();
    SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
    paramBean.setKeyAlias("privatekey");
    paramBean.setPriKeyPwd("noryar456");
    paramBean.setStorePwd("noryar123");
    paramBean.setSubJect("noryar");
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


/** 
* 
* Method: createLicenseContent(ParamBean param) 
* 
*/ 
@Test
public void testCreateLicenseContent() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = CreateLicense.getClass().getMethod("createLicenseContent", ParamBean.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
