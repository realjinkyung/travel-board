package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionCheckFIlter
 */
@WebFilter(filterName="/SessionCheckFilter", urlPatterns="*")
public class SessionCheckFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	List<String> whiteList= new ArrayList<>();

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession(false);
		String uri = whiteList.stream().filter((uriItem)-> uriItem.equals(req.getServletPath())).findFirst().orElse(null);

		if(Objects.isNull(uri)){
			if(Objects.isNull(session) || Objects.isNull(session.getAttribute("username"))) {
				req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		whiteList.add("/joinForm.jsp");
		whiteList.add("/login.do");
		whiteList.add("/boardList.do");
		whiteList.add("/post.do");
		


	}

}
