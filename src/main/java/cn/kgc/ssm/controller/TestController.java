package cn.kgc.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello,springMvc";
    }
    @RequestMapping("/admin/test")
    @ResponseBody
    public String test1(){
        return "hello,admin";
    }
    @RequestMapping("/test2")
    @ResponseBody
    public Map<String,Object> test2(){
        Map maps=new HashMap();
        maps.put("时间",new Date());
        maps.put("姓名","小李子");
        return maps;
    }
}
