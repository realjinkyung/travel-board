package com.douzone.travel.report.service;

public interface ReportService {
	 public int reportComment(int commentNum, String username, String targetUsername, int reportReason);
	 public int reportPost(int postNum, String username, String targetUsername, int reportReason);
	
}
