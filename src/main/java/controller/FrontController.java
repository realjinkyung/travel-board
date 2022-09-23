package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontController extends HttpServlet {
	private static final String REDIRECT_PREfIX = "redirect:";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");

		try {
			Command command = resolveCommand(req.getServletPath(), req.getMethod());
			String view = command.execute(req, resp);

			if (view.startsWith(REDIRECT_PREfIX)) {
				resp.sendRedirect(view.substring(REDIRECT_PREfIX.length()));
			} else {
				RequestDispatcher rd = req.getRequestDispatcher(view);
				rd.include(req, resp);
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
		}

		return command;
	}


}
