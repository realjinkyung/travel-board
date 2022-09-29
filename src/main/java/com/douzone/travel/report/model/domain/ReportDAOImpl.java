package com.douzone.travel.report.model.domain;

public class ReportDAOImpl implements ReportDAO {

    private static ReportDAO instance = new ReportDAOImpl();

    private ReportDAOImpl() {
    }

    public static ReportDAO getInstance(){
        return instance;
    }
}
