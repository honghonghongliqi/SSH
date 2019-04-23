package org.example.service;


import org.example.bean.UserBean;
import org.example.exception.UserException;

//
public class UserService {
    public boolean login(UserBean userBean) throws Exception {
        if (userBean.getUsername().equalsIgnoreCase("admin")) {
            throw new UserException("�û�������Ϊadmin!");
        }
        if (userBean.getPassword().toUpperCase().contains("AND") || userBean.getPassword().toUpperCase().contains("OR")) {
            throw new java.sql.SQLException("���벻�ܰ�����and����or��!");
        }
        if (userBean.getUsername().equals(userBean.getPassword())) {
            return true;
        }
        return false;


    }


}
