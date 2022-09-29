package controller;

import controller.comment.DeleteCommentController;
import controller.comment.ProduceCommentController;
import controller.comment.ReadCommentController;
import controller.comment.editCommentController;
import controller.post.ConnectNewPostController;
import controller.post.DeletePostController;
import controller.post.PostReadController;
import controller.post.ProducePostController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(fileSizeThreshold=2048*2048*10,
		maxFileSize=2048*2048*50,
		maxRequestSize=2048*2048*100)
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontController extends HttpServlet {
	private static final String REDIRECT_PREfIX = "redirect:";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");

		System.out.println(req.getParameter("id"));
		try {
			Command command = resolveCommand(req.getServletPath(), req.getMethod());
			String view = command.execute(req, resp);

			if (view.startsWith(REDIRECT_PREfIX)) { 
				resp.sendRedirect(view.substring(REDIRECT_PREfIX.length())); 
			} else {
				RequestDispatcher rd = req.getRequestDispatcher(view);
				rd.forward(req, resp);
			}
		} catch (Exception ex) {
			System.out.printf("", ex); 

			req.setAttribute("exception", ex);
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, resp);
		}
	}

	private Command resolveCommand(String servletPath, String method) {
		Command command = null;
		
		if ("/boardList.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
			command = new BoardReadController();
		} else if("/userinfo.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
			System.out.println("userInfo.do");
			command = new UserInfoController();											// 유저 정보 확인
		} else if("/userRevisePage.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
			command = new UserRevisePageController();
		}else if("/userRevise.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
			command = new UserReviseController();
		} else if ("/join.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {	// 회원가입
			command = new JoinFormContoller();											
//		} else if("/revise.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//			command = new UserReviseController();
		}else if("/logout.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) { // 로그아웃
			command = new LogOutController();
		} else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) { // 로그인
			command = new LoginController(); 
		} else if ("/post.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) { //FIXME URL
			command = new PostReadController();
		} else if ("/newPost.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){ //FIXME URL
			command = new ConnectNewPostController();
		} else if ("/makePost.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) { //FIXME URL
			command = new ProducePostController();
		} else if ("/edit.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) { //FIXME URL
			command = new ConnectNewPostController();
		} else if ("/deletePost.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) { //FIXME URL
			command = new DeletePostController();	// session
		} else if ("/comments.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) { //FIXME URL
			command = new ReadCommentController();
		} else if ("/addComment.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) { //FIXME URL
			command = new ProduceCommentController();
		} else if ("/updateComment.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) { //FIXME URL
			command = new editCommentController();	// session
		} else if ("/deleteComment.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) { //FIXME URL
			command = new DeleteCommentController();	// session
		}

		return command;
	}


}
