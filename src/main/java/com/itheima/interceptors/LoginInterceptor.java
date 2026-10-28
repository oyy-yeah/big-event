package com.itheima.interceptors;

import com.itheima.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 获取请求头中的 Authorization
        String token = request.getHeader("Authorization");

        // 2. 判断是否为空（没带令牌直接打回）
        if (token == null || token.trim().isEmpty()) {
            response.setStatus(401);
            return false;
        }

        // 3. 截取掉前面的 "Bearer " 前缀（如果有的话）
        if (token.startsWith("Bearer ")) {
            token = token.substring(7); // 截掉前7个字符
        }

        // 4. 开始验证令牌
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 解析成功，说明令牌合法且未过期
            return true; // 放行
        } catch (Exception e) {
            // 解析失败（伪造、过期、格式错误）
            e.printStackTrace();
            response.setStatus(401);
            return false;
        }
    }
}