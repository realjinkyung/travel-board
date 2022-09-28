package service.file;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public interface FileService {
    int inputImage(Long userId, String imagePath) throws SQLException;

    int profileImageUpload(String imagePath, HttpServletRequest req) throws ServletException, IOException;

    int postImageUpload(String username, HttpServletRequest req);
}
