package com.ssafy.board.model.dto;

public class CommentDTO {
	private int commentIdx;
	private String commentId;
	private String boardId;
	private String commentWriter;
	private String commentContent;
	private String commentRegDate;
	private int boardIdx;
	
	public CommentDTO() {
		super();
	}
	
	public CommentDTO(int commentIdx, String commentId, String boardId, String commentWriter, String commentContent,
			String commentRegDate, int boardIdx) {
		super();
		this.commentIdx = commentIdx;
		this.commentId = commentId;
		this.boardId = boardId;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
		this.commentRegDate = commentRegDate;
		this.boardIdx = boardIdx;
	}
	
	public int getCommentIdx() {
		return commentIdx;
	}
	
	public void setCommentIdx(int commentIdx) {
		this.commentIdx = commentIdx;
	}
	
	public String getCommentId() {
		return commentId;
	}
	
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	
	public String getBoardId() {
		return boardId;
	}
	
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	
	public String getCommentWriter() {
		return commentWriter;
	}
	
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	
	public String getCommentContent() {
		return commentContent;
	}
	
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String getCommentRegDate() {
		return commentRegDate;
	}
	
	public void setCommentRegDate(String commentRegDate) {
		this.commentRegDate = commentRegDate;
	}
	
	public int getBoardIdx() {
		return boardIdx;
	}
	
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [commentIdx=" + commentIdx + ", commentId=" + commentId + ", boardId=" + boardId
				+ ", commentWriter=" + commentWriter + ", commentContent=" + commentContent + ", commentRegDate="
				+ commentRegDate + ", boardIdx=" + boardIdx + "]";
	}
	
	
}
