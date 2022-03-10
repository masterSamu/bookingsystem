<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
                <h1>Toimittaja - ${supplier.name} <a href="/showbookingsforsupplier?id=${supplier.supplier_id}"><button class="btn btn-blue">Katso varaukset</button></a></h1>
            </div>
            <div class="col-sm-6 col-right">
                <a href="/lisaatoimittajasivu"><button class="btn upper-btn">Lis‰‰ uusi toimittaja</button></a>
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
            			<li>Toimittajan nimi</li>
            		</ol>
            		<h3>Maksimi merkkim‰‰r‰t</h3>
            		<ol>
	            		<li><b>Toimittajan nimi </b>255</li>
	            		<li><b>Lis‰tiedot </b>255</li>
            		</ol>
            	</div>
            </div>
            
            <form name="tieto-form" id="tieto-form" action="/editsupplier" method="POST">
                <div class="row">
                    <div class="col">
                        <div class="row">
                            <div class="col">
                                <label for="nimi">Toimittajan nimi</label>
                                <input type="text" class="form-control uusituote-input" name="nimi" id="nimi" value="${supplier.name}" maxlength="255" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <label for="lisatiedot">Lis‰tiedot</label>
                                <textarea class="form-control uusituote-input" name="lisatiedot" id="lisatiedot" maxlength="255">${supplier.additionalInformation}</textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="text" class="hide" name="id" id="id" value="${supplier.supplier_id}">
             </form>   
                
                <div class="submit-row">
                    <div class="submit-col-r">
                        <a href="deletesupplier?id=${supplier.supplier_id }"><button class="btn btn-delete">Poista</button></a>
                        <input type="submit" form="tieto-form" class="btn btn-save" value="Tallenna">
                    </div>
                </div>
            </div>
        </div>
	</div>

</body>
</html>