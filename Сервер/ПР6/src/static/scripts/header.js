function headerOnScroll(){
	posTop = (window.pageYOffset !== undefined) ? window.pageYOffset : (document.documentElement || document.body.parentNode || document.body).scrollTop;
	if(posTop>5){
		header.style.backgroundPosition = '0vmax 0vmax';
	}
	else{
		header.style.backgroundPosition = '0vmax -10vmax';
	}
};

function headerLoad(){
	header.style.backgroundPosition = '0vmax -10vmax';
}

function buttonOnClick(el){
	if(el.classList.contains("active")){
		el.classList.remove("active");
	}
	else{
		el.classList.add("active");
	}
}

window.addEventListener("load", headerLoad);
window.addEventListener("load", headerOnScroll);
window.addEventListener("scroll", headerOnScroll);