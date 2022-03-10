<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
    
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
                <h1 class="page-heade">Tuotteet</h1>
            </div>
            <div class="col-sm-6 col-right">
                <a href="/lisaatuotesivu"><button class="btn upper-btn">Lisää uusi tuote</button></a>
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
		            		<h3>Varaa</h3>
							<p><svg class="plus-icon" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
                                    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                                </svg> Plussa ikonia klikkaamalla voit tehdä varauksen kyseisen rivin tuotteesta.
							</p>
							<h3>Tuotesivu</h3>
							<p>Tuotekoodia klikkaamalla aukeaa tuotekohtainen sivu, missä voi tarkastella kaikkia tuotteen tietoja sekä muokata niitä.</p>
		            		<h3>Poista</h3>
		            		<p>
	            			  	<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-trash trash-icon" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                                Roskakorin näköistä ikonia klikkaamalla rivi poistuu pysyvästi.
		            		</p>
		            	</div>
		            </div>
        	</div>
            <div class="table-container">
                <table class="table" id="table">
                    <tr>
                        <th>Varaa</th>
                        <th class="tableHeader" onclick="sortTable(1)">Tuotekoodi</th>
                        <th class="tableHeader" onclick="sortTable(2)">Tuotteen nimi</th>
                        <th>Toimittajat</th>
                        <th>Linkki</th>
                        <th>Lisätiedot</th>
                        <th>Tuotekuva</th>
                        <th>Varaukset</th>
                        <th>Poista</th>
                        <th class="hide">Viivakoodi</th>
                        <th class="hide">Verkkokauppa id</th>
                    </tr>
                    <c:forEach var="productsList" items="${requestScope.products}">
                    <tr class="data">
                        <td>
                            <a href="/uusivaraus-tuote?id=${productsList.product.product_id }">
                                <svg class="plus-icon" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
                                    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                                </svg>
                            </a>
                        </td>
                        <td class="td-productcode">
                            <a class="tuote-info" href="/tuotesivu?productid=${productsList.product.product_id }">${productsList.product.productcode }</a>
                        </td>
                        <td class="td-product-name">
                            <p class="tuote-info">${productsList.product.name }</p>
                        </td>
                        <td>
                            <p class="tuote-info tuote-info-suppliers">
	                            <c:forEach var="supplier" items="${productsList.suppliers}">
	                            	<span class="supplier-name"><c:out value="${supplier.name}"/></span>
	                            </c:forEach>
                            </p>
                        </td>
                        <td class="td-link">
                            <a class="tuote-info" href="${productsList.product.link }"><c:if test="${fn:length(productsList.product.link) > 0}"><c:out value="linkki"/></c:if></a>
                        </td>
                        <td>
                        	<p class="tuote-info">${productsList.product.additionalInformation}</p>
                        </td>
                        <td>
                            <img class="tuote-info-img" src="${productsList.product.image }" height="75px" width="75px">
                        </td>
                        <td>
                        	<a href="/showbookingsforproduct?id=${productsList.product.product_id }" alt="Linkki tuotekohtaisiin varauksiin">Varaukset</a>
                        </td>
                        <td>
                             <svg class="trash-icon" id="${productsList.product.product_id}" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                 <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                 <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                             </svg>
                        </td>
                        <td class="hide">
                        	${productsList.product.barcode }
                        </td>
                        <td class="hide">
                        	${productsList.product.shop_product_id }
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    </div>
    <script src="/js/focus-searchbar.js"></script>
    <script src="/js/comma-separator-string.js"></script>
    <script src="/js/tablefilter.js"></script>
    <script src="/js/deleteProduct-ajax.js"></script>
</body>
</html>