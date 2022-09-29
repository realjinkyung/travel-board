package com.douzone.travel.report.service;

import com.douzone.travel.report.model.domain.ReportDAO;
import com.douzone.travel.report.model.domain.ReportDAOImpl;

public class ReportServiceImpl implements ReportService{
    private static ReportService instance = new ReportServiceImpl();
    ReportDAO reportDAO = ReportDAOImpl.getInstance();

    private ReportServiceImpl(){ }

    public ReportService getInstance(){
        return instance;
    }
}
