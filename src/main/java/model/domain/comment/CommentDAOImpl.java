package model.domain.comment;

import domain.CommentViewDTO;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        PreparedStatement pstmt = con.prepareStatement("select c.*, u.username \n" +
                "from comment c inner join user u on c.user_no = u.user_no\n" +
                "where post_no = ?");
        pstmt.setLong(1, postNo);
        ResultSet rSet = pstmt.executeQuery();
        List<CommentViewDTO> commentDTOList = new ArrayList<>();

        while(rSet.next()){
            commentDTOList.add(CommentViewDTO.builder()
                    .commentNo(rSet.getLong("comments_no"))
                    .postNo(rSet.getLong("post_no"))
                            .username(rSet.getString("username"))
                    .createdAt(rSet.getDate("created_at"))
                    .content(rSet.getString("comment_content"))
                    .build());
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
        PreparedStatement pstmt = con.prepareStatement("delete from comment where comments_no=?");
        pstmt.setLong(1, commentNo);
        int result = pstmt.executeUpdate();

        DBUtils.close(con, pstmt);

        return result;
    }

    @Override
    public int updateComment(Long commentNo, String username, String comment) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("update comment set comment_content = ? where comment_no = ?;");
        pstmt.setString(1, comment);
        pstmt.setLong(2, commentNo);

        int result = pstmt.executeUpdate();

        DBUtils.close(con, pstmt);
        return result;
    }
}
