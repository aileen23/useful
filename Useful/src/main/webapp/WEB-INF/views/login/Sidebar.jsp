<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UsefulWare</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
	<link rel="stylesheet" type="text/css" media="screen"
		href="${pageContext.request.contextPath}/resources/jquery-ui/jquery-ui.css" />
	<link rel="stylesheet" type="text/css" media="screen"
		href="${pageContext.request.contextPath}/resources/jqGrid/css/ui.jqgrid.css" /> 
	<link rel="stylesheet" type="text/css" media="screen"
		href="${pageContext.request.contextPath}/resources/jqGrid/plugins/ui.multiselect.css" /> 
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/jqGrid/js/jquery-1.11.0.min.js"></script> 
	<script type="text/javascript" 
		src="${pageContext.request.contextPath}/resources/jquery-ui/jquery-ui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/jqGrid/js/i18n/grid.locale-en.js"></script> 
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/jqGrid/js/jquery.jqGrid.min.js"></script> 
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
      <!-- 왼쪽 사이드바 쪽  -->
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <div>
                           <div>
                              <center><span><i class="fa fa-user fa-fw"></i>[${LoginUser.position }] ${LoginUser.ename}님 안녕하세요~!!</span></center> 
                           </div>
                           <p></p>
                           <div>
                           <center>
                           <span>
                              <button type="button" id="#">  <i class="fa fa-envelope fa-fw"></i>메일함</button>
                              <button type="button" id="commute_in"><i class="fa fa-sort-up fa-fw"></i>출근</button>
                              <button type="button" id="commute_out"><i class="fa fa-sort-down fa-fw"></i>퇴근</button>
                           </span>
                           </center>
                           </div>
                           <p></p>
                           <div>
                           		<span><i class="fa fa-clock-o fa-fw"></i>최근접속 : <fmt:formatDate value="${LoginUser.regdate}" pattern="yyyy-MM-dd HH:mm"/> </span>
                           </div>
                        </div>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-file-text fa-fw"></i> 전자결재 <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="/useful/approval/form">기안하기</a>
                                </li>
                                <li>
                                    <a href="/useful/approval/liststatus">결재진행</a>
                                </li>
                                <li>
                                   <a href="/useful/approval/listdept">결재완료(수신)</a>
                                </li>
                                <li>
                                   <a href="/useful/approval/listmine">내 기안문서</a>
                                </li>
                                <li>
                                   <a href="/useful/approval/listmyturn">내 결재문서</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users fa-fw"></i> 인사관리<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">급여관리</a>
                                </li>
                                <li>
                                    <a href="morris.html">근태관리</a>
                                </li>
                                <li>
                                   <a href="/useful/manager/employee_List">사원정보관리</a>
                                </li>
                                <li>
                                   <a href="#">증명서관리</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-table fa-fw"></i> 게시판<span class="fa arrow"></span></a>
                           <ul class="nav nav-second-level">
                           <li>
                              <a href="/useful/board/notice/listPage">공지게시판</a>
                           </li>
                           <li>
                              <a href="/useful/board/listPage">사내게시판</a>
                           </li>
                           <li>
                              <a href="#">부서게시판</a>
                           </li>
                           <li>
                              <a href="/useful/board/anonymity/listPage">익명게시판</a>
                           </li>
                           </ul>
                        </li>
                        
                        <li>
                            <a href="forms.html"><i class="fa fa-list-alt fa-fw"></i> 업무공유</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-calendar fa-fw"></i> 일정관리<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="panels-wells.html">회사일정관리</a>
                                </li>
                                <li>
                                    <a href="buttons.html">부서별일정관리</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-calendar-o fa-fw"></i> 회의실예약<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">예약하기</a>
                                </li>
                                <li>
                                    <a href="#">예약내역</a>
                                </li>
                                
                                    </ul>
                                    <!-- /.nav-third-level -->
                               </li>
                        
                         <li>
                            <a href="#"><i class="fa fa-sort fa-fw"></i> 출퇴근내역조회<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">출근내역조회</a>
                                </li>
                                <li>
                                    <a href="#">퇴근내역조회</a>
                                </li>
                                <li>
                                   <a href="#">출퇴근관리</a>
                                </li>
                                
                                    </ul>
                                    <!-- /.nav-third-level -->
                               </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
            </div>

    
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/raphael/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>

</body>
</html>