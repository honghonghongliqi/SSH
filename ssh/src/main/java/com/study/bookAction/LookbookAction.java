package com.study.bookAction;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.study.dao.dbBook;
import org.apache.struts2.ServletActionContext;



public class LookbookAction extends ActionSupport{
	
	private HttpServletRequest request;
    private String message="input";
    
    public String execute() throws Exception {
    	request=ServletActionContext.getRequest();
    	dbBook DB=new dbBook();
    	List list=DB.findAllInfo();
    	request.getSession().setAttribute("count", list.size());
    	request.getSession().setAttribute("allinfo",list);
    	message="success";
    	return message; 
    }
}
