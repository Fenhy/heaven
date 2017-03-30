package com.heaventony.web.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午12:00
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping(value = "{v}", method = RequestMethod.GET)
//    @IgnoreToken
    public String test(@PathVariable String v){
        return "test: " + v;
    }

}
