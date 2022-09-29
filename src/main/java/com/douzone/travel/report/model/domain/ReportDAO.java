package com.douzone.travel.report.model.domain;

public interface ReportDAO {
	int reportComment(int commentNum, String username, String targetUsername, int reportReason);
	int reportPost(int postNum, String username, String targetUsername, int reportReason) ;
	
}
