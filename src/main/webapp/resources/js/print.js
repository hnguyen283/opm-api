var dataPDF = undefined;
function processPDF(){	
	var pdf = new jsPDF('p','pt','a4');
	var pages =  document.getElementsByClassName("page");
	var cursor = 0;	
	renderPage(pages,cursor,pdf,function(){		
		dataPDF = pdf.output('datauristring');
	});
}

function renderPage(pages,cursor,pdf,callback){
	if (cursor === (pages.length - 1)){
		var widthPage = pages[cursor].offsetWidth;
		pdf.addHTML(pages[cursor], 0, 0,{
			'width': widthPage
		},callback);
	}else{
		var width = pages[cursor].offsetWidth;
		pdf.addHTML(pages[cursor], 0, 0,{
			'width': widthPage
		},function(){
			pdf.addPage();
			renderPage(pages,++cursor,pdf,callback);
		});		
	}
}

window.onload = processPDF();