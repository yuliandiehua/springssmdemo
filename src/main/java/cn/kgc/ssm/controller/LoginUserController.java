package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.User;
import cn.kgc.ssm.service.UserService;
import cn.kgc.ssm.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录退出控制层
 */
@Controller
public class LoginUserController {
    private Logger logger=Logger.getLogger(LoginUserController.class);
    @Autowired
    private UserService userService;
    /**
     * 登录验证
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String login(@RequestParam String userCode, @RequestParam String userPassword, HttpServletRequest request){
        logger.info("用户登录验证");
        //调用业务层方法进行登录验证
        User user = this.userService.login(userCode, userPassword);
        //判断验证结果返回不同页面
        if(null==user){
            logger.info("用户名或密码错误!");
            request.setAttribute("error","用户名或密码错误!");
            return "forward:/login.jsp";
        }
        //将用户加入到session当中
        request.getSession().setAttribute(Constants.USER_SESSION,user);
        return "admin/main";
    }
    /**
     * 退出验证
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        return "redirect:/login.jsp";

    }
}
