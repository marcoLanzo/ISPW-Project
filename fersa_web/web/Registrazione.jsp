<%@ page import="Exception.DatiErratiException" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="Exception.UtenteEsistenteException"
%>

<jsp:useBean id="Registrazione" scope="request" class="View.RegistrazioneBean" />
<jsp:setProperty name="Registrazione" property="*"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
	<link href="css/navbar.css" rel="stylesheet" media="screen">

	<jsp:useBean id="annuncioBean" class="View.AnnuncioBean" scope="request"/>


	<title>Registrazione </title>
</head>

<div class="container">

	<nav class="navbar navbar-light" style="background-color: #00121F" role="navigation">

		<!-- Logo e pulsante per barra ridimensionata -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Espandi barra di navigazione</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>

		<!-- Elementi della barra -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li><a href="Homepage_Ospite_Locatori.jsp">Bacheca Locatori</a></li>
				<li><a href="Homepage_Ospite_Locatari.jsp">Bacheca Locatari</a></li>
				<li><a href="Registrazione.jsp">Registrati</a></li>
				<li><a href="Login.jsp">Login</a></li>
			</ul>
		</div>
	</nav>
</div>

<!--   request.getParameter prende in input il NOME del bottone! -->
	<%
		if (request.getParameter("registratiBtn") != null) {
			try{
				 Registrazione.registra();%>
				<jsp:forward page="Homepage_Utente_Locatori.jsp"/>

			<%}
			catch(DatiErratiException de){%>
			<div class="alert alert-danger alert-dismissible" role="alert">
		   	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		   	<strong> Attenzione!</strong> Inserire tutti i dati!
		   </div>
		<%}catch(UtenteEsistenteException up){%>
		<div class="alert alert-danger alert-dismissible" role="alert">
	   	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	   	<strong> Attenzione!</strong> L'utente è gia registrato nel sistema
	   </div>
	<%}

		}
	%>

	<div class="container">
	<div class="jumbotron">
		<h2>Registrazione al sito</h2><br>
		<form action="Registrazione.jsp" name="myform" method="POST">

			<div class="form-group">
				<label for=nickname> Nome*</label><input type="text"
					class="form-control" id="nickname" name="nickname" placeholder="Nickname" /> <label
					for=password> Password*</label><input type="password"
					class="form-control" id="password" name="password"
					placeholder="scegli una password" />

			</div>
			<input type="submit" class="btn btn-alarm " name="registratiBtn"
				value="Registrati" id="registratiBtn">
		</form>
		</div>
	</div>
</body>
</html>