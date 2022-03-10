/**
 * Addbooking pages scripts.
 */


$(document).ready(function() {
	$("#submit-booking-btn").attr("disabled", true);
	$(".input-amount").attr("disabled", true);
	
	/**
	Enable button if input field's value is more than 0 and at least 1 checkbox is checked
	 */ 
	 
	// Listen checkbox changes
	$("#bookingform input:checkbox").change(function() {
			
		if ($(this).is(":checked")) {
			$(this).parent("div").siblings(".container-input-amount").find("input").attr("disabled", false);
			$(this).parent("div").siblings(".container-input-amount").find("input").val(1);
		} else {
			$(this).parent("div").siblings(".container-input-amount").find("input").attr("disabled", true);
			$(this).parent("div").siblings(".container-input-amount").find("input").val(null);
		}
		
		if ($("#bookingform input:checkbox:checked").length > 0) {
			$("#submit-booking-btn").attr("disabled", false);
		} else {
			$("#submit-booking-btn").attr("disabled", true);
		}
		
	})
	
	// Listen input field changes
	$(".input-amount").change(function() {
		if ($(this).val() > 0 && $("#bookingform input:checkbox:checked").length > 0) {
			$("#submit-booking-btn").attr("disabled", false);
		} 
		else {
			$("#submit-booking-btn").attr("disabled", true);
		}
		

	})
	
	
	
	
	
});