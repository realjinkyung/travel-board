package service.report;

import model.domain.report.ReportDAO;
import model.domain.report.ReportDAOImpl;

public class ReportServiceImpl implements ReportService{
    private static ReportService instance = new ReportServiceImpl();
    ReportDAO reportDAO = ReportDAOImpl.getInstance();

    private ReportServiceImpl(){ }

    public ReportService getInstance(){
        return instance;
    }
}
