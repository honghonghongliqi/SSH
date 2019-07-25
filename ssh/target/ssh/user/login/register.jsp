<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         import="java.util.ArrayList,com.study.entity.People,com.study.dao.dbPeople" %>
<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>修改people</title>
    <link rel="stylesheet" href="../css/1.css" type="text/css"/>

</head>

<body class="body">
<div class="a"><p class="p">图书管理系统</p>
</div>

<div class="c">
    <center>
        <s:form action="register" method="post">
            <table align="center" class="button">

                <tr>
                    <td>
                        姓名：&nbsp;&nbsp;<input type="text" name="name" class="addpeople" size="30"/>
                    </td>
                </tr>


                <tr>
                    <td>
                        性别：&nbsp;&nbsp;<input type="text" type="text" name="sex" class="addpeople" size="30"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        电话:&nbsp;&nbsp;<input type="text" name="phone" class="addpeople" size="30"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        地址：&nbsp;&nbsp;<input type="text" name="address" class="addpeople" size="30"/>

                    </td>
                </tr>

                <tr>
                    <td>
                        密码：&nbsp;&nbsp;<input type="text" name="password" class="addpeople" size="30"/>

                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                        <center><s:submit value="注册"/></center>
                    </td>
                </tr>

                <tr>
                    <td>&nbsp;&nbsp;</td>
                </tr>

            </table>
        </s:form>
    </center>
</div>
</body>
</html>
