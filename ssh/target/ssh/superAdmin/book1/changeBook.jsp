<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,com.study.entity.Book,com.study.dao.dbBook" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>修改图书信息</title>
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

		<div class="c">
			<center>
				<p class="p1">修改图书信息</p>
		<s:form action="UpdatepeopleAction1"  method="post">
				<table  align="center"  class="table_a">
				<%
				String id=request.getParameter("id");
				String str=new String(id.getBytes("ISO-8859-1"),"UTF-8");
				dbBook DB=new dbBook();
     	        List list=DB.findInfo("id",str);
					Book info=(Book)list.get(0);
				 %>
				
				<tr>
				   <td>
				借书卡号：<input name="id"  readonly="readonly" class="addpeople"  size="30" value="<%=info.getId()%>" />
				
				   </td>
				</tr>
				
				<tr>
				   <td>
				图片名称：<input name="picture" readonly="readonly" class="addpeople"   size="30" value=<%=info.getPicture() %> />
				   </td>
				</tr>
				
				
				<tr>
				   <td>
				书名：&nbsp;&nbsp;<input name="name" class="addpeople"     size="30" value=<%=info.getName() %> />
				   </td>
				</tr>
				
				<tr>
					<td>		   
				作者:&nbsp;&nbsp;<input name="author"  class="addpeople"    size="30" value=<%=info.getAuthor()%> />			
				   </td>
				</tr>
				
				<tr>
					<td>		   
				数量:&nbsp;&nbsp;<input name="number"  class="addpeople"    size="30" value=<%=info.getNumber()%> />			
				   </td>
				</tr>
					<tr>
				   <td>
				位置：&nbsp;&nbsp;<input name="place"  class="addpeople"   size="30" value=<%=info.getPlace() %>  />
			
				   </td>
				</tr>
				
					<tr>
				   <td>
				价钱：&nbsp;&nbsp;<input name="price"  class="addpeople"   size="30" value=<%=info.getPrice() %>  />
			
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
					&nbsp;&nbsp;<a href="LookBookAction">返回</a>
					</td>
				</tr>
				</table>
			</s:form>
			</center>
		</div>
  </body>
</html>
