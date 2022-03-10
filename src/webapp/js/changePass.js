/**
 *  This script validates form fields before submitting password change.
 */

$(document).ready(function() {
	
	$("#userform").submit(function(e) {
		if ($("#username").val() == "") {
			e.preventDefault();
			$("#message").addClass("error");
			$("#message").text("Virheellinen käyttäjätunnus");
		}
		
		if ($("#oldPassword").val() == "") {
			e.preventDefault();
			$("#message").addClass("error");
			$("#message").text("Virheellinen vanha salasana");
		}
		
		if ($("#newPassword1").val() != $("#newPassword2").val()) {
			e.preventDefault();
			$("#message").addClass("error");
			$("#message").text("Salasanat eivät täsmää");
		}
	})
	
});