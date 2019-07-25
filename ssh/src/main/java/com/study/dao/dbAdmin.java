package com.study.dao;

import java.util.List;
import javax.swing.JOptionPane;
import com.study.addHibernateFile.HibernateSessionFactory;
import com.study.entity.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class dbAdmin {
   private Session session;
   private Transaction transaction;
   private Query query;
   HibernateSessionFactory getSession;
   public dbAdmin(){
   }
   
   //添加
   public String saveAdmin(Admin aPo){
	   String mess="error";

	   session=getSession.getSession();
	   try {
		    transaction=session.beginTransaction();
		    session.save(aPo);
		    transaction.commit();
		    mess="success";
		    return mess;
	} catch (Exception e) {
		    message("Register.error"+e);
		    e.printStackTrace();
		    return null;
	}
}
   
  
   //查询返回list集合（登录）
   public List queryAdmin(String type,Object value){
	  // getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {
		     String hqlsql="from Admin as u where u.userName=?";
		     query=session.createQuery(hqlsql);
		     query.setParameter(0, value);
		     List list=query.list();
		     transaction=session.beginTransaction();
		     transaction.commit();
		     return list;
	       } catch (Exception e) {
		     message("LoginAdmin类中有异常类，异常为："+e);
		     e.printStackTrace();
		     return null;
	       }
   }
	//按条件type查询
   public List findAdmin(String type,Object value){
	  // getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {		   
		transaction=session.beginTransaction();
		//HQL语句
		String queryString="from Admin as model where model."+type+"=?";
		 query=session.createQuery(queryString);
	     query.setParameter(0, value);
	     List list=query.list();
	     transaction.commit();
	     session.close();
	     return list;
	} catch (Exception e) {
		message("findAdmin.error:"+e);
	     e.printStackTrace();
	     return null;
	}
}
   
   //查找整个表的信息
   public List findAllAdmin(){
	  // getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {
		transaction=session.beginTransaction();
		String queryString="from Admin where type=?";
		query=session.createQuery(queryString);
		query.setParameter(0,"admin");
	    List list=query.list();
	    System.out.println(list);
	    transaction.commit();
	    session.close();
	    return list;
	} catch (Exception e) {
		message("findAllAdmin.error:"+e);
	    e.printStackTrace();
	    return null;
	}
}
   
   
   
   //修改管理员信息
   public boolean updateAdmin(Admin apPo){
	   //getSession=new HibernateSessionFactory();
	   session=getSession.getSession();
	   try {
		     transaction=session.beginTransaction();
		     session.update(apPo);
		     transaction.commit();
		     session.close();
		     return true;
	       } catch (Exception e) {
	    	message("updateAdmin.error:"+e);
	   	    e.printStackTrace();
	   	    return false;
	      }
   }
   
   //删除管理员
    public boolean deleteAdmin(String id) {
     //  getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();
  	   try {
		      transaction=session.beginTransaction();
		      Admin infoAdminPO=new Admin();
		      String hql="from Admin where id=?";
		      Query query = session.createQuery(hql);
		      query.setParameter(0,id);
		      infoAdminPO=(Admin)query.list().get(0);
		      session.delete(infoAdminPO);
		      transaction.commit();
		      session.close();
		      return true;
	       } catch (Exception e) {
	    	   message("deleteAdmin.error:"+e);
		   	   e.printStackTrace();
		   	   return false;
	   }
	}
	 public void message(String mess) {
		int type=JOptionPane.YES_NO_OPTION;
		String title="提示消息";
		JOptionPane.showMessageDialog(null, mess,title,type);
	}
	
}
