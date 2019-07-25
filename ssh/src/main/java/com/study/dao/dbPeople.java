package com.study.dao;

import java.util.List;


import javax.swing.JOptionPane;

import com.study.addHibernateFile.HibernateSessionFactory;
import com.study.entity.People;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class dbPeople {
    private Transaction transaction;
    private Session session;
    private Query query;
    HibernateSessionFactory getSession;
    public dbPeople() {	
	}
    //添加people信息操作
    public boolean saveInfo(People pPO){
      // getSession=new HibernateSessionFactory();
 	   session=getSession.getSession();
    	try {
			 transaction=session.beginTransaction();
			  session.save(pPO);
			  transaction.commit();
			  session.close();
			  return true;
		} catch (Exception e) {
			message("saveInfo.error:"+e);
			e.printStackTrace();
			return false;			
		}
    }
  //people条件查找操作
    public List findInfo(String type,Object value){
    	//getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();               
  	   try {
		transaction=session.beginTransaction();
		String queryString="from People as model where model."+type+"=?";
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
    //people查找全部的操作
    public List findAllInfo(){
    	//getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();
  	   try {
		transaction=session.beginTransaction();
		String queryString="from People";
		query=session.createQuery(queryString);		
		List list=query.list();
		transaction.commit();
		session.close();
		return list;
		
	} catch (Exception e) {
		message("findAllInfo.error:"+e);
		e.printStackTrace();
		return null;
	}
    }


    //删除people的操作
    public boolean deleteInfo(String id) {
    	// getSession=new HibernateSessionFactory();
    	   session=getSession.getSession();
    	   try {
  		      transaction=session.beginTransaction();
			   People infoPeoplePO=new People();
  		    infoPeoplePO=(People)session.get(People.class,id);
  		      session.delete(infoPeoplePO);
  		      transaction.commit();
  		      session.close();
  		      return true;
  	       } catch (Exception e) {
  	    	   message("deleteAdmin.error:"+e);
  		   	   e.printStackTrace();
  		   	   return false;
  	   }
	}
    
    //修改people信息
    public boolean updateInfo(People pPo){
 	  // getSession=new HibernateSessionFactory();
 	   session=getSession.getSession();
 	   try {
 		     transaction=session.beginTransaction();
 		     session.update(pPo);
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
