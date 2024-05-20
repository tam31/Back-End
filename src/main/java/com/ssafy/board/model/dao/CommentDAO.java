package com.ssafy.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.board.model.dto.BoardDTO;
import com.ssafy.board.model.dto.CommentDTO;

public interface CommentDAO {
	public int insert(CommentDTO cmt);
	
	public int update(CommentDTO comment);
	
	public int delete(@Param("commentIdx") int commentIdx);
	
	public CommentDTO selectOne(int commentIdx);
	
	public List<CommentDTO> selectList(int boardIdx);
}
