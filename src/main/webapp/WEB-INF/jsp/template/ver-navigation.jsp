<%@page import="java.util.ArrayList"%>
<%@page import="org.springframework.context.annotation.Import"%>
<%@page import="org.springframework.beans.factory.annotation.Qualifier"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-xs-12 col-sm-4 col-md-3 col-lg-3" id="adivleft">
	<div class="block block-sidebar cs-blsb-martop">
		<div class="block-head">
			<button type="button"
				class="cs-id-button-category pull-right hidden-sm hidden-md hidden-lg"
				id="cs-id-button-category">
				<i class="fa fa-bars"></i>
			</button>
			<h3 class="widget-title">
				<span>
					<div class="circle">
						<i class="fa fa-cogs" style="margin-top: 5px;" aria-hidden="true"></i>
					</div>
				</span> Danh mục sản phẩm
			</h3>
		</div>
		<div class="block-inner cs-xs-block-inner-category">
			<div class="block-list-category">

				<ul id="menuleft">
					<li class="selected"><a rel="nofollow"
						title="Máy lạnh Chiller"
						href="<%=request.getContextPath()%>/product/all"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								Máy lạnh Chiller
							</h2></a>
						<ul class="selected">
							<li><a rel="nofollow" title="MÁY LÀM LẠNH NƯỚC - TATUNG"
								href="<%=request.getContextPath()%>/product/wc">Máy lạnh Chiller giải nhiệt nước</a></li>
							<li><a rel="nofollow" title="MÁY LÀM LẠNH NƯỚC - DAIKIN"
								href="<%=request.getContextPath()%>/product/ac">Máy lạnh Chiller giải nhiệt gió</a></li>
						</ul>
					</li>
					<li class=""><a rel="nofollow" title="MÁY SẤY KHÍ"
						href="/ProductCategory/may_say_khi-56.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								Kho lạnh 
							</h2></a>
						<ul class="">
						</ul>
					</li>					
					<li class=""><a rel="nofollow" title="MÁY HÚT ẨM"
						href="/ProductCategory/may_hut_am-67.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								Máy sấy không khí
							</h2></a>
						<ul class="">

						</ul>
					</li>
				</ul>

			</div>
		</div>
	</div>

	<div class="block block-sidebar cs-blsb-martop"
		style="margin-top: 10px">
		<div class="block-head">
			<button type="button"
				class="cs-id-button-category pull-right hidden-sm hidden-md hidden-lg"
				id="cs-id-button-Services">
				<i class="fa fa-bars"></i>
			</button>
			<h3 class="widget-title">
				<span><i class="fa fa-street-view" aria-hidden="true"></i></span>
				Dịch vụ
			</h3>
		</div>
		<div class="block-inner cs-xs-block-inner-Services">
			<div class="block-list-category">

				<ul id="menuservice">

					<li class=""><a rel="nofollow"
						title="THI CÔNG HỆ THỐNG LẠNH - ỐNG NƯỚC LẠNH, ỐNG GAS"
						href="/Services/thi_cong_he_thong_lanh_-_ong_nuoc_lanh_ong_gas-36.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								THI CÔNG HỆ THỐNG LẠNH - ỐNG NƯỚC LẠNH, ỐNG GAS
							</h2></a>

						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow"
						title="Dịch Vụ Tư Vấn Online &amp; Tư Vấn Tại Chỗ"
						href="/Services/dich_vu_tu_van_online__tu_van_tai_cho-32.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								Dịch Vụ Tư Vấn Online &amp; Tư Vấn Tại Chỗ
							</h2></a>

						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow"
						title="Dịch Vụ Tư Vấn Thiết Kế Hệ Thống Lạnh Công Nghiệp"
						href="/Services/dich_vu_tu_van_thiet_ke_he_thong_lanh_cong_nghiep-31.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								Dịch Vụ Tư Vấn Thiết Kế Hệ Thống Lạnh Công Nghiệp
							</h2></a>

						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow"
						title="Dịch Vụ Sửa Chửa - Bảo trì"
						href="/Services/dich_vu_sua_chua_-_bao_tri-30.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								Dịch Vụ Sửa Chửa - Bảo trì
							</h2></a>

						<ul class="">

						</ul></li>
				</ul>

			</div>
		</div>
	</div>
	<div class="block block-sidebar cs-blsb-martop"
		style="margin-top: 10px">
		<div class="block-head">
			<button type="button"
				class="cs-id-button-category pull-right hidden-sm hidden-md hidden-lg"
				id="cs-id-button-Online">
				<i class="fa fa-bars"></i>
			</button>
			<h3 class="widget-title">
				<span><i class="fa fa-life-ring" aria-hidden="true"></i></span> Hỗ trợ trực tuyến
			</h3>
		</div>
		<div class="block-inner cs-xs-block-inner-online">
			<div class="block-list-category">
				<ul id="menuonline">
					<li>
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tbody>
								<tr>
									<td
										style="text-align: center; vertical-align: middle; width: 12%">
										<i style="font-size: 18px;" class="fa fa-phone-square"
										aria-hidden="true"></i>
									</td>
									<td>
										<a href="#"> Mr. Denny Ou<br>+84 83 7225881</a>
									</td>
								</tr>
								<tr>
									<td
										style="text-align: center; vertical-align: middle; width: 12%">
										<i style="font-size: 18px;" class="fa fa-phone-square"
										aria-hidden="true"></i>
									</td>
									<td>
										<a href="#"> Phone 1<br> +84 1686290668</a>
									</td>
								</tr>
								<tr>
									<td
										style="text-align: center; vertical-align: middle; width: 12%">
										<i style="font-size: 18px;" class="fa fa-phone-square"
										aria-hidden="true"></i>
									</td>
									<td>
										<a href="#"> Phone 2<br> +84 822530885</a>
									</td>
								</tr>
							</tbody>
						</table>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>

