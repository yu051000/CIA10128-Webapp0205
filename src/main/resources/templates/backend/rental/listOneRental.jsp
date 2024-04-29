<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.rental.model.*"%>

<%
    RentalVO rentalVO = (RentalVO) request.getAttribute("rentalVO"); //RentalServlet.java(Concroller), �s�Jreq��rentalVO����
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>���ɫ~��Ƭd�ߵ��G - listOneRental.jsp</title>

    <style>
        table#table-1 {
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
            width: 600px;
            background-color: white;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        table, th, td {
            border: 1px solid #CCCCFF;
        }
        th, td {
            padding: 5px;
            text-align: center;
        }
    </style>
</head>

<body>
<table id="table-1">
    <tr>
        <td>

        <h3>���ɫ~���</h3>
        <h4><a href="<%=request.getContextPath()%>select_page.jsp">�^����</a></h4>
        </td>
    </tr>
</table>

<table>
    <tr>
        <th>���ɫ~�s��</th>
        <th>���ɫ~�W��</th>
        <th>���ɫ~���</th>
        <th>���ɫ~�ؤo</th>
        <th>���ɫ~�C��</th>
        <th>���ɫ~��T</th>
        <th>���ɫ~���A</th>
        <th>���ɫ~���O�s��</th>
    </tr>
    <tr>
        <td>${rentalVO.rNo}</td>
        <td>${rentalVO.rName}</td>
        <td>${rentalVO.rPrice}</td>
        <td>${rentalVO.rSize}</td>
        <td>${rentalVO.rColor}</td>
        <td>${rentalVO.rInfo}</td>
        <td>${rentalVO.rStat}</td>
        <td>${rentalVO.rCatNo}-[${rentalVO.rCatNo.rName}]</td>
    </tr>
</table>
</body>
</html>