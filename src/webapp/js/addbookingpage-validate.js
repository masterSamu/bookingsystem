/**
 * Addbooking pages scripts.
 */


$(document).ready(function() {

	$("#submit-booking-btn").attr("disabled", true);
	$(".input-amount").attr("disabled", true);
	/**
	Enable button if input field's value is more than 0 and at least 1 checkbox is checked
	 */ 

// Listen products checkbox changes
	
		$(".ul-booking-elements-products input:checkbox").change(function() {
			
		if ($(this).is(":checked")) {
			$(this).parent("div").siblings(".container-input-amount").find("input").attr("disabled", false);
			$(this).parent("div").siblings(".container-input-amount").find("input").val(1);
		} else {
			$(this).parent("div").siblings(".container-input-amount").find("input").attr("disabled", true);
			$(this).parent("div").siblings(".container-input-amount").find("input").val(null);
		}
		
		if ($(".ul-booking-elements-products input:checkbox:checked").length > 0 && $(".ul-booking-elements-customers input:checkbox:checked").length > 0) {
			$("#submit-booking-btn").attr("disabled", false);
		} else {
			$("#submit-booking-btn").attr("disabled", true);
		}
		
	})
	 
	// Listen customer checkbox changes
	$(".ul-booking-elements-customers input:checkbox").change(function() {
		if ($(".ul-booking-elements-customers input:checkbox:checked").length > 0 && $(".ul-booking-elements-products input:checkbox:checked").length > 0) {
			$("#submit-booking-btn").attr("disabled", false);
		} else {
			$("#submit-booking-btn").attr("disabled", true);
		}
	})
	
	// Listen input field changes
	$(".input-amount").change(function() {
		if ($(this).val() > 0 && $(".ul-booking-elements-products").find("input:checkbox:checked").length > 0 && $(".ul-booking-elements-customers input:checkbox:checked").length > 0) {
			console.log($(this).val())
			$("#submit-booking-btn").attr("disabled", false);
		} 
		else {
			$("#submit-booking-btn").attr("disabled", true);
		}
		

	})
	
	// Filter customer list

  $("#search-list-input-customers").on("keyup", function() {
	  console.log("customers");
	    var value = $(this).val().toLowerCase();
	    $(".ul-booking-elements-customers").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	});

  
  // Filter product list
  $("#search-list-input-products").on("keyup", function() {
	  console.log("products");
	    var value = $(this).val().toLowerCase();
	    $(".ul-booking-elements-products").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
  	});
	
	
});
