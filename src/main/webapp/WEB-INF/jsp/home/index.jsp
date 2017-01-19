<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<header>
		<script type="text/javascript">	var base_URL = "<%=request.getContextPath()%>";</script>
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css" />
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css" />
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/nivo-slider/nivo-slider.css" />
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css" />
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/custom.css" />
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/feedback.css" />
		<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.js"></script>
		<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/jquery.nivo.slider.js"></script>
		<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
		<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/jspdf.debug.js"></script>
		<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/html2canvas.js"></script>
		<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/html2canvas.svg.js"></script>
		<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/ipos-screenPDF.js"></script>
		<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/optional.js"></script>
	</header>
	<body>
		<div class="container">
			<div class="page row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<img src="<%=request.getContextPath()%>/resources/images/csc-logo.jpg" alt="" class="img-rounded">				
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<h1> This is a page </h1>		
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2">	
						</div>
						<div class="col-xs-2">
							<label> Author: </label>			
						</div>
						<div class="col-xs-8">
							<label> Hung Dong Nguyen </label>			
						</div>
					</div>
					<div class="row">
						<div class="col-xs-2">	
						</div>
						<div class="col-xs-2">
							<label> NRIC:</label>			
						</div>
						<div class="col-xs-8">
							<label> AC1549131 </label>			
						</div>
					</div>	
				</div>				
			</div>
			<div>
				<div class="btn-group button-print" role="group" aria-label="...">
					<button onclick="processPDF()" type="button" class="btn btn-default">Print PDF</button>
					<button onclick="closeIframe()" type="button" class="btn btn-default">Close</button>
				</div>
			</div>
			<div id="parentIframe">				
			</div>						
		</div>		
	</body>
	<footer>
	</footer>
</html>