<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         import="java.util.ArrayList,
                 com.study.entity.Book,
                 com.study.dao.dbBook,
                 com.study.dao.dbPeople,
                 com.study.entity.People" %>


<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>借书</title>
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
        <p class="p1">申请借书</p>
        <s:form action="BorrowAction" method="post">
            <table align="center" class="table_a">
                <%
                    String id = request.getParameter("id");
                    String str = new String(id.getBytes("ISO-8859-1"), "UTF-8");
                    dbBook DB = new dbBook();
                    List list = DB.findInfo("id", str);
                    Book info = (Book) list.get(0);
                %>

                <tr>
                    <td>
                        书号：<input name="bookId" readonly="readonly" class="addpeople" size="30"
                                    value="<%=info.getId()%>"/>

                    </td>
                </tr>

                <tr>
                        <td>
                            图片名称：<input name="picture" readonly="readonly" class="addpeople" size="30"
                                        value=<%=info.getPicture()%>"/>
                        </td>
                </tr>

                <tr>
                    <td>
                        书名：&nbsp;&nbsp;<input name="name" readonly="readonly" class="addpeople" size="30"
                                              value="<%=info.getName()%>"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        作者:&nbsp;&nbsp;<input name="author" readonly="readonly" class="addpeople" size="30"
                                              value=<%=info.getAuthor()%>"/>
                    </td>
                </tr>

                <tr>
                    <td>
                        库存数量:&nbsp;&nbsp;<input name="number" readonly="readonly" class="addpeople" size="30"
                        value=<%=info.getNumber()%>>
                    </td>
                </tr>


                <tr>
                    <td>
                        位置：&nbsp;&nbsp;<input name="place" readonly="readonly" class="addpeople" size="30"
                                              value=<%=info.getPlace() %>/>

                    </td>
                </tr>


                <tr>
                    <td>
                        价钱：&nbsp;&nbsp;<input name="price" readonly="readonly" class="addpeople" size="30"
                                              value=<%=info.getPrice() %>/>

                    </td>
                </tr>

            <tr>
                <td>
                    &nbsp;&nbsp;请选择借书卡号：
                </td>
                <td>
                    <select name="pid">
                        <%
                            dbPeople db = new dbPeople();
                            List list1 = db.findAllInfo();

                            if (list1.isEmpty()) {
                        %>
                        <option value="null"></option>
                        <%
                        } else {
                            for (int i = 0; i < list1.size(); i++) {
                                People pPO = (People) list1.get(i);

                        %>

                        <option value="<%=pPO.getId()%>"><%=pPO.getId()%>
                        </option>

                        <%
                                }
                            }
                        %>
                    </select>
                </td>
                </tr>
                <tr>
                    <td>
                        &nbsp;&nbsp;借书数量：<input name="num" class="addpeople" size="30"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <center><s:submit value="确定借书"/></center>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;</td>
                </tr>
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
