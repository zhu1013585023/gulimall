package com.shangma.springCloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T>{
    private int code;
    private String message;
    private T t;
    public CommonResult(int code,String message){
//        this(code,message,null);
        this.code=code;
        this.message = message;
        this.t = null;
    }
}
