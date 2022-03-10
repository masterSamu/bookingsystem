/**
 * This script changes checkbox value based on state.
 	used on pages:
 	edit-booking-page.jsp
 */

$(document).ready(function() {
	$("#bookingform input:checkbox").change(function() {
		if ($(this).val() == "true") {
			$(this).val("false");
		} 
		else if ($(this).val() == "false") {
			$(this).val("true");
		}
	}); 
});