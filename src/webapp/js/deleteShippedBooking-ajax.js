/**
 * used in files: 
	show-shippedbookings-page.jsp, 
 */

$(document).ready(function() {
	$("#table .trash-icon").click(function() {
		hideElement($(this).closest("tr"));
		deleteBooking($(this).attr("id"));
	})
	
	function hideElement(element) {
		element.remove();
	}
	
	function deleteBooking(id) {
		$.ajax({
			type: "GET",
			url: "deleteshippedbooking",
			data: {
				id: id
			}
		})
	}
})