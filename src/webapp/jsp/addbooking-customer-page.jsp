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
    <link href="css/addbooking-style.css" rel="stylesheet">
    <%@ include file="./components/jquery.jsp" %>
</head>
<body>
   <%@ include file="./components/navbar.jsp" %>
<div class="container-fluid main-container">

	      <div class="container-fluid header-container">
	            <div class="col-sm-6 col-left">
	                <h1 class="page-heade"></h1>
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
            		<h3>Varauksen tekeminen</h3>
            		<ol>
	            		<li>Tarkista, että olet valinnut halutun asiakkaan.</li>
	            		<li>Valitse vähintään 1 tuote</li>
	            		<li>Valitse valituille tuotteille lukumäärä. (0 ei kelpaa lukumääräksi.)</li>
	            		<li>Paina <button class="btn btn-save">Tallenna</button> nappia sivun oikeasta alakulmasta</li>
            		</ol>
            		<h3>Haku</h3>
            		<p>Voit etsiä tuotteita millä tahansa näkyvällä informaatiolla, lisäksi voit etsiä myös viivakoodilla.</p>
            	</div>
		   </div>    
          <form id="bookingform" action="/addbooking-customer" method="POST">
              <div class="row">
                      <div class="col-sm-4">
                          <h2 class="form-header">Asiakkaan tiedot</h2>
                          <div class="row left-container">
                                 <label class="label-input">Etunimi:</label><p class="tuote-info">${customer.firstname}</p>
                                 <label class="label-input">Sukunimi:</label><p>${customer.lastname}</p>
                                 <label class="label-input">Sähköposti:</label><p>${customer.email}</p>
                                 <label class="label-input">Puhelin:</label><p>${customer.phone}</p>
                                 <label class="label-input">Lisätiedot:</label><p>${customer.additionalInformation}</p>
                                 <input type="text" class="hide" name="customer_id" value="${customer.customer_id}">
                          </div>
                      </div> 
                      <div class="col-sm-8">
                          <h2 class="form-header">Valitse tuotteet</h2>
                          <div class="row right-container">
                   			<input type="text" class="form-control" id="search-list-input-products" placeholder="Hae tuotetta..">
                              <ul class="ul-booking ul-booking-products" id="ul-booking">
                              	<c:forEach var="product" items="${requestScope.products }" varStatus="productsLoop">
                                  <li>
                                     <div class="ul-booking-elements">
                                      	<div class="container-checkbox">
                                     		<input type="checkbox" class="ul-booking-li-element" name="checkbox-products" id="checkbox-products-${productsLoop.index}" value="${product.product_id }">
                                       </div>
                                        <span class="hide">${product.barcode }</span>
                                        <label for="checkbox-products-${productsLoop.index}">
                                        	<span class="">${product.productcode }</span>
                                        </label>
                                        <div class="container-product-name">
                                        	<label for="checkbox-products-${productsLoop.index}">
                                        		<span class="">${product.name }</span>
                                       		</label>
                                        </div>
                                        <label for="checkbox-products-${productsLoop.index}">
                                        	<img class="image-fluid small-image" src="${product.image}" height="50px">
                                        </label>
                                        <div class="container-input-amount">
	                                      <label class="input-amount-label" >lkm:</label>
	                                      <input type="number" class="input-amount" name="amount" min="1">
                                     	</div>
                                     </div>
                                  <c:if test="${!productsLoop.last}"><hr class="li-element-hr"></c:if>
                                  </li>
                                 </c:forEach>
                              </ul>
                          </div>
                      </div>
              </div>
              <div class="row submit-row">
                   <div class="col submit-left-column">
                		<label class="label-input">Varauksen lisätiedot:</label>
                	</div>
                	<div class="col submit-middle-column">
                		<textarea class="form-control input-textarea" name="additionalInformation" maxlength=255></textarea>
                	</div>
                	<div class="col submit-right-column">
                  		<input type="submit" class="btn btn-save" id="submit-booking-btn" value="Tallenna">
                	</div>
               </div>
            </form>
        </div>
    </div>
    
    <script src="/js/addbooking.js"></script>
    <script src="/js/search-list.js"></script>
</body>
</html>