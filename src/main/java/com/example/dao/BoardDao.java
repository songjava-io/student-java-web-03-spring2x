package com.example.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.example.domain.Board;

/**
 * 게시판 Dao
 * @author youtube
 *
 */
public class BoardDao extends SqlMapClientDaoSupport {

	/**
	 * 게시물 목록 조회 리턴
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<Board> selectBoardList(Map<String, Object> paramMap) 
			throws SQLException {
		return getSqlMapClientTemplate().
			queryForList("selectBoardList", paramMap);
	}

	/**
	 * 게시물 조회
	 * @param boardSeq
	 * @return
	 * @throws SQLException
	 */
	public Board selectBoard(String boardSeq) throws SQLException  {
		return (Board) getSqlMapClientTemplate()
			.queryForObject("selectBoard", boardSeq);
	}
	
	/**
	 * 게시물 등록
	 * @param board
	 * @throws SQLException
	 */
	public void insertBoard(Board board) throws SQLException  {
		getSqlMapClientTemplate()
			.insert("insertBoard", board);
	}
	
	/**
	 * 게시물 업데이트
	 * @param board
	 * @throws SQLException
	 */
	public void updateBoard(Board board) throws SQLException  {
		getSqlMapClientTemplate()
			.update("updateBoard", board);
	}
	
	/**
	 * 게시물 삭제
	 * @param board
	 * @throws SQLException
	 */
	public void deleteBoard(int boardSeq) throws SQLException  {
		getSqlMapClientTemplate()
			.update("deleteBoard", boardSeq);
	}
	
}
