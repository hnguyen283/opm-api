<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/template/header.jsp"></jsp:include>
	
<!-- 	This is controller -->
	<script src="<%=request.getContextPath()%>/resources/app-code/home/home-controller.js"></script>
</head>
<body ng-cloak layout="column" ng-controller="HomeController as home">
<!-- Container #1 (see wireframe)  -->
  <md-toolbar layout="row" class="md-toolbar-tools">  	
    <h1>DEMO - jsPDF</h1>
  </md-toolbar>

  <div flex layout="row" layout-wrap>
    <md-content flex id="content">
		<div layout="column">
		  <div layout="row" layout-align="center center">
			  <div flex="30">
			  	<md-card layout layout-padding>
				  	<img ng-src="{{imagePath}}csc-logo.jpg" alt="">
          		</md-card>
			  </div>
		  </div>
		  <div layout="row" layout-align="center center">
			  <div flex="50">
			  	<md-card layout layout-padding>
				  	<div class="mdc-textfield mdc-textfield--upgraded">
					  <input type="text" id="pre-filled" class="mdc-textfield__input" value="Pre-filled value">
					  <label class="mdc-textfield__label mdc-textfield__label--float-above" for="pre-filled">
					    Label in correct place
					  </label>
					</div>
          		</md-card>
			  </div>
  			  <div flex="50">
			  	<md-card layout layout-padding>
				  	<div class="mdc-textfield mdc-textfield--upgraded">
					  <input type="text" id="pre-filled" class="mdc-textfield__input" value="Pre-filled value">
					  <label class="mdc-textfield__label mdc-textfield__label--float-above" for="pre-filled">
					    Label in correct place
					  </label>
					</div>
          		</md-card>
			  </div>
		  </div>
		  <div layout="row" layout-align="center center">
			  <div flex="80">
			  	<canvas id="bar" class="chart chart-bar" chart-data="data" chart-labels="labels" chart-series="series">
				</canvas>
			  </div>
		  </div>
		  <div layout="row">
			<div flex="100" id="parentIframe" >
			</div>
		  </div>
		</div>
    </md-content>
  </div>
	<div>
		<div class="btn-group button-print" role="group" aria-label="...">			
			<button class="mdc-button mdc-button--raised" ng-click="processPDF();">Print PDF</button>
			<button class="mdc-button mdc-button--raised" ng-click="closeIframe();">Close</button>
		</div>
	</div>
<jsp:include page="/WEB-INF/jsp/template/footer.jsp"></jsp:include>   