package com.heaventony.license;

import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 上午11:02
 */
public class LicenseManagerHolder {

    private static LicenseManager licenseManager;

    public static synchronized LicenseManager getLicenseManager(LicenseParam licenseParams) {
        if (licenseManager == null) {
            licenseManager = new LicenseManager(licenseParams);
        }
        return licenseManager;
    }

}
