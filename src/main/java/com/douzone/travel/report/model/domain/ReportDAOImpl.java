package com.douzone.travel.model.domain.report;

public class ReportDAOImpl implements ReportDAO {

    private static ReportDAO instance = new ReportDAOImpl();

    private ReportDAOImpl() {
    }

    public static ReportDAO getInstance(){
        return instance;
    }
}
