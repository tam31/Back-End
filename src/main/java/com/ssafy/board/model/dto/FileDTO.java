package com.ssafy.board.model.dto;

public class FileDTO {
	private int fileIdx;
	private int boardIdx;
	private String filePath;
	private String fileRegDate;
	private String fileOriginalName;
	
	public FileDTO() {
		super();
	}

	public FileDTO(int fileIdx, int boardIdx, String filePath, String fileRegDate, String fileOriginalName) {
		super();
		this.fileIdx = fileIdx;
		this.boardIdx = boardIdx;
		this.filePath = filePath;
		this.fileRegDate = fileRegDate;
		this.fileOriginalName = fileOriginalName;
	}

	public int getFileIdx() {
		return fileIdx;
	}

	public void setFileIdx(int fileIdx) {
		this.fileIdx = fileIdx;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileRegDate() {
		return fileRegDate;
	}

	public void setFileRegDate(String fileRegDate) {
		this.fileRegDate = fileRegDate;
	}

	public String getFileOriginalName() {
		return fileOriginalName;
	}

	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}

	@Override
	public String toString() {
		return "FileDTO [fileIdx=" + fileIdx + ", boardIdx=" + boardIdx + ", filePath=" + filePath + ", fileRegDate="
				+ fileRegDate + ", fileOriginalName=" + fileOriginalName + "]";
	}
}
