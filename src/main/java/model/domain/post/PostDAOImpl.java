package model.domain.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.BoardDTO;
import domain.PostDTO;
import utils.DBUtils;

public class PostDAOImpl implements PostDAO {

    private static PostDAO instance = new PostDAOImpl();

    private PostDAOImpl() {
    }

    public static PostDAO getInstance(){
        return instance;
    }
    
    @Override
    public ArrayList<HashMap<String, Object>> selectPostList(int pageNumber) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        ArrayList<HashMap<String, Object>> postList= new ArrayList<HashMap<String, Object>>();
        
    	try {
            con = DBUtils.getConnection();
            pstmt = con.prepareStatement("select post_no, username, title, created_at, views from post join user using(user_no) limit ?, ?");
            pstmt.setInt(1, (pageNumber - 1) * 18);
            pstmt.setInt(2, pageNumber * 18);
            rset = pstmt.executeQuery();

            while (rset.next()){
            	HashMap<String, Object> data = new HashMap<String, Object>();
            	data.put("postNo",rset.getLong("post_no"));
            	data.put("username", rset.getString("username"));
            	data.put("title",rset.getString("title"));
            	data.put("createdAt",rset.getLong("post_no"));
            	data.put("views",rset.getLong("views"));
            	
            	postList.add(data);
            }

    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con,pstmt,rset);
		}
    	
        
      return postList;
    }
}
