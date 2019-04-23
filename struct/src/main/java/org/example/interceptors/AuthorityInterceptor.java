package org.example.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class AuthorityInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Authority Interceptor executed!");
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		String user = (String)session.get("user");
		if(user!=null){
			return invocation.invoke();
		}
		ctx.put("tip", "����û�е�¼���������û����������¼ϵͳ��");
		return "login";
	}
	
}
