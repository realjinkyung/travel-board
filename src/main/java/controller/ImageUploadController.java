package controller;

import domain.UserDTO;
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

        String status = (String) req.getAttribute("status");
        Long postNo = (Long) req.getAttribute("postNo");
        UserDTO userDTO = (UserDTO) req.getAttribute("user");
        String fileName = "";

        if("profileImage".equals(status)) {
            fileName = fileService.profileImageUpload(userDTO.getUsername(), req);
        }
        if("postImage".equals(status)) {
            fileName = fileService.postImageUpload(req);
        }


        if(fileName != "" && status.equals("profileImage")){
            fileService.inputProfileImage(userDTO.getUserNo(), fileName);
            return "redirect:boardList.do";
        } else if (fileName != "" && status.equals("postImage")) {
            fileService.inputPostImage(postNo, fileName);
            return "redirect:post.do?postNo=" + postNo;
        } else {
            req.setAttribute("msg", "file upload에 실패했습니다.");
            return "error.jsp";
        }
    }
}
