package service.file;

import model.domain.file.FileDAO;
import model.domain.file.FileDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileServiceImpl implements FileService{
    private static final String UPLOAD_DIR = "profile";
    private static FileService instance = new FileServiceImpl();
    FileDAO fileDAO = FileDAOImpl.getInstance();
    private FileServiceImpl(){ }

    public static FileService getInstance(){
        return instance;
    }

    @Override
    public int inputImage(Long userId, String imagePath) throws SQLException {

        return fileDAO.insertImage(userId, imagePath);
    }

    @Override
    public int profileImageUpload(String username, HttpServletRequest req) throws ServletException, IOException {
        String applicationPath = req.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + UPLOAD_DIR;
        File image = new File(uploadFilePath);
        int result = 0;

        if(!image.exists()){
            image.mkdirs();
        }

        String fileName = null;
        String extension = null;

        for(Part part : req.getParts()){
            fileName = getFilename(part);
            if(!fileName.isEmpty()){
                extension = fileName.split("\\.")[1];
                part.write(uploadFilePath + File.separator + username + "." + extension);
                result = 1;
            }
        }

        return result;
    }

    @Override
    public int postImageUpload(String username, HttpServletRequest req) {
        return 0;
    }

    private String getFilename(Part part){
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens){
            if(token.trim().startsWith("filename")){
                return token.substring(token.indexOf("=")+2, token.length()-1);
            }
        }
        return "";
    }
}
