package service.file;

import domain.PostViewDTO;
import domain.UserDTO;
import model.domain.file.FileDAO;
import model.domain.file.FileDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileServiceImpl implements FileService{
    private static final String POST_IMAGE = "post/";
    private static final String APPLICATION_PATH = "images/";
    private static FileService instance = new FileServiceImpl();
    FileDAO fileDAO = FileDAOImpl.getInstance();
    private FileServiceImpl(){ }

    public static FileService getInstance(){
        return instance;
    }

    @Override
    public int inputProfileImage(Long userId, String imagePath) throws SQLException {

        return fileDAO.insertImage(userId, imagePath);
    }

    @Override
    public String profileImageUpload(String username, HttpServletRequest req) throws ServletException, IOException {
        // String path = System.getProperty("user.dir");
        // String status = (String) req.getAttribute("status");
        // String uploadFilePath = path + "/webapp/" + APPLICATION_PATH + "/" + status;
        String applicationPath = req.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + APPLICATION_PATH;
        File image = new File(uploadFilePath);

        String fileNameForReturn = "";

        if(!image.exists()){
            image.mkdirs();
        }

        String fileName = null;
        String extension = null;

        for(Part part : req.getParts()){
            fileName = getFilename(part);
            if(!fileName.isEmpty()){
                extension = fileName.split("\\.")[1];
                fileNameForReturn = APPLICATION_PATH + "/" + username + "." + extension;
                //images/asdf.png
                part.write(uploadFilePath + File.separator + username + "." + extension);
            }
        }
        req.getParts().clear();
        return fileNameForReturn;
    }

    @Override
    public String postImageUpload(HttpServletRequest req) throws ServletException, IOException {

        String applicationPath = req.getServletContext().getRealPath("");
        Long postNo = (Long) req.getAttribute("postNo");
        String uploadFilePath = applicationPath + APPLICATION_PATH + POST_IMAGE + postNo;
        File image = new File(uploadFilePath);

        if(!image.exists()){
            image.mkdirs();
        }

        String fileName = null;
        String extension = null;
        String fileNameForReturn = "";

        for(Part part : req.getParts()){
            fileName = getFilename(part);
            if(!fileName.isEmpty()){
                extension = fileName.split("\\.")[1];
                fileNameForReturn = APPLICATION_PATH + POST_IMAGE + postNo + File.separator + postNo + "." + extension;
                part.write(uploadFilePath + File.separator +  postNo + "." + extension);
            }
        }
        req.getParts().clear();
        return fileNameForReturn;
    }

    @Override
    public String imageLoad(UserDTO user) throws SQLException {
        return fileDAO.findByUserId(user);
    }

    @Override
    public String imageLoad(PostViewDTO post) throws SQLException {
        return fileDAO.findByPostId(post);
    }

    @Override
    public int inputPostImage(Long postNo, String fileName) throws SQLException {
        return fileDAO.insertPostImage(postNo, fileName);
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
