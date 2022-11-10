window.onload = function() {
	var arr = document.getElementsByClassName("purchaseNum");

	for (var i = 0; i < arr.length; i++) {
		if( arr[i].innerText == 0){		
			arr[i].innerText = '-';
		}else{
			arr[i].innerText = arr[i].innerText + '개';
		}
	}	
}
