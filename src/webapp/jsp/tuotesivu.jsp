<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Varausj‰rjestelm‰</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/tuotesivu-style.css" rel="stylesheet">
</head>
<body>
<%@ include file="./components/navbar.jsp" %>

    <div class="container-fluid main-container">
        <div class="container-fluid header-container">
            <div class="col-sm-6 col-left">
                <h1 class="page-heade">Muokkaa tuotetta</h1>
            </div>
            <div class="col-sm-6 col-right">
                <a href="/lisaatuotesivu"><button class="btn upper-btn">Lis‰‰ uusi tuote</button></a>
            </div>
        </div>
        <div class="container-fuild tuote-container">
            <div class="tooltip-info">
	            <svg class="info-circle" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
	                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
	                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
	            </svg>
            	<div class="tooltiptext">
            		<h2 class="tooltip-header">Vinkkej‰ sivun k‰ytt‰j‰lle</h2>
            		<h3>Pakolliset kent‰t</h3>
            		<ol>
            			<li>Tuotekoodi</li>
            			<li>Tuotteen nimi</li>
            		</ol>
            		<h3>Toimittajan valinta</h3>
            		<p>Valitse tuotteelle toimittaja merkitsem‰ll‰ checkboxi tuotteen kohdalta. Jos haluamaasi toimittajaa ei lˆydy listasta, voit lis‰t‰ uuden <a href="/toimittajat">toimittajat</a> sivulta.</p>
            		<h3>Maksimi merkkim‰‰r‰t</h3>
            		<ol>
	            		<li><b>Tuotekoodi </b>50</li>
	            		<li><b>Viivakoodi </b>255</li>
	            		<li><b>Tuotteen nimi </b>255</li>
	            		<li><b>Linkki verkkokauppaan </b>255 (Huom! Linkki ei saa p‰‰tty‰ .jpeg | .jpg | .gif | .png)</li>
	            		<li><b>Tuotekuvan URL -osoite </b>255 (Huom! Tuotekuvan osoitteen tulee p‰‰tty‰ .jpeg | .jpg | .gif | .png)</li>
	            		<li><b>Lis‰tiedot </b>255</li>
            		</ol>
            	</div>
            </div>
            
	            <form class="tuotetieto-form" name="tuotetieto-form" id="tuotetieto-form" action="/editproduct" method="POST">
                <div class="row">
                    <div class="col-md-6 tuote-left-column">
                        <div class="row">
                            <div class="col-sm-6">
                                <label for="tuotekoodi" class="label-input">Tuotekoodi</label>
                                <input type="text" class="form-control uusituote-input" name="tuotekoodi" id="tuotekoodi" value="${product.productcode }" required>
                            </div>
                            <div class="col-md-6">
                                <label for="viivakoodi" class="label-input">Viivakoodi</label>
                                <input type="text" class="form-control uusituote-input" name="viivakoodi" id="viivakoodi" value="${product.barcode}">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <label for="tuotenimi" class="label-input">Tuotteen nimi</label>
                                <input type="text" class="form-control uusituote-input" name="tuotenimi" id="tuotenimi" value="${product.name }" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <label for="toimittajat" class="label-input">Toimittajat</label>
	                            <div class="div-toimittajat">
		                            <c:forEach var="supplier" items="${requestScope.suppliers }">
		                                <label for="toimittaja" class="label-toimittaja">
		                                <c:if test="${requestScope.selectedProductSuppliers.size() > 0 }">
		                                    <input type="checkbox" name="toimittaja" value="${supplier.supplier_id}" 
		                                <c:forEach var="selectedSP" items="${requestScope.selectedProductSuppliers }">
		                                    <c:if test="${supplier.supplier_id == selectedSP.supplier_id}">checked</c:if> </c:forEach>>
		                                    ${supplier.name}
		                                </c:if>
		                                <c:if test="${requestScope.selectedProductSuppliers.size() == 0 }">
		                                 	<input type="checkbox" name="toimittaja" value="${supplier.supplier_id}">
		                                    ${supplier.name}
		                                </c:if>
		                                </label>
		                            </c:forEach>
	                            </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <label for="linkki" class="label-input">Linkki verkkokauppaan</label>
                                <input type="text" class=" form-control uusituote-input" name="linkki" id="linkToWebsite" value="${product.link }">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <label for="lisatiedot" class="label-input">Lis‰tiedot</label>
                                <textarea class="form-control uusituote-input" name="lisatiedot" id="lisatiedot" >${product.additionalInformation }</textarea>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 tuote-right-column">
                        <div class="row">
                            <img class="img-fluid tuotekuva" src="${product.image }">
                        </div>
                        <div class="row">
                            <div class="col">
                                <label for="kuva-url" class="label-input">Tuotekuvan URL-osoite</label>
                                <textarea class=" form-control uusituote-input" name="kuva-url" id="linkToImage" maxlength="255">${product.image }</textarea>
                            </div>
                        </div>
                    </div>
                </div>
                	<input type="text" class="hide" name="productid" value="${product.product_id}">
                </form>
                
                <div class="submit-row">
                    <div class="submit-col-l">
                        <a href="/uusivaraus-tuote?id=${product.product_id}"><button class="btn btn-blue" >Varaa</button></a>
                    </div>
                    <div class="submit-col-r">
                        <a  href="/deleteproduct?productid=${product.product_id}"><button class="btn btn-delete">Poista</button></a>
                        <button type="submit" form="tuotetieto-form" class="btn btn-save" id="btn-save">Tallenna</button>
                    </div>
                </div>
            </div>
        </div>
        
	<script src="/js/validateAddingInputs.js"></script>
</body>
</html>