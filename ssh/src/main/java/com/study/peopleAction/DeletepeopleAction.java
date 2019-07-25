package com.study.peopleAction;

import com.study.dao.dbPeople;
import org.apache.struts2.ServletActionContext;



public class DeletepeopleAction {
	private String mess="input";
	public String execute() throws Exception {   
 	  String id= ServletActionContext.getRequest().getParameter("id");
	    dbPeople db=new dbPeople();
	    boolean del=db.deleteInfo(id);
	    if(del){
	    	mess="success";
	    }
		return mess;
	  
   }
}
