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
	<title>���ɫ~��Ʒs�W - addRental.jsp</title>
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
			<h3>���ɫ~���O��Ʒs�W</h3>
			<h4><a href="<%=request.getContextPath()%>select_page.jsp">�^����</a></h4>
		</td>
	</tr>
</table>

<h3>�s�W��ơG</h3>

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
			<td>���ɫ~�W��:</td>
			<td><input type="TEXT" name="rName" id="rName" value="${param.rName}" size="45"/></td> <td>${errorMsgs.rName}</td>
		</tr>
		<tr>
			<td>���ɫ~���:</td>
			<td><input type="TEXT" name="rPrice" id="rPrice" value="<%=(rentalVO==null) ? "" : rentalVO.getrPrice()%>"></td>
		</tr>
		<tr>
			<td>���ɫ~�ؤo:</td>
			<td><input type="TEXT" name="rSize" id="rSize" value="<%=(rentalVO==null) ? "" : rentalVO.getrSize()%>"></td>
		</tr>
		<tr>
			<td>���ɫ~�C��:</td>
			<td><input type="TEXT" name="rColor" id="rColor" value="<%=(rentalVO==null) ? "" : rentalVO.getrColor()%>"></td>
		</tr>
		<tr>
			<td>���ɫ~��T:</td>
			<td><input type="TEXT" name="rInfo" id="rInfo" value="<%=(rentalVO==null) ? "" : rentalVO.getrInfo()%>"></td>
		</tr>
		<tr>
			<td>���ɫ~���A:</td>
			<td><input type="TEXT" name="rStat" id="rStat" value="<%=(rentalVO==null) ? "" : rentalVO.getrStat()%>"></td>
		</tr>
		<tr>
			<td>���ɫ~���O�s��:</td>
			<td><input type="TEXT" name="rCatNo" id="rCatNo" value="<%=(rentalVO==null) ? "" : rentalVO.getrCatNo()%>"></td>
		</tr>

	</table>
	<br>
	<input type="hidden" name="action" value="insert">
	<input type="submit" id="submitAdd" value="�e�X�s�W">
</FORM>
	<script src="<%=request.getContextPath()%>/jquery/jquery.js"></script>
<%--	<script>--%>
<%--		$(function (){--%>

<%--			$("#addform1").on("submit", function(event){ //���e�X�AĲ�o"submit"�ƥ�--%>
<%--				event.preventDefault(); //����w�]--%>

<%--				// ���o��檺�ƾ�--%>
<%--				var rName = $("#rName").val();--%>
<%--				var password = $("#password").val();--%>
<%--			});--%>
<%--		});--%>
<%--	</script>--%>
</body>
</html>