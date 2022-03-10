/**
 *  used in pages:
 	addbooking-product-page.jsp
 	addbooking-customer-page.jsp
 */

$(document).ready(function(){
  $("#search-list-input-customers").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $(".ul-booking-customers li").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });

  });
  
  $("#search-list-input-products").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $(".ul-booking-products li").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});