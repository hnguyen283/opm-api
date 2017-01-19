
function processPDF(){		
	var html = loadPage(window.location.href + "/print");
	var iframe = document.createElement('iframe');
	iframe.setAttribute('style','position: absolute;width:1080px; height:780px;top: 10px;visibility: hidden;');
	iframe.setAttribute('id','iframeHTML');
	document.getElementById("parentIframe").appendChild(iframe);
	var docIframe = iframe.document;
    if(iframe.contentDocument)
    	docIframe = iframe.contentDocument; // For NS6
    else if(iframe.contentWindow)
    	docIframe = iframe.contentWindow.document; // For IE5.5 and IE6
    // Put the content in the iframe
    docIframe.open();
    docIframe.writeln(html);
    docIframe.close();
    checkStatus(function(pdf){
    	showPDF(pdf);
    });	
}

function showPDF(pdf){
	$('#iframeHTML').remove();
	var iframe = document.createElement('iframe');
	iframe.setAttribute('style','position: absolute;width:95%; height:780px;left: 30px;top: 10px;');
	iframe.setAttribute('id','iframePDF');
	iframe.src = pdf;
	document.getElementById("parentIframe").appendChild(iframe);
}

function checkStatus(callback){
	var myFrame = window.frames[0].window;
	var pdf = myFrame.dataPDF;
	if(pdf){
		callback(pdf);
	}else{
		setTimeout(function(){
			checkStatus(callback);
		}, 1000);	
	}
}

function closeIframe(){		
	$('#iframePDF').remove();
}

function loadPage(href){
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", href, false);
    xmlhttp.send();
    return xmlhttp.responseText;
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


function getPageHeight(){
	var body = document.body,
    html = document.documentElement;
	return Math.max( body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight );
}