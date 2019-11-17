var checkedEmail = false;
var checkedPW = false;

var emailInput = document.getElementById("email");
var checkEmailBtn = document.getElementById("check_email");

// 비밀번호 확인
function checkPW() {
	var pw1 = document.getElementById("pw").value;
	var pw2 = document.getElementById("check_pw").value;

	// 비밀번호가 입력되지 않은 경우
	if (pw1 == "" || pw2 == "") {
		document.getElementById("check_pw_m").innerHTML = '비밀번호를 입력하세요.';
		checkedPW = false;
	}

	if (pw1 == pw2) {
		document.getElementById("check_pw_m").innerHTML = '비밀번호 확인 완료.';
		checkedPW = true;
	} else {
		document.getElementById("check_pw_m").innerHTML = '비밀번호가 틀렸습니다. 다시 입력해 주세요.';
		checkedPW = false;
	}
}

// 중복확인을 완료하고 이메일을 수정하면 중복확인 취소
emailInput.addEventListener("change", function(event){
	if (checkedEmail === true){
		checkedEmail = false;
		checkEmailBtn.style.backgroundColor = "white";
		checkEmailBtn.style.color = "black";
		document.getElementById("check_email_m").innerHTML = '';
	}
});

// 아이디(email) 중복확인
function checkEmail() {
    var email = document.getElementById("email").value;
    
    // 입력값이 있는 지 확인
    if (email === ''){
    	document.getElementById("check_email_m").innerHTML = '이메일을 입력하세요.';
    	return false;
    }
    
    // 이메일 형식 확인
    if (email !== '/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i') {
    	document.getElementById("check_email_m").innerHTML = '유효한 이메일주소가 아닙니다.';
    	return false;
    }
    
    var xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState == 4 && xhttp.status == 200){
            result = xhttp.responseText;
            if (result === "ok"){
            	checkedEmail = true;
            	checkEmailBtn.style.backgroundColor = "green";
            	checkEmailBtn.style.color = "white";
            	document.getElementById("check_email_m").innerHTML = '사용 가능한 이메일입니다.';
            } else {
            	checkedEmail = false;
            	emailInput.value = "";
            	document.getElementById("check_email_m").innerHTML = '이미 존재하는 이메일입니다.';
            }
        }
    };
       
    xhttp.open('Post', './CheckEmail', true);
    xhttp.setRequestHeader('Content-Type', 'text/plain; charset=UTF-8');
    xhttp.send(email);
}

function checkValue() {
	if(emailInput === ""){
		return false;
	}
	
	if (!checkedEmail) {
        alert('이메일을 확인해주세요!');
        return false;
    } else if (!checkedPW){
		alert('비밀번호확인을 해주세요!');
		return false;
	}

    if (checkPW() && checkName()) {
    	return true;
    }

    return true;
}