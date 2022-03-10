/**
 * Used in files: tuotteet.jsp
 */

$(document).ready(function() {
	$("#table .trash-icon").click(function() {
		deleteProduct($(this).attr("id"), $(this));
	})
	
	function hideElement(element) {
			element.remove();
		}
		
	function deleteProduct(id, element) {
		$.ajax({
			type: "GET",
			url: "deleteproduct",
			data: {
				id: id
			},
			success: hideElement(element.closest("tr"))
		})
	}
})