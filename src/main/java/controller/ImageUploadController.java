package controller;

import service.file.FileService;
import service.file.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ImageUploadController implements Command {
    FileService fileService = FileServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Long userId = (Long) req.getAttribute("userId");
        String username = (String) req.getAttribute("username");
        String status = (String) req.getAttribute("status");
        int result = 0;

        if(status.equals("profileImage")) {
            result = fileService.profileImageUpload(username, req);
        }
        if(status.equals("postImage")) {
            result = fileService.postImageUpload(username, req);
        }


        if(result == 1){
            fileService.inputImage(userId, username);
            return "redirect:boardList.do";
        } else {
            req.setAttribute("msg", "file upload에 실패했습니다.");
            return "error.jsp";
        }
    }
}
