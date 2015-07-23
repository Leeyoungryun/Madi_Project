package model.domain;

import java.io.Serializable;

public class MemoBean implements Serializable{
	private int memoNum;	
	private int memberNum;	
	private String title;
	private String content;	
	private String writeday;			
	private int musicNum;
	
	public MemoBean() {	}
	
	public MemoBean(int memoNum) {
		this.memoNum = memoNum;
	}
	
	public MemoBean(int memberNum, String title, String content) {
		this.memberNum = memberNum;
		this.title = title;
		this.content = content;
	}

	public MemoBean(int memoNum, int memberNum, String title, String content) {
		this.memoNum = memoNum;
		this.memberNum = memberNum;
		this.title = title;
		this.content = content;
	}

	public MemoBean(int memoNum, int memberNum, String title, String content,
			String writeday) {
		this.memoNum = memoNum;
		this.memberNum = memberNum;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
	}

	public MemoBean(int memoNum, int memberNum, String title, String content,
			String writeday, int musicNum) {
		this.memoNum = memoNum;
		this.memberNum = memberNum;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
		this.musicNum = musicNum;
	}
	public int getMemoNum() {
		return memoNum;
	}
	
	public void setMemoNum(int memoNum) {
		this.memoNum = memoNum;
	}
	
	public int getMemberNum() {
		return memberNum;
	}
	
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriteday() {
		return writeday;
	}
	
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	
	public int getMusicNum() {
		return musicNum;
	}
	
	public void setMusicNum(int musicNum) {
		this.musicNum = musicNum;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemoBean [memoNum=");
		builder.append(memoNum);
		builder.append(", memberNum=");
		builder.append(memberNum);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writeday=");
		builder.append(writeday);
		builder.append(", musicNum=");
		builder.append(musicNum);
		builder.append("]");
		return builder.toString();
	}
}