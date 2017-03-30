package com.heaventony.validation;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/28
 * Time: 下午2:04
 */
public class TestEntity {

    @DataValidation(nullable = false, maxLength = 10, minLength = 2)
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
