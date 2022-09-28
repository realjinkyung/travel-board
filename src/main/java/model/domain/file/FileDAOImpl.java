package model.domain.file;

import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
