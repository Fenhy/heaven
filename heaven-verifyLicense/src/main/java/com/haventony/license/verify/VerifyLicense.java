package com.haventony.license.verify;

import com.heaventony.license.AbstractLicense;
import com.heaventony.license.verify.LicenseManagerHolder;
import de.schlichtherle.license.LicenseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 上午11:50
 */
public class VerifyLicense extends AbstractLicense{

    private static final Logger log = LoggerFactory.getLogger(VerifyLicense.class);
    //common param
    private static String PUBLICALIAS = "";
    private static String STOREPWD = "";
    private static String SUBJECT = "";
    private static String licPath = "";
    private static String pubPath = "";
    private static String issuedTime = "";

    public void initParam(String propertiesPath) {
        // 获取参数
        Properties prop = new Properties();
        InputStream in = getClass().getResourceAsStream(propertiesPath);
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
        }
        PUBLICALIAS = prop.getProperty("PUBLICALIAS");
        STOREPWD = prop.getProperty("STOREPWD");
        SUBJECT = prop.getProperty("SUBJECT");
        licPath = prop.getProperty("licPath");
        pubPath = prop.getProperty("pubPath");
        issuedTime = prop.getProperty("issuedTime");
    }

    public boolean verify(String propertiesPath) {
        this.initParam(propertiesPath);

        /**************证书使用者端执行******************/
        LicenseManager licenseManager =
                LicenseManagerHolder.getLicenseManager(initLicenseParams(this.getClass(),null));
        // 安装证书
        try {
            licenseManager.install(new File(licPath));
            log.info("客户端安装证书成功!");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("客户端证书安装失败!");
            log.error(e.getMessage(), e);
            return false;
        }
        // 验证证书
        try {
            licenseManager.verify();
            log.info("客户端验证证书成功!");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("客户端证书验证失效!");
            log.error(e.getMessage(), e);
            return false;
        }
        return true;
    }


}
