package model.domain.post;

import domain.PostDTO;
import domain.PostViewDTO;

import java.sql.SQLException;

public interface PostDAO {
	// 로그인 1줄

    PostViewDTO findByPostNo(Long postNo) throws SQLException;

    int insertPost(PostDTO postDTO) throws SQLException;

    int updatePost(PostDTO postDTO) throws SQLException;
}
