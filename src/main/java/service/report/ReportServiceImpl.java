package service.report;

import model.domain.report.ReportDAO;
import model.domain.report.ReportDAOImpl;

public class ReportServiceImpl implements ReportService{
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
