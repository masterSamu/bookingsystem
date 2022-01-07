/**
 * used in files: 
	bookings-page.jsp, 
	bookings-page-customers.jsp, 
	bookings-page-products.jsp, 
	bookings-page-supplier.jsp
 */

$(document).ready(function() {
	$("#table .bag-icon").click(function() {
		setBookingShipped($(this).attr("id"), $(this));
	})
	
	function hideElement(element) {
		element.remove();
	}
	
	function setBookingShipped(id, element) {
		$.ajax({
			type: "GET",
			url: "shippedbooking",
			data: {
				id: id
			},
			success: hideElement(element.closest("tr"))
		})
	}
})