package com.study.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    //指定Hibernate配置文件路径
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    //创建ThreadLocal对象
    private static final ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<Session>();
    //创建Configuration对象
    private static Configuration configuration = new Configuration();
    //定义SessionFactory对象
    private static SessionFactory sessionFactory;
    //定义configFile属性并复制
    private static String configFile = CONFIG_FILE_LOCATION;

    //静态代码块来启动Hibernate，该类被加载时执行一次，用于创建SessionFactory。所以SessionFactory是线程安全的，只能被实例化一次.
    static {
        try {
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE).build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //创建无参的HibernateSessionFactory构造方法
    private HibernateSessionFactory() {
    }

    //获得SessionFactory对象(sessionFactory的get方法)
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //重建SessionFactory
    public static void rebuildSessionFactory() {
        synchronized (sessionFactory) {
            try {
               /* StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure(configFile).build();
                Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE).build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();*/
                Configuration configure = new Configuration().configure(configFile);
                sessionFactory = configure.buildSessionFactory();
            } catch (HibernateException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }
    }

    //获得Session对象
    public static Session getSession() {
        //获得ThreadLocal对象管理的session对象
        Session session = sessionThreadLocal.get();
        try {
            //判断Session对象是否已经存在或是打开
            if (session == null || !session.isOpen()) {
                //如果Session对象为空或未打开，再判断sessionFactory对象是否为空
                if (sessionFactory == null) {
                    //如果sessionFactory为空，创建SessionFactory
                    rebuildSessionFactory();
                }
                //如果sessionFactory不为空，则打开Session
                session = (sessionFactory != null) ? sessionFactory.openSession() : null;
                sessionThreadLocal.set(session);
            }
        } catch (HibernateException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return session;
    }

    //关闭Session对象
    public static void closeSession() {
        Session session = sessionThreadLocal.get();
        sessionThreadLocal.set(null);
        try {
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (HibernateException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    //configFile 属性的set方法
    public static void setConfigFile(String configFile) {
        HibernateSessionFactory.configFile = configFile;
        sessionFactory = null;
    }

    //configuration 属性的get方法
    public static Configuration getConfiguration() {
        return configuration;
    }
}
