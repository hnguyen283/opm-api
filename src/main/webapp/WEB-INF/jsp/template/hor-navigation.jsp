<%@page import="java.util.ArrayList"%>
<%@page import="org.springframework.context.annotation.Import"%>
<%@page import="org.springframework.beans.factory.annotation.Qualifier"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/home.css" />

<div>
	<div id="slider" class="nivoSlider"> 
	<img src="<%=request.getContextPath()%>/resources/images/header_banner/0542de90ea_d068_40ad_855c_da904b0b2300_.jpg" data-thumb="resources/images/header_banner/0542de90ea_d068_40ad_855c_da904b0b2300_.jpg" alt="" /> 
	<img src="<%=request.getContextPath()%>/resources/images/header_banner/hinh_03769e88e8_9643_4715_a01f_bdd9428b3e2e_.jpg" data-thumb="resources/images/header_banner/hinh_03769e88e8_9643_4715_a01f_bdd9428b3e2e_.jpg" alt="" />
	</div>
</div>
	
<nav>
  <div class="container-fluid" style="padding-right: 0px;padding-left: 0px;">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="menu">
      <ul class="nav navbar-nav">
<!--         <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li> -->
        <li><a href="#">Giới thiệu</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Máy lạnh Chiller<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/product/wc">Máy lạnh Chiller giải nhiệt nước</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="<%=request.getContextPath()%>/product/ac">Máy lạnh Chiller giải nhiệt gió</a></li>           
          </ul>
        </li>
        <li><a href="#">Bể chứa băng</a></li>
        <li><a href="#">Kho lạnh</a></li>
        <li><a href="#">Máy sấy không khí</a></li>
        <li><a href="<%=request.getContextPath()%>/service">Dịch vụ</a></li>
        <li class="pull-right"><a class="glyphicon glyphicon-phone"> 01686290668</a></li>
      </ul>     
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="row">
	<div class="col-md-12">
		<ol class="breadcrumb">
		  <li><a href="<%=request.getContextPath()%>">Trang chủ</a></li>
		</ol>
	</div>
</div>