package com.douzone.travel.post.model.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.douzone.travel.post.domain.PostDTO;
import com.douzone.travel.post.domain.PostViewDTO;
import org.modelmapper.ModelMapper;
import com.douzone.travel.utils.DBUtils;

public class PostDAOImpl implements PostDAO {

    private static PostDAO instance = new PostDAOImpl();
    ModelMapper modelMapper = new ModelMapper();

    private PostDAOImpl() {
    }

    public static PostDAO getInstance(){
        return instance;
    }
    
    @Override
    public ArrayList<HashMap<String, Object>> selectPostList(int pageNumber, String board, String searchOption, String searchContent) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        ArrayList<HashMap<String, Object>> postList= new ArrayList<HashMap<String, Object>>();
    	try {
            con = DBUtils.getConnection();

            String sql = "select *from (select *from (select *from (select post_no, board_no, username, user.is_blinded, title, created_at, views, content from post join user using(user_no)) sub join board using(board_no)) sub2 left outer join (select post_no, count(*) comment_count from comment group by post_no) sub3 using(post_no)) sub4 left outer join (select post_no, count(*) post_report_count from report where post_no is not null group by post_no) sub5 using (post_no)";
            if(board.equals("all")) {
            	if(searchOption != null && !searchOption.equals("")) {
            		switch (searchOption) {
					case "title":
						sql += " where title like ?";
						break;
					case "content":
						sql += " where content like ?";
						break;
					case "writer":
						sql += " where username like ?";
						break;
					default:
						break;
					}
            	}
            	sql += "order by post_no desc limit ?, ?";	// ??? ?????? ????????? ?????? default??? 0~1000 ex) 0~50
            }else {
            	sql += " where board_name = ?"; // input(text) ?????? ??????
            	
            	if(searchOption != null && !searchOption.equals("")) {
            		switch (searchOption) {	// searchOption??? ?????? ???????????? case ?????? - title/content/writer ??? ?????????
					case "title":
						sql += " and title like ?";
						break;
					case "content":
						sql += " and content like ?";
						break;
					case "writer":
						sql += " and username like ?";
						break;
					default:
						break;
					}
            	}
            	
            	sql += "order by post_no desc limit ?, ?";
            }
            
            	System.out.println(sql);
            
            pstmt = con.prepareStatement(sql);
            
            if(board.equals("all")) {			// pagenation
            	if(searchOption != null && !searchOption.equals("")) {
            		pstmt.setString(1,  "%" + searchContent + "%");
                    pstmt.setInt(2, (pageNumber - 1) * 10);
                    pstmt.setInt(3, 10);
            	}else {
            		pstmt.setInt(1, (pageNumber - 1) * 10);
                    pstmt.setInt(2, 10);
            	}
            	 
            }else {
            	if(searchOption != null && !searchOption.equals("")) {
            		pstmt.setString(1, board);
            		pstmt.setString(2, "%" + searchContent + "%");
                	pstmt.setInt(3, (pageNumber - 1) * 10);
                    pstmt.setInt(4, 10);
            	}else {
            		pstmt.setString(1, board);
                	pstmt.setInt(2, (pageNumber - 1) * 10);
                    pstmt.setInt(3, 10);
            	}
            	
            }
           
            rset = pstmt.executeQuery();

            while (rset.next()){
            	HashMap<String, Object> data = new HashMap<String, Object>();
            	data.put("postNo",rset.getLong("post_no"));
            	data.put("username", rset.getString("username"));
            	data.put("title",rset.getString("title"));
            	data.put("createdAt",rset.getDate("created_at"));
            	data.put("views",rset.getLong("views"));
            	data.put("commentCount", rset.getInt("comment_count"));
            	data.put("isBlinded", rset.getInt("is_blinded"));
            	data.put("postReportCount", rset.getInt("post_report_count"));
            	
            	postList.add(data);
            }

    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con,pstmt,rset);
		}

      return postList;
    }

    @Override
    public int selectPostCount(String board) {
    	String sql = "select count(*) p_count from post";
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int count = 0;
        
    	try {
            con = DBUtils.getConnection();
            
            if(!board.equals("all")) {
            	sql += " where board_no = (select board_no from board where board_name = ?)";
            	System.out.println("sql : " + board);
            }
            pstmt = con.prepareStatement(sql);
            
            if(!board.equals("all")) {
            	pstmt.setString(1, board);
            }
            
            
            rset = pstmt.executeQuery();

            if (rset.next()){
            	count = rset.getInt("p_count");
            }

    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con,pstmt,rset);
		}
    	
        
      return count;
    }
    
    @Override
    public int selectPostCount(int pageNumber, String board, String searchOption, String searchContent) {
    	Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        int postCount = 0;
        
    	try {
            con = DBUtils.getConnection();
            String sql = "select count(*) postCount from (select *from (select *from (select post_no, board_no, username, user.is_blinded, title, created_at, views, content from post join user using(user_no)) sub join board using(board_no)) sub2 left outer join (select post_no, count(*) comment_count from comment group by post_no) sub3 using(post_no)) sub4 left outer join (select post_no, count(*) post_report_count from report where post_no is not null group by post_no) sub5 using (post_no)";
            if(board.equals("all")) {
            	if(searchOption != null && !searchOption.equals("")) {
            		switch (searchOption) {
					case "title":
						sql += " where title like ?";
						break;
					case "content":
						sql += " where content like ?";
						break;
					case "writer":
						sql += " where username like ?";
						break;
					default:
						break;
					}
            	}
            	sql += " limit ?, ?";
            }else {
            	sql += " where board_name = ?";
            	
            	if(searchOption != null && !searchOption.equals("")) {
            		switch (searchOption) {
					case "title":
						sql += " and title like ?";
						break;
					case "content":
						sql += " and content like ?";
						break;
					case "writer":
						sql += " and username like ?";
						break;
					default:
						break;
					}
            	}
            	
            	sql += " limit ?, ?";
            }
            
            	System.out.println(sql);
            
            pstmt = con.prepareStatement(sql);
            
            if(board.equals("all")) {
            	if(searchOption != null && !searchOption.equals("")) {
            		pstmt.setString(1,  "%" + searchContent + "%");
                    pstmt.setInt(2, (pageNumber - 1) * 10);
                    pstmt.setInt(3, 10);
            	}else {
            		pstmt.setInt(1, (pageNumber - 1) * 10);
                    pstmt.setInt(2, 10);
            	}
            	 
            }else {
            	if(searchOption != null && !searchOption.equals("")) {
            		pstmt.setString(1, board);
            		pstmt.setString(2, "%" + searchContent + "%");
                	pstmt.setInt(3, (pageNumber - 1) * 10);
                    pstmt.setInt(4, 10);
            	}else {
            		pstmt.setString(1, board);
                	pstmt.setInt(2, (pageNumber - 1) * 10);
                    pstmt.setInt(3, 10);
            	}
            	
            }
           
            rset = pstmt.executeQuery();

            if (rset.next()){
            	postCount = rset.getInt("postCount");
            }

    	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con,pstmt,rset);
		}

      return postCount;
    }
    
    @Override
    public PostViewDTO findByPostNo(Long postNo, boolean status) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        PostViewDTO postView = null;

        try{
            con = DBUtils.getConnection();
            pstmt = con.prepareStatement("select p.post_no, u.username, p.board_no, p.title, p.content, p.created_at, p.updated_at, p.deleted_at, p.views " +
                                               "from post p inner join user u " +
                                                                   "on p.user_no = u.user_no " +
                                              "where p.post_no = ?");
            pstmt.setLong(1, postNo);

            rset = pstmt.executeQuery();

            if(rset.next()) {
                postView = PostViewDTO.builder()
                        .postNo(rset.getLong("post_no"))
                        .username(rset.getString("username"))
                        .title(rset.getString("title"))
                        .content(rset.getString("content"))
                        .createdAt(rset.getDate("created_at"))
                        .views(rset.getLong("views")).build();

                Date modifiedAt = rset.getDate("updated_at");
                Date deletedAt = rset.getDate("deleted_at");

                if(modifiedAt != null){
                    postView.setModifiedAt(modifiedAt);
                }
                if(deletedAt != null){
                    postView.setDeletedAt(deletedAt);
                }
            }
            if(status) {
                pstmt = con.prepareStatement("update post set views = views+1 where post_no = ?");
                pstmt.setLong(1, postNo);
                pstmt.executeUpdate();
            }

        }finally{

            DBUtils.close(con,pstmt,rset);
        }
        return postView;
    }

    @Override
    public int insertPost(PostDTO postDTO, String username) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result;

        con = DBUtils.getConnection();
        pstmt = con.prepareStatement("insert into post (user_no, board_no, title, content, created_at) values((select user_no from user where username=?),?,?,?,now())");
        pstmt.setString(1, username);
        pstmt.setLong(2,postDTO.getBoardNo());
        pstmt.setString(3,postDTO.getTitle());
        pstmt.setString(4,postDTO.getContent());

        result = pstmt.executeUpdate();

        DBUtils.close(con,pstmt);

        return result;
    }
    @Override
    public Long findPostByTitleAndContent(String title, String content) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        pstmt = con.prepareStatement("select post_no from post where title=? and content=?");
        pstmt.setString(1, title);
        pstmt.setString(2, content);

        rset = pstmt.executeQuery();
        if(rset.next()) {
            return rset.getLong("post_no");
        }
        return 0L;
    }

    @Override
    public int updatePost(PostDTO postDTO) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("update post set title=?, content=?, updated_at=now() where post_no=?");
        pstmt.setString(1, postDTO.getTitle());
        pstmt.setString(2, postDTO.getContent());
        pstmt.setLong(3, postDTO.getPostNo());

        int result = pstmt.executeUpdate();

        DBUtils.close(con,pstmt);
        return result;
    }

    @Override
    public int deletePost(Long postNo) throws SQLException {
        Connection con = DBUtils.getConnection();
        PreparedStatement pstmt = con.prepareStatement("delete from post where post_no = ?");
        pstmt.setLong(1, postNo);
        int result = pstmt.executeUpdate();

        DBUtils.close(con, pstmt);

        return result;
    }
}
