let slides = [];
let index = 0;

function nextSlide(){
	slides[index].classList.remove("active_slide");
	index = (index+1)%slides.length;
	slides[index].classList.add("active_slide")
}

function previousSlide(){
	slides[index].classList.remove("active_slide");
	if(index==0)index = slides.length;
	index--;
	slides[index].classList.add("active_slide")
}

function sliderButtonsLoad(){
	slides= document.querySelectorAll('.slider_buttons_content');
}

window.addEventListener("load", sliderButtonsLoad);