package com.mercury.laptapVS.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.laptapVS.bean.User;
import com.mercury.laptapVS.http.AuthenticationSuccessResponse;
import com.mercury.laptapVS.http.Response;


public class SecurityUtils {
	
	private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendResponse(HttpServletResponse response, int status, String message, Exception exception) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        PrintWriter writer = response.getWriter();
        
        writer.write(mapper.writeValueAsString(new Response(exception == null ? true : false, status, message)));
        response.setStatus(status);
        writer.flush();
        writer.close();
    }
    
    public static void sendAuthenticationSuccessResponse(HttpServletResponse httpServletResponse, int status, String message, Exception exception, User user)
            throws IOException {
        Response response = new AuthenticationSuccessResponse(exception == null ? true : false, status, message, user);
        System.out.println(response);
        flushResponse(httpServletResponse, response);
    }
	
    public static void flushResponse(HttpServletResponse httpServletResponse, Response response) throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(response.getCode());
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(mapper.writeValueAsString(response));
        writer.flush();
        writer.close();
    }
}