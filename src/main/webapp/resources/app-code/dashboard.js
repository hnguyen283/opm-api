/**
 * author: Nguyen Dong Hung
 * 
 * 
 */
var products = [{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669439","number":"0","image":"1450669439_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482250890","number":"0","image":"1482250890_image.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669410","number":"0","image":"1450669410_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669382","number":"0","image":"1450669382_cummaychillertrucvitgiainhietnuo.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1450669341","number":"0","image":"1450669341_cummaychillertrucvit40hp.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1451354444","number":"0","image":"1451354444_hinh1.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482378989","number":"0","image":"1482378989_1image.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482251403","number":"0","image":"1482251403_image-1.jpg","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt nước","type":"WC","code":"1482144542","number":"0","image":"1482144542_untitled-3.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482213845","number":"0","image":"1482213845_untitled-5.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1482145186","number":"0","image":"1482145186_untitled-6.png","description":"Đang cập nhật"},{"title":"Máy lạnh Chiller giải nhiệt gió","type":"AC","code":"1451355721","number":"0","image":"1451355721_hinh3.jpg","description":"Đang cập nhật"}];

$(document).ready(function() {


	$.a_jquery_function = function loadRuntime() {		
		
		$('#product_list').append(getProducts);
	}
	
	function getProducts() {
		var pathname = window.location.pathname;
		if(pathname.indexOf("wc")!=-1){
			var products_by_type = getProductsByType("wc");
			return genCards(products_by_type);
		}else if(pathname.indexOf("ac")!=-1){
			var products_by_type = getProductsByType("ac");
			return genCards(products_by_type);
		}else{
			return genCards(products);
		}
	}
	
	function getProductsByType(type) {
		var results = [];	
		for(var i = 0; i < products.length;i++){
			if(products[i].type.toLowerCase() === type.toLowerCase()){
				results.push(products[i]);
			}
		}
		return results;
	}
	
	function genCards(dataIn) {
		var results = "";	
		for(var i = 0; i < dataIn.length;i++){
			var imageSRC = base_URL + "/resources/images/products/" + dataIn[i].image;
			var productURL = base_URL + "/product/detail/" + dataIn[i].code;
//			var template = "<div class=\"col-md-3\"><div class=\"card\"><div class=\"card-image\"><img class=\"img-responsive\" src=\"" + imageSRC + "\"><span class=\"card-title\">" + dataIn[i].title + "</span></div><div class=\"card-content\"><p>" + dataIn[i].title + "</p></div><div class=\"card-action\"><a href=\"product/detail/"+ dataIn[i].code + "\" target=\"new_blank\">Chi tiết</a></div></div></div>"
			var template = "<div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\"><div class=\"card\"><div class=\"card-image\"><img class=\"img-responsive\" src=\"" + imageSRC + "\"><span class=\"card-title\"></span></div><div class=\"card-content\"><p>" + dataIn[i].title + "</p></div><div class=\"card-action\"><a href=\""+ base_URL + "/product/detail/" + dataIn[i].code + "\">Chi tiết</a></div></div></div>"
//			var template = "<div class=\"col-xs-12 col-sm-3 col-md-3 col-lg-3\"><div class=\"card\"><div class=\"card-image\"><div class=\"image\"><div class=\"img-overflow\"><a href=\""+ productURL + "\" title=\""+ dataIn[i].title + "\"><img src=\"" + imageSRC + "\"></a><div class=\"ImageOverlay\"></div><div class=\"CStyle\"><ul class=\"function\"></ul></div></div></div><span class=\"card-title\"></span></div><div class=\"card-content\"><p>" + dataIn[i].title + "</p></div><div class=\"card-action\"><a href=\""+ productURL + "\">Chi tiết</a></div></div></div>"
			results = results + template;
		}
		return results;
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
	$.a_jquery_function();
});
