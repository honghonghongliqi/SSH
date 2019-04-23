package com.study.dao;

import org.hibernate.SessionFactory;


/**
 * @author wangqianlong
 * @create 2019-04-23 11:44
 */

public class BaseDao  {

    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
