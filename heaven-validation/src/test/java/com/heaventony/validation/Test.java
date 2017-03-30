package com.heaventony.validation;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/28
 * Time: 下午2:06
 */
public class Test {

    @org.junit.Test
    public void testValidationMinLength() {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("1");
        Map<String, Object> map = DataValidateProcess.validate(testEntity);
        assertEquals("错误","name字段长度小于2", map.get("message"));
    }

    @org.junit.Test
    public void testValidationMaxLength() {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("11111111111");
        Map<String, Object> map = DataValidateProcess.validate(testEntity);
        assertEquals("错误","name字段长度超过10", map.get("message"));
    }

    @org.junit.Test
    public void testValidationNullable() {
        TestEntity testEntity = new TestEntity();
//        testEntity.setName("1");
        Map<String, Object> map = DataValidateProcess.validate(testEntity);
        assertEquals("错误","name字段不能为空", map.get("message"));
    }
}
