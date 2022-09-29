package com.douzone.travel.file.controller;

import com.douzone.travel.Command;
import com.douzone.travel.post.domain.PostViewDTO;
import com.douzone.travel.user.domain.UserDTO;
import com.douzone.travel.file.service.FileService;
import com.douzone.travel.file.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ImageLoadController implements Command {

    FileService fileService = FileServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        String path = "";
        String profilePath = "";
        if(req.getAttribute("status").equals("profile")) {
            UserDTO user = (UserDTO) req.getAttribute("user");
            path = fileService.imageLoad(user);
            System.out.println("path:" + path);

            req.setAttribute("user", user);
            req.setAttribute("path", path);

            return "/userinfo.jsp";
        }

        if(req.getAttribute("status").equals("post")){
            PostViewDTO post = (PostViewDTO) req.getAttribute("postview");
            UserDTO user = (UserDTO) req.getAttribute("user");

            path = fileService.imageLoad(post);

            if(!Objects.isNull(user)){
                profilePath = fileService.imageLoad(user);
            }


            System.out.println("path:" + path);

            // req.setAttribute("user", user);
            req.setAttribute("path", path);
            req.setAttribute("profilePath" , profilePath);

            return "/post.jsp";
        }

        return "/error.jsp";


    }
}
