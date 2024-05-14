package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.FileDTO;

public interface FileDAO {
	public int insert(FileDTO f);
	
	public List<FileDTO> selectList(int boardIdx);
	
	public FileDTO selectOne(int fileIdx);
}
