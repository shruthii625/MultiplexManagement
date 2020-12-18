package com.multiplex.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.multiplex.utils.ConnectionUtils;




@WebFilter({ "/CreateConnFilter", "/*" })
public class CreateConnFilter implements Filter {
	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    public CreateConnFilter() {
    }

	
	public void destroy() {
	}

	 private boolean needConn(HttpServletRequest request) {
	        String servletPath = request.getServletPath();
	        String pathInfo = request.getPathInfo();
	        String urlPattern = servletPath;
	        if (pathInfo != null) {
	            urlPattern = servletPath + "/*";
	        }
	        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
	        Collection<? extends ServletRegistration> values = servletRegistrations.values();
	        for (ServletRegistration sr : values) {
	            Collection<String> mappings = sr.getMappings();
	            if (mappings.contains(urlPattern)) {
	                return true;
	            }
	        }
	        return false;
	 }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		if (this.needConn(req)) {
			Connection conn = null;
                try {
					conn = ConnectionUtils.getConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                request.setAttribute(ATT_NAME_CONNECTION, conn);
                
 
                
            
        }
	
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		 
	}

}
