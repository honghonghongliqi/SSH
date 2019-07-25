<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>添加管理员</title>
    
	<link rel="stylesheet" href="../css/1.css" type="text/css"/>

  </head>
  
  <body class="body">
    <div class="a"><p class="p">增加管理员</p></div>
		<div class="b">
			<nav>
			<ul>
			<!--<li><a href="http://127.0.0.1:8080/pzl/admin/addAdmin.jsp">Home</a></li>
			<li><a href="http://store.apple.com/" target="_blank">Store</a></li>
			-->
			<li>
				<a>管理员账户管理</a>
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
				<a>借书卡号管理</a>
				<ul>
					<li>
						<a href="http://127.0.0.1:8081/LookPeopleAction1" >查看借书卡号信息</a>
						
					</li>
					<li>
						<a href="http://127.0.0.1:8081/superAdmin/people1/addPeople.jsp" >添加借书卡号</a>
						
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
							<a href="http://localhost:8081/superAdmin/book1/addBook.jsp" >图书入库</a>

						</li>

					</ul>
				</li>
			
			<li>
				<a href="http://localhost:8081/LookRecordAction1">查看图书借阅记录</a>
				<ul>
					<!--<li>
						<a href="" >借</a>
						
					</li>
					<li>
						<a href="" >还</a>
						
					</li>
					
				--></ul>
			</li>
			<!--<li><a href="http://www.apple.com/iphone/" target="_blank">iPhone</a></li>
			<li><a href="http://www.apple.com/ipad/" target="_blank">iPad</a></li>
			<li><a href="http://www.apple.com/itunes/" target="_blank">iTunes</a></li>
			<li><a href="http://www.apple.com/support/" target="_blank">Support</a></li>
		-->
		</ul>
		</nav>
		</div>
		<div class="c">
		<center>
		<s:form action="AddAdminAction1"  method="post">
				<table  align="center"  class="button">
				<tr>
				   <td>
				<s:textfield name="userName"  label="账号"  size="30" /><br/>
				用户名慎重不得修改
				   </td>
				</tr>
				
				<tr>
				   <td>
				<s:password name="password1"  label="密码" size="30" />
				   </td>
				</tr>
				
				
				<tr>
				   <td>
				<s:password name="password2"  label="再次输入密码" size="30" />
				   </td>
				</tr>
				
				<tr>
				   <td colspan="2" align="center">

				<input type="radio" name="type" class="Sor" value="admin" />管理员
			
				   </td>
				</tr>
				
				
				<tr>
				   <td colspan="2"  align="center">
					<input type="submit" class="button1"  value="确定"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" class="button1" value="清空"/>
					</td>
				</tr>
				</table>
			</s:form>
			</center>
		</div>
  </body>
</html>
