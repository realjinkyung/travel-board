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
<<<<<<< HEAD
		HttpSession session = req.getSession(false); // session 생성 
		String uri = whiteList.stream().filter((uriItem)-> uriItem.equals(req.getServletPath())).findFirst().orElse(null); // ?

=======
		HttpSession session = req.getSession(false);
		// System.out.println(req.getServletPath());
		String uri = whiteList.stream().filter((uriItem)-> req.getServletPath().contains(uriItem)).findFirst().orElse(null);
		System.out.println(uri);
>>>>>>> af51c7d18fb95c8d5a963c33b2add4e4b39c4ecd
		if(Objects.isNull(uri)){
			if(Objects.isNull(session) || Objects.isNull(session.getAttribute("username"))) { // 톰캣 자동생성 방지 -> setAttribute에 username넣기
				req.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		
		chain.doFilter(request, response); // 세션이 있는지 없는지 check -> filter에서 해 줌 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
<<<<<<< HEAD
		// 세션이 필요없는 목록
		whiteList.add("/joinForm.jsp"); // 회원가입
		whiteList.add("/login.do");		// 로그인
		whiteList.add("/login.jsp");	// 로그인
		whiteList.add("/boardList.do"); // 게시판리스트
//		whiteList.add("/post.do");		// 게시글
//		whiteList.add("/post.jsp");		// 게시글
//		whiteList.add("/comments.do"); 	// 댓글
		whiteList.add("/board.jsp");	// 게시판?
		whiteList.add("/error.jsp");	// 에러
		whiteList.add("/index.jsp");
=======
		// TODO Auto-generated method stub
		whiteList.add("/joinForm.jsp");
		whiteList.add("/login.do");
		whiteList.add("/boardList.do");
		whiteList.add("/post.do");
		whiteList.add("/join.do");
		whiteList.add("/image-upload.do");
		whiteList.add("images");
		whiteList.add("profile");

>>>>>>> af51c7d18fb95c8d5a963c33b2add4e4b39c4ecd
	}
}
