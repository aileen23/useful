<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- Login.jsp --%>
<title>로 그 인</title>

	<!-- Bootstrap Core CSS -->
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="../resources/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	function checkLogin(){
		if($.trim($("#empnoinput").val()) == ""){
			alert("아이디를 입력해 주세요.");
			$("#empnoinput").focus();
			return;
		}
		if($.trim($("#passinput").val()) == ""){
			alert("비밀번호를 입력해 주세요.");
			$("#passinput").focus();
			return;
		}
		
		$.ajax({
			type:'post',
			async:true,
			url:'/useful/login/Main',
			data:$("#form").serialize(),
			success:function(result){

				if(result=="SUCCESS"){
					alert("로그인 성공!!");
					location.href="/useful/login/Modify_Pass";
				}else{
					alert("로그인 실패!!");
					self.location = "/useful/login/Login";
				}
			}
		});
	}
</script>
</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In...</h3>
                    </div>
                    <div class="panel-body">
                        <form name="form" id="form" action="/useful/login/Main" method="post">
							<div class="form-group">
                                    Empno : <input class="form-control"  name="empno" type="text" id="empnoinput" autofocus>
                                </div>
                                <div class="form-group">
                                   Password : <input class="form-control"  name="pass" type="password" id="passinput">
                                </div>
                                <div class="radio" align="center">
                                    <label>
                                        <input name="member" type="radio" value="사원" checked="checked">사원
                                    </label>
                                    <label>
                                        <input name="member" type="radio" value="관리자">관리자
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <div>
                                <button type="button" class="btn btn-lg btn-success btn-block" id="btn" onclick="checkLogin()">Login</button>
                                </div>
                                <p></p>
                                <div>
                                	<center><a href="Search_Pass" >비밀번호 찾기</a></center>
                                </div>
						</form>
                    </div>
                </div>
            </div>
        </div>
    </div>

 <!-- jQuery -->
    <script src="../resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../resources/dist/js/sb-admin-2.js"></script>

</body>
</html>