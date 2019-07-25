package com.study.peopleAction;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.dao.dbPeople;
import com.study.entity.People;
import org.apache.struts2.ServletActionContext;



import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletResponseAware;

public class LookUserAction extends ActionSupport implements ServletResponseAware {
    private HttpServletRequest request;


    private HttpServletResponse response;

    public String execute() throws Exception {
        request=ServletActionContext.getRequest();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        String peopleId= (String) request.getSession().getAttribute("PeopleId");
        if (peopleId==null||peopleId.equals("")){
          return "fail";
        }
        dbPeople DB=new dbPeople();
        List<People> peopleList = DB.findInfo("id",peopleId);
        //People people = peopleList.get(0);
        request.getSession().setAttribute("allinfo",peopleList);
        return "success";
    }


    // 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
