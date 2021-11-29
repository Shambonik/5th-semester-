let checkboxes = [];
let products = [];

function checkedChange(){
	if(!checkboxes[0].checked && !checkboxes[1].checked && !checkboxes[2].checked && !checkboxes[3].checked){
		for(let i = 0; i<products.length; i++){
			products[i].style.visibility = "visible";
			products[i].style.position = "relative";
		}
		return;
	}
	for(let i = 0; i<products.length; i++){
		if(products[i].classList.contains("milk")){
			if(checkboxes[0].checked){
				products[i].style.visibility = "visible";
				products[i].style.position = "relative";
			}
			else{
				products[i].style.visibility = "hidden";
				products[i].style.position = "absolute";
			}
		}
		if(products[i].classList.contains("dark")){
			if(checkboxes[1].checked){
				products[i].style.visibility = "visible";
				products[i].style.position = "relative";
			}
			else{
				products[i].style.visibility = "hidden";
				products[i].style.position = "absolute";
			}
		}
		if(products[i].classList.contains("white")){
			if(checkboxes[2].checked){
				products[i].style.visibility = "visible";
				products[i].style.position = "relative";
			}
			else{
				products[i].style.visibility = "hidden";
				products[i].style.position = "absolute";
			}
		}
		if(products[i].classList.contains("mix")){
			if(checkboxes[3].checked){
				products[i].style.visibility = "visible";
				products[i].style.position = "relative";
			}
			else{
				products[i].style.visibility = "hidden";
				products[i].style.position = "absolute";
			}
		}
	}
}


function checkboxLoad(){
	products = document.querySelectorAll(".product_item");
	checkboxes.push(document.querySelector(".checkbox_type.milk"));
	checkboxes.push(document.querySelector(".checkbox_type.dark"));
	checkboxes.push(document.querySelector(".checkbox_type.white"));
	checkboxes.push(document.querySelector(".checkbox_type.mix"));
}

window.addEventListener("load", checkboxLoad);