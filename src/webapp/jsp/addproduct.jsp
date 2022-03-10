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
    <link href="css/addbooking-style.css" rel="stylesheet">
</head>
<body>
<%@ include file="./components/navbar.jsp" %>

    <div class="container-fluid main-container">
        <div class="container-fluid header-container">
            <div class="col-sm-6 col-left">
                <h1 class="page-heade">Lis‰‰ uusi tuote</h1>
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
		            
               <form class="tuotetieto-form" action="/lisaatuote" method="POST">
                <div class="row">
                    <div class="col-lg-7">
                        <h2 class="form-header">Tuotteen tiedot</h2>
                       <div class="row left-container product-info-container">
	                        <div class="row">
	                        <div class="col-sm-6">
	                            <label class="label-input" for="tuotekoodi">Tuotekoodi</label>
	                            <input type="text" class="form-control uusituote-input" name="tuotekoodi" id="tuotekoodi" maxlength="50" required>
	                        </div>
	                        <div class="col-sm-6">
	                            <label class="label-input" for="viivakoodi">Viivakoodi</label>
	                            <input type="text" class="form-control uusituote-input" name="viivakoodi" id="viivakoodi" maxlength="255">
	                        </div>
		                    <div class="row">
		                        <div class="col">
		                            <label class="label-input" for="tuotenimi">Tuotteen nimi</label>
		                            <input type="text" class="form-control uusituote-input" name="tuotenimi" id="tuotenimi" maxlength="255" required>
		                        </div>
		                    </div>
		                   </div>
		                    <div class="row">
		                        <div class="col">
		                            <label class="label-input" for="linkki">Linkki verkkokauppaan</label>
		                            <input type="text" class="form-control uusituote-input" name="linkki" id="linkToWebsite" maxlength="255">
		                            <div class="errorMsg hide" id="linkToWebsiteErrorMessage"></div>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col">
		                            <label class="label-input" for="kuva-url">Tuotekuvan URL-osoite</label>
		                            <input type="text" class=" form-control uusituote-input" name="kuva-url" id="linkToImage" maxlength="255">
		                        	<div class="errorMsg hide" id="linkToImageErrorMessage"></div>
		                        </div>
		                    </div>
		                    <div class="row">
		                        <div class="col">
		                            <label class="label-input" for="lisatiedot">Lis‰tiedot</label>
		                            <textarea class="form-control uusituote-input" name="lisatiedot" id="lisatiedot" maxlength=255></textarea>
		                        </div>
		                    </div>
	                    </div>
					</div>
					
                    <div class="col-lg-5">
                   	<h2 class="form-header">Valitse toimittajat</h2>
                      <div class="row right-container">
	                        <div class="row">
                            	<ul class="ul-new-product">
	                            <c:forEach var="supplier" items="${requestScope.suppliers }" varStatus="supplierLoop">
	                                <li>
	                                    <input type="checkbox" class="supplier-checkbox" name="toimittaja" id="supplier-${supplierLoop.index}" value="${supplier.supplier_id}">
		                                <label for="supplier-${supplierLoop.index}" class="label-toimittaja">
		                                    <span><b>${supplier.name}</b></span> 
		                                    <span>${supplier.additionalInformation }</span>
		                                </label>
	                                </li>
	                                <c:if test="${!supplierLoop.last}"><hr class="li-element-hr"></c:if>
	                            </c:forEach>
	                            </ul>
	                        </div>
                		</div>
                    </div>
                </div>
                <div class="submit-row">
                    <div class="col submit-right-column">
	                	<div class="col-sm-12">
                   			<input type="submit" class="btn btn-save" id="btn-save" value="Tallenna">
                   		</div>
                	</div>
                </div>
            </form>
        </div>
      </div>
      
      <script src="/js/validateAddingInputs.js"></script>
</body>
</html>