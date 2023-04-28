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
<title>Login</title>
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
		url('https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExNjRkMjFjNDg3MzYzYzdhZjAzNGUxNWQ2MjRhMTU2NjA0M2Y5MTk2ZiZlcD12MV9pbnRlcm5hbF9naWZzX2dpZklkJmN0PWc/J3BlD4W2r1mcK1vMWW/giphy.gif');
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center center;
}
</style>
</head>

<body class="bg-dark">
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Đăng nhập</div>
			<div class="card-body">

				<form action="/Zootube/user/login" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Email</label> <input
							class="form-control" id="exampleInputEmail1" type="email"
							aria-describedby="emailHelp" placeholder="Nhập email"
							name="email" value="${email}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label>
						<div class="input-group">
							<input type="password" class="form-control" id="userPassword"
								placeholder="Nhập mật khẩu" name="password" value="${password}">
							<button class="btn btn-outline-secondary" type="button"
								id="showPassword">Hiển thị</button>
						</div>
					</div>
					<div class="form-group">
						<div class="form-check">
							<label class="form-check-label"> <input
								class="form-check-input" type="checkbox" name="check" value="on">
								Nhớ mật khẩu
							</label>
						</div>
					</div>

					<div class="pt-1 mb-4">
						<button class="btn btn-primary btn-lg btn-block" type="submit">Đăng
							nhập</button>
					</div>

				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href="/Zootube/user/user-register">Đăng
						ký ngay</a> <a class="d-block small"
						href="/Zootube/user/forgotpassword">Quên mật khẩu?</a>
				</div>
			</div>
		</div>
	</div>

	<script>
	<c:if test="${ not empty message }">
		alert("${message}")
	</c:if>
	</script>

	<!-- Bootstrap core JavaScript-->
	<script
		src="<c:url value ='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script
		src="<c:url value ='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
	<script>
    const showPasswordButton = document.getElementById('showPassword');
    const passwordInput = document.getElementById('userPassword');
    showPasswordButton.addEventListener('click', () => {
      if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
        showPasswordButton.textContent = 'Ẩn';
      } else {
        passwordInput.type = 'password';
        showPasswordButton.textContent = 'Hiển thị';
      }
    });
  </script>

	<script>
  const showConfirmPasswordBtn = document.querySelector('#showConfirmPassword');
  const userConfirmPassword = document.querySelector('#userConfirmPassword');
  
  showConfirmPasswordBtn.addEventListener('click', () => {
    if (userConfirmPassword.type === 'password') {
      userConfirmPassword.type = 'text';
      showConfirmPasswordBtn.textContent = 'Ẩn';
    } else {
      userConfirmPassword.type = 'password';
      showConfirmPasswordBtn.textContent = 'Hiển thị';
    }
  });
</script>
</body>
</html>
