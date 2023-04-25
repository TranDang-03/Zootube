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
<title>Register</title>
<!-- Bootstrap core CSS-->
<link
	href="<c:url value='/template/admin/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">
<!-- Custom fonts for this template-->
<link
	href="<c:url value='/template/admin/vendor/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="<c:url value ='/template/admin/css/sb-admin.css'/>"
	rel="stylesheet">
<style type="text/css">
body {
	background-image:
		url('<c:url value="/template/other/img/wallpaper-1.jpg"/>');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
}
</style>
</head>

<body class="bg-dark">
	<div class="container">
		<div class="card card-register mx-auto mt-5">
			<div class="card-header">Đăng ký tài khoản</div>
			<div class="card-body">

				<form action="/Zootube/user/user-register" method="post">
					<div class="form-group">
						<label for="exampleInputName">Tên tài khoản</label> <input
							class="form-control" id="exampleInputName" name="username"
							type="text" aria-describedby="nameHelp"
							placeholder="Nhập tên tài khoản">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email</label> <input
							class="form-control" id="exampleInputEmail1" name="email"
							type="email" aria-describedby="emailHelp"
							placeholder="Nhập email">
					</div>
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<label for="exampleInputPassword1">Mật khẩu</label> <input
									class="form-control" id="exampleInputPassword1" name="password"
									type="password" placeholder="Nhập mật khẩu">
							</div>
							<div class="col-md-6">
								<label for="exampleConfirmPassword">Xác nhận mật khẩu</label> <input
									class="form-control" name="confirmpassword"
									id="exampleConfirmPassword" type="password"
									placeholder="Nhập lại mật khẩu">
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Đăng
						ký</button>
				</form>

				<script type="text/javascript">
					<c:if test="${not empty message}">
					alert("${message}")
					</c:if>
				</script>

				<div class="text-center">
					<a class="d-block small mt-3" href="/Zootube/user/login">Trang
						Đăng Nhập</a> <a class="d-block small"
						href="/Zootube/user/forgotpassword">Quên Mật Khẩu?</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>">
		
	</script>
</body>

</html>