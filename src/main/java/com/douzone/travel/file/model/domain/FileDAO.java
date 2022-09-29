package com.douzone.travel.file.model.domain;

import com.douzone.travel.post.domain.PostViewDTO;
import com.douzone.travel.user.domain.UserDTO;

import java.sql.SQLException;

public interface FileDAO{

    int insertImage(Long userId, String imagePath) throws SQLException;

    String findByUserId(UserDTO user) throws SQLException;

    String findByPostId(PostViewDTO post) throws SQLException;

    int insertPostImage(Long postNo, String fileName) throws SQLException;
}
