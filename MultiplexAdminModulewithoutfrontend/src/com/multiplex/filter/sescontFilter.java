package com.multiplex.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class sescontFilter
 */
@WebFilter(
					 
		urlPatterns = { 
				"/sescontFilter", 
				"*.do"
		})
public class sescontFilter implements Filter {

    /**
     * Default constructor. 
     */
    public sescontFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;

		 HttpSession session = req.getSession(true);
		if(req.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/")|| req.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/home.do")|| req.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/loginpage.do")|| req.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/signshow.do") || req.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/login.do") || req.getRequestURI().equals("/MultiplexAdminModulewithoutfrontend/forgot.do")) {
			System.out.println("first if");
			chain.doFilter(request, response);
		}
	
		
		 String s=(String) session.getAttribute("validadmin");
		 if(s!=null && s.contentEquals("yes")) {

			 System.out.println("second if");
			 chain.doFilter(request, response);
			 
		 }
		 else {
			 
			 System.out.println("ACCESSDENES");
			 HttpServletResponse res=(HttpServletResponse) response;
			 res.sendRedirect("/MultiplexAdminModulewithoutfrontend/");

		 }
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
