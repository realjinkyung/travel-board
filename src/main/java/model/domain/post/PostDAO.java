package model.domain.post;

import java.util.ArrayList;
import java.util.HashMap;

import domain.PostDTO;

public interface PostDAO {
	public ArrayList<HashMap<String, Object>> selectPostList(int pageNumber);
}
