<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
import="java.util.ArrayList,com.study.entity.Record"%>

<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>查看借阅记录</title>
    <link rel="stylesheet" href="../css/1.css" type="text/css"/>
	

  </head>
  
  <body class="body">
            <div class="a"><p class="p">图书管理系统</p></div>
		<div class="b">
			<nav>
			<ul>
						
			<li>
				<a >用户信息管理</a>
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
					<!--<li>
						<a href="" >借</a>
						
					</li>					
					
				--></ul>
			</li>
					
		</ul>
		</nav>
		</div>
		<div class="c">
		<center>
		<span class="renshuzi">你要查询的数据表中共有<%=request.getSession().getAttribute("count")%>条记录</span>
		<table align="center" width="80%" border="3">
		  <tr>
		    <th>记录条数</th>
		    <th>书编号</th>
		    
		    <th>书名</th>
		    
		    <th>借阅数量</th>
		    <th>借书卡号</th>
		    <th>借书时间</th>
		    
		  </tr>
		
		<%
		  ArrayList list1=(ArrayList)session.getAttribute("allinfo1");
		  if(list1.isEmpty()){
		        %>
		        <tr>
		            <td align="center"><span>暂无管理员信息！</span></td>
		        </tr>
		        <%
		        }else{
		          for(int i=0;i<list1.size();i++){
					  Record rPo=(Record)list1.get(i);
		            %>
		            <tr>
		              <td align="center"><%=i+1%></td>
		              <td><%=rPo.getId()%></td>
		              
		              <td><%=rPo.getName()%></td>
		              
		              <td><%=rPo.getNum()%></td>
		              <td><%=rPo.getPeople()%></td>
		              <td><%=rPo.getTime()%></td>
						<td><%=rPo.getStatus()%></td>

		              
		              
		            
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
