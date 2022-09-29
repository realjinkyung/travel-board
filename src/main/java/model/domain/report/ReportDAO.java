package model.domain.report;

public interface ReportDAO {
	public int reportComment(int commentNum, String username, String targetUsername, int reportReason);
	public int reportPost(int postNum, String username, String targetUsername, int reportReason);
}
