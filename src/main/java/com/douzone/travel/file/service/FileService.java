package com.douzone.travel.file.service;

import com.douzone.travel.post.domain.PostViewDTO;
import com.douzone.travel.user.domain.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public interface FileService {
    int inputProfileImage(Long userId, String imagePath) throws SQLException;

    String profileImageUpload(String imagePath, HttpServletRequest req) throws ServletException, IOException;

    String postImageUpload(HttpServletRequest req) throws ServletException, IOException;

    String imageLoad(UserDTO user) throws SQLException;

    String imageLoad(PostViewDTO post) throws SQLException;

    int inputPostImage(Long postNo, String fileName) throws SQLException;
}
