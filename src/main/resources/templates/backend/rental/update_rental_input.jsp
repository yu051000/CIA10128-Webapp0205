<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.rental.model.*"%>

<%
    RentalVO rentalVO = (RentalVO) request.getAttribute("rentalVO"); //RentalServlet.java(Controller), �s�Jreq��rentalVO����
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>���ɫ~��ƭק�</title>

    <style>
        table#table-1 {
            width: 450px;
            background-color: #CCCCFF;
            border: 2px solid black;
            text-align: center;
        }
        table#table-1 h4 {
            color: red;
            display: block;
            margin-bottom: 1px;
        }
        h4 {
            color: blue;
            display: inline;
        }
    </style>
    <style>
        table {
            background-color: white;
            margin-top: 1px;
            margin-bottom: 1px;
        }
        table, th, td {
            border: 0px solid #CCCCFF;
        }
        th, td {
            padding: 1px;
        }
    </style>
</head>

<body>
<table id="table-1">
    <tr>
        <td>
            <h3>���ɫ~��ƭק�</h3>
            <h4><a href="<%=request.getContextPath()%>select_page.jsp">�^����</a></h4>
        </td>
    </tr>
</table>

<h3>��ƭק�:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">�Эץ��H�U���~:</font>
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li style="color:red">${message}</li>
        </c:forEach>
    </ul>
</c:if>

<FORM method="post" action="<%=request.getContextPath()%>/rental.do" enctype="multipart/form-data">
    <table>
        <tr>
            <td>���ɫ~�s��:<font color=red><b>*</b></font></td>
            <td><%=rentalVO.getrNo()%></td>
        </tr>
        <tr>
            <td>���ɫ~�W��:</td>
            <td><input type="TEXT" name="rName" value="<%=rentalVO.getrName()%>"></td><td>${errorMsgs.rName}</td>
        </tr>
        <tr>
            <td>���ɫ~���:</td>
            <td><input type="TEXT" name="rPrice" value="<%=rentalVO.getrPrice()%>"></td><td>${errorMsgs.rPrice}</td>
        </tr>
        <tr>
            <td>���ɫ~�ؤo:</td>
            <td><input type="TEXT" name="rSize"  value="<%=rentalVO.getrSize()%>"></td><td>${errorMsgs.rSize}</td>
        </tr>
        <tr>
            <td>���ɫ~�C��:</td>
            <td><input type="TEXT" name="rColor"  value="<%=rentalVO.getrColor()%>"></td><td>${errorMsgs.rColor}</td>
        </tr>
        <tr>
            <td>���ɫ~��T:</td>
            <td><input type="TEXT" name="rInfo"  value="<%=rentalVO.getrInfo()%>"></td><td>${errorMsgs.rInfo}</td>
        </tr>
        <tr>
            <td>���ɫ~���A:</td>
            <td><input type="TEXT" name="rStat"  value="<%=rentalVO.getrStat()%>"></td><td>${errorMsgs.rStat}</td>
        </tr>
        <jsp:useBean id="rentalSvc" scope="page" class="com.rental.model.RentalService" />
        <tr>
            <td>���ɫ~���O�s��:<font color=red><b>*</b></font></td>
            <td><select size="1" name="rCatNo">
                <c:forEach var="rentalVO" items="${rentalSvc.all}">
                <option value="${rentalVO.rCatNo}" ${(param.rCatNo==rentalVO.rCatNo)? 'selected':'' }>${rentalVO.rName}
                    </c:forEach>
            </select></td>
        </tr>
    </table>
    <br>
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="rNo" value="${rentalVO.rNo}">
    <input type="submit" value="�e�X�ק�"></FORM>
</body>
</html>