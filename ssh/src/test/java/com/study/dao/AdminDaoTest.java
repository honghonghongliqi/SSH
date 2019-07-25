package com.study.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring-dao.xml"})
public class AdminDaoTest {

  /*  @Autowired
    private AdminDao adminDao;

    @Autowired
    private BookDao bookDao;


    @Test
    public void saveAdmin() {
        System.out.println(bookDao.findInfo("name","第一个"));
    }

    @Test
    public void queryAdmin() {

        System.out.println(adminDao.queryAdmin("userName","cooper"));
    }

    @Test
    public void findAdmin() {
    }

    @Test
    public void findAllAdmin() {
    }

    @Test
    public void updateAdmin() {
    }

    @Test
    public void deleteAdmin() {
    }

    @Test
    public void message() {
    }*/
}