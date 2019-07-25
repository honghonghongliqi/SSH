<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,com.study.entity.Admin"%>
<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书管理系统</title>
  <link rel="stylesheet" href="../css/1.css" type="text/css"  rel="stylesheet"/>
  
  </head>
  <body class="body">
  <div class="a"><p class="p">图书管理系统</p></div>
		<div class="b">
			<nav>
			<ul>
			<li>
				<a >管理员账户管理</a>
				<ul>
					<li>
						<a href="http://127.0.0.1:8081/LookMessageAction1">查看管理员</a>
						
					</li>
					<li>
						<a href="http://127.0.0.1:8081/superAdmin/admin/addAdmin.jsp" >添加管理员</a>
						
					</li>
					
				</ul>
			</li>
			
			
			<li>
				<a >用户管理</a>
				<ul>
					<li>
						<a href="http://127.0.0.1:8081/LookPeopleAction1" >查看用户信息</a>
					</li>
				</ul>
			</li>
			
			<li>
				<a >图书信息管理</a>
				<ul>
					<li>
						<a href="http://localhost:8081/LookBookAction1" >查看图书信息</a>
						
					</li>
					<li>
						<a href="http://127.0.0.1:8081/superAdmin/book1/addBook.jsp" >图书入库</a>
						
					</li>
					
				</ul>
			</li>
			
			<li>
				<a href="http://localhost:8081/LookRecordAction1">查看图书借阅记录</a>
				<ul>
				</ul>
			</li>
		</ul>
		</nav>
		</div>

		<center>
			<table boder="1" align="center" bgcolor="#AABBCCDD" width="501" height="89">
   

    </table>
    </center>
    </div>
  
    
     
    
  </body>
</html>
