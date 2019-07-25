<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
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
            <p class="p1">添加图书</p>
		<s:form action="AddbookAction1" enctype="multipart/form-data" method="post">
				<table  align="center"  class="table_a">
				<tr>
				   <td>
				<s:textfield name="id"  label="编号" cssClass="addpeople" size="30"  />
				   </td>
				</tr>
				
				 <tr>
                     <td>
				 &nbsp;&nbsp;<s:file  name ="upload" label="选择图片" />
				    </td>
                 </tr>
				
				
				<tr>
				   <td>
				<s:textfield name="name"  label="书名" cssClass="addpeople" size="30"  /><br/>
				   </td>
				</tr>
				
				<tr>
				   <td>
				<s:textfield name="author"  label="作者" cssClass="addpeople" size="30"  /><br/>
				   </td>
				</tr>
				
				
				<tr>
				   <td>
				<s:textfield name="number"  label="数量" cssClass="addpeople" size="30"  />
				   </td>
				</tr>
				
				<tr>
				   
				<s:textfield name="place"  label="位置" cssClass="addpeople"  size="30"  /><br/>
			
				   </td>
				</tr>
				
					<tr>
				   
				<s:textfield name="price"  label="价格" cssClass="addpeople" size="30"  /><br/>
			
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
