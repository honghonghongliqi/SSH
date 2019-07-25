package com.study.borrowAndReturnAction;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.study.dao.dbBook;
import com.study.dao.dbRecord;
import com.study.entity.Book;
import com.study.entity.Record;
import org.apache.struts2.interceptor.ServletResponseAware;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Return extends ActionSupport implements ServletResponseAware{
	private String id;
	private String bookId;
	private String name;
	private String author;
	private	String place;
	private	String price;
	private	String pid;
	private	String num;

	private String mess="input";
    private HttpServletResponse response;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		String str = null;
		try {
			str=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		String str = null;
		try {
			str=new String(author.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPlace() {
		String str = null;
		try {
			str=new String(place.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPrice() {
		String str = null;
		try {
			str=new String(price.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	} 
    
	public void validate() {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(this.getNum()==null||this.getNum().length()==0){
			addFieldError("num", "借书数量不能为空！");			
			out.print("<script>alert('还书数量不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		if (Integer.valueOf(this.getNum())>3) {
            addFieldError("num", "借书数量不能超过3！");			
			out.print("<script>alert('还书数量不能超过3！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
     }
	
	@Override
    public String execute() throws Exception {
    	response.setContentType("text/html;charset=UTF-8");
 		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
 		PrintWriter out = null;
 		try {
 			out = response.getWriter();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

 		//更新book数据库 图书数量更新
 		dbBook dbBook=new dbBook();
    	boolean update=dbBook.updateInfo(info());

    	//更新借阅数据库 更改状态为已还
    	dbRecord record=new dbRecord();
    	boolean save=record.update(recordinfo());
    	
    	if (update&&save) {
    		mess="success";
    		out.print("<script>alert('归还成功！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		return mess;
    }


	public Record recordinfo(){
		dbRecord record=new dbRecord();
		Record updateRecord=record.findById(this.getId());
		updateRecord.setId(this.getId());
		updateRecord.setName(this.getName());
		updateRecord.setNum(this.getNum());
		updateRecord.setPeople(this.getPid());
		updateRecord.setStatus("已还");
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		updateRecord.setTime("还书时间"+sdf.format(d));
		return updateRecord;
	}
	
	public Book info(){
		dbBook dbBook=new dbBook();
		Book info= (Book) dbBook.findInfo("id",this.getBookId()).get(0);
    	info.setId(this.getBookId());
    	int b=Integer.valueOf(this.getNum())+Integer.valueOf(this.getNum());
        String booknum=String.valueOf(b);
    	info.setNumber(booknum);
    	return info;
    }
	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
          this.response = response;
    }
	
}
