package com.study.addHibernateFile;

import com.study.entity.Admin;
import org.hibernate.Session;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-07-11 11:49
 */

public class Test {
    public static void main(String[] args) {

        Session session = HibernateSessionFactory.getSession();
      /*  Admin admin = session.get(Admin.class, "1");
        System.out.println(admin);
        admin.setUserName("wang");
        admin.setPassword("1234");
        session.beginTransaction().begin();
        session.update(admin);
        session.beginTransaction().commit();*/

     /*   Admin admin = new Admin();
        admin.setUserName("s");
        admin.setPassword("da");
        admin.setType("admin");
        admin.setId("3");
        session.beginTransaction().begin();
        session.save(admin);
        session.beginTransaction().commit();
        */

     /*   Admin admin = session.get(Admin.class, "3");
        System.out.println(admin);
        session.beginTransaction().begin();
        session.delete(admin);
        session.beginTransaction().commit();*/

    }


}
