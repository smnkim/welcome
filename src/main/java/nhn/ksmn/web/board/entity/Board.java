package nhn.ksmn.web.board.entity;

import java.sql.Date;

public class Board {
	private int no;
	private String email;
	private String pwd;
	private String title;
	private String content;
	private Date origial_time;
	private Date latest_time;
	
	
	public Board() {
	}



	public Board(String email, String pwd, String title, String content) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
	}



	public Board(String pwd) {
		super();
		this.pwd = pwd;
	}


	
	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
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



	public Date getOrigial_time() {
		return origial_time;
	}



	public void setOrigial_time(Date origial_time) {
		this.origial_time = origial_time;
	}



	public Date getLatest_time() {
		return latest_time;
	}



	public void setLatest_time(Date latest_time) {
		this.latest_time = latest_time;
	}



	@Override
	public String toString() {
		return "Board [no=" + no + ", email=" + email + ", pwd=" + pwd + ", title=" + title + ", content=" + content
				+ ", origial_time=" + origial_time + ", latest_time=" + latest_time + "]";
	}


	
}
