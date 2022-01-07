/**
 * used in files: 
	bookings-page.jsp, 
	bookings-page-customers.jsp, 
	bookings-page-products.jsp, 
	bookings-page-supplier.jsp
 */

$(document).ready(function() {
	$("#table .trash-icon").click(function() {
		deleteBooking($(this).attr("id"), $(this));
	})
	
	function hideElement(element) {
		element.remove();
	}
	
	function deleteBooking(id, element) {
		$.ajax({
			type: "GET",
			url: "deletebooking",
			data: {
				id: id
			},
			success: hideElement(element.closest("tr"))
		})
	}
})