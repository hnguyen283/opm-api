<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">	var base_URL = "<%=request.getContextPath()%>";</script>
<!--Import Bootstrap CSS-->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css" />

<!--Import Nivo Slider CSS-->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/nivo-slider/nivo-slider.css" />

<!--Import font-awesome CSS-->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css" />

<!--Import custom CSS-->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/custom.css" />

<title>${title}</title>

	<!-- JQuerry Libraries -->
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/jquery-3.1.1.js"></script>
	
	<!-- Nivo Silder -->
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/jquery.nivo.slider.js"></script>
	
	<!-- Bootstrap -->
	<script type="text/javascript"src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
	
	<div class="header-top">
        <div class="container">
            <div class="header-address hidden-xs">
                <i class="fa fa-map-marker"></i>  <span>Số 8 Đường số 2, Kp 4, P.Linh Chiểu, Q.Thủ Đức. Tp.HCM</span>
            </div>
            <div class="pull-right">
                <ul class="list-inline">
                    <li class="circle hidden-xs"><a href="https://twitter.com/" target="_blank"><i class="fa fa-twitter"></i></a></li>
                    <li class="space hidden-xs"></li>
                    <li class="circle hidden-xs"><a href="https://www.facebook.com/" target="_blank"><i class="fa fa-facebook"></i></a></li>
                    <li class="space hidden-xs"></li>
                    <li class="circle hidden-xs"><a href="https://plus.google.com/" target="_blank"><i class="fa fa-google-plus"></i></a></li>
                    <li role="presentation" class="dropdown chat hidden-xs"><a class="dropdown-toggle" href="#" data-toggle="modal" data-target="#myModal">
                        <span class="text">Live chat</span><span class="fa fa-comments-o icon"></span></a></li>
                    <div class="modal fade" id="myModal" role="dialog" aria-hidden="true" style="display: none;"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal">×</button><h4 class="modal-title"> Hỗ trợ trực tuyến</h4></div><div class="modal-body"><table class="table table-condensed"><thead><tr><th>Chat</th><th>Họ Tên:</th><th>Vị trí:</th></tr></thead><tbody><tr><td><a href="skype:ngocsinh168?chat">    <i class="fa fa-skype"></i></a></td><td>Lưu Ngọc Sinh</td><td>Kinh doanh</td></tr><tr><td><a href="skype:ngocvi16461?chat">    <i class="fa fa-skype"></i></a></td><td>Ngoc Vi</td><td>NVVP</td></tr><tr><td><a href="skype:khoanm.sinhthinh?chat">    <i class="fa fa-skype"></i></a></td><td>Nguyễn Minh Khoa</td><td>Kinh Doanh</td></tr></tbody></table></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button> </div></div></div></div>
                    <li role="presentation" class="dropdown lang"><a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><span class="fa fa-globe icon"></span><span>Tiếng Việt</span><span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/language/english.gss" title="English">English</a></li>
                            <li><a href="/language/vietnamese.gss" title="Tiếng Việt">Tiếng Việt</a></li>
                        </ul>
                    </li>
                    
                </ul>
            </div>
        </div>
    </div>
