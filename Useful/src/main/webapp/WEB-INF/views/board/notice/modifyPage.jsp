<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<body>

  <%@include file="../../login/Main.jsp" %>
<%@include file="../../login/Sidebar.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시글 수정</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            작성페이지
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" method="post" action="/useful/board/notice/modifyPage">
                                    	
                                        <div class="form-group">
                                            <label>글 제목</label>
                                            <input class="form-control" type="text" id="title" name="title" value="${board.title }"></input>
                                            <input type='hidden' name="serial" value=${board.serial }>
                                        </div>
                                        <div class="form-group">
                                            <label>글쓴이</label>
                                            <input type="text" id="writer" class="form-control" name="writer" value="${board.writer }" readonly="readonly"></input>
                                        </div>
										<div class="form-group">
                                            <label>글내용</label>
                                            <textarea id="content" class="form-control" rows="3" name="content">${board.content }</textarea>
                                        </div>

                                        <div class="form-group">
                                        
                                        </div>
                                        <div class="form-group">
                                            <label>파일 올리기</label>
                                            <input type="file">
                                        </div>
                                        <input type="hidden" name="page" value="${cri.page }">
                                        <input type="hidden" name="perPageNum" value="${cri.perPageNum }">
                                       <input type='hidden' name='searchType' value="${cri.searchType}">
	                                   <input type='hidden' name='keyword' value="${cri.keyword}">
                                         <button type="submit" class="btn btn-default" id="submit">작성완료</button>
                                        <button type="reset" class="btn btn-default" id="reset">다시작성하기</button>
										<button type="button" class="btn btn-default" id="backPage">되돌아가기</button>
                                        </form>
										

</div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../resources/dist/js/sb-admin-2.js"></script>
    <!-- 게시물 버튼 설정 -->
    <script>
    $(document).ready(function(){
    	 
    	$("#backPage").on("click",function(){
    		history.back();
    	});

    });
    </script>

</body>
</body>
</html>