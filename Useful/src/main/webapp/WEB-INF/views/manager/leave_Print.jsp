<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table border="0" cellpadding="0" cellspacing="0" style="margin-top: 10px; width: 100%;">
	<tr>
		<th width="10%">�μ�</th>
		<th width="10%">���</th>
		<th width="20%">�����</th>
		<th width="20%">�Ի�����</th>
		<th width="10%">�⺻����</th>
		<th width="10%">��뿬��</th>
		<th width="10%">��������</th>
		<th width="10%">����</th>
	</tr>
	<c:forEach items="${commute }" var="print" varStatus="status">
	<tr>
		<td>${print.dname }</td>
		<td>${print.empno }</td>
		<td>${print.ename }</td>
		<td>${print.hiredate }</td>
		<td>${print.basic }</td>
		<td>${print.used }</td>
		<td>${print.rest }</td>
		<td><button onclick="update('${print.dname }','${print.empno }','${print.ename }','${print.hiredate }','${print.basic }','${print.used }','${print.rest }')">����</button></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>