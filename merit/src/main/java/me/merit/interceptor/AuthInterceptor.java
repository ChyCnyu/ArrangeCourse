package me.merit.interceptor;

import me.merit.annotation.AuthRequired;
import me.merit.entity.UserEntity;
import me.merit.util.TokenUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            // 附带token 进行认证
            String token = request.getHeader("token");

            // 注解
            AuthRequired authRequired = (AuthRequired) ((HandlerMethod) handler).getMethodAnnotation(AuthRequired.class);
            if (authRequired == null) {
                return true;
            }
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            if (token == null) {
                response.getWriter().write("{\"code\":400,\"msg\":\"缺少口令！\"}");
                return false;
            }
            UserEntity user = TokenUtil.verifyToken(token);
            if (user == null) {
                response.getWriter().write("{\"code\":400,\"msg\":\"口令验证失败！\"}");
                return false;
            }
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user_id", user.getId());
            httpSession.setAttribute("user_role", user.getRoleId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
