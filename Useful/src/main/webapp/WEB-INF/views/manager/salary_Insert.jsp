<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�޿����</title>
 <link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/jquery-ui/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/jqGrid/css/ui.jqgrid.css" /> 
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/jqGrid/plugins/ui.multiselect.css" /> 
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqGrid/js/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqGrid/js/i18n/grid.locale-en.js"></script> 
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqGrid/js/jquery.jqGrid.src.js"></script> 
<script type="text/javascript">
$(function(){	
 	   $( "#startdate" ).datepicker({
 		  changeMonth: true, 
          changeYear: true,
 		  dateFormat: 'yy-mm-dd'
 	   });
 	   $( "#enddate" ).datepicker({
 		  changeMonth: true, 
          changeYear: true,
 		  dateFormat: 'yy-mm-dd'
 	   });
});
</script> 
</head>
<body>
<header><%@include file="/WEB-INF/views/manager/Main.jsp"%></header> 
<div>
	<jsp:include page="/WEB-INF/views/manager/Sidebar.jsp"></jsp:include>  
</div>
	<div id="page-wrapper">
	<p>
		<font size="5" style="font-style: inherit;">�޿����</font>
		<input type="button" id="btn_search" value="��ȸ" />
		<input type="button" id="btn_oneReg" value="�޿��������" /> 
		<input type="button" id="btn_delete" value="����" />
	</p>
	<hr>
	<p>�ػ������</p>
	<table>
	 <tr>
	 	<td>���</td>
	 	<td>���</td>
	 	<td>�����</td> 
	 	<td>�����</td> 
	 </tr>
	</table>
	<p>����������</p>
	<table>
	 <tr>
	 	<td>������</td>
	 	<td>������</td>
	 	<td>�ͼӿ�</td> 
	 	<td>�ͼӿ�</td> 
	 </tr>
	</table>
	<p>�رݾ�����</p>
	<table>
	 	<tr>
			<th colspan="2">����</th>
			<th colspan="2">����</th>
	 	</tr>
	 	<tr>
	 		<td>�⺻��</td>
	 		<td>�⺻��</td>
	 		<td>���ο���</td>
	 		<td>�⺻��</td>
	 	</tr>
	 	<tr>
	 		<td>����������</td>
	 		<td>����������</td>
	 		<td>�ǰ�����</td>
	 		<td>�ǰ�����</td>
	 	</tr>
	 	<tr>
	 		<td>�Ĵ뺸����</td>
	 		<td>�Ĵ뺸����</td>
	 		<td>��뺸��</td>
	 		<td>��뺸��</td>
	 	</tr>
	 	<tr>
	 		<td>��������</td>
	 		<td>��������</td>
	 		<td>����纸��</td>
	 		<td>����纸��</td>
	 	</tr>
	 	<tr>
	 		<td>��Ÿ����</td>
	 		<td>��Ÿ����</td>
	 		<td>�ҵ漼</td>
	 		<td>�ҵ漼</td>
	 	</tr>
	 	<tr>
	 		<td></td>
	 		<td></td>
	 		<td>����ҵ漼</td>
	 		<td>����ҵ漼</td>
	 	</tr>
	</table>
	<p>���հ�</p>
	<table>
	<tr>
		<td>�����հ�</td>
		<td>�����հ�</td>
		<td>�����հ�</td>
		<td>�����հ�</td>
		<td>�������޾�</td>
		<td>�������޾�</td>
	</tr>
	</table>
</div>
</body>
</html>