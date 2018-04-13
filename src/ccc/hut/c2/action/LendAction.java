package ccc.hut.c2.action;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ccc.hut.c2.dao.*;
import ccc.hut.c2.model.*;
import ccc.hut.c2.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LendAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=4;
	private Lend lend;
	private String message;
	public int getPageNow(){
		return pageNow;
	}
	public void setPageNow(int pageNow){
		this.pageNow = pageNow;
	}
	
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
	
	public Lend getLend(){
		return lend;
	}
	public void setLend(Lend lend){
		this.lend = lend;
	}
	
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	LendDao lendDao=new LendDao();
	public String selectAllLend() throws Exception{
		if(lend.getReaderId()==null||lend.getReaderId().equals("")){
			this.setMessage("请输入借书证号！");
			return SUCCESS;
		}else if(new StudentDao().selectByReaderId(lend.getReaderId())==null){
//			System.out.println(lend.getReaderId());
			this.setMessage("不存在该学生！");
			return SUCCESS;
		}
		List list=lendDao.selectLend(lend.getReaderId(),this.getPageNow(),this.getPageSize());
		Pager page=new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());
		return SUCCESS;
	}
	
	public String lendBook()throws Exception{
		BookDao bookDao=new BookDao();
		if(lend.getISBN()==null || lend.getISBN().equals("")||bookDao.selectBook(lend.getISBN())==null||(bookDao.selectBook(lend.getISBN()).getSnum())<1){
			List list=lendDao.selectLend(lend.getReaderId(),this.getPageNow(),this.getPageSize());
			Pager page=new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
			Map request=(Map) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			setMessage("ISBN不能为空或者不存在该ISBN的图书或者该ISBN的图书没有库存量！");
			return SUCCESS;
		}else if(lend.getBookId()==null||lend.getBookId().equals("")||
			lendDao.selectByBookId(lend.getBookId())!=null){
			List list=lendDao.selectLend(lend.getReaderId(),this.getPageNow(),this.getPageSize());
			Pager page=new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
			Map request=(Map) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			this.setMessage("该图书ID已经存在或图书ID为空！");
			return SUCCESS;
		}
		Lend l=new Lend();
		l.setBookId(lend.getBookId());
		l.setISBN(lend.getISBN());
		l.setReaderId(lend.getReaderId());
		l.setLTime(new Date());
		lendDao.addLend(l);
		Book book=bookDao.selectBook(lend.getISBN());
		book.setSnum(book.getSnum()-1);
		bookDao.updateBook(book);
		StudentDao studentDao=new StudentDao();
		Student stu=studentDao.selectByReaderId(lend.getReaderId());
		stu.setNum(stu.getNum()+1);
		studentDao.updateStudent(stu);
		List list=lendDao.selectLend(lend.getReaderId(),this.getPageNow(),this.getPageSize());
		Pager page=new Pager(pageNow,lendDao.selectLendSize(lend.getReaderId()));
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());
		return SUCCESS;
	}

}
