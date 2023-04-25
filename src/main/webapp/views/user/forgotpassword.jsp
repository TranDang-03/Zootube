<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="f" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Quên mật khẩu</title>
<!-- Bootstrap core CSS-->
<link
	href="<c:url value='/template/admin/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="<c:url value='/template/admin/vendor/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="<c:url value='/template/admin/css/sb-admin.css'/>"
	rel="stylesheet">

<style type="text/css">
body {
	background-image:
		url('<c:url value="/template/other/img/wallpaper-2.jpg"/>');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
}
</style>
</head>

<body class="bg-dark">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Quên mật khẩu</div>
			<div class="card-body">
				<div class="text-center mt-4 mb-5">
					<h4>Bạn quên mật khẩu của mình?</h4>
					<p>Nhập email của bạn vào đây và chúng tôi sẽ gửi mã reset mật
						khẩu đến.</p>
				</div>
				<form>
					<div class="form-group">
						<input class="form-control" id="exampleInputEmail1" type="email"
							aria-describedby="emailHelp" placeholder="Nhập email của bạn">
					</div>
					<a class="btn btn-primary btn-block">Reset mật khẩu</a>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="/Zootube/user/user-register">Đăng
						ký tài khoản</a> <a class="d-block small" href="/Zootube/user/login">Trang
						đăng nhập</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
</body>

</html>