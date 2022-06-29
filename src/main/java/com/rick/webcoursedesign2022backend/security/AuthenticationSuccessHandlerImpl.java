package com.rick.webcoursedesign2022backend.security;

import com.alibaba.fastjson.JSON;
import com.rick.webcoursedesign2022backend.entity.User;
import com.rick.webcoursedesign2022backend.result.ResultVO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setPassword(null);
        ResultVO resultVO;
        if(user.getIst().equals("Y")){
            resultVO = new ResultVO();
            resultVO.setStatus_code("200");
            resultVO.getMap().put("type","teacher");
            resultVO.getMap().put("user",user);
        }else{
            resultVO = new ResultVO();
            resultVO.setStatus_code("200");
            resultVO.getMap().put("type","student");
            resultVO.getMap().put("user",user);
        }
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(resultVO));
    }
}
