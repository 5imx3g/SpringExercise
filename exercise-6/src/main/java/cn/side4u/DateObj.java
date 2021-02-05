package cn.side4u;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DateObj {
	
	private Date date = new Date();
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date jsonDate = new Date();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getJsonDate() {
		return jsonDate;
	}

	public void setJsonDate(Date jsonDate) {
		this.jsonDate = jsonDate;
	}
	
	

}
