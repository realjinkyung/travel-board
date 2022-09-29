package com.douzone.travel.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.travel.Command;
import com.douzone.travel.report.service.ReportServiceImpl;

import service.report.ReportService;

public class ReportCommentPageController implements Command{
	
	ReportService reportService = (ReportService) ReportServiceImpl.getInstance();


	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int postNum = Integer.parseInt(req.getParameter("postNum"));
			int commentNum = Integer.parseInt(req.getParameter("commentNum"));
			String username = req.getParameter("username");
			String targetUsername = req.getParameter("targetUsername");
			String content = req.getParameter("content");
			String reportKinds = req.getParameter("report_kinds");
			
			req.setAttribute("postNum", postNum);
			req.setAttribute("commentNum", commentNum);
			req.setAttribute("username", username);
			req.setAttribute("targetUsername", targetUsername);
			req.setAttribute("content", content);
			req.setAttribute("reportKinds", reportKinds);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "reportComment.jsp";
	}
}