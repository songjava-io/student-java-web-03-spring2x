package com.example.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.BaseCommandController;

import com.example.domain.Board;
import com.example.service.BoardService;

public class BoardListController extends BaseCommandController {
	
	final Logger logger = LogManager.getLogger(getClass());

	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) 
			throws Exception {
		ModelAndView view = new ModelAndView("/board/list");
		try {
			logger.info("BoardListController 실행...");
			// 검색조건 파라메터
			String query = req.getParameter("query");
			
			Map<String, Object> paramMap = new HashMap<>();
			
			paramMap.put("query", query);
			
			// 서비스를 호출해서 게시물 목록을 리턴 받
			List<Board> boardList = boardService.selectBoardList(paramMap);
			
			// reuqest에 boardList 키에 boardList 변수의 값을 저장 (set)
			view.addObject("boardList", boardList);
		} catch (SQLException e) {
			logger.error("boardListError", e);
		}
		return view;
	}

}
