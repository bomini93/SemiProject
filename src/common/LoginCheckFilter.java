package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{

	
	
	 @Override
     public void destroy() {                 
     }

     @Override
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                             throws IOException, ServletException {
    	 System.out.println("LoginCheckFilter");
    	 
    	 if( !"/home/home".equals(((HttpServletRequest)request).getRequestURI()) && !"/recipe/search".equals(((HttpServletRequest)request).getRequestURI())
    			 && !"/rest/search".equals(((HttpServletRequest)request).getRequestURI()) && !"/member/join".equals(((HttpServletRequest)request).getRequestURI())
    			 && !"/member/findpw".equals(((HttpServletRequest)request).getRequestURI())  && !"/memberid/check".equals(((HttpServletRequest)request).getRequestURI())) {
	         System.out.println("<<AdminCheck test>>");
	         HttpServletRequest httpReq = (HttpServletRequest)request;
	         HttpSession session = httpReq.getSession();
	         Object login = session.getAttribute("login");
	         boolean loginCheck = false;
	         if(login!=null){
	             loginCheck = true;
	         }
	         if(!loginCheck){ //로그인O일 때
	        	
	             RequestDispatcher dispatcher = request.getRequestDispatcher("/member/login");
	             dispatcher.forward(request, response);
	             return;
	         }
    	 }
         
         chain.doFilter(request, response); //이걸 써야 목적지로 이동
     }
     @Override
    
     public void init(FilterConfig arg0) throws ServletException {              
     }
}

