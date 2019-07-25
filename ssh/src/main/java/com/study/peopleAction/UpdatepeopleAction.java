package com.study.peopleAction;

import com.study.dao.dbPeople;
import com.study.entity.People;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


public class UpdatepeopleAction extends ActionSupport implements ServletResponseAware {
    private String id;
    private String name;
    private String sex;
    private String phone;
    private String address;
    private String password;
    private String mess = "input";
    private HttpServletResponse response;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        String str = null;
        try {
            str = new String(name.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        String str = null;
        try {
            str = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        String str = null;
        try {
            str = new String(address.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    @Override
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

        if (this.getName() == null || this.getName().length() == 0) {
            addFieldError("id", "账号不能为空！");
            out.print("<script>alert('账号不能为空！')</script>");
            out.print("<script>window.location.href='http://127.0.0.1:8081LookPeopleAction1'</script>");
            out.flush();
            out.close();
        }
        if (this.getSex() == null || this.getSex().length() == 0) {
            addFieldError("sex", "性别不能为空！");
            out.print("<script>alert('性别不能为空！')</script>");
            out.print("<script>window.location.href='http://127.0.0.1:8081LookPeopleAction1'</script>");
            out.flush();
            out.close();
        }
        if (this.getPhone() == null || this.getPhone().length() == 0) {
            addFieldError("phone", "电话不能为空！");
            out.print("<script>alert('电话不能为空！')</script>");
            out.print("<script>window.location.href='http://127.0.0.1:8081LookPeopleAction1'</script>");
            out.flush();
            out.close();
        }
        if (this.getAddress() == null || this.getAddress().length() == 0) {
            addFieldError("address", "地址不能为空！");
            out.print("<script>alert('地址不能为空！')</script>");
            out.print("<script>window.location.href='http://127.0.0.1:8081LookPeopleAction1'</script>");
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

        dbPeople lr = new dbPeople();
        boolean update = lr.updateInfo(info());
        if (update) {
            mess = "success";
	    		/*out.print("<script>alert('修改成功！')</script>");
				out.print("<script>window.location.href='http://127.0.0.1:8081LookPeopleAction1'</script>");
				out.flush();
				out.close();*/
        }
        return mess;
    }

    public People info() {
        People info = new People();
        info.setId(this.getId());
        info.setName(this.getName());
        info.setSex(this.getSex());
        info.setPhone(this.getPhone());
        info.setAddress(this.getAddress());
        info.setPassword(this.password);
        System.out.println();
        return info;

    }

    // 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}
