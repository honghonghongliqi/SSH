<%@ page language="java" import="java.util.*,com.opensymphony.xwork2.util.ValueStack,java.util.List,java.util.Iterator,bean.ItemBean" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>itemList.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <%
  //获取值栈中的值
  	ValueStack vs = (ValueStack)request.getAttribute("struts.valueStack")                                                    ;
  	List itemList = (List)vs.findValue("list");            
   %>
   
   
   <s:property value="#session.user"/>,您好！
   <!-- 全部商品 -->
    <center>商品列表</center> <br>
    <table border=1>
    	<tr>
    		<th>名称</th><th>编号</th><th>单价</th>
    	</tr>
    	<s:iterator value="list">
    	<tr>
    		<td><s:property value="name"/></td>
    		<td><s:property value="number"/></td>
    		<td><s:property value="price"/></td>
    	</tr>
    	</s:iterator>
    </table>
    <!-- 价格小于30元的商品 --><br>
    <table border=1>
    	<tr>
    		<th>名称</th><th>编号</th><th>单价</th>
    	</tr>
    	<s:iterator value="list.{?#this.price<30}">
    	<tr>
    		<td><s:property value="name"/></td>
    		<td><s:property value="number"/></td>
    		<td><s:property value="price"/></td>
    	</tr>
    	</s:iterator>
    </table>
    <p>
    	名称为《Java》的商品价格为：
    	<s:property value="list.{?#this.name=='Java'}.{price}[0]"/>元
    </p>
    <br>比较输出：
    <br><s:url value="list.{name}[0]"/>
    <br><s:url value="%{list.{name}[0]}"/>
    <br>原因：值类型标签的value属性，默认不支持OGNL,所以必须加上%{}来提供OGNL的运行环境。而像property的Struts标签默认支持OGNL表达式。
  </body>
</html>
