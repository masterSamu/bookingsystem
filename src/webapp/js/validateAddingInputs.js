/**
 * Used in files: addproduct.jsp and editproduct.jsp
 */

const linkInput = document.getElementById("linkToWebsite");
const linkToImageInput = document.getElementById("linkToImage");
const btnSave = document.getElementById("btn-save");
const linkToWebsiteErrorMessage = document.getElementById("linkToWebsiteErrorMessage");
const linkToImageErrorMessage = document.getElementById("linkToImageErrorMessage");



linkInput.addEventListener('blur', (event) => {
	let inputField = event.target;
	let inputContent = inputField.value;
	let errorMsg = "Virheellinen tiedostomuoto antamassasi URL osoitteessa."
	if(checkUrlForImageExtension(inputContent)) {
		enableInputFieldError(inputField, linkToWebsiteErrorMessage, errorMsg, btnSave);
	} else {
		disableInputFieldError(inputField, linkToWebsiteErrorMessage, btnSave);
	}
});


linkToImageInput.addEventListener('blur', (event) => {
	let inputField = event.target;
	let inputContent = inputField.value;
	let errorMsg = "Antamasi URL osoitteen pääte ei ole tuettu tiedostomuoto."
	if (inputContent !== "") {
		if(!checkUrlForImageExtension(inputContent)) {
			enableInputFieldError(inputField, linkToImageErrorMessage, errorMsg, btnSave)
		} else {
			disableInputFieldError(inputField, linkToImageErrorMessage, btnSave);
		}
	} else {
		disableInputFieldError(inputField, linkToImageErrorMessage, btnSave);
	}
})


function disableInputFieldError(input, errorMsgElement, button) {
		input.classList.remove("inputFieldError");
		errorMsgElement.classList.add("hide");
		button.disabled = false;
}

function enableInputFieldError(input, errorMsgElement, errorMsg, button) {
		input.classList.add("inputFieldError");
		errorMsgElement.classList.remove("hide");
		errorMsgElement.innerHTML = errorMsg;
		button.disabled = true;
}

function checkUrlForImageExtension(url) {
    return(url.match(/\.(jpeg|jpg|gif|png)$/) != null);
}