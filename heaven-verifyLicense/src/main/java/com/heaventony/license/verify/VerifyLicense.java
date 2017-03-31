package com.heaventony.license.verify;

import com.heaventony.license.AbstractLicense;
import com.heaventony.license.ParamBean;
import com.heaventony.license.LicenseManagerHolder;
import de.schlichtherle.license.LicenseContent;
import de.schlichtherle.license.LicenseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 上午11:50
 */
@Component
public class VerifyLicense extends AbstractLicense{

    private static final Logger log = LoggerFactory.getLogger(VerifyLicense.class);

    private static ParamBean paramBean = new ParamBean();

    @Resource(name = "paramProperty")
    private ParamProperty paramProperty;

    public void initParam() {
        paramBean.setKeyAlias(paramProperty.getPublicAlias());
        paramBean.setStorePwd(paramProperty.getStorePwd());
        paramBean.setSubJect(paramProperty.getSubJect());
        paramBean.setLicPath(paramProperty.getLicPath());
        paramBean.setStorePath(paramProperty.getPubPath());
    }

    public boolean verify() {
        this.initParam();

        /**************证书使用者端执行******************/
        LicenseManager licenseManager =
                LicenseManagerHolder.getLicenseManager(initLicenseParams(this.getClass(),paramBean));
        // 安装证书
        try {
            licenseManager.install(new File(paramBean.getLicPath()));
            log.info("客户端安装证书成功!");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("客户端证书安装失败!");
            log.error(e.getMessage(), e);
            return false;
        }
        // 验证证书
        try {
            LicenseContent content = licenseManager.verify();
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
