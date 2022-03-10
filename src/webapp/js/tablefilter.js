/**
 * Scripts for filtering and sorting tables
 */
 


 document.addEventListener("DOMContentLoaded", function(){
 	displayTableRows();
});


function displayTableRows() {
 var trData = document.querySelectorAll(".data");
 	for (var i = 0; i < trData.length; i++) {
    	trData[i].style.display = "table-row";
 	}
};

$(document).ready(function(){
	  $("#searchinput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $(".table tr.data").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	  
	  $("#toggleInformedBtn").on("click", function() {
	  		showOnlyInformedRows(0);
	  		$(this).toggleClass("btnActive");
			togglePropDisabled($("#toggleUnInformedBtn"));
			
	  });
  
	  $("#toggleUnInformedBtn").on("click", function() {
	  	showOnlyUninformedRows(0);
	  	$(this).toggleClass("btnActive");
		togglePropDisabled($("#toggleInformedBtn"));
	  });
  
	
	function togglePropDisabled(element) {
		if (element.prop('disabled') === false) {
			element.prop('disabled', true);
		} else if (element.prop('disabled')) {
			element.prop('disabled', false);
		}
	}

});

function showOnlyUninformedRows(n) {
	let table2 = document.getElementById("table");
	let rows = table2.rows;

	for (var i = 1; i < rows.length; i++) {
		let tdData = rows[i].getElementsByTagName("td")[n];
		let checkboxValue = tdData.getElementsByTagName("input")[0].value;
		if (rows[i].style.display === 'table-row') {
			if (checkboxValue === "true") {
				rows[i].style.display = "none";
			}
		} else {
			rows[i].style.display = "table-row";
		}
	}
}


// Toggle ilmoitettu to visible
function showOnlyInformedRows(n) {
	var table2 = document.getElementById("table");
	var rows = table2.rows;
	
	for (var i = 1; i < rows.length; i++) {
		let tdData = rows[i].getElementsByTagName("td")[n];
		let checkboxValue = tdData.getElementsByTagName("input")[0].value;
		if (rows[i].style.display === 'table-row') {
			if (checkboxValue === "false") {
				rows[i].style.display = "none";
			}
		} else {
			rows[i].style.display = "table-row";
		}
		
	}
}


// Sort function (Call at onclick="")
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("table");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc";
 
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
      // Start by saying there should be no switching:
      shouldSwitch = false;
      /* Get the two elements you want to compare,
      one from current row and one from the next: */
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /* Check if the two rows should switch place,
      based on the direction, asc or desc: */
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          // If so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          // If so, mark as a switch and break the loop:
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      // Each time a switch is done, increase this count by 1:
      switchcount ++;
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}