<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th {
	background-color: #CCC;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>연차관리</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jqGrid/js/jquery-1.11.0.min.js"></script> 
 <script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>  
<script type="text/javascript">
	$(function(){
		
		$("#btn_search").click(function(){
			searchList();
		});
		$("#btn_close").click(function(){
 			$("#popup").fadeOut(500);
 		});
 		$("#btn_update").click(function(){
 			$.ajax({
 				type:'POST',
 				url:'/useful/manager/leave_List_Update',
 	 			  headers : {
 	 				  "Content-Type" : "application/json",
 	 				  "X-HTTP-Method-Override":"POST"
 	 			  },	
 	 			  dataType: 'text',
 	 			  data: JSON.stringify({
 	 				empno:$("#update_Empno").text(),
 	 				basic:$("#update_Basic").val(),
 	 				used:$("#update_Used").val(),
 	 				rest:$("#update_Rest").val()
 	 				  }),
 	 			  success: function(){
 	 						alert("수정되었습니다");
 	 						searchList();
 	 				  }
 			});
 							$("#popup").fadeOut(500);
 		});
	});
	function searchList(){
	 		  $.ajax({
	 			  type: 'POST',
	 			  url: '/useful/manager/leave_List',
	 			  headers : {
	 				  "Content-Type" : "application/json",
	 				  "X-HTTP-Method-Override":"POST"
	 			  },
	 			  dataType: 'text',
	 			  data: JSON.stringify({
	 				deptno:$("#deptno option:selected").val(),
	 				empno:$("#empno").val(),
	 				ename:$("#ename").val()
	 				  }),
	 			  success: function(result){
	 					$("#div_print").html(result);
	 			  }
	 			});
	 		  
	}
	function update(dname,empno,ename,hiredate,basic,used,rest){
		$("#update_Dname").text(dname);
		$("#update_Empno").text(empno);
		$("#update_Ename").text(ename);
		$("#update_Hiredate").text(ename);
		$("#update_Basic").val(basic);
		$("#update_Used").val(used);
		$("#update_Rest").val(rest);
		$("#popup").fadeIn(700);
	}
	
</script>
</head>
<header><%@include file="/WEB-INF/views/manager/Main.jsp"%></header>
<body>
<div>
	<jsp:include page="/WEB-INF/views/manager/Sidebar.jsp"></jsp:include> 
</div>
<!-- leave_List.jsp -->
<div id="page-wrapper">
<p><br>
<font size="5" style="font-style: inherit;">연차관리</font><br><hr>
<table style="border-color: black;">
<tbody>

	<tr>
		<th style="	text-align: center;">부서명</th>
			<td><select id="deptno" name="deptno" class="select" style="width: 200px;">
						<option value="0" selected="selected">-- 선택 --</option>
						<option value="10">잘했조</option>
						<option value="20">보여조</option>
						<option value="30">강조</option>
						<option value="40">삼삼오오조</option>
				</select></td>
			</tr>
	<tr>
		<th  style="	text-align: center;">사원번호</th>
		<td><input type="text" id="empno"></td>
	</tr>
	<tr>
		<th  style="	text-align: center;">사원명</th>
		<td><input type="text" id="ename"></td>
	</tr>
</tbody>
</table>
	<div><button id="btn_search" class="btn btn-default" >검색</button></div>
	
	<div id="div_print">
	<table border="0" cellpadding="0" cellspacing="0" style="margin-top: 10px; width: 100%;">
	<tr>
		<th width="10%">부서</th>
		<th width="10%">사번</th>
		<th width="20%">사원명</th>
		<th width="20%">입사일자</th>
		<th width="10%">기본연차</th>
		<th width="10%">사용연차</th>
		<th width="10%">남은연차</th>
		<th width="10%">변경</th>
	</tr>
	<tr>
		<td colspan="8">
		<b>데이터를 검색해주세요</b>
		</td>
	</tr>
	</table>
	</div>
</div>
<div id="popup" class="overlay"
		style="z-index: 25; display: none; position: fixed; top: 0; left: 0; background-color: rgba(0, 0, 0, 0.6); width: 100%; height: 100%;">
		<div
			style="background-color: white; width: 50%; height: 60%; margin-left: 20%; margin-top: 10%;  border: 1px solid black;">

			<br>
			<table class="table" style="margin-left: 30px;margin-top: 10px;margin-right: 30px;width: 90%;">
				<tr>
				<td colspan="2" align="center">연차 변경페이지</td>
				</tr>
				<tr>
					<th width="30%" align="center">부서명</th>
					<td><div id="update_Dname"></div></td>
				</tr>
				<tr>
					<th>사번</th>
					<td><div id="update_Empno"></div></td>
				</tr>
				<tr>
					<th>사원명</th>
					<td><div id="update_Ename"></div></td>
				</tr>
				<tr>
					<th>입사년월</th>
					<td><div id="update_Hiredate"></div></td>
				</tr>
				<tr>
					<th>기본연차</th>
					<td><input type="text" id="update_Basic"></td>
				</tr>
				<tr>
					<th>사용연차</th>
					<td><input type="text" id="update_Used"></td>
				</tr>
				<tr>
					<th>남은연차</th>
					<td><input type="text" id="update_Rest"></td>
				</tr>
			</table>
			<input type="hidden" id="update_Serial">
			<button type="button" class="btn btn-default" id="btn_update"
				style="margin-left: 45%">수정</button>
			<button type="button" class="btn btn-default" id="btn_close"
				>닫기</button>


		</div>
	</div>
</body>
</html>