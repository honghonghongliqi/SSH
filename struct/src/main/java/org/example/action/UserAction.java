package org.example.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.example.bean.UserBean;
import org.example.service.UserService;


import java.util.Map;

public class UserAction extends ActionSupport implements ModelDriven<UserBean> {

	private static final long serialVersionUID = 1L;
	private UserBean userBean = new UserBean();
	private Map<String, Object> session;
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserBean getModel() {
		// TODO Auto-generated method stub
		return userBean;
	}

	public String login() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		session = (Map<String, Object>)ctx.getSession();
		UserService userServ = new UserService();
		System.out.println("UserService-->execute()����");
		try{
		if(userServ.login(userBean)){
			session.put("user", userBean.getUsername());
			return "success";
		}
		return "fail";	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
			//return "exception";
		}
	}

}
