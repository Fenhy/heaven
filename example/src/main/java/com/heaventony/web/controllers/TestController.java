package com.heaventony.web.controllers;

import com.heaventony.auth.annotation.IgnoreToken;
import com.heaventony.license.verify.annotation.CheckLicense;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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

    public static void main(String[] args){

//        String ttt = "[123,133,124]";
////        ttt = ttt.replace("[","");
////        ttt = ttt.replace("]","");
//        ttt = ttt.substring(1,ttt.length()-1);
//        System.out.println(ttt);
//        String[] tts = ttt.split(",");
//        System.out.println(Arrays.toString(tts));

        String[] ts1 = new String[3];
        ts1[0] = "123";
        ts1[1] = "133";
        ts1[2] = "134";
        Arrays.sort(ts1);
        String t1 = Arrays.toString(ts1);
        String[] ts2 = new String[3];
        ts2[0] = "134";
        ts2[1] = "133";
        ts2[2] = "123";
        Arrays.sort(ts2);
        String t2 = Arrays.toString(ts2);
        System.out.println(t1.equals(t2));
    }
}
