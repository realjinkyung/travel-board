package com.douzone.travel.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter", urlPatterns = "*")
public class CharsetFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override   
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // 1 - 필터 거치기 전
        System.out.println("서블릿 전");
        chain.doFilter(request, response); // 2 - 필터링
        System.out.println("서블릿 후");
        // 3 - 필터링 후
    }
}
