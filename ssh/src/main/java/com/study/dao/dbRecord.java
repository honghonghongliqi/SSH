package com.study.dao;


import java.util.List;

import javax.swing.JOptionPane;

import com.study.addHibernateFile.HibernateSessionFactory;
import com.study.entity.Record;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class dbRecord {
	private Transaction transaction;
    private Session session;
    private Query query;
    HibernateSessionFactory getSession;
    public dbRecord() {
		
	}
    
  //添加record信息操作
    public boolean saveInfo1(Record rPO){

      // getSession=new HibernateSessionFactory();
 	   session=getSession.getSession();
    	try {
			 transaction=session.beginTransaction();
			  session.save(rPO);
			  transaction.commit();
			System.out.println();
			  session.close();
			  return true;

		} catch (Exception e) {
			message("saveInfo.error:"+e);
			e.printStackTrace();
			return false;			
		}
    }

	//修改record信息操作
	public boolean update(Record rPO){
		session=getSession.getSession();
		try {
			System.out.println();
			transaction=session.beginTransaction();
			session.update(rPO);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			message("saveInfo.error:"+e);
			e.printStackTrace();
			return false;
		}
	}
    
    //record查找全部的操作
    public List findAllInfo1(){
    	//getSession=new HibernateSessionFactory();
  	   session=getSession.getSession();
  	   try {
		transaction=session.beginTransaction();
		String queryString="from Record";
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



	//record查找的操作
	public List findInfo(String peopeleId){
		//getSession=new HibernateSessionFactory();
		session=getSession.getSession();
		try {
			transaction=session.beginTransaction();
			String queryString="from Record where people=? and status=?";
			query=session.createQuery(queryString);
			query.setParameter(0,peopeleId);
			query.setParameter(1,"未还");
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



	//record查找的操作
	public Record findById(String id){
		//getSession=new HibernateSessionFactory();
		session=getSession.getSession();
		try {
			transaction=session.beginTransaction();
			String queryString="from Record where id=?";
			query=session.createQuery(queryString);
			query.setParameter(0,id);
			List list=query.list();
			transaction.commit();
			session.close();
			return (Record) list.get(0);

		} catch (Exception e) {
			message("findAllInfo.error:"+e);
			e.printStackTrace();
			return null;
		}
	}
    
    public void message(String mess) {
		int type=JOptionPane.YES_NO_OPTION;
		String title="提示消息";
		JOptionPane.showMessageDialog(null, mess,title,type);
	}
}
