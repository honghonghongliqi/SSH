package com.study.borrowAndReturnAction;

import com.study.addHibernateFile.KeyUtil;
import com.study.dao.dbBook;
import com.study.dao.dbRecord;
import com.study.entity.Book;
import com.study.entity.Record;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrow extends ActionSupport implements ServletResponseAware{
	private String bookId;
	private String picture;
	private String name;
	private String author;
	private	String number;
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

	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
			out.print("<script>alert('借书数量不能为空！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		if (Integer.valueOf(this.getNum())>3) {
            addFieldError("num", "借书数量不能超过3！");			
			out.print("<script>alert('借书数量不能超过3！')</script>");
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
 		
 		dbBook dbBook=new dbBook();
    	boolean update=dbBook.updateInfo(info());
    	
    	dbRecord dbRecord=new dbRecord();
    	boolean save=dbRecord.saveInfo1(recordinfo());
    	
    	if (update&&save) {
    		mess="success";
    		out.print("<script>alert('借出成功！')</script>");
			out.print("<script>window.location.href='LookBookAction'</script>");
			out.flush();
			out.close();
		}
		return mess;
    }
	
	public Record recordinfo(){
		Record recordinfo=new Record();
		recordinfo.setId(KeyUtil.genUniqueKey());
		recordinfo.setBookId(this.getBookId());
		recordinfo.setName(this.getName());
		recordinfo.setNum(this.getNum());
		recordinfo.setPeople(this.getPid());
		recordinfo.setStatus("未还");
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		recordinfo.setTime("借书时间"+sdf.format(d));
		return recordinfo;
	}
	
	public Book info(){
		Book info=new Book();
    	info.setId(this.getBookId());
    	info.setPicture(this.getPicture());
    	info.setName(this.getName());
    	info.setAuthor(this.getAuthor());
    	int b=Integer.valueOf(this.getNumber())-Integer.valueOf(this.getNum());
        String booknum=String.valueOf(b);
    	info.setNumber(booknum);
    	info.setPlace(this.getPlace());
    	info.setPrice(this.getPrice());
		System.out.println("借书信息位："+info);
    	return info;
    }
	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
          this.response = response;
    }
}
