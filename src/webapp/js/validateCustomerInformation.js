/**
 * Used in files: addNewCustomerPage.jsp
 */

const emailInput = document.getElementById("email");
let emailExist = false;
let message = "Tällä sähköpostilla on jo asiakas.";
let warningMessage = document.getElementById("emailWarningMessage");

$(document).ready(function() {
	$("#email").blur(function() {
		validateEmail();
	});
})

function validateEmail() {
	$.getJSON("getcustomeremails", function(json) {
		for (let item of json) {
			if (item === $("#email").val()) {
				emailExist = true;
			}
		}
		showWarning(emailExist);
	});
}

function showWarning(boolean) {
	if (emailExist) {
		emailInput.classList.add("inputFieldWarning");
		warningMessage.classList.remove("hide");
		warningMessage.innerHTML = "Tällä sähköpostilla on jo asiakas.";
		
	} else {
		emailInput.classList.remove("inputFieldWarning");
		warningMessage.classList.add("hide");
		warningMessage.innerHTML = "";
	}
}