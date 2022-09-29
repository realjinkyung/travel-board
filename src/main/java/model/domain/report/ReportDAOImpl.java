package model.domain.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DBUtils;

public class ReportDAOImpl implements ReportDAO {

	private static ReportDAO instance = new ReportDAOImpl();

	private ReportDAOImpl() {
	}

	public static ReportDAO getInstance() {
		return instance;
	}

	@Override
	public int reportComment(int commentNum, String username, String targetUsername, int reportReason) {
		String sql = "insert into report(user_no, reported_user_no, comment_no, reason) values((select user_no from user where username = ?), (select user_no from user where username = ?), ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String reason = "";
		int result = 0;

		switch (reportReason) {
		case 1:
			reason = "불법 정보";
			break;
		case 2:
			reason = "청소년 유해 내용";
			break;
		case 3:
			reason = "욕설/생명경시/혐오/차별적 표현";
			break;
		case 4:
			reason = "스팸홍보/도배글";
			break;
		case 5:
			reason = "개인정보 노출";
			break;
		case 6:
			reason = "불쾌한 표현";
			break;
		default:
			break;
		}

		try {
			con = DBUtils.getConnection();
			
			pstmt = con.prepareStatement("select *from report where user_no = (select user_no from user where username = ?) and reported_user_no = (select user_no from user where username = ?) and comment_no = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, targetUsername);
			pstmt.setInt(3, commentNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 2;
			}else {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, targetUsername);
				pstmt.setInt(3, commentNum);
				pstmt.setString(4, reason);

				result = pstmt.executeUpdate();

				if (result == 1) {
					return 1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.close(con, pstmt);
		}

		return 0;
	}
	
	@Override
	public int reportPost(int postNum, String username, String targetUsername, int reportReason) {
		String sql = "insert into report(user_no, reported_user_no, post_no, reason) values((select user_no from user where username = ?), (select user_no from user where username = ?), ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String reason = "";
		int result = 0;

		switch (reportReason) {
		case 1:
			reason = "불법 정보";
			break;
		case 2:
			reason = "청소년 유해 내용";
			break;
		case 3:
			reason = "욕설/생명경시/혐오/차별적 표현";
			break;
		case 4:
			reason = "스팸홍보/도배글";
			break;
		case 5:
			reason = "개인정보 노출";
			break;
		case 6:
			reason = "불쾌한 표현";
			break;
		default:
			break;
		}

		try {
			con = DBUtils.getConnection();
			
			pstmt = con.prepareStatement("select *from report where user_no = (select user_no from user where username = ?) and reported_user_no = (select user_no from user where username = ?) and post_no = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, targetUsername);
			pstmt.setInt(3, postNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 2;
			}else {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, targetUsername);
				pstmt.setInt(3, postNum);
				pstmt.setString(4, reason);

				result = pstmt.executeUpdate();

				if (result == 1) {
					return 1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtils.close(con, pstmt);
		}

		return 0;
	}

}
