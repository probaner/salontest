package SpringMy.Maven.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//public class ApplicationSessionListener implements HttpSessionListener {
	public class ApplicationSessionListener implements Filter {

/*public void sessionCreated(HttpSessionEvent event) {
   System.out.println("Channda Session Created");
   System.out.println("Session Created:: ID="+event.getSession().getId());
 }

public void sessionDestroyed(HttpSessionEvent event) {
   //write your logic
   System.out.println("Chanchal Session Destroyed");
   System.out.println("Session Destroyed:: ID="+event.getSession().getId());
  }*/

		
		@Override
		public void destroy() {
			// ...
		}

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			//
		}

		@Override
		public void doFilter(ServletRequest request,
	               ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
           
			System.out.println("IIIIIIIIIIINNNNNNNNNNNNNNN");
			
			try {
				chain.doFilter(request, response);
			} catch (Exception ex) {
				//request.setAttribute("errorMessage", ex);
				request.getRequestDispatcher("/WEB-INF/views/home.jsp")
	                               .forward(request, response);
			}

		}

		
		
		
}
