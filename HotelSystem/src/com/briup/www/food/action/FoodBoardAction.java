package com.briup.www.food.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.briup.www.food.entity.Board;
import com.briup.www.food.entity.PageBean;
import com.briup.www.food.service.IBoardService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**  
 * @ClassName: FoodBoardAction  
 * @Description: 餐桌表示层实现  
 * @author wangfali
 * @date 2017年3月28日  
 * @version V1.0  
 */
public class FoodBoardAction extends ActionSupport implements ModelDriven<Board>{
	private static final long serialVersionUID = 1L;
	private Board board=new Board();
	private List<Board> boardList;
	private int findResult;
	private long pageCount;
	private long allPageCount;
	@Resource
	private IBoardService iBoardService;
	public String listUI() throws Exception{
		boardList=iBoardService.FindAll();
		pageCount=1;
		return "listUI";
	}
	public String addUI()throws Exception{
		return "addUI";
	}
	public String add() throws Exception{
		board.setTime(null);
		board.setState(false);
		iBoardService.save(board);
		return "list";
	}
	public String delete()throws Exception{
		iBoardService.delete(board.getId());
		return "list";
	}
	public void verifyBoardName() throws Exception{
	List<Board> list = iBoardService.FindAll(board.getBoardName());
		String result="false";
		if(list!=null && list.size()>0){
			result="true";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.write(result);
		writer.close();
	}
	//预定
	public String select()throws Exception{
		//获取当前时间
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh");
		String string = dateFormat.format(new Date());
		//保存预定时间
		board.setTime(string);
		//设置状态为预定
		board.setState(true);
		String name = board.getBoardName();
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		board.setBoardName(name);
		//更新
		iBoardService.update(board);
		return "list";
	}
	public String edit() throws Exception{
		//设置当前时间为空
		board.setTime(null);
		//设置状态为无人
		board.setState(false);
		String name = board.getBoardName();
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		board.setBoardName(name);
		//更新
		iBoardService.update(board);
		return "list";
	}
	//搜索
	public String findByName()throws Exception{
		boardList = iBoardService.FindAll(board.getBoardName());
		if(boardList!=null && boardList.size()>0){
			findResult=0;
		}else{
			findResult=1;
		}
		return "listUI";
	}
	//分页查询
	public String page() throws Exception{
		//获取当前页的信息进行封装
		PageBean<Board> pageBean = new PageBean<Board>();
		pageBean.setCurrentPage(pageCount);
		iBoardService.getAll(pageBean);
		boardList=pageBean.getPageList();
		allPageCount = pageBean.getAllPageCount();
		System.out.println(allPageCount);
		return "listUI";
	}
	
	
	
	
	
	
	@Override
	public Board getModel() {
		return board;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public List<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}
	public int getFindResult() {
		return findResult;
	}
	public void setFindResult(int findResult) {
		this.findResult = findResult;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public long getAllPageCount() {
		return allPageCount;
	}
	public void setAllPageCount(long allPageCount) {
		this.allPageCount = allPageCount;
	}

	

}
