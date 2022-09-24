package service.post;

import java.util.ArrayList;
import java.util.HashMap;

import domain.PostDTO;

public interface PostService {
	public ArrayList<HashMap<String, Object>> allPostList(int pageNumber);
}
