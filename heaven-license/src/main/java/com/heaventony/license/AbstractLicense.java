package com.heaventony.license;

import de.schlichtherle.license.*;

import java.util.prefs.Preferences;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 下午12:01
 */
public class AbstractLicense {


    /**
     * 初始化证书参数
     * @param clazz
     * @param param
     * @return
     */
    protected static LicenseParam initLicenseParams(Class<?> clazz, ParamBean param) {

        Preferences preference = Preferences.userNodeForPackage(clazz);
        CipherParam cipherParam = new DefaultCipherParam(param.getStorePwd());

        KeyStoreParam privateStoreParam =
                new DefaultKeyStoreParam(clazz, param.getStorePath(), param.getKeyAlias(), param.getStorePwd(), param.getPriKeyPwd());
        LicenseParam licenseParams =
                new DefaultLicenseParam(param.getSubJect(), preference, privateStoreParam, cipherParam);
        return licenseParams;
    }

}
