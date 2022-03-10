<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/lisaatuote-style.css" rel="stylesheet">
    <title>Varausjärjestelmä</title>
</head>
<body>   

<%@ include file="./components/navbar.jsp" %>

    <div class="container-fluid main-container">
        <div class="container-fluid header-container">
            <div class="col col-left">
                <h1 class="page-heade">Muokkaa asiakasta</h1>
            </div>
        </div>
        <div class="container-fuild tuote-container">
           <div class="tooltip-info">
	            <svg class="info-circle" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
	                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
	                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
	            </svg>
            	<div class="tooltiptext">
            		<h2 class="tooltip-header">Vinkkejä sivun käyttäjälle</h2>
            		<h3>Pakolliset kentät</h3>
            		<ol>
            			<li>Sähköposti</li>
            		</ol>
            		<h3>Maksimi merkkimäärät</h3>
            		<ol>
	            		<li><b>Etunimi</b>100</li>
	            		<li><b>Sukunimi</b>100</li>
	            		<li><b>Sähköposti</b>255</li>
	            		<li><b>Puhelin</b>20</li>
	            		<li><b>Lisätiedot</b>255</li>
            		</ol>
            	</div>
		   </div>    
            <div class="container-fluid inner-container">

                <form class="tuotetieto-form" action="/editcustomer" method="POST">
                    <div class="row">
                        <div class="col">
                            <label for="firstname" class="label-input">Etunimi</label>
                            <input type="text" class="form-control uusituote-input" name="firstname" id="firstname" value="${customer.firstname }" maxlength="100">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="lastname" class="label-input">Sukunimi</label>
                            <input type="text" class="form-control uusituote-input" name="lastname" id="lastname" value="${customer.lastname }" maxlength="100">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="email" class="label-input">Sähköposti</label>
                            <input type="text" class=" form-control uusituote-input" name="email" id="email" value="${customer.email }" required maxlength="255">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="phone" class="label-input">Puhelin</label>
                            <input type="text" class=" form-control uusituote-input" name="phone" id="phone" value="${customer.phone }" maxlength="20">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="additionalInformation" class="label-input">Lisätiedot</label>
                            <textarea class="form-control uusituote-input" name="additionalInformation" id="additionalInformation" maxlength="255">${customer.additionalInformation }</textarea>
                        </div>
                    </div>
                    <input type="text" class="hide" name="customer_id" value="${customer.customer_id }">
                    <div class="submit-row">
                        <input type="submit" class="btn btn-save" value="Tallenna">
                    </div>
                </form>

                </div>
            </div>
        </div>
        
</body>
</html>