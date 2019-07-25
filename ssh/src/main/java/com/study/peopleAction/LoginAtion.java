package com.study.peopleAction;

import com.opensymphony.xwork2.ActionSupport;
import com.study.dao.dbPeople;
import com.study.entity.People;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class LoginAtion extends ActionSupport{

	String name;
	String password;
	private HttpServletRequest request;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
    	request=ServletActionContext.getRequest();
    	dbPeople DB=new dbPeople();
    	List<People> peopleList = DB.findInfo("name",name);
    	if (CollectionUtils.isEmpty(peopleList)){
    		return "register";
		}
		if (peopleList.get(0).getPassword().equals(password)){
			request.getSession().setAttribute("PeopleId",peopleList.get(0).getId());
    		return "success";
		}
		return "fail";
    }
}
