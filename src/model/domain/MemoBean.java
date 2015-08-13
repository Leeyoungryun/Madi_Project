package model.domain;

import java.io.Serializable;

public class MemoBean implements Serializable{
	private int memoNum;	
	private int memberNum;	
	private String title;
	private String content;
	private String hashTag1;
	private String hashTag2;
	private String hashTag3;
	private String writeday;			
	private int musicNum;

	public MemoBean() {	}
	
	public MemoBean(int memoNum) {
		this.memoNum = memoNum;
	}
	
	public MemoBean(int memberNum, String title, String content,
			String hashTag1, String hashTag2, String hashTag3) {
		this.memberNum = memberNum;
		this.title = title;
		this.content = content;
		this.hashTag1 = hashTag1;
		this.hashTag2 = hashTag2;
		this.hashTag3 = hashTag3;
	}
		
	public MemoBean(int memoNum, int memberNum, String title, String content) {
		super();
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
			String hashTag1, String hashTag2, String hashTag3) {
		this.memoNum = memoNum;
		this.memberNum = memberNum;
		this.title = title;
		this.content = content;
		this.hashTag1 = hashTag1;
		this.hashTag2 = hashTag2;
		this.hashTag3 = hashTag3;
	}

	public MemoBean(int memoNum, int memberNum, String title, String content,
			String hashTag1, String hashTag2, String hashTag3, String writeday,
			int musicNum) {
		this.memoNum = memoNum;
		this.memberNum = memberNum;
		this.title = title;
		this.content = content;
		this.hashTag1 = hashTag1;
		this.hashTag2 = hashTag2;
		this.hashTag3 = hashTag3;
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

	public String getHashTag1() {
		return hashTag1;
	}

	public void setHashTag1(String hashTag1) {
		this.hashTag1 = hashTag1;
	}

	public String getHashTag2() {
		return hashTag2;
	}

	public void setHashTag2(String hashTag2) {
		this.hashTag2 = hashTag2;
	}

	public String getHashTag3() {
		return hashTag3;
	}

	public void setHashTag3(String hashTag3) {
		this.hashTag3 = hashTag3;
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

	@Override
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
		builder.append(", hashTag1=");
		builder.append(hashTag1);
		builder.append(", hashTag2=");
		builder.append(hashTag2);
		builder.append(", hashTag3=");
		builder.append(hashTag3);
		builder.append(", writeday=");
		builder.append(writeday);
		builder.append(", musicNum=");
		builder.append(musicNum);
		builder.append("]");
		return builder.toString();
	}
}