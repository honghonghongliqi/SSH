package com.study.dao;

import java.util.List;




import javax.swing.JOptionPane;

import com.study.addHibernateFile.HibernateSessionFactory;
import com.study.entity.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class dbBook {
	private Transaction transaction;
    private Session session;
    private Query query;
    HibernateSessionFactory getSession;
    public dbBook() {
		
	}
    
  //添加book信息操作
    public boolean saveInfo(Book bPO){
       //getSession=new HibernateSessionFactory();
 	   session=getSession.getSession();
    	try {
			 transaction=session.beginTransaction();
			  System.out.println();
			  session.save(bPO);
			  transaction.commit();
			  session.close();
			  return true;
		} catch (Exception e) {
			message("saveInfo.error:"+e);
			e.printStackTrace();
			return false;			
		}
    }
  //条件查找操作
    public List findInfo(String type,Object value){
    	//getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();               
  	   try {
		transaction=session.beginTransaction();
		String queryString="from Book as model where model."+type+"=?";
		query=session.createQuery(queryString);
		query.setParameter(0, value);
		List list=query.list();
		transaction.commit();
		session.close();
		return list;
		
	} catch (Exception e) {
		message("findInfo.error:"+e);
		e.printStackTrace();
		return null;
	}
    }
    //查找全部的操作
    public List findAllInfo(){
    	//getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();
  	   try {
		transaction=session.beginTransaction();
		String queryString="from Book";
		query=session.createQuery(queryString);		
		List list=query.list();
		transaction.commit();
		session.close();
		return list; //返回一个list
		
	} catch (Exception e) {
		message("findAllInfo.error:"+e);
		e.printStackTrace();
		return null;
	}
    }
    //删除图书的操作
    public boolean deleteInfo(String id) {
    	 //getSession=new HibernateSessionFactory();
    	   session=getSession.getSession();
    	   try {
  		      transaction=session.beginTransaction();
			   Book book=new Book();
  		    book=(Book)session.get(Book.class,id);
  		      session.delete(book);
  		      transaction.commit();
  		      session.close();
  		      return true;
  	       } catch (Exception e) {
  	    	   message("deleteAdmin.error:"+e);
  		   	   e.printStackTrace();
  		   	   return false;
  	   }
	}
    
    //修改图书信息
    public boolean updateInfo(Book bPo){
 	 //  getSession=new HibernateSessionFactory();
 	   session=getSession.getSession();
 	   try {
 		     transaction=session.beginTransaction();
 		     session.update(bPo);
 		     transaction.commit();
 		     session.close();
 		     return true;
 	       } catch (Exception e) {
 	    	message("updateAdmin.error:"+e);
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
