package com.douzone.travel.file.model.domain;

import com.douzone.travel.post.domain.PostViewDTO;
import com.douzone.travel.user.domain.UserDTO;
import com.douzone.travel.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// import static com.douzone.travel.file.service.FileServiceImpl.PROFILE_IMAGE;

public class FileDAOImpl implements FileDAO {


    private static FileDAO instance = new FileDAOImpl();

    private FileDAOImpl() {
    }

    public static FileDAO getInstance(){
        return instance;
    }

    @Override
    public int insertImage(Long userId, String imagePath) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into file (user_no, file_path) values(?, ?)");
        pstmt.setLong(1, userId);
        pstmt.setString(2, imagePath);

        int result = pstmt.executeUpdate();

        DBUtils.close(con, pstmt);

        return result;
    }

    @Override
    public String findByUserId(UserDTO user) throws SQLException {
        String path = null;

        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from file where user_no=?");
        pstmt.setLong(1, user.getUserNo());
        ResultSet rset = pstmt.executeQuery();

        if(rset.next()) {
            path = rset.getString("file_path");
        }

        DBUtils.close(con,pstmt,rset);

        return path;
    }

    @Override
    public String findByPostId(PostViewDTO post) throws SQLException {
        String path = null;
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from file where post_no = ?");
        pstmt.setLong(1,post.getPostNo());

        ResultSet rset = pstmt.executeQuery();
        if(rset.next()){
            path = rset.getString("file_path");
        }

        DBUtils.close(con,pstmt,rset);
        return path;
    }

    @Override
    public int insertPostImage(Long postNo, String fileName) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into file (post_no, file_path) values (?, ?)");
        pstmt.setLong(1,postNo);
        pstmt.setString(2, fileName);

        int result = pstmt.executeUpdate();

        return result;
    }
}
