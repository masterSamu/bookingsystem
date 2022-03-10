<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Varausj�rjestelm�</title>
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
                <h1 class="page-heade">Asiakkaat</h1>
            </div>
            <div class="col-sm-6 col-right">
                <a href="/lisaa-asiakas"><button class="btn upper-btn">Lis�� uusi asiakas</button></a>
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
		            		<h2 class="tooltip-header">Vinkkej� sivun k�ytt�j�lle</h2>
		            		<h3>Haku</h3>
		            		<p>Voit etsi� mill� tahansa taulukon hakusanalla ja taulukossa n�kyy vain haetut tiedot. Voit etsi� my�s viivakoodilla.</p>
		            		<h3>Lajittelu</h3>
		            		<p>Taulukon otsikoita painamalla voit lajitella taulukossa n�kyv�t tiedot. Huomaa, ett� jokaisen otsikon mukaan ei pysty lajittelemaan.</p>
		            		<h3>Varaa</h3>
							<p><svg class="plus-icon" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
                                    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                                </svg> Plussa ikonia klikkaamalla voit tehd� varauksia kyseisen rivin asiakkaalle.
							</p>
							<h3>Muokkaa</h3>
							<p>
								<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-pencil pencil-icon" viewBox="0 0 16 16">
								  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
								</svg>
								Kyn�n n�k�ist� ikonia klikkaamalla avautuu asiakas kohtainen sivu, josta voi muokata asiakkaan tietoja.
							</p>
		            		<h3>Poista</h3>
		            		<p>
	            			  	<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-trash trash-icon" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                                Roskakorin n�k�ist� ikonia klikkaamalla asiakas poistuu pysyv�sti. Samalla poistuu my�s asiakkaan varaustiedot.
		            		</p>
		            	</div>
		            </div>
        	</div>
            
            <div class="table-container">
                <table class="table">
                    <tr>
                        <th>Varaa</th>
                        <th>Etunimi</th>
                        <th>Sukunimi</th>
                        <th>S�hk�posti</th>
                        <th>Puhelin</th>
                        <th>Varaukset</th>
                        <th>Muokkaa</th>
                        <th>Poista</th>
                    </tr>
                    <c:forEach var="customer" items="${requestScope.customers }">
                    <tr class="data">
                        <td>
                            <a href="/uusivaraus-asiakas?id=${customer.customer_id }">
                                <svg class="plus-icon" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-plus-square" viewBox="0 0 16 16">
                                    <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                                    <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                                </svg>
                            </a>
                        </td>
                        <td class="td-customer-fname">
                            <p class="tuote-info">${customer.firstname }</p>
                        </td>
                        <td class="td-customer-lname">
                            <p class="tuote-info">${customer.lastname }</p>
                        </td>
                        <td class="td-customer-email">
                            <p class="tuote-info">${customer.email }</p>
                        </td>
                        <td class="td-customer-phone">
                            <p class="tuote-info">${customer.phone }</p>
                        </td>
                        <td>
                        	<a href="/showbookingsforcustomer?id=${customer.customer_id }">Varaukset</a>
                        </td>
                        <td>
                        	<a href="/editcustomerpage?id=${customer.customer_id }">
                        		<svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-pencil pencil-icon" viewBox="0 0 16 16">
								  <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
								</svg>
                        	</a>
                        <td>
                            <a href="/deletecustomer?id=${customer.customer_id }">
                                <svg class="trash-icon" xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                </svg>
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </div>
    </div>
    <script src="/js/focus-searchbar.js"></script>
    <script src="/js/tablefilter.js"></script>
</body>
</html>