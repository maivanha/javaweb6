function Search() {
	var xhttp;
	var name = document.formSearch.search.value;

	if(name != "") {
		var url = "SearchAction?name="+name;

		if(window.XMLHttpRequest) {
			xhttp=new XMLHttpRequest();
		} else {
			xhttp = new ActiveXObject("microsoft.XMLHttp");
		}
		xhttp.onreadystatechange = function() {
			if(xhttp.readyState == 4) {
				var data = xhttp.responseText;
				document.getElementById("searchh").innerHTML = data;
				document.getElementById("searchh").style.display = "block";
			}
		}
		xhttp.open("POST",url,true);
		xhttp.send();
	} else {
		document.getElementById("searchh").innerHTML = "";
	}
}


function LoadFormCart(para) {
	var xhttp;
	//alert(para);
	var url = "BuyProduct?codeProduct=" + para;

	if (window.XMLHttpRequest) {
		xhttp = new XMLHttpRequest();
	} else {
		xhttp = new ActiveXObject("microsoft.XMLHttp");
	}
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			var data = xhttp.responseText;
			document.getElementById("cart").innerHTML = data;
			document.getElementById(id).style.display = "block";
		}
	}
	xhttp.open("GET", url, true);
	xhttp.send();
}


function LoadFormOrder() {
	var xhttp;
	//alert(para);
	var email = document.formcheckOrder.email.value;
	var url = "CheckOrders?email=" + email;

	if (window.XMLHttpRequest) {
		xhttp = new XMLHttpRequest();
	} else {
		xhttp = new ActiveXObject("microsoft.XMLHttp");
	}
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			var data = xhttp.responseText;
			document.getElementById("checkOrder").innerHTML = data;
		}
	}
	xhttp.open("POST", url, true);
	xhttp.send();
}

//var bt = document.getElementById("fff")
//window.onclick = function(event) {
//if(event.target == bt){
////searchh.style.display = "block";
//document.getElementById("searchh").style.display = "block";
//} else {
////searchh.style.display = "none";
//document.getElementById("searchh").style.display = "none";
//}





//var div = document.getElementById("searchh");
//var text = document.getElementById("search");
//text.addEventListener("click", function(event) {
//	div.style.display = "block";
//	event.stopPropagation();
//	
//});
//
//document.body.addEventListener("click", function() {
//	div.style.display = "none";
//});


function LoadFormLogin(url) {
	var xhttp;

		if(window.XMLHttpRequest) {
			xhttp=new XMLHttpRequest();
		} else {
			xhttp = new ActiveXObject("microsoft.XMLHttp");
		}
		xhttp.onreadystatechange = function() {
			if(xhttp.readyState == 4) {
				document.getElementById("myModal").innerHTML = xhttp.responseText;
				myModal.style.display = "block";
			}
		}
		xhttp.open("POST",url,true);
		xhttp.send();
}


function hidepopup(id) {
	document.getElementById(id).style.display = "none";
}

function showpopup(id, url) {
	var xhttp;
	//var url = "GetListCartAction";

	if (window.XMLHttpRequest) {
		xhttp = new XMLHttpRequest();
	} else {
		xhttp = new ActiveXObject("microsoft.XMLHttp");
	}
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			var data = xhttp.responseText;
			document.getElementById("cart").innerHTML = data;
		}
	}
	xhttp.open("GET", url, true);
	xhttp.send();
	document.getElementById(id).style.display = "block";
}

function changeCountBuy(codeProduct, i) {
	var xhttp;
	var count = document.getElementsByName("countbuy")[i].value;
	var url = "ChangeCountBuy?codeProduct=" + codeProduct +"&countBuy=" + count;
	//alert(count);
	if (window.XMLHttpRequest) {
		xhttp = new XMLHttpRequest();
	} else {
		xhttp = new ActiveXObject("microsoft.XMLHttp");
	}
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			var data = xhttp.responseText;
			document.getElementById("cart").innerHTML = data;
		}
	}
	xhttp.open("GET", url, true);
	xhttp.send();
	document.getElementById(id).style.display = "block";
}
