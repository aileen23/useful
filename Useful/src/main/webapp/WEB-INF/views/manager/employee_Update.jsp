<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������������</title>
<style type="text/css">
th {
	background-color: #CCC;
}

</style>
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

	$(function() {
		$("#dept").val("${vo.deptno}").prop("selected", true);
		$("#position").val("${vo.position}").prop("selected", true);
		$("#bank").val("${vo.bank}").prop("selected", true);
		
 	   $( "#hiredate" ).datepicker({
 		  changeMonth: true, 
          changeYear: true,
 		  dateFormat: 'yy-mm-dd'
 	   });
 	   
 	   $("#btn_Save").click(function(){
 		  $.ajax({
 			  type: 'POST',
 			  url: '/useful/manager/employee_Update',
 			  headers : {
 				  "Content-Type" : "application/json",
 				  "X-HTTP-Method-Override":"POST"
 			  },
 			  dataType: 'text',
 			  data: JSON.stringify({
 				empno: $("#emp_no").val(),
 				ename:$("#emp_nm").val(),
 				ssn:$("#ssn").val(),
 				deptno:$("#dept option:selected").val(),
 				position:$("#position option:selected").val(),
 				email:$("#email").val(),
 				phone:$("#mobile").val(),
 				address:$("#addr").val(),
 				bank:$("#bank option:selected").val(),
 				account:$("#account_no").val(),
 				hiredate:$("#hiredate").val(),
 				  }),
 			  success: function(){
 				  alert("�����Ǿ����ϴ�")
 			  }
 			});
 	   });
 	   $("#btn_List").click(function(){
 		   
 			location.href="/useful/manager/employee_List";
 		   
 	   });
 	   $("#btn_Delete").click(function(){
 		  if (confirm("���� �����Ͻðڽ��ϱ�?") == true){    //Ȯ��
 			  	$.ajax({
 		 			  type: 'POST',
 		 			  url: '/useful/manager/employee_Delete?empno='+$("#emp_no").val(),
 		 			  headers : {
 		 				  "Content-Type" : "application/json",
 		 				  "X-HTTP-Method-Override":"POST"
 		 			  },
 		 			  success: function(result){
 		 				if(result=='SUCCESS'){
 		 					alert("�����Ǿ����ϴ�");
			 			location.href="/useful/manager/employee_List";
 		 			 	 }
 		 			  }
 			  	});
 			}else{   //���
 			    return;
 			}
 		   
 	   });
	});

</script>

</head>
<body>
<!-- employee_Update.jsp -->
	<div>
		<font size="5" style="font-style: inherit;margin-right: 300px;">������������ </font>
		<button id="btn_Save">�����Ϸ�</button>
		<button id="btn_Delete">����</button>
		<button id="btn_List">���</button>
		<br>
	</div>
<hr>
	<table class="bbs_row">
		<colgroup>
			<col width="150" />
			<col />
		</colgroup>
		<tbody style="">
			<tr>
				<th>����ڵ�*</th>
				<input type="hidden" value="${vo.empno}" id="emp_no">
				<td>${vo.empno}</td>
			</tr>
			<tr>
				<th>���� *</th>
				<td><input id="emp_nm" name="emp_nm" class="text" type="text"
					value="${vo.ename }" maxlength="15" /></td>
			</tr>

			<tr>
				<th>�ֹι�ȣ *</th>
				<td><input id="ssn" name="ssn" class="text" type="text"
					value="${vo.ssn }" maxlength="14" /></td>
			</tr>
			<tr>
				<th>�μ���*</th>
				<td><select id="dept" name="dept" class="select"
					style="width: 200px;" >
						<option value="" >-- ���� --</option>
						<option value="10">������</option>
						<option value="20">������</option>
						<option value="30">����</option>
						<option value="40">��������</option>

				</select></td>
			</tr>
			<tr>
				<th>��å *</th>
				<td><select id="position" name="position" class="select"
					style="width: 200px;">
						<option value="">-- ���� --</option>

						<option value="����">����</option>

						<option value="����">����</option>

						<option value="����">����</option>

						<option value="�븮">�븮</option>

						<option value="���">���</option>

				</select></td>
			</tr>
			
			<tr>
				<th>�̸���</th>
				<td><input id="email" name="email" class="text"
					style="width: 200px;" type="text" value="${vo.email }"
					maxlength="50" /></td>
			</tr>
			<tr>
				<th>�ڵ��� *</th>
				<td><input id="mobile" name="mobile" class="text"
					style="width: 200px;" type="text" value="${vo.phone }"
					maxlength="20" /></td>
			</tr>
			<tr>
				<th>�ּ�</th>
				<td><input id="addr" name="addr" class="text"
					style="width: 100%;" type="text" value="${vo.address }"
					maxlength="100" /></td>
			</tr>
			<tr>
				<th>����</th>
					<td>
					<select id="bank" name="bank" class="select" style="width:200px;">
						<option value="">--����--</option>
						<option value="����">����</option>
						<option value="�츮">�츮</option>
						<option value="����">����</option>
						<option value="����">����</option>
						<option value="��ȯ">��ȯ</option>
						<option value="�ϳ�">�ϳ�</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>���¹�ȣ</th>
				<td><input id="account_no" name="account_no" class="text"
					style="width: 200px;" type="text" value="${vo.account }" maxlength="100" /></td>
			</tr>

			<tr>
				<th>�Ի���</th>
				<td>
					<input type="text" id="hiredate" value="<fmt:formatDate value="${vo.hiredate }" type="date" pattern="yyyy-mm-dd "/>">  
				</td>
			</tr>


			<tr>
				<th>�ֱ�������</th>
				<td>
				<fmt:formatDate value="${vo.regdate}" type="date" pattern="yyyy-mm-dd "/>
				</td>
				
			</tr>
		</tbody>
	</table>
	
	
</body>
</html>