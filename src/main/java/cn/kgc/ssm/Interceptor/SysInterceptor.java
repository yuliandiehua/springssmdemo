package cn.kgc.ssm.Interceptor;

import cn.kgc.ssm.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 自定义权限拦截器
 */
public class SysInterceptor extends HandlerInterceptorAdapter {
    Logger logger= Logger.getLogger(SysInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("执行权限验证");
        HttpSession session=request.getSession();
        Object object=session.getAttribute(Constants.USER_SESSION);
        if(null==object){
            //没有权限，跳转到错误页面
            response.sendRedirect(request.getContextPath()+"/error.jsp");
            //返回false
            return false;
        }
        //有权限时放行
        return super.preHandle(request, response, handler);
    }
}
