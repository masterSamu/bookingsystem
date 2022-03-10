<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
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
    <link href="css/tuotesivu-style.css" rel="stylesheet">
    <%@ include file="./components/jquery.jsp" %>
</head>
<body>
<%@ include file="./components/navbar.jsp" %>

    <div class="container-fluid main-container">
        <div class="container-fluid header-container">
            <div class="col-sm-6 col-left">
                <h1 class="page-heade">Varauksen tiedot</h1>
            </div>
            <div class="col-sm-6 col-right">
            </div>
        </div>
            
            <div class="container-fluid tuote-container">
	            <div class="tooltip-info">
			            <svg class="info-circle" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
			                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
			                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
			            </svg>
		            	<div class="tooltiptext">
		            		<h2 class="tooltip-header">Vinkkejä sivun käyttäjälle</h2>
		            		<h3>Yleistä</h3>
		            		<p>Tällä sivulla voit tarkastella kaikkia yksittäiseen varaukseen liittyviä tietoja. Sekä muokata varausta. Tuotetietoja tai asiakastietoja ei pysty tällä sivulla muokkaamaan. Niiden muokkaamista varten pitää mennä <a href="/asiakkaat">asiakas</a> tai <a href="/tuotteet">tuotteet</a> sivulle.</p>
		            		<h3>Varauksen tietojen muokkaaminen</h3>
		            		<p>Voit asettaa varauksen ilmoitettu tilaan.<br> Voit muokata varaukseen sisältyvän tuotteen lukumäärää.<br> Voit muokata varaukseen liittyviä lisätietoja.</p>
		            		<h3>Tallenna</h3>
							<p>Painamalla <button class="btn btn-save">Tallenna</button> näköistä painiketta, varauksen tiedot päivittyy tietokantaan.</p>
							<h3>Toimitettu</h3>
							<p>Painamalla <button class="btn btn-blue">Toimitettu</button> näköistä painiketta, varaus siirtyy toimitetuksi. Ja löytyy tämän jälkeen toimitettujen varausten <a href="/toimitetut-varaukset">sivulta.</a></p>
		            		<h3>Poista</h3>
		            		<p>Painamalla <button class="btn btn-delete">Poista</button> näköistä painiketta, varaus poistuu pysyvästi.</p>
		            	</div>
		            </div>
                <div class="row add-new-product-container">
                    <div class="col-md-6 tuote-left-column-booking">
                        <h2>Tuotteen tiedot</h2>
                       <div class="product-container">
	                        <div class="row">
	                        	<div class="col-sm-10">
	                        		<label class="label-input" for="productname">Tuotteen nimi:</label>
	                        		<span id="productname">${product.name }</span>
	                        	</div>
	                        </div>
	                        <div class="row">
	                       		<div class="col-sm-6">
	                        		<label class="label-input" for="productcode">Tuotekoodi:</label>
	                        		<span id="productcode">${product.productcode }</span>
	                        	</div>
	                            <div class="col-sm-6">
	                                <label class="label-input" for="linkki">Linkki:</label>
	                                <a href="${product.link}">Verkkokauppaan</a>
	                            </div>
	                        </div>
	                        <div class="row">
	                            <div class="col-sm-6">
	                                <label class="label-input" for="toimittajat" class="label-input">Toimittajat</label>
		                            	<ul class="supplier-list">
		                           		<c:forEach var="suppliers" items="${requestScope.suppliers }">
	                            			<li><a href="toimittajasivu?id=${suppliers.supplier_id}">${suppliers.name }</a></li>
			                            </c:forEach>
			                            </ul>
	                            </div>
	                            <div class="col-sm-6">
	                            	<img class="img-fluid product-image-booking" src="${product.image }">
	                            </div>
	                        </div>
	                        <div class="row">
	                            <div class="col">
	                                <label class="label-input" for="lisatiedot">Lisätiedot:</label>
	                                <p>${product.additionalInformation }</p>
	                            </div>
	                        </div>
	                    </div>
					</div>
					
                    <div class="col-sm-6 tuote-right-column-booking">
                   	<h2>Asiakkaan tiedot</h2>
                     <div class="customer-container">
	                        <div class="row">
	                            <div class="col">
	                              	<label class="label-input" for="firstname">Etunimi:</label>
	                                <span id="firstname">${customer.firstname }</span>
	                            </div>
                            </div>
                            <div class="row">
	                            <div class="col">
	                            	<label class="label-input" for="lastname">Sukunimi:</label>
	                                <span id="firstname">${customer.lastname }</span>
	                            </div>
	                        </div>
	                        <div class="row">
	                            <div class="col">
	                                <label class="label-input" for="email">Sähköposti:</label>
	                                <span id="email">${customer.email }</span>
	                            </div>
                            </div>
                            <div class="row">
	                            <div class="col">
	                                <label class="label-input" for="phone">Puhelin:</label>
	                                <span id="phone">${customer.phone }</span>
	                            </div>
                            </div>
	                        
	                        <div class="row">
	                            <div class="col-sm-12">
	                                <label class="label-input" for="additionalInformation">Lisätiedot:</label>
	                                <span id="additionalInformation">${customer.additionalInformation }</span>
	                            </div>
	                      	</div>
                      </div>
                      
                   	<h2>Varauksen tiedot</h2>
                      <div class="booking-container">
                    	<form id="bookingform" action="/editbooking" method="POST">
	                        <div class="row">
	                        	<div class="col-sm-6 col-booking-info">
                        	  		<label class="label-input" for="informed">Ilmoitettu:</label>
                              		<input type="checkbox" class="informed-checkbox" name="informed" id="informed-${booking.booking_id}" value="${booking.informed }" <c:if test="${booking.informed == true }"><c:out value="checked"/></c:if>>
	                        	</div>
	                        	<div class="col-sm-6 col-booking-info">
	                        		<label class="label-input" >lkm:</label>
                                    <input type="number" class="input-amount" name="amount" min="1" value="${booking.amount }">
	                        	</div>
	                        </div>
	                        <div class="row">
	                            <div class="col">
	                                <label class="label-input" for="kuva-url">Lisätiedot:</label>
	                                <textarea class="form-control uusituote-input" name="additionalInformation" maxlength="255">${booking.additionalInformation }</textarea>
	                                <input type="number" class="hide" name="bookingid" value="${booking.booking_id}">
	                            </div>
	                        </div>
		                </form>
                	</div>
                    </div>
                </div>
                
                <div class="submit-row">
                    <div class="submit-col-l">
                     	<a  href="/deletebooking?id=${booking.booking_id}"><button class="btn btn-delete">Poista</button></a>
                    </div>
                    <div class="submit-col-r">
                   		<a href="/shippedbooking?id=${booking.booking_id}"><button class="btn btn-blue">Toimitettu</button></a>
                        <button type="submit" form="bookingform" class="btn btn-save">Tallenna</button>
                    </div>
                </div>
            </div>
	
	</div>
	
	<script src="/js/set-informed-value.js"></script>
</body>
</html>