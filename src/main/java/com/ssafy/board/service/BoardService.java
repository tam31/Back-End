package com.ssafy.board.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.board.model.dao.BoardDAO;
import com.ssafy.board.model.dao.CommentDAO;
import com.ssafy.board.model.dao.FileDAO;
import com.ssafy.board.model.dto.BoardDTO;
import com.ssafy.board.model.dto.CommentDTO;
import com.ssafy.board.model.dto.FileDTO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO bdao;
	@Autowired
	private FileDAO fdao;
	@Autowired
	private CommentDAO cdao;

	public void write(BoardDTO board) throws Exception {
		bdao.insert(board);
	}

	public boolean update(BoardDTO board) {
		if (bdao.update(board) > 0) {
			return true;
		}
		return false;
	}

	public boolean delete(int boardIdx) {
		if (bdao.delete(boardIdx) > 0) {
			return true;
		}
		return false;
	}

	public BoardDTO read(int boardIdx) {
		BoardDTO board = bdao.selectOne(boardIdx);
		board.setBoardCnt(board.getBoardCnt()+1);
		board.setFiles(fdao.selectList(boardIdx));
		return board;
	}
	
	public FileDTO getFileInfo(int fileIdx) {
		return fdao.selectOne(fileIdx);
	}

	public Map<String, Object> makePage(int curPage) {
		Map<String, Object> map = new HashMap();

		int startPage = (curPage - 1) / 10 * 10 + 1;
		int endPage = startPage + 9;

		int totalCount = bdao.selectTotalCount();
		int totalPage = totalCount / 10;
		if (totalCount % 10 > 0) {
			totalPage++;
		}

		if (totalPage < endPage) {
			endPage = totalPage;
		}

		int startRow = (curPage - 1) * 10;
		int count = 10;
		List<BoardDTO> boardList = bdao.selectList(startRow, count); 

		map.put("curPage", curPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("boardList", boardList);

		return map;
	}

//	public List<BoardDTO> searchBoards(String keyword) {
//		return bdao.searchBoards(keyword);
//	}

	public int writeComment(String commentId, String boardId, String commentWriter, String commentContent, String commentRegDate, int boardIdx) {
		CommentDTO cmt = new CommentDTO();
		cmt.setCommentId(commentId);
		cmt.setBoardId(boardId);
		cmt.setCommentWriter(commentWriter);
		cmt.setCommentContent(commentContent);
		cmt.setCommentRegDate(commentRegDate);
		cmt.setBoardIdx(boardIdx);
		return cdao.insert(cmt);
	}
	
	public boolean updateComment(CommentDTO comment) {
		if (cdao.update(comment) > 0) {
			return true;
		}
		return false;
	}

	public boolean deleteComment(int commentIdx) {
		if (cdao.delete(commentIdx) > 0) {
			return true;
		}
		return false;
	}
	
	public CommentDTO readComment(int commentIdx) {
		CommentDTO comment = cdao.selectOne(commentIdx);
		return comment;
	}
	
	public List<CommentDTO> getComments(int boardIdx){
		return cdao.selectList(boardIdx);
	}
	
	public void inputComment(int boardIdx, CommentDTO comment) {
		BoardDTO board = bdao.selectOne(boardIdx);
		comment.setBoardId(board.getUserId());
		cdao.insert(comment);
	}
}
