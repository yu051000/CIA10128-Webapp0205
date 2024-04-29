<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>�d�߯��ɫ~ - select_page.jsp</title>
    <style>
        table#table-1 {
            width: 450px;
            background-color: #CCCCFF;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 3px ridge Gray;
            height: 80px;
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
</head>

<body>
<table id="table-1">
    <tr><td><h3>���ɫ~Home</h3><h4>( MVC )</h4></td></tr>
</table>

<h3>��Ƭd��:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
    <font style="color:red">�Эץ��H�U���~:</font>
    <ul>
        <c:forEach var="message" items="${errorMsgs}">
            <li style="color:red">${message}</li>
        </c:forEach>
    </ul>
</c:if>

<ul>
    <li>
        <a href='<%=request.getContextPath()%>listAllRental.jsp'>�d�ߩҦ����ɫ~</a><br><br>
    </li>
    <li>
        <FORM method="post" action="<%=request.getContextPath()%>/rental.do" enctype="multipart/form-data">
            <b>��J���ɫ~�s�� (ex. 5001):</b>
            <input type="text" name="rNo" value="${rentalVO.rNo}"><font color=red>${errorMsgs.rNo}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>
    <jsp:useBean id="rentalSvc" scope="page" class="com.rental.model.RentalService" />
    <li>
        <FORM method="post" action="<%=request.getContextPath()%>/rental.do">
            <b>��ܯ��ɫ~���O�s��:</b>
            <select size="1" name="rCatNo">
                <c:forEach var="rentalVO" items="${rentalSvc.all}">
                    <option value="${rentalVO.rNo}">${rentalVO.rCatNo}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>
    <li>
        <FORM method="post" action="<%=request.getContextPath()%>/rental.do">
            <b>��J���ɫ~�W��:</b>
            <input type="text" name="rName" value="${rentalVO.rName}"><font color=red>${errorMsgs.rName}</font>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>
    <li>
        <FORM method="post" action="<%=request.getContextPath()%>/rental.do">
            <b>��ܯ��ɫ~�ؤo:</b>
            <select size="1" name="rSize">
                <c:forEach var="rentalVO" items="${rentalSvc.all}" >
                    <option value="${rentalVO.rNo}">${rentalVO.rSize}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>
    <li>
        <FORM method="post" action="<%=request.getContextPath()%>/rental.do">
            <b>���ɫ~�C��:</b>
            <select size="1" name="rColor">
                <c:forEach var="rentalVO" items="${rentalSvc.all}" >
                <option value="${rentalVO.rNo}">${rentalVO.rColor}
                    </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>
    <li>
        <FORM method="post" action="<%=request.getContextPath()%>/rental.do">
            <b>���ɫ~���A:</b>
            <select size="1" name="rStat">
                <c:forEach var="rentalVO" items="${rentalSvc.all}" >
                    <option value="${rentalVO.rNo}">${rentalVO.rStat}
                </c:forEach>
            </select>
            <input type="hidden" name="action" value="getOne_For_Display">
            <input type="submit" value="�e�X">
        </FORM>
    </li>
</ul>
<br>
<ul>
    <li><a href='addRental.jsp'>�s�W���ɫ~</a></li>
</ul>
</body>
</html>