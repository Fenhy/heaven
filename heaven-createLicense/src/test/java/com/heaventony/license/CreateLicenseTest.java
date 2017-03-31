package com.heaventony.license; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

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
    paramBean.setPrivateAlias("privatekey");
    paramBean.setPriKeyPwd("noryar456");
    paramBean.setStorePwd("noryar123");

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
