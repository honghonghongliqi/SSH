<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,com.study.entity.People,com.study.dao.dbPeople" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>修改people</title>
    <link rel="stylesheet" href="../css/1.css" type="text/css"/>

	  <style type="text/css">
		  .table_a{
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
			<p class="p1">修改用户信息</p>
		<s:form action="updatepeopleAction1"  method="post">
				<table  align="center"  class="table_a">
				<%
				String id=request.getParameter("id");
				String str=new String(id.getBytes("ISO-8859-1"),"UTF-8");
					dbPeople DB=new dbPeople();
     	        List list=DB.findInfo("id",str);
					People info=(People)list.get(0);
				 %>
				
				<tr>
				   <td>
				借书卡号：<input name="id"  readonly="readonly" class="addpeople"  size="30" value="<%=info.getId()%>" />
				
				   </td>
				</tr>
				
				<tr>
				   <td>
				姓名：&nbsp;&nbsp;<input name="name" class="addpeople"   size="30" value=<%=info.getName()%> />
				   </td>
				</tr>
				
				
				<tr>
				   <td>
				性别：&nbsp;&nbsp;<input name="sex" class="addpeople"     size="30" value=<%=info.getSex()%> />
				   </td>
				</tr>
				
				<tr>
					<td>		   
				电话:&nbsp;&nbsp;<input name="phone"  class="addpeople"    size="30" value=<%=info.getPhone()%> />			
				   </td>
				</tr>
				
					<tr>
				   <td>
				地址：&nbsp;&nbsp;<input name="address"  class="addpeople"   size="30" value=<%=info.getAddress() %>  />
			
				   </td>
				</tr>
					<tr>
						<td>
							密码：&nbsp;&nbsp;<input name="password"  class="addpeople"   size="30" value=<%=info.getPassword() %>  />

						</td>
					</tr>
				<tr>
				   <td colspan="2" align="center">
					<center><s:submit  value="修改"/></center>
					</td>
				</tr>
				
				<tr>  <td>&nbsp;&nbsp;</td></tr>
				<tr>
				    <td align="center">
					&nbsp;&nbsp;<a href="LookPeopleAction">返回</a>
					</td>
				</tr>
				</table>
			</s:form>
			</center>

  </body>
</html>
