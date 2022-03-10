<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Varausjärjestelmä</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/tuotteet-style.css" rel="stylesheet">
    <%@ include file="./components/jquery.jsp" %>
</head>
<body>
   <%@ include file="./components/navbar.jsp" %>

    <div class="container-fluid main-container">
        <div class="container-fluid header-container">
            <div class="col-sm-6 col-left">
                <h1 class="page-heade">Varaukset asiakkaalle</h1>
                <p><b>Etunimi:</b> ${customer.firstname } <b>Sukunimi:</b> ${customer.lastname} <b>Sähköposti:</b> ${customer.email } <b>Puhelin</b> ${customer.phone }</p>
            </div>
            <div class="col-sm-6 col-right">
                <a href="/uusivaraus"><button class="btn upper-btn">Lisää uusi varaus</button></a>
            </div>
        </div>
      

        <div class="container-fluid tuote-container">
             <div class="row">
	        	<div class="col-sm-12">
	            	<div class="row">
		        		<div class="col-sm-6">
		        			<input type="text" class="form-control haku-form" name="searchinput" id="searchinput" placeholder="Hae..">
		        		</div>
		        		<div class="col-sm-6">
		        			<button class="btn filterBtn" id="toggleInformedBtn">Ilmoitetut</button>
		            		<button class="btn filterBtn" id="toggleUnInformedBtn">Ilmoittamattomat</button>
		        		</div>
		        	</div>
		            <div class="tooltip-info">
			            <svg class="info-circle" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
			                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
			                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
			            </svg>
		            	<div class="tooltiptext">
		            		<h2 class="tooltip-header">Vinkkejä sivun käyttäjälle</h2>
		            		<h3>Haku</h3>
		            		<p>Voit etsiä millä tahansa taulukon hakusanalla ja taulukossa näkyy vain haetut tiedot. Voit etsiä myös viivakoodilla.</p>
		            		<h3>Lajittelu</h3>
		            		<p>Taulukon otsikoita painamalla voit lajitella taulukossa näkyvät tiedot. Huomaa, että jokaisen otsikon mukaan ei pysty lajittelemaan.</p>
		            		<h3>Suodatus</h3>
		            		<p>Voit suodattaa nälymän ilmoitettujen ja ilmoittamattomien varausten mukaan</p>
		            		<h3>Ilmoitettu</h3>
		            		<p>Checkboxia klikkaamalla voit muuttaa varauksen "ilmoitettu" tilannetta. Jos kyseinen checkbox on valittuna, niin asiakas on ilmoiettu tilassa.</p>
		            		<h3>Toimitettu</h3>
							<p><svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-bag-check bag-icon" viewBox="0 0 16 16">
								 <path fill-rule="evenodd" d="M10.854 8.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
								 <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
								</svg> Kassin näköistä ikonia klikkaamalla varaus siirretään toimitettuihin varauksiin, ja kyseinen rivi poistuu tältä sivulta. Tämän jälkeen se löytyy kuitenkin 
								<a href="/toimitetut-varaukset">Toimitetut varaukset sivulta</a>.
							</p>
							<h3>Lisätiedot</h3>
							<p>Saat lisätiedot näkyviin viemällä hiiren "Lisätiedot" tekstin päälle.</p>
		            		<h3>Poista</h3>
		            		<p>
	            			  	<svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-trash trash-icon" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                                Roskakorin näköistä ikonia klikkaamalla rivi poistuu pysyvästi.
		            		</p>
		            	</div>
		            </div>
	        	</div>
        	</div>

            <div class="table-container">
                <table class="table" id="table">
                    <tr>
                        <th class="th-icon">Ilmoitettu</th>
                        <th class="tableHeader" onclick="sortTable(1)">Tuotekoodi</th>
                        <th class="tableHeader" onclick="sortTable(2)">Tuotteen nimi</th>
                        <th>Tuotekuva</th>
                        <th>Lisätiedot</th>
                        <th class="tableHeader" onclick="sortTable(5)">Määrä</th>
                        <th class="th-icon">Muokkaa</th>
                        <th class="th-icon">Toimitettu</th>
                        <th class="th-icon">Poista</th>
                        <th class="hide">Viivakoodi</th>
                        <th class="hide">Verkkokauppa id</th>
                        <th class="hide">Toimittajat</th>
                    </tr>
                    
                    <c:forEach var="bookingInfo" items="${requestScope.bookings}">
                    <tr class="data">
                        <td class="th-icon">
                            <input type="checkbox" name="informed" id="${bookingInfo.booking.booking_id}" value="${bookingInfo.booking.informed }" <c:if test="${bookingInfo.booking.informed == true }"><c:out value="checked"/></c:if>>
                        </td>
                        <td class="td-bookingpage">
                            <a class="tuote-info" href="/tuotesivu?productid=${bookingInfo.productWithSuppliers.product.product_id }">${bookingInfo.productWithSuppliers.product.productcode }</a>
                        </td>
                        <td class="td-bookingpage">
                            <p class="tuote-info">${bookingInfo.productWithSuppliers.product.name }</p>
                        </td>
                        <td>
                            <img class="tuote-info-img" src="${bookingInfo.productWithSuppliers.product.image }" height="50px" width="50px">
                        </td>
                        <td>
                      		<p class="tuote-info">${bookingInfo.booking.additionalInformation}</p>
                        </td>
                        <td class="tuote-info-amount">
                        	<p class="tuote-info">${bookingInfo.booking.amount }</p>
                        </td>
                        <td class="td-icon">
                        	<a href="/editbooking-page?id=${bookingInfo.booking.booking_id}&p2=${booking.productWithSuppliers.product.product_id}&p3=${bookingInfo.customer.customer_id}">
                        		<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-pencil pencil-icon" viewBox="0 0 16 16">
								  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
								</svg>
                        	</a>
                        </td>
                        <td class="td-icon">
	                       	<svg id="${bookingInfo.booking.booking_id}" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-bag-check bag-icon" viewBox="0 0 16 16">
							  <path fill-rule="evenodd" d="M10.854 8.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 0 1 .708-.708L7.5 10.793l2.646-2.647a.5.5 0 0 1 .708 0z"/>
							  <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
							</svg>
                        </td>
                        <td class="td-icon">
                            <svg id="${bookingInfo.booking.booking_id}" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-trash trash-icon" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                            </svg>
                        </td>
                        <td class="hide">
                        	${bookingInfo.productWithSuppliers.product.barcode }
                        </td>
                        <td class="hide">
                        	${bookingInfo.productWithSuppliers.product.shop_product_id }
                        </td>
                        <td class="hide">
                            <p class="tuote-info">
	                            <c:forEach var="supplier" items="${bookingInfo.productWithSuppliers.suppliers }" >
	                            	<c:out value="<span>${supplier.name}</span>" />
	                            </c:forEach>
                            </p>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </div>
    
    <script src="/js/focus-searchbar.js"></script>
    <script src="/js/tablefilter.js"></script>
    <script src="/js/set-informed-ajax.js"></script>
    <script src="/js/setBookingShipped-ajax.js"></script>
    <script src="/js/deleteBooking-ajax.js"></script>
</body>
</html>