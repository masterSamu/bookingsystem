/**
 * This script sets booking to informed
 
 used in files:
	 bookings-page.jsp
	 bookings-page-customers.jsp
	 bookings-page.products.jsp
	 bookings-page.suppliers.jsp
 */

$(document).ready(function() {
	$("#table input:checkbox").change(function() {
		$.ajax({
			type: "POST",
			url: "setinformed",
			data: {
				id: $(this).attr("id"),
				data: $(this).val()
			}
		})
	})
})