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
						title="MÁY LÀM LẠNH NƯỚC"
						href="/ProductCategory/may_lam_lanh_nuoc-52.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								MÁY LÀM LẠNH NƯỚC
							</h2></a>
						<ul class="selected">
							<li><a rel="nofollow" title="MÁY LÀM LẠNH NƯỚC - TATUNG"
								href="/ProductSub/52/may_lam_lanh_nuoc_-_tatung-154.gss">MÁY
									LÀM LẠNH NƯỚC - TATUNG</a></li>
							<li><a rel="nofollow" title="MÁY LÀM LẠNH NƯỚC - DAIKIN"
								href="/ProductSub/52/may_lam_lanh_nuoc_-_daikin-178.gss">MÁY
									LÀM LẠNH NƯỚC - DAIKIN</a></li>
							<li><a rel="nofollow" title="MÁY LÀM LẠNH NƯỚC - KINGAIR"
								href="/ProductSub/52/may_lam_lanh_nuoc_-_kingair-195.gss">MÁY
									LÀM LẠNH NƯỚC - KINGAIR</a></li>
						</ul></li>
					<li class=""><a rel="nofollow" title="MÁY SẤY KHÍ"
						href="/ProductCategory/may_say_khi-56.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								MÁY SẤY KHÍ
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow"
						title="PHỤ TÙNG &amp; VẬT TƯ PHỤ"
						href="/ProductCategory/phu_tung__vat_tu_phu-65.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								PHỤ TÙNG &amp; VẬT TƯ PHỤ
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow" title="MÁY HÚT ẨM"
						href="/ProductCategory/may_hut_am-67.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								MÁY HÚT ẨM
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow" title="MÁY LẠNH TỦ ĐỨNG"
						href="/ProductCategory/may_lanh_tu_dung-69.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								MÁY LẠNH TỦ ĐỨNG
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow" title="MÁY TẠO KHÍ NITƠ - RICH"
						href="/ProductCategory/may_tao_khi_nito_-_rich-70.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								MÁY TẠO KHÍ NITƠ - RICH
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow" title="AHU - FCU"
						href="/ProductCategory/ahu_-_fcu-74.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								AHU - FCU
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow" title="MÁY NÉN KHÍ"
						href="/ProductCategory/may_nen_khi-76.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								MÁY NÉN KHÍ
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow" title="THIẾT BỊ TRAO ĐỔI NHIỆT"
						href="/ProductCategory/thiet_bi_trao_doi_nhiet-77.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								THIẾT BỊ TRAO ĐỔI NHIỆT
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow" title="THÁP GIẢI NHIỆT"
						href="/ProductCategory/thap_giai_nhiet-78.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								THÁP GIẢI NHIỆT
							</h2></a>
						<ul class="">

						</ul></li>
					<li class=""><a rel="nofollow" title="BƠM NƯỚC"
						href="/ProductCategory/bom_nuoc-79.gss"><h2>
								<i class="fa fa-chevron-circle-right" aria-hidden="true"></i>
								BƠM NƯỚC
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
				<span><i class="fa fa-life-ring" aria-hidden="true"></i></span> Hỗ
				trợ trực tuyến
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
										<i style="font-size: 18px;" class="fa fa-skype"
										aria-hidden="true"></i>
									</td>
									<td><a href="skype:ngocsinh168?chat"> Lưu Ngọc Sinh<br>
											0918998566
									</a></td>
								</tr>
							</tbody>
						</table>
					</li>
					<li>
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tbody>
								<tr>
									<td
										style="text-align: center; vertical-align: middle; width: 12%">
										<i style="font-size: 18px;" class="fa fa-skype"
										aria-hidden="true"></i>
									</td>
									<td><a href="skype:khoanm.sinhthinh?chat"> Nguyễn Minh
											Khoa<br> 0916508839
									</a></td>
								</tr>
							</tbody>
						</table>
					</li>
					<li>
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tbody>
								<tr>
									<td
										style="text-align: center; vertical-align: middle; width: 12%">
										<i style="font-size: 18px;" class="fa fa-skype"
										aria-hidden="true"></i>
									</td>
									<td><a href="skype:ngocvi16461?chat"> Ngoc Vi<br>

									</a></td>
								</tr>
							</tbody>
						</table>
					</li>
					<li><a class="dropdown-toggle pull-right" href="#"
						data-toggle="modal" data-target="#myModal"><span
							style="padding-top: 2px; float: left;"> Xem thêm</span>
							<div class="circle">
								<i class="fa fa-angle-double-right" aria-hidden="true"></i>
							</div></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>

