package com.ssafy.board.model.dto;

import java.util.List;

public class BoardDTO {
	private int boardIdx;
	private String boardTitle;
	private String boardContent;
	private String boardRegDate;
	private String boardUpdDate;
	private String boardDelDate;
	private String userId;
	private int boardCnt;
	private int boardLike;
	private int boardCommentCnt;
	private List<FileDTO> files;
	
	public BoardDTO() {}

	public BoardDTO(int boardIdx, String boardTitle, String boardContent, String boardRegDate, String boardUpdDate,
			String boardDelDate, String userId, int boardCnt, int boardLike, int boardCommentCnt, List<FileDTO> files) {
		super();
		this.boardIdx = boardIdx;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardRegDate = boardRegDate;
		this.boardUpdDate = boardUpdDate;
		this.boardDelDate = boardDelDate;
		this.userId = userId;
		this.boardCnt = boardCnt;
		this.boardLike = boardLike;
		this.boardCommentCnt = boardCommentCnt;
		this.files = files;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardRegDate() {
		return boardRegDate;
	}

	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}

	public String getBoardUpdDate() {
		return boardUpdDate;
	}

	public void setBoardUpdDate(String boardUpdDate) {
		this.boardUpdDate = boardUpdDate;
	}

	public String getBoardDelDate() {
		return boardDelDate;
	}

	public void setBoardDelDate(String boardDelDate) {
		this.boardDelDate = boardDelDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardCnt() {
		return boardCnt;
	}

	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	public int getBoardCommentCnt() {
		return boardCommentCnt;
	}

	public void setBoardCommentCnt(int boardCommentCnt) {
		this.boardCommentCnt = boardCommentCnt;
	}

	public List<FileDTO> getFiles() {
		return files;
	}

	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardIdx=" + boardIdx + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardRegDate=" + boardRegDate + ", boardUpdDate=" + boardUpdDate + ", boardDelDate=" + boardDelDate
				+ ", userId=" + userId + ", boardCnt=" + boardCnt + ", boardLike=" + boardLike + ", boardCommentCnt="
				+ boardCommentCnt + ", files=" + files + "]";
	}
}
