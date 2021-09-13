package com.shangma.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    @RequestMapping(value = {"/goto","/"})
    public String gotoSuccess(HttpServletRequest request){
        request.setAttribute("msg","操作成功");
        request.setAttribute("code",200);
        return "forward:success";
    }

    @ResponseBody
    @RequestMapping("/success")
    public Map<String,Object> success(@RequestAttribute("msg") String msg,HttpServletRequest request){
        Object code = request.getAttribute("code");
        Map<String,Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("code",code);
        return map;
    }
}
