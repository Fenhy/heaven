package com.heaventony.license.verify;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 下午4:49
 */
@Data
@Component("paramProperty")
public class ParamProperty {

    @Value("${public.alias}")
    private String publicAlias;
    @Value("${key.store.pwd}")
    private String storePwd;
    @Value("${subject}")
    private String subJect;
    @Value("${license.path}")
    private String licPath;
    @Value("${public.store.path}")
    private String pubPath;


}
