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
     <%@ include file="./components/jquery.jsp" %>
</head>
<body>   

<%@ include file="./components/navbar.jsp" %>

    <div class="container-fluid main-container">
        <div class="container-fluid header-container">
            <div class="col col-left">
                <h1 class="page-heade">Asetukset</h1>
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
	           		<p>Kaikki kentät ovat pakollisia</p>
	           	</div>
           </div>
            <div class="container-fluid inner-container">
                <form class="tuotetieto-form" id="userform" action="/changepassword" method="POST">
                    <div class="row">
                        <div class="col">
                            <label for="username" class="label-input">Käyttäjätunnus</label>
                            <input type="text" class="form-control uusituote-input" name="username" id="username" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="password" class="label-input">Vanha salasana</label>
                            <input type="password" class="form-control uusituote-input" name="oldPassword" id="oldPassword" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="newPassword1" class="label-input">Uusi salasana</label>
                            <input type="password" class="form-control uusituote-input" name="newPassword1" id="newPassword1" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label for="newPassword2" class="label-input">Vahvista uusi salasana</label>
                            <input type="password" class=" form-control uusituote-input" name="newPassword2" id="newPassword2" required>
                        </div>
                    </div>
                    <div class="submit-row">
                        <input type="submit" class="btn btn-save" value="Tallenna">
                    </div>
                </form>
                <div class="message-div ${classname}" id="message-div">
   					<span id="message">${message}</span>
				</div>
            </div>
        </div>
       </div>
       
        <script src="/js/changePass.js"></script>
</body>
</html>