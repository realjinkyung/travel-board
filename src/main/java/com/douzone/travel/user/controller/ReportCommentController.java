package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.report.ReportService;
import service.report.ReportServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

public class ReportCommentController implements Command{
	
	ReportService reportService = ReportServiceImpl.getInstance();
	UserService userService = UserServiceImpl.getInstance();

	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result1 = 0;
		boolean result2 = false;
		try {
			int postNum = Integer.parseInt(req.getParameter("postNum"));
			int commentNum = Integer.parseInt(req.getParameter("commentNum"));
			String username = req.getParameter("username");
			String targetUsername = req.getParameter("targetUsername");
			int reportReason = Integer.parseInt(req.getParameter("report_reason"));
			String reportKinds = req.getParameter("reportKinds");
			
			
			if(reportKinds.equals("comment") && postNum == 0) {
				result1 = reportService.reportComment(commentNum, username, targetUsername, reportReason);
			}else if(reportKinds.equals("post") && commentNum == 0) {
				result1 = reportService.reportPost(postNum, username, targetUsername, reportReason);
			}
			
			System.out.println(result1);
			
			if(result1 == 1) {
				result2 = userService.updateIsBlinded(targetUsername);
				System.out.println("블라인드 업데이트 수행");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result1 != 0 && result2 == true) {
			return "redirect:boardList.do";
		}else if(result1 == 2) {
			return "redirect:boardList.do";
		}else {
			return "error.jsp";
		}
	}
}