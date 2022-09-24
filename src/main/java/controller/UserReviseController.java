package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardDTO;
import service.board.BoardService;
import service.board.BoardServiceImpl;

//public class UserReviseController implements Command {

//    private final UserReviseService userReviseService = BoardServiceImpl.getInstance();

//    @Override
//    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        boolean result;
//        
//    	try {
////            result = userReviseService.modifyUser();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        if(result != true){
//            return "error.jsp";
//        }else{
////            req.setAttribute("boardList", boardDTOList);
//            return "board.jsp";
//        }
//    }
//
//}
