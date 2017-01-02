/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
$(window).on('load', function() { 
	$('#slider').nivoSlider({
		effect : 'random',
		slices : 15,
		boxCols : 8,
		boxRows : 4,
		animSpeed : 500,
		pauseTime : 3000,
		startSlide : 0,
		directionNav : false,
		controlNav : false,
		controlNavThumbs : false,
		pauseOnHover : true,
		manualAdvance : false,
		prevText : 'Prev',
		nextText : 'Next',
		randomStart : false,
		beforeChange : function() {
		},
		afterChange : function() {
		},
		slideshowEnd : function() {
		},
		lastSlide : function() {
		},
		afterLoad : function() {
		}
	});
});

var products = [{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669439","number":"0","image":"1450669439_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482250890","number":"0","image":"1482250890_image.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669410","number":"0","image":"1450669410_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669382","number":"0","image":"1450669382_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669341","number":"0","image":"1450669341_cummaychillertrucvit40hp.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1451354444","number":"0","image":"1451354444_hinh1.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482378989","number":"0","image":"1482378989_1image.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482251403","number":"0","image":"1482251403_image-1.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482144542","number":"0","image":"1482144542_untitled-3.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482213845","number":"0","image":"1482213845_untitled-5.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482145186","number":"0","image":"1482145186_untitled-6.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1451355721","number":"0","image":"1451355721_hinh3.jpg","description":"Đang cập nhật"}];

$(document).ready(function() {

	var jsonDealsNew = null;
	var jsonDealsNearDead = null;

	$(".product_click").click(
			function(e) {
				$("#bodyNew").html('');
				if (toggleSort)
					toggleSort = false
				else
					toggleSort = true;
				$("#bodyNew").html('');
				if (sizeOfDeal < currenPoint)
					currenPoint = sizeOfDeal;
				$("#preloading").removeClass("loaded");
				getDeals(toggleSort, "getbybegintime",
						"#bodyNew", 0, currenPoint);
				$("#preloading").addClass("loaded");
			});
});

