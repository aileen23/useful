<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�޿�������ȸ</title>
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
		<font size="5" style="font-style: inherit;">�޿�������ȸ</font>
		<input type="button" id="btn_search" value="��ȸ" />
		<input type="button" id="btn_oneReg" value="�޿��������" /> 
		<input type="button" id="btn_delete" value="����" />
	</p>
	<hr>
	<div id="div_searchArea" class="searchArea cb mgb10"
		style="vertical-align: middle; min-width: 800px; padding-bottom: 0px; padding-top: 15px;">
		<div>��ȸ�Ⱓ: <input type="text" id="startdate">~<input type="text" id="enddate">  </div>
	</div>
	
	<div id="div_print">
	<table border="0" cellpadding="0" cellspacing="0" style="margin-top: 10px; width: 100%;">
	<tr>
		<th width="10%">���</th>
		<th width="20%">�����</th>
		<th width="20%">�μ�</th>
		<th width="10%">����</th>
		<th width="10%">�⺻��</th>
		<th width="10%">�����հ�</th>
		<th width="10%">�����հ�</th>
		<th width="10%">�������޾�</th>
	</tr>
	<tr>
		<td colspan="8">
		<b>�����͸� �˻����ּ���</b>
		</td>
	</tr>
	</table>
	</div>
</div>
</body>
</html>