package com.heaventony.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/9/13
 * Time: 下午5:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends Exception {

    private StatusCode statusCode;
    
}
