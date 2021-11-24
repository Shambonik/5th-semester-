function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}
 
async function sliderChange(){
	var checkboxes = document.getElementsByClassName("slider_checkbox");
	var startSleepTime = 5000;
	var sleepTime = startSleepTime;
	var wait = false;
	var counter = 0;
	for(var i = 0; i<checkboxes.length; i++){
		checkboxes[i].onclick = function(){
			counter = i;
			sleepTime = 15000;
			wait = true;
		}
	}

	while(true){
		wait = false;
		await sleep(sleepTime);
		if(sleepTime == startSleepTime){
			counter = (counter + 1)%checkboxes.length;
			checkboxes[counter].checked = true;
		}
		else if (!wait){
			sleepTime = startSleepTime;
		}
	}
}

window.addEventListener("load", sliderChange);