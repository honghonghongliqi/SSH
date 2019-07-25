<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         import="java.util.ArrayList,com.study.entity.Admin,com.study.dao.dbAdmin" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>redirect</title>

    <link rel="stylesheet" href="../css/1.css" type="text/css"/>

</head>

<body class="body">
<div class="a"><p class="p">redirect</p></div>
<div class="b">
    <nav>
        <ul>
            <li>
                <a>管理员账户管理</a>
                <ul>
                    <li>
                        <a href="http://127.0.0.1:8081/LookMessageAction1">查看管理员</a>
                    </li>
                    <li>
                        <a href="http://127.0.0.1:8081/superAdmin/admin/addAdmin.jsp">添加管理员</a>
                    </li>
                </ul>
            </li>
            <li>
                    <a>用户信息管理</a>
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
                        <a href="http://localhost:8081/superAdmin/book1/addBook.jsp" >图书入库</a>

                    </li>

                </ul>
            </li>

            <li>
                <a href="http://localhost:8081/LookRecordAction1">查看图书借阅记录</a>

            </li>
        </ul>
    </nav>
</div>
<div class="c">
    <center>
        <s:form action="UpdateMessageAction1" method="post">
            <table align="center" class="button">
                <%
                    String userName = request.getParameter("userName");
                    String str = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
                    dbAdmin DB = new dbAdmin();
                    List list = DB.findAdmin("userName", str);
                    Admin info = (Admin) list.get(0);
                %>
                <tr>

                    <td>


                        账号：&nbsp;&nbsp;<input name="id" class="xiugai"
                                              readonly="readonly" value="<%=info.getId()%>"/>
                    </td>
                    <td>


                        账号：&nbsp;&nbsp;<input name="userName" class="xiugai"
                                              readonly="readonly" value="<%=info.getUserName()%>"/>
                    </td>


                </tr>

                <tr>
                    <td>
                        密码：&nbsp;&nbsp;<input name="password" class="xiugai" value="<%=info.getPassword()%>"/>
                    </td>
                </tr>


                <tr>
                    <td colspan="2" align="center">


                        用户类别:<input name="type" class="xiugai" value="<%=info.getType()%>"/></td>
                </tr>


                <tr>
                    <td colspan="2" align="center">
                        <center><s:submit value="修改"/></center>
                    </td>
                </tr>

                <tr>
                    <td>&nbsp;&nbsp;</td>
                </tr>
                <tr>
                    <td align="center">
                        &nbsp;&nbsp;<a href="LookMessageAction">返回</a>
                    </td>
                </tr>
            </table>
        </s:form>
    </center>
</div>
</body>
</html>
