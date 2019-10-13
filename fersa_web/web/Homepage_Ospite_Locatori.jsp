<%@ page import="View.AnnuncioBean" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
	<link href="css/navbar.css" rel="stylesheet" media="screen">

	<jsp:useBean id="annuncioBean" class="View.AnnuncioBean" scope="request"/>


	<title>Homepage</title>
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


<%!  AnnuncioBean annuncioBean = new AnnuncioBean(); %>
<%!  ArrayList<AnnuncioBean> ab  = annuncioBean.getRenterAnnounces();%>

<% for(int x=0; x< ab.size(); x++){
	if (request.getParameter("visualizza" + x) != null){%>

<% AnnuncioBean annuncioSelezionato = annuncioBean.getSelectedAnnounceRenter(ab.get(x));

    String nomeAnnuncio = annuncioSelezionato.getNomeAnnuncio();
    String descrizione = annuncioSelezionato.getAppartamentoBean().getDescription();
    String città = annuncioSelezionato.getAppartamentoBean().getCitta();
    int prezzo = annuncioSelezionato.getPrezzoMax();
    String nickname = annuncioSelezionato.getUser().getUserid();
    String indirizzo = annuncioSelezionato.getAppartamentoBean().getSurfaceAddress();
    int nStanze = annuncioSelezionato.getAppartamentoBean().getStanze();
    int nPostiLetto = annuncioSelezionato.getStanzaBean().getPostiLetto();
    boolean macchinaDelGas = annuncioSelezionato.getStanzaBean().isMacchinaDelGas();
    boolean frigorifero = annuncioSelezionato.getStanzaBean().isFrigorifero();
    boolean lavastoviglie = annuncioSelezionato.getStanzaBean().isLavastoviglie();
    String riscaldamento = annuncioSelezionato.getStanzaBean().getRiscaldamento();
    boolean misuratoreConsumoSingolaUnità = annuncioSelezionato.getStanzaBean().isMisuratoreConsumoSingolaUnità();
    boolean termostato = annuncioSelezionato.getStanzaBean().isTermostato();
    boolean wifi = annuncioSelezionato.getStanzaBean().isWifi();


	session.setAttribute("description", descrizione);
    session.setAttribute("announce", nomeAnnuncio);
    session.setAttribute("city", città);
    session.setAttribute("nickname", nickname);
    session.setAttribute("address", indirizzo);
    session.setAttribute("price", prezzo);
    session.setAttribute("rooms", nStanze);
    session.setAttribute("postiLetto", nPostiLetto);
    session.setAttribute("macchinaGas", macchinaDelGas);
    session.setAttribute("cooler", frigorifero);
    session.setAttribute("lavastoviglie", lavastoviglie);
    session.setAttribute("riscaldamento", riscaldamento);
    session.setAttribute("misuratore", misuratoreConsumoSingolaUnità);
    session.setAttribute("termostato", termostato);
    session.setAttribute("wifi", wifi);
%>

<jsp:forward page="Annuncio_Locatore_Ospite.jsp" ></jsp:forward>

<%}
}
%>


<div class="container">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

	<form action="Homepage_Ospite_Locatori.jsp" name="myform" method="POST">


	<%if (ab.size() > 0)
	{
		for(int x=0; x< ab.size(); x++){
			String buttonId = "visualizza" + x;
	%>

		<div class="row" >
			<div class="col-sm-2"> </div>
			<div class="col-sm-8">
				<!-- Page Content -->
				<div class="container">
					<div class="row text-center text-lg-left">
						<div class="col-md-12">
							<div class="list-group my-3">
								<a href="#" class="list-group-item list-group-item-action d-flex   align-items-center">
									<div class="w-100">
										<h4 class="mb-0 text-center">

											<h4> <%= ab.get(x).getNomeAnnuncio()%>
												<br>
												<h5> <%= ab.get(x).getUser().getUserid()%>
													<br><br>
													<h5> <%= ab.get(x).getCity()%> &emsp; &emsp; <%=ab.get(x).getPrezzoMax()+"euro"%>
														&emsp; &emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
														<input type="submit" class="btn btn-alarm " name="<%=buttonId%>"
															   value="Visualizza" id="Visualizza">

									</div>
									<img src="res/stanza1.jpg" width="200" height="100" > </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	<%	}
	}%>

	</form>

</div>


<style>
	.input-group{padding-bottom:15px;}
	h1{font-family:"Serif";}
</style>

</html>