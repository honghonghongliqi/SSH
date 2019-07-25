<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,com.study.entity.People"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>查看借书卡号</title>
     <link rel="stylesheet" href="../css/1.css" type="text/css"/>
	

  </head>
  
  <body class="body">
            <div class="a"><p class="p">图书管理系统</p></div>

		<div class="c">
		<center>
		<table align="center" width="80%" border="3">
		  <tr>
		    <th>记录条数</th>
		    <th>借书卡号</th>
		    <th>姓名</th>
		    <th>性别</th>
		    <th>电话</th>
		    <th>地址</th>
			  <th>密码</th>
		    <th>用户操作</th>
		  </tr>
		
		<%
		  ArrayList list=(ArrayList)session.getAttribute("allinfo");
		  if(list.isEmpty()){
		        %>
		        <tr>
		            <td align="center"><span>暂无管理员信息！</span></td>
		        </tr>
		        <%
		        }else{
		          for(int i=0;i<list.size();i++){
					  People pPo=(People)list.get(i);
		            %>
		            <tr>
		              <td align="center"><%=i+1%></td>
		              <td><%=pPo.getId()%></td>
		              <td><%=pPo.getName()%></td>
		              <td><%=pPo.getSex()%></td>
		              <td><%=pPo.getPhone()%></td>
		              <td><%=pPo.getAddress()%></td>
						<td><%=pPo.getPassword()%></td>
		              <td><a href="http://127.0.0.1:8081/user/login/update.jsp?id=<%=pPo.getId()%>">修改</a>
					  </td>
		             </tr>
		             <%
		             }
		          }
		      %>       
		</table> 
		</center>
		</div>
		</body>
</html>
