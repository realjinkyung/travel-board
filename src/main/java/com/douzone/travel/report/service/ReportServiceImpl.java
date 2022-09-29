package com.douzone.travel.report.service;

import com.douzone.travel.report.model.domain.ReportDAO;
import com.douzone.travel.report.model.domain.ReportDAOImpl;


public class ReportServiceImpl implements ReportService {
    private static ReportService instance = new ReportServiceImpl();
    ReportDAO reportDAO = ReportDAOImpl.getInstance();

    private ReportServiceImpl(){ }

    public static ReportService getInstance(){
        return instance;
    }
    
    @Override
    public int reportComment(int commentNum, String username, String targetUsername, int reportReason) {
    	return reportDAO.reportComment(commentNum, username, targetUsername, reportReason);
    }
    
    @Override
    public int reportPost(int postNum, String username, String targetUsername, int reportReason) {
    	
    	return reportDAO.reportPost(postNum, username, targetUsername, reportReason);
    }
}
