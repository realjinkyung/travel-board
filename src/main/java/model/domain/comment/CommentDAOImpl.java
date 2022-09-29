package model.domain.comment;

import domain.CommentViewDTO;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CommentDAOImpl implements CommentDAO{

    private static CommentDAO instance = new CommentDAOImpl();

    private CommentDAOImpl() {
    }

    public static CommentDAO getInstance(){
        return instance;
    }

    @Override
    public List<CommentViewDTO> findAll(Long postNo) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select *from (select c.*, u.username from comment c inner join user u on c.user_no = u.user_no where post_no = ?) sub left outer join (select comment_no, count(*) comment_report_count from report where comment_no is not null group by comment_no) sub2 using(comment_no)");
        pstmt.setLong(1, postNo);
        ResultSet rSet = pstmt.executeQuery();
        List<CommentViewDTO> commentDTOList = new ArrayList<>();

        while(rSet.next()){
            CommentViewDTO commentViewDTO = CommentViewDTO.builder()
                    .commentNo(rSet.getLong("comment_no"))
                    .postNo(rSet.getLong("post_no"))
                    .username(rSet.getString("username"))
                    .createdAt(rSet.getDate("created_at"))
                    .content(rSet.getString("comment_content"))
                    .build();

            Date modified = rSet.getDate("updated_at");
            if(Objects.nonNull(modified)){
                commentViewDTO.setCreatedAt(modified);
                commentViewDTO.setModifiedAt(" - modified");
            }

            commentDTOList.add(commentViewDTO);
        }

        return commentDTOList;
    }

    @Override
    public int insertComment(String commentContent, Long postNo) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into comment (user_no, post_no, comment_content, created_at) values (1, ?,?, now())");
        pstmt.setLong(1, postNo);
        pstmt.setString(2,commentContent);
        int result = pstmt.executeUpdate();

        DBUtils.close(con, pstmt);

        return result;
    }

    @Override
    public int deleteComment(Long commentNo) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("delete from comment where comment_no=?");
        pstmt.setLong(1, commentNo);
        int result = pstmt.executeUpdate();

        DBUtils.close(con, pstmt);

        return result;
    }

    @Override
    public int updateComment(Long commentNo, String username, String comment) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("update comment set comment_content = ?, updated_at = now() where comment_no = ?;");
        pstmt.setString(1, comment);
        pstmt.setLong(2, commentNo);

        int result = pstmt.executeUpdate();

        DBUtils.close(con, pstmt);
        return result;
    }
    
    
    
    @Override
    public ArrayList<HashMap<String, Object>> selectAllComments(Long postNo) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select *from (select c.*, u.username from comment c inner join user u on c.user_no = u.user_no where post_no = ?) sub left outer join (select comment_no, count(*) comment_report_count from report where comment_no is not null group by comment_no) sub2 using(comment_no)");
        pstmt.setLong(1, postNo);
        ResultSet rSet = pstmt.executeQuery();
        ArrayList<HashMap<String, Object>> commentList = new ArrayList<>();
        HashMap<String, Object> comment;
        while(rSet.next()){
        	comment = new HashMap<String, Object>();
        	comment.put("commentNo",rSet.getLong("comment_no"));
        	comment.put("postNo",rSet.getLong("post_no"));
        	comment.put("username",rSet.getString("username"));
        	comment.put("createdAt",rSet.getDate("created_at"));
        	comment.put("content",rSet.getString("comment_content"));
        	comment.put("commentReportCount",rSet.getInt("comment_report_count"));
        	
          
            Date modified = rSet.getDate("updated_at");
            if(Objects.nonNull(modified)){
            	comment.put("createdAt", modified);
            	comment.put("modifiedAt", " - modified");
            }
            
            commentList.add(comment);
        }

        return commentList;
    }
    
}
