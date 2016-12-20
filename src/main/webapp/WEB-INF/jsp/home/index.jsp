<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>
	
<!-- 	This is controller -->
	<script src="<%=request.getContextPath()%>/resources/app-code/home/home-controller.js"></script>
</head>
<body layout="row" ng-controller="HomeController">
	<div layout="column" layout-fill role="main">
		<div lazy-scroll="paginationFuntion()" lazy-scroll-trigger="80" >
			<md-content layout="column">				
		  	</md-content>   
	  	</div>
	</div>
  	
<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>   