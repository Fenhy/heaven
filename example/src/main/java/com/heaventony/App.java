package com.heaventony;

import com.heaventony.auth.annotation.IgnoreToken;
import com.heaventony.exceptions.LicenseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午2:10
 */
@RestController
@SpringBootApplication
@ComponentScan
public class App {

    @RequestMapping("/")
    @IgnoreToken
    String home() throws LicenseException {
        throw new LicenseException();
        //return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
