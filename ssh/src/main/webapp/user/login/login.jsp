<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书信息管理系统</title>
    
	<link rel="stylesheet" href="css/style.css" />
	<style type="text/css">
		.logo{
            background-color: rgba(134,153,255,0.42);
            font-size: 40px;
            letter-spacing: 5px;
            margin: auto;
            padding-top: 5px;
            height: 80px;
            width: 100%;
        }

        .h11{
            color: #333333;
            margin-top: 25px;
        }

        .table_c{
            border:2px solid #99B4BB;
            padding: 50px;
        }
        .button1{
            margin-top: 15px;
        }


	</style>
  </head>
  
  <body>
  <center>
        <header id="header">
			<div class="center">
				<h1 class="logo">图书管理系统</h1>
			</div>
		</header>
		
		<div id="login">
			<div class="box">
				<div>
					<center><h1 class="h11">用户登录 </h1></center>
				</div>
				<s:form action="loginAction1"  method="post">
				<table  align="center"  class="table_c">
				<tr>
				   <td>
					<s:textfield name="name"   label="账号"  size="30" placeholder="请输入姓名"/>
				   </td>
				</tr>
				
				<tr>
				   <td>
				<s:password name="password"  label="密码" size="30" placeholder="请输入密码"/>
				   </td>
				</tr>
				
				<tr>
				   <td colspan="2"  align="center">
					<input type="submit" class="button1"  value="确定"/>
					&nbsp;&nbsp;
					<input type="reset" class="button1" value="重置"/>
					</td>
				</tr>
				</table>
			</s:form>
			
			</div>
			
		</div>

  </center>
  </body>
</html>
