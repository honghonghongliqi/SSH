package com.study.adminAction;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.study.dao.dbAdmin;
import org.apache.struts2.ServletActionContext;



import com.opensymphony.xwork2.ActionSupport;

public class LookMessageAction extends ActionSupport{
     private HttpServletRequest request;
     private String message="input";
     @Override
    public String execute() throws Exception {
    	request=ServletActionContext.getRequest();
    	dbAdmin DB=new dbAdmin();
    	List list=DB.findAllAdmin();
    	request.getSession().setAttribute("count", list.size());
    	request.getSession().setAttribute("allinfo",list);
    	message="success";
    	return message; 
    }
}
