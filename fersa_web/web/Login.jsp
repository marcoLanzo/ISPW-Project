<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="Exception.DatiErratiException" %>
<%@ page import="Exception.UtenteNonTrovatoException" %>

<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
	<link href="css/login_stile.css" rel="stylesheet">
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
</head>


<jsp:useBean id="LoginBean" scope="request" class="View.LoginBean" />
<jsp:setProperty name="LoginBean" property="*" />

<%@include  file="login.html" %>
    
<%
if(request.getParameter("login") != null) {

	try{
		LoginBean.validate();
%>

        <jsp:forward page="Homepage_Utente_Locatori.jsp"/>

		<%
		}catch (DatiErratiException e){
		%>

 	    <div class="alert alert-danger alert-dismissible" role="alert">
	   	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	   	<strong> Errore</strong> username o password errati!
	    </div>

	<%
	}catch (UtenteNonTrovatoException e){
	%>

	<div class="alert alert-danger alert-dismissible" role="alert">
	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	<strong> Errore</strong> Utente non esistente!
	</div>

   <%
	}catch (NullPointerException e){
   %>

	<div class="alert alert-warning alert-dismissible" role="alert">
   	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
   	<strong>Attenzione!</strong> Inserire tutti i campi!
   </div>

	<%
	}
}
	%>

</html>