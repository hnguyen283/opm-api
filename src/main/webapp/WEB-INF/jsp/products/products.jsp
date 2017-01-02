<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>
	
<!-- 	This is controller -->
	<script src="<%=request.getContextPath()%>/resources/app-code/home/home-controller.js"></script>
</head>
<body class="option1">
	<div class="container">
		<div class="container-fluid">
			<jsp:include page="/WEB-INF/jsp/template/hor-navigation.jsp"></jsp:include>
			<div class="row">
				<div class="col-md-12">
					<ol class="breadcrumb">
					  <li><a href="">Home</a></li>
					</ol>
				</div>
			</div>			
			<div class="row">
				<jsp:include page="/WEB-INF/jsp/products/airConditionerChiller.jsp"></jsp:include>
				<jsp:include page="/WEB-INF/jsp/template/ver-navigation.jsp"></jsp:include>
			</div>
		</div>
	</div>

<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>   