package com.briup.www.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.briup.www.util.MyEncodingRequest;
@WebFilter(urlPatterns={"/*"})
public class EncodingFliter implements Filter {

    public EncodingFliter() {
       
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse) resp;
		chain.doFilter(new MyEncodingRequest(request), response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
