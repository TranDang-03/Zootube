<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="f" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Zootube</title>
<link rel="stylesheet"
	href="<c:url value='/template/other/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/other/fontawesome/css/all.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/template/other/css/templatemo-style.css'/>">

</head>
<body>
	<!-- Page Loader -->
	<div id="loader-wrapper">
		<div id="loader"></div>

		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>

	</div>
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <i class="fas fa-film mr-2"></i>
				Zootube
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link nav-link-1 active"
						aria-current="page" href="index.html">Photos</a></li>
					<li class="nav-item"><a class="nav-link nav-link-2"
						href="videos.html">Videos</a></li>
					<li class="nav-item"><a class="nav-link nav-link-3"
						href="about.html">About</a></li>
					<li class="nav-item"><a class="nav-link nav-link-4"
						href="contact.html">Contact</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="tm-hero d-flex justify-content-center align-items-center"
		data-parallax="scroll"
		data-image-src="<c:url value='/template/other/img/hero.jpg'/>">
		<form class="d-flex tm-search-form">
			<input class="form-control tm-search-input" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success tm-search-btn" type="submit">
				<i class="fas fa-search"></i>
			</button>
		</form>
	</div>

	<div class="container-fluid tm-container-content tm-mt-60">
		<div class="row mb-4">
			<h2 class="col-6 tm-text-primary">Video mới nhất</h2>
			<div class="col-6 d-flex justify-content-end align-items-center">
				<form action="" class="tm-text-primary">
					Page <input type="text" value="1" size="1"
						class="tm-input-paging tm-text-primary"> of 200
				</form>
			</div>
		</div>
		<div class="row tm-mb-90 tm-gallery">
			<c:forEach items="videos" var="video" varStatus="loop">

				<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6 col-12 mb-5">
					<figure class="effect-ming tm-video-item">
						<img src="<c:url value='/template/other/img/img-03.jpg'/>"
							alt="Image" class="img-fluid">
						<figcaption
							class="d-flex align-items-center justify-content-center">
							<h2>${video.title}</h2>
							<a href="/Zootube/video/detail?id=${video.id}"></a>
						</figcaption>
					</figure>
					<div class="d-flex justify-content-between tm-text-gray">
						<span class="tm-text-gray-light">${video.shares} share</span> <span>${video.viewss}
							views</span>
					</div>
				</div>

			</c:forEach>

		</div>
	</div>
	<!-- row -->
	<div class="row tm-mb-90">
		<div
			class="col-12 d-flex justify-content-between align-items-center tm-paging-col">
			<a href="javascript:void(0);"
				class="btn btn-primary tm-btn-prev mb-2 disabled">Previous</a>
			<div class="tm-paging d-flex">
				<a href="javascript:void(0);" class="active tm-paging-link">1</a> <a
					href="javascript:void(0);" class="tm-paging-link">2</a> <a
					href="javascript:void(0);" class="tm-paging-link">3</a> <a
					href="javascript:void(0);" class="tm-paging-link">4</a>
			</div>
			<a href="javascript:void(0);" class="btn btn-primary tm-btn-next">Next
				Page</a>
		</div>
	</div>
	</div>
	<!-- container-fluid, tm-container-content -->

	<footer class="tm-bg-gray pt-5 pb-3 tm-text-gray tm-footer">
		<div class="container-fluid tm-container-small">
			<div class="row">
				<div class="col-lg-6 col-md-12 col-12 px-5 mb-5">
					<h3 class="tm-text-primary mb-4 tm-footer-title">About Zootube</h3>
					<p>
						Zootube is free <a rel="sponsored"
							href="https://v5.getbootstrap.com/">Bootstrap 5</a> Alpha 2 HTML
						Template for video and photo websites. You can freely use this
						TemplateMo layout for a front-end integration with any kind of CMS
						website.
					</p>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
					<h3 class="tm-text-primary mb-4 tm-footer-title">Our Links</h3>
					<ul class="tm-footer-links pl-0">
						<li><a href="#">Advertise</a></li>
						<li><a href="#">Support</a></li>
						<li><a href="#">Our Company</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
				</div>
				<div class="col-lg-3 col-md-6 col-sm-6 col-12 px-5 mb-5">
					<ul class="tm-social-links d-flex justify-content-end pl-0 mb-5">
						<li class="mb-2"><a href="https://facebook.com"><i
								class="fab fa-facebook"></i></a></li>
						<li class="mb-2"><a href="https://twitter.com"><i
								class="fab fa-twitter"></i></a></li>
						<li class="mb-2"><a href="https://instagram.com"><i
								class="fab fa-instagram"></i></a></li>
						<li class="mb-2"><a href="https://pinterest.com"><i
								class="fab fa-pinterest"></i></a></li>
					</ul>
					<a href="#" class="tm-text-gray text-right d-block mb-2">Terms
						of Use</a> <a href="#" class="tm-text-gray text-right d-block">Privacy
						Policy</a>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8 col-md-7 col-12 px-5 mb-3">Copyright 2020
					Zootube Company. All rights reserved.</div>
				<div class="col-lg-4 col-md-5 col-12 px-5 text-right">
					Designed by <a href="https://templatemo.com" class="tm-text-gray"
						rel="sponsored" target="_parent">Zootube Team</a>
				</div>
			</div>
		</div>
	</footer>

	<script src="<c:url value='/template/other/js/plugins.js'/>"></script>
	<script>
		$(window).on("load", function() {
			$('body').addClass('loaded');
		});
	</script>
</body>
</html>