package servletFilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "/ActionLogging", urlPatterns = "*")
public class ActionLogging implements Filter {

    public ActionLogging() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest sRequest = (HttpServletRequest) request;
		String Logging = "user:" + sRequest.getSession().getAttribute("username") + " accesses: " + sRequest.getRequestURI().toString();
		System.out.println(">>>>>> Log: " + Logging);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
