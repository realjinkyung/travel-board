package com.douzone.travel.service.report;

import com.douzone.travel.model.domain.report.ReportDAO;
import com.douzone.travel.model.domain.report.ReportDAOImpl;

public class ReportServiceImpl implements ReportService{
    private static ReportService instance = new ReportServiceImpl();
    ReportDAO reportDAO = ReportDAOImpl.getInstance();

    private ReportServiceImpl(){ }

    public ReportService getInstance(){
        return instance;
    }
}
