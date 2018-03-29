package com.heaventony.web.controllers;

import com.heaventony.auth.annotation.IgnoreToken;
import com.heaventony.license.verify.annotation.CheckLicense;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午12:00
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "{v}", method = RequestMethod.GET)
    @IgnoreToken
    @CheckLicense
    public String test(@PathVariable String v){
        return "test: " + v;
    }

}
