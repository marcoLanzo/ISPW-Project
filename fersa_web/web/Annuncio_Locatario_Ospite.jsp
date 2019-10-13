<%@ page import="static java.util.Objects.equals" %>
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

    <% String nomeAnnuncio  = (String) session.getAttribute("announce");
String città = (String) session.getAttribute("city");
String nickname = (String) session.getAttribute("nickname");
int prezzoMin = (Integer) session.getAttribute("minPrice");
int prezzoMax = (Integer) session.getAttribute("maxPrice");
String descrizione = (String)session.getAttribute("description");
int nPostiLetto = (Integer) session.getAttribute("postiLetto");
boolean macchinaDelGas = (Boolean) session.getAttribute("macchinaGas");
boolean frigorifero = (Boolean) session.getAttribute("cooler");
boolean lavastoviglie = (Boolean) session.getAttribute("lavastoviglie");
boolean misuratoreConsumoSingolaUnita = (Boolean) session.getAttribute("misuratore");
boolean termostato = (Boolean) session.getAttribute("termostato");
boolean wifi = (Boolean) session.getAttribute("wifi");
String riscaldamento = (String) session.getAttribute("riscaldamento");

;%>


<main role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3"> <%= nomeAnnuncio%> </h1>
            <p><%= descrizione%></p>


        </div>
    </div>

    <div class="container">
        <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <img src="res/utente_positivo.png" width="300" height="300" > </a>
                &emsp; &emsp;
                <p><a class="btn btn-primary" role="button">Contatta &raquo;</a> &emsp; <a class="btn btn-primary" role="button">Segnala &raquo;</a></p>

            </div>
            <div class="col-md-4">
                <h2>Informazioni generali</h2>
                <br><br>
                <p> LOCATARIO: <%=nickname%> &emsp;<br> FASCIA DI PREZZO DESIDERATA: <%= prezzoMin+"-"+prezzoMax%> euro </p>
                <br>
                <p> CERCO CASA A: <%= città%> &emsp;</p>


            </div>
            <div class="col-md-4">
                <h2>Servizi offerti </h2>
                <br><br>

                <p> Numero posti letto richiesti: <%= nPostiLetto%> <br><br>  Specifiche: <br><br>

                    Macchina del gas:  <%= macchinaDelGas ? "si" : "no" %> <br>
                    Frigorifero: <%= frigorifero ? "si" : "no" %> <br>
                    Lavastoviglie: <%= lavastoviglie ? "si" : "no" %> <br>
                    Termostato: <%= termostato ? "si" : "no" %> <br>
                    Wifi: <%= wifi ? "si" : "no" %> <br>
                    MisuratoreConsumo: <%= misuratoreConsumoSingolaUnita ? "si" : "no" %> <br>
                    Riscaldamento: <%= riscaldamento %>



                </p>
            </div>
        </div>

        <hr>

    </div> <!-- /container -->

</main>

<style>
    .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
    }

    @media (min-width: 768px) {
        .bd-placeholder-img-lg {
            font-size: 3.5rem;
        }
    }
</style>
