package com.study.adminAction;



import javax.servlet.http.HttpServletResponse;

import com.study.dao.dbAdmin;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;





import com.opensymphony.xwork2.ActionSupport;
public class DeleteMessageAction extends ActionSupport implements ServletResponseAware{
	 String id;
	 private String mess="input";
	 private HttpServletResponse response;
	
	 
	
	 
	

 
       public String execute() throws Exception {   
    	   id= ServletActionContext.getRequest().getParameter("id");
	    dbAdmin db=new dbAdmin();
	    boolean del=db.deleteAdmin(id);
	    if(del){
	    	mess=SUCCESS;
	    }
	    return mess;
      }


	// 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
          this.response = response;
    }
}
