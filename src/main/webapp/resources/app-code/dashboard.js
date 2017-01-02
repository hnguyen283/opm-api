/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
$(window).on('load', function() { 
	$.a_jquery_function();
	
});

var products = [{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669439","number":"0","image":"1450669439_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482250890","number":"0","image":"1482250890_image.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669410","number":"0","image":"1450669410_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669382","number":"0","image":"1450669382_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669341","number":"0","image":"1450669341_cummaychillertrucvit40hp.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1451354444","number":"0","image":"1451354444_hinh1.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482378989","number":"0","image":"1482378989_1image.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482251403","number":"0","image":"1482251403_image-1.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482144542","number":"0","image":"1482144542_untitled-3.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482213845","number":"0","image":"1482213845_untitled-5.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482145186","number":"0","image":"1482145186_untitled-6.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1451355721","number":"0","image":"1451355721_hinh3.jpg","description":"Đang cập nhật"}];

$(document).ready(function() {


	$.a_jquery_function = function loadRuntime() {		
		
		$('#product_list').append(getProducts);
	}
	
	function getProducts() {
		var template = ""
		var pathname = window.location.pathname;
		if(pathname.indexOf("wc")!=-1){
			
		}else if(pathname.indexOf("ac")!=-1){
			
		}else{
			
		}
	}

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

