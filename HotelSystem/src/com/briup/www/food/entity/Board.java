/**    
* @Title: Board.java  
* @Package com.briup.www.food.entity  
* @Description: TODO  
* @author wangfali    
* @date 2017年3月27日 下午10:01:26  
* @version V1.0    
*/
package com.briup.www.food.entity;

import java.io.Serializable;

/**  
 * @ClassName: Board  
 * @Description: 餐桌实体类 
 * @author wangfali
 * @date 2017年3月27日  
 * @version V1.0  
 */
public class Board implements Serializable{ 
	private static final long serialVersionUID = 1L;
	private String id;
	private String boardName;
	private boolean state;
	private String time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Board(String id, String boardName, boolean state, String time) {
		super();
		this.id = id;
		this.boardName = boardName;
		this.state = state;
		this.time = time;
	}
	public Board() {
		super();
	}
	
}
