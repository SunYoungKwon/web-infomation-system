
function check() {
	var sign = document.getElementById("sign").value;
	var num2 = document.getElementById("num2").value;
	num2 = Number(num2);		// num2를 Number타입으로 변경
	
	// 0으로 나누기하는지 확인
	if (sign === "div" && num2 === 0) {
		document.getElementById("msg").style.display = 'block';		// Show error message
		document.getElementById("num2").value = "";					// Delete 'num2' value
	} else {
		document.getElementById("msg").style.display = 'none';		// Hide error message
	}
}