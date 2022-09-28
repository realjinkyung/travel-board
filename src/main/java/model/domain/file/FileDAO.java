package model.domain.file;

import java.sql.SQLException;

public interface FileDAO{

    int insertImage(Long userId, String imagePath) throws SQLException;
}
