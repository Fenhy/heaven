package com.heaventony.license;

import de.schlichtherle.license.LicenseContent;
import de.schlichtherle.license.LicenseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.x500.X500Principal;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 上午11:39
 */
public class CreateLicense extends AbstractLicense {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // X500Princal是一个证书文件的固有格式，详见API
    private final static X500Principal DEFAULTHOLDERANDISSUER = new X500Principal("CN=noryar, OU=noryar, O=noryar, L=china, ST=dalian, C=china");


    public void create(ParamBean param) {
        LicenseManager licenseManager = LicenseManagerHolder.getLicenseManager(initLicenseParams(this.getClass(), param));
        LicenseContent content = createLicenseContent(param);
        try {
            licenseManager.store(content, new File(param.getLicPath()));
            logger.info("证书生成成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过外部参数构建证书的的相关信息
     *
     * @return
     */
    private final static LicenseContent createLicenseContent(ParamBean param) {
        LicenseContent content = null;
        content = new LicenseContent();
        content.setSubject(param.getSubJect());
        content.setHolder(DEFAULTHOLDERANDISSUER);
        content.setIssuer(DEFAULTHOLDERANDISSUER);
        content.setIssued(param.getIssuedTime());
        content.setNotBefore(param.getNotBefore());
        content.setNotAfter(param.getNotAfter());
        content.setConsumerType(param.getConsumerType());
        content.setConsumerAmount(param.getConsumerAmount());
        content.setInfo(param.getInfo());
        //扩展
        content.setExtra(new Object());
        return content;
    }
}
