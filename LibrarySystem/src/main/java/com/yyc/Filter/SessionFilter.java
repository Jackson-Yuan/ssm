package com.yyc.Filter;

import com.yyc.entity.Reader;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by yyc on 2018/8/15.
 */
public class SessionFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String path = request.getServletPath();
//        System.out.println(path);
        if (path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".jsp") || path.endsWith(".html") || path.startsWith("/ajax") ||
                path.endsWith("show")) {
            filterChain.doFilter(request, response);
            return;
        }

        Reader reader = (Reader) request.getSession().getAttribute("loginReader");
        if (reader == null) {
            response.sendRedirect(request.getContextPath() + "/error.html");
            return;
        }

        filterChain.doFilter(request, response);

    }
}
