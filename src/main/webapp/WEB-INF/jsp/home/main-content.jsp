<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-xs-12 col-sm-8 col-md-9 col-lg-9 cs-thumb-img"
	id="bdivright">
	<div>
		<div class="defaultproject">
			<span class="iscon"><i class="fa fa-puzzle-piece fa-2"
				aria-hidden="true"></i></span> Dự án
		</div>
		<div class="divlineproject"></div>
		<div class="divctbnst">
			<div id="carousel-main-content" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#carousel-main-content" data-slide-to="0" class="active"></li>
			    <li data-target="#carousel-main-content" data-slide-to="1"></li>
			  </ol>
			
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner" role="listbox">
			    <div class="item active">
			      <img src="<%=request.getContextPath()%>/resources/images/dieu_hoa_khong_khi_khu_nha_van_phong_6b753517_9059_4c84_9ab2_4ec3f0f6c3f3.jpg" alt="">
			      <div class="carousel-caption">
			        ...
			      </div>
			    </div>
			    <div class="item">
			      <img src="<%=request.getContextPath()%>/resources/images/he_thong_nuoc_lanh_san_xuat_cha_ca_surimi_a4f57e5c_3606_450b_9583_77f979b28363_2.jpg" alt="">
			      <div class="carousel-caption">
			        ...
			      </div>
			    </div>
			    ...
			  </div>
			
			  <!-- Controls -->
			  <a class="left carousel-control" href="#carousel-main-content" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#carousel-main-content" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
		</div>
		<div class="divlineproject"></div>
		
	</div>
</div>