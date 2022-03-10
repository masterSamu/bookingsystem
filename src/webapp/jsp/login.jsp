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
    <link href="/css/main.css" rel="stylesheet">
    <link href="/css/login-style.css" rel="stylesheet">
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must re-validate"); // HTTP 1.1
	response.setHeader("Progma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies
 %>
 
    <div class="container main-container">
        <div class="container login-container">
            <h1 class="page-header">Kirjaudu sis‰‰n</h1>
            <div class="tooltip-info">
	            <svg class="info-circle" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
	                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
	                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
	            </svg>
            	<div class="tooltiptext">
            		<h2 class="tooltip-header">Vinkkej‰ sivun k‰ytt‰j‰lle</h2>
            		<h3>Kirjautuminen</h3>
            		<p>Sivustolle p‰‰seminen vaatii oikeat k‰ytt‰j‰tunnukset. Pyyd‰ tunnukset sivuston yll‰pit‰j‰lt‰.</p>
            	</div>
		   </div>    
            <form id="login-form" action="/validateuser" method="POST">
                <div class="mb-3">
                    <input type="text" name="username" class="form-control" placeholder="K‰ytt‰j‰tunnus" maxlength="32" required >
                </div>
                <div class="mb-3">
                    <input type="password" name="password" class="form-control" placeholder="Salasana" required>
                </div>
                <button type="submit" class="btn button">Kirjaudu sis‰‰n</button>
            </form>
            <p class="error">${requestScope.loginErrorMessage}</p>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>