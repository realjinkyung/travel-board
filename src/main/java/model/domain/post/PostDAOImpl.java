package model.domain.post;

import domain.PostDTO;
import domain.PostViewDTO;
import utils.DBUtils;

import java.sql.*;

public class PostDAOImpl implements PostDAO {

    private static PostDAO instance = new PostDAOImpl();

    private PostDAOImpl() {
    }

    public static PostDAO getInstance(){
        return instance;
    }

    @Override
    public PostViewDTO findByPostNo(Long postNo) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        PostViewDTO postView = null;

        try{
            con = DBUtils.getConnection();
            pstmt = con.prepareStatement("select p.post_no, u.username, p.board_no, p.title, p.content, p.created_at, p.updated_at, p.deleted_at,p.views " +
                                               "from post p inner join user u " +
                                                                   "on p.user_no = u.user_no " +
                                              "where p.user_no = ?");
            pstmt.setLong(1, postNo);

            rset = pstmt.executeQuery();

            if(rset.next()) {
                postView = PostViewDTO.builder()
                        .postNo(rset.getLong("post_no"))
                        .username(rset.getString("username"))
                        .title(rset.getString("title"))
                        .content(rset.getString("content"))
                        .createdAt(rset.getDate("created_at"))
                        .views(rset.getLong("views")).build();

                Date modifiedAt = rset.getDate("updated_at");
                Date deletedAt = rset.getDate("deleted_at");

                if(modifiedAt != null){
                    postView.setModifiedAt(modifiedAt);
                }
                if(deletedAt != null){
                    postView.setDeletedAt(deletedAt);
                }
            }
        }finally{
            DBUtils.close(con,pstmt,rset);
        }
        return postView;
    }

    @Override
    public int insertPost(PostDTO postDTO) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result;

        con = DBUtils.getConnection();
        pstmt = con.prepareStatement("insert into post (user_no, board_no, title, content, created_at) values(?,?,?,?,now())");
        pstmt.setLong(1,postDTO.getUserNo());
        pstmt.setLong(2,postDTO.getBoardNo());
        pstmt.setString(3,postDTO.getTitle());
        pstmt.setString(4,postDTO.getContent());

        result = pstmt.executeUpdate();

        DBUtils.close(con,pstmt);

        return result;
    }

    @Override
    public int updatePost(PostDTO postDTO) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("update post set title=?, content=?, updated_at=now() where post_no=?");
        pstmt.setString(1, postDTO.getTitle());
        pstmt.setString(2, postDTO.getContent());
        pstmt.setLong(3, postDTO.getPostNo());

        int result = pstmt.executeUpdate();

        DBUtils.close(con,pstmt);
        return result;
    }
}
