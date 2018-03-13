var maxsize = 1048576 * 2;

function buttonSubmitClickedFileupload(event) {
	var el = event.currentTarget;
	var inputId = el.getAttribute('data-input-id');
	var idlist = inputId.split(',');
	for (var i = 0; i < idlist.length; i++) {
		var id = idlist[i].trim();
		var inputEl = document.getElementById(id);
		switch (inputEl.getAttribute('type')) {
		case 'file':
			if (inputEl.value == "") {
				event.preventDefault();
				alert("Please choose a file!");
			} else {
				if (!inputEl.value.match(/.(jpg|jpeg)$/i)) {
					alert('not an image');
				} else if (inputEl.files[0].size > maxsize) {
					alert("file size more then 2 MB");
				} else {
					break;
				}
				event.preventDefault();
			}
			break;

		case 'text':
			if (inputEl.value == null) {
				event.preventDefault();
				alert("Please enter a title!");
			}
			break;
		}
	}

	//
	// alert('elam');
	/*
	 * var form = document.getElementById("my_form"); form.submit();
	 */
}

function buttonSubmitClickedLogin(event) {
	var el = event.currentTarget;
	var inputId = el.getAttribute('data-login-id');
	var idlist = inputId.split(',');
	for (var i = 0; i < idlist.length; i++) {
		var id = idlist[i].trim();
		var inputEl = document.getElementById(id);
		var inputType = inputEl.getAttribute('type');
		inputType = inputType ? inputType.trim() : "";
		switch (inputType) {
		case 'text':
			if (inputEl.value == "") {
				event.preventDefault();
				alert("Please enter a title!");
			}
			break;
		case 'password':
			if (inputEl.value == "") {
				event.preventDefault();
				alert("Please enter a password!");
			}
			break;
		}

	}
}

function dissableField() {
	
	//alert(titelColor1);
	//alert(titelColor2);
	var isDisabled = "disabled";
	
	if (titelColor1.length > 0) {
		document.getElementById("titelcolour1").disabled = isDisabled;
		document.getElementById("browsecol1").disabled = isDisabled;
		document.getElementById("uploadcol1").disabled = isDisabled;
	}
	
	if (titelColor2.length > 0) {
		document.getElementById("titelcolour2").disabled = isDisabled;
		document.getElementById("browsecol2").disabled = isDisabled;
		document.getElementById("uploadcol2").disabled = isDisabled;
	}
	
	if (titelColor3.length > 0) {
		document.getElementById("titelcolour3").disabled = isDisabled;
		document.getElementById("browsecol3").disabled = isDisabled;
		document.getElementById("uploadcol3").disabled = isDisabled;
	}
	
	if (titelColor4.length > 0) {
		document.getElementById("titelcolour4").disabled = isDisabled;
		document.getElementById("browsecol4").disabled = isDisabled;
		document.getElementById("uploadcol4").disabled = isDisabled;
	}

}

function dissablePayField() {
	var ccie = document.getElementById("couponCodeId");
	var pays = document.getElementById("paySubmit");
	// alert(isDisabledPayment+" "+ccie+" " +pays);
	if (isDisabledPayment == "0") {
		pays.setAttribute("disabled", "");
		ccie.setAttribute("disabled", "");
	}
}

function deleteJob(event) {
	if (document.getElementById("titelcolour1").disabled == false
			|| document.getElementById("browsecol1").disabled == false
			|| document.getElementById("uploadcol1").disabled == false) {
		event.preventDefault();
		alert(" nothing to delete");
	}
	
	if (document.getElementById("titelcolour2").disabled == false
			|| document.getElementById("browsecol2").disabled == false
			|| document.getElementById("uploadcol2").disabled == false) {
		event.preventDefault();
		alert(" nothing to delete");
	}
	
	if (document.getElementById("titelcolour3").disabled == false
			|| document.getElementById("browsecol3").disabled == false
			|| document.getElementById("uploadcol3").disabled == false) {
		event.preventDefault();
		alert(" nothing to delete");
	}
	
	if (document.getElementById("titelcolour4").disabled == false
			|| document.getElementById("browsecol4").disabled == false
			|| document.getElementById("uploadcol4").disabled == false) {
		event.preventDefault();
		alert(" nothing to delete");
	}
}

function dissableImageArea() {   // replace image area if image not available
	var img = document.getElementById("col1img");
	var src = img.getAttribute('src');
	var start = "data:image/jpg;base64,";
	if(src && src.length){
		var end = src.substring(start.length);
		if(!end || end.length==0){
		    img.style.display="none";	
		  }
	  }else{
		    img.style.display="none";
	       }
  
}


function lockPage() {
	
	var ccie = document.getElementById("couponCodeId");
	var pays = document.getElementById("paySubmit");
	// alert(isDisabledPayment+" "+ccie+" " +pays);
	if (isDisabledAll == "lock") {
		
		//dissable pay part
		pays.setAttribute("disabled", "");
		ccie.setAttribute("disabled", "");
		
		//dissable colour part		
		document.getElementById("titelcolour1").disabled = isDisabled;
		document.getElementById("browsecol1").disabled = isDisabled;
		document.getElementById("uploadcol1").disabled = isDisabled;
		document.getElementById("deletecol1").disabled = isDisabled;
		event.preventDefault();
		
	}
	
}



function myFunction() {	
    var pass1 = document.getElementById("password").value;
    var pass2 = document.getElementById("confirm_password").value;    
    var ok = true;
    if (pass1 != pass2) {
        alert("Passwords Do not match");
        document.getElementById("password").style.borderColor = "#E34234";
        document.getElementById("confirm_password").style.borderColor = "#E34234";
        ok = false;
    }
    else {
    	ok = true;
    }
    return ok;
}
