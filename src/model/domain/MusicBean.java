package model.domain;

public class MusicBean {
	private int musicNum;
	private String title;
	private String singer;
	private String emotion;
	private String url;
	
	public MusicBean() { }
	
	public MusicBean(int musicNum) {
		this.musicNum = musicNum;
	}

	public MusicBean(int musicNum, String title, String singer, String emotion,
			String url) {
		this.musicNum = musicNum;
		this.title = title;
		this.singer = singer;
		this.emotion = emotion;
		this.url = url;
	}
	
	public int getMusicNum() {
		return musicNum;
	}
	
	public void setMusicNum(int musicNum) {
		this.musicNum = musicNum;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSinger() {
		return singer;
	}
	
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public String getEmotion() {
		return emotion;
	}
	
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MusicBean [musicNum=");
		builder.append(musicNum);
		builder.append(", title=");
		builder.append(title);
		builder.append(", singer=");
		builder.append(singer);
		builder.append(", emotion=");
		builder.append(emotion);
		builder.append(", url=");
		builder.append(url);
		builder.append("]");
		return builder.toString();
	}
}
