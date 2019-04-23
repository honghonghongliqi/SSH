package com.study.dao;

import com.study.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author wangqianlong
 * @create 2019-04-22 20:19
 */


@Repository
public class UserDao  {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void save() {
        Session session = sessionFactory.getCurrentSession();
        User user = new User();
        user.setName("cooper");
        user.setPassword("admin");

        session.save(user);
        throw new RuntimeException();
    }
}