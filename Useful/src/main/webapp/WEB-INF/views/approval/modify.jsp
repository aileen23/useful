<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>반려된 문서 수정</title>
<%@include file="/WEB-INF/views/login/Main.jsp" %>
<%@include file="/WEB-INF/views/login/Sidebar.jsp" %>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>
<!-- DataTables JavaScript -->
<script	src="${pageContext.request.contextPath}/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script	src="${pageContext.request.contextPath}/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>
<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script type="text/javascript">
	$(function(){
		var frm=$('form');
		$('[name=modify]').click(function(){
			frm.attr('action','/useful/approval/modify');
			frm.attr('method','post');
			var oldfilename=$('[name=oldfilename]').val();
			var newfilename=$('[name=file]').val();
			if(oldfilename!=''){
		 		if(newfilename!='')
					alert('새로운 첨부파일로 대체됩니다.');
				else
					alert('기존 첨부파일을 유지합니다.');
			}
			else{
				if(newfilename!='')
					alert('새로운 첨부파일이 등록됩니다.');
				else
					alert('첨부파일이 등록되지 않은 상태가 유지됩니다.');
			}
			frm.submit();
		});
		$('[name=delete]').click(function(){
			if(confirm('삭제하시겠습니까?')){
				frm.attr('action','/useful/approval/delete');
				frm.attr('method','post');
				frm.submit();
			}
		});
	})
</script>
</head>
<body>
<div id='page-wrapper'>
	<form method="post" enctype="multipart/form-data"><!-- enctype 설정은 submit 직전에 지정됨 (in jQuery) -->
	<table border='1' width='35%'>
	<tr>
		<td width='20%' align='center'>발신자</td>
		<td>
			<input type='text' name='writer_name' size='80' value='${vo.writer_name}' readonly>
			<input type='hidden' name='writer' size='80' value='${vo.writer}'>
			<input type='hidden' name='no' value='${vo.no}'>
			<input type='hidden' name='next_approval' value='${vo.next_approval}'>
		</td>
	</tr>
	<tr>
	<td width='20%' align='center'>수신처</td>
		<td>
			<input type='text' name='receiver_name' value='${vo.receiver_dname }' readonly>
			<input type='hidden' name='receiver' value='${vo.receiver}'>
		</td>
	</tr>
	<tr><td width='20%' align='center'>제목</td><td><input type='text' name='title' size='80' value="${vo.title}"></td></tr>
	<tr><td colspan="2" align='center'><textarea name='content' cols="65" rows="20">${vo.content}</textarea></td></tr>
	<tr>
		<td width='20%' align='center'>기존첨부파일</td>
		<td>
			<c:if test="${vo.filename==null}">첨부된 파일이 없습니다.</c:if>
			<c:if test="${vo.filename!=null}"><a href='${pageContext.request.contextPath}/approval/filedownload?filename=${vo.filename}'>${vo.filename}</a></c:if>
		</td>		
	<tr><td width='20%' align='center'>신규첨부파일</td><td><input type="file" name='file' size='63'></td></tr>
	</table>
	<input type='hidden' name='oldfilename' value='${vo.filename}'>
	<input type='button' name='modify' value='수정'>
	<input type='button' name='delete' value='삭제'>
	<input type='button' name='cancel' value='뒤로' onclick='history.back()'>
	</form>
</div>
</body>
</html>