package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.board.model.dto.BoardDTO;


public interface BoardDAO {

	public int insert(BoardDTO board) throws SQLException;
	
	public int update(BoardDTO board);
	
	public int delete(int boardIdx);
	
	public int selectTotalCount();
	
	public List<BoardDTO> selectList(@Param("sr") int startRow, @Param("cc") int count);
	
	public BoardDTO selectOne(int boardIdx);
}
