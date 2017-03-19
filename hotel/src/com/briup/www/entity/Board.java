package com.briup.www.entity;

import java.util.Date;

/**
 * 餐桌实体类
 * @author wangfali
 *@version 1.0
 *@date 2016年12月17日
 */
public class Board {
	private long id;
	private String boardName;
	private int state;
	private Date time;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Board(long id, String boardName, int state, Date time) {
		super();
		this.id = id;
		this.boardName = boardName;
		this.state = state;
		this.time = time;
	}
	public Board() {
		super();
	}
	@Override
	public String toString() {
		return "Board [id=" + id + ", boardName=" + boardName + ", state="
				+ state + ", time=" + time + "]";
	}
	
}
