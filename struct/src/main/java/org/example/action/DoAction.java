package org.example.action;

import com.opensymphony.xwork2.ActionSupport;

public class DoAction extends ActionSupport {

    private int count=0;

    public DoAction() {
        System.out.println("创建了一个DoAction对象");
    }

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    public String index;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("DoLogin" + " " + getUsername() + " " + getPassword() + " ");
        if (getUsername().equals(getPassword())) {
            return "success";
        }
        return "error";
    }

    //login
    public String login() {
        System.out.println("login" + " " + getUsername() + " " + getPassword() + " ");
        if (getUsername().equals(getPassword())) {
            this.addActionMessage("login");
            return "success";
        }
        this.addActionError("成功");
        return "fail";
    }

    //regist
    public String regist() {
        System.out.println("regist" + " " + getUsername() + " " + getPassword() + " ");
        if (getUsername().equals(getPassword())) {
            this.addActionMessage("regist");
            return "success";
        }
        this.addActionError("成功");
        return "fail";
    }


    @Override
    public void validate() {
        super.validate();
        if (getUsername().equals(null) || getUsername().equals("")) {
            this.addFieldError(username, this.getText("lr.fielderror.username"));
        }
        if (getPassword().equals("") || getPassword().equals(null)) {
            this.addFieldError(password, this.getText("lr.fielderror.password"));
        }
    }

}
