package com.study.borrowAndReturnAction;

import com.opensymphony.xwork2.ActionSupport;
import com.study.dao.dbRecord;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class UserLookrecordAction extends ActionSupport{

	private HttpServletRequest request;
    private String message="input";

    //private String  peopleId;
    
    public String execute() throws Exception {
    	request=ServletActionContext.getRequest();
		String peopleId= (String) request.getSession().getAttribute("PeopleId");
		if (peopleId==null||peopleId.equals("")){
			return "fail";
		}
		System.out.println("peopleId"+peopleId);
    	dbRecord DB=new dbRecord();
    	List list=DB.findInfo(peopleId);
		System.out.println(list);
    	request.getSession().setAttribute("count1", list.size());
    	request.getSession().setAttribute("allinfo2",list);
    	message="success";
    	return message; 
    }
}
