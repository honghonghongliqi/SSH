<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加管理员</title>
	  <link rel="stylesheet" href="../css/1.css" type="text/css"/>

      <style type="text/css">
          .table_b{
              border:2px solid #99B4BB;
              padding: 65px;
          }
          .p1{
              font-size: 20px;
              color: #486EA7;
              margin-top: 50px;
          }
          body{
              background-color: rgba(167,147,255,0.24);
          }
      </style>
  </head>
  
  <body class="body">
		<center>
            <p class="p1">添加管理员</p>
		<s:form action="AddAdminAction1"  method="post">
				<table  align="center"  class="table_b">
				<tr>
				   <td>
				<s:textfield name="userName"  label="账号"  size="30" /><br/>
				<!--用户名慎重不得修改-->
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

  </body>
</html>
