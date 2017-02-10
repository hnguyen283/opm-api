<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="opmApp" class="mdc-typography">
<head>
<script type="text/javascript">	var base_URL = "<%=request.getContextPath()%>";</script>

<!--Import Material CSS-->

<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/angular-material/angular-material.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/material-components-web.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/custom.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/app.css" />

<title>${title}</title>

	<!-- JQuerry Libraries -->
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.js"></script>
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/Chart.js"></script>
	<!-- Angular Material requires Angular.js Libraries -->
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/angular.js"></script>
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/angular-animate.js"></script>
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/angular-aria.js"></script>
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/angular-messages.js"></script>
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/angular-route.js"></script>
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/angular-chart.js"></script>
	
	<!-- Angular Material Library -->
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/angular-material.js"></script>
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/material-components-web.js"></script>
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/angular-ui-router.js"></script>
	
	<script src="<%=request.getContextPath()%>/resources/app-code/app.js"></script>
	<script src="<%=request.getContextPath()%>/resources/app-code/directive.js"></script>
	<script src="<%=request.getContextPath()%>/resources/app-code/common-service.js"></script>
	<script src="<%=request.getContextPath()%>/resources/app-code/print/print-core.js"></script>
	