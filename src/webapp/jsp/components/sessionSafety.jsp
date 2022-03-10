
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must re-validate"); // HTTP 1.1
	response.setHeader("Progma", "no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies
	if (session.getAttribute("auth") == null) {
		response.sendRedirect("/login");
	} else if ((boolean)session.getAttribute("auth") == false) {
		response.sendRedirect("/login");
	}

%>