let animItems = [];
function animOnScroll(){
	for (let i = 0; i < animItems.length; i++){
		const animItem = animItems[i];
		if(!animItem.classList.contains("active_anim")){
			const animItemHeight = animItem.offsetHeight;
			const rect = animItem.getBoundingClientRect();
			const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
			const animItemOffset = rect.top + scrollTop;
			const animStart = 6;

			let animItemPoint = window.innerHeight - animItemHeight / animStart;

			if(animItemHeight > window.innerHeight){
				animItemPoint = window.innerHeight - window.innerHeight/animStart;
			}


			if (pageYOffset > animItemOffset - animItemPoint){
				animItem.classList.add("active_anim");
			}
		}
	}
}


function animationLoad(){
	animItems= document.querySelectorAll('.anim_item');
}

window.addEventListener("load", animationLoad);
window.addEventListener("load", animOnScroll);
window.addEventListener("scroll", animOnScroll);
window.addEventListener("resize", animOnScroll);