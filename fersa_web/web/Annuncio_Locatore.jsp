
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


    <title>Visualizza annuncio Locatore</title>
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
                <li><a href="Homepage_Utente_Locatori.jsp">Bacheca Locatori</a></li>
                <li><a href="Homepage_Utente_Locatari.jsp">Bacheca Locatari</a></li>
                <li><a href="Pubblicazione_annuncio.jsp">Pubblica annuncio immobile</a></li>
                <li><a href="Homepage_Ospite_Locatori.jsp">Logout</a></li>
            </ul>
        </div>
    </nav>
</div>

<% String nomeAnnuncio  = (String) session.getAttribute("announce");
String città = (String) session.getAttribute("city");
String nickname = (String) session.getAttribute("nickname");
String indirizzo = (String)session.getAttribute("address");
int prezzo = (Integer) session.getAttribute("price");
String descrizione = (String)session.getAttribute("description");
int nStanze = (Integer) session.getAttribute("rooms");
int nPostiLetto = (Integer) session.getAttribute("postiLetto");
boolean macchinaDelGas = (Boolean) session.getAttribute("macchinaGas");
boolean frigorifero = (Boolean) session.getAttribute("cooler");
boolean lavastoviglie = (Boolean) session.getAttribute("lavastoviglie");
boolean misuratoreConsumoSingolaUnita = (Boolean) session.getAttribute("misuratore");
boolean termostato = (Boolean) session.getAttribute("termostato");
boolean wifi = (Boolean) session.getAttribute("wifi");
String riscaldamento = (String) session.getAttribute("riscaldamento");

;%>


<form action="Annuncio_Locatore.jsp" name="myform" method="POST">

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
                <img src="res/stanza1.jpg" width="300" height="300" > </a>
                <br> <br>
                <p><a class="btn btn-primary" role="button">Contatta &raquo;</a> &emsp; <a class="btn btn-primary" role="button">Segnala &raquo;</a></p>

            </div>
            <div class="col-md-4">
                <h2>Informazioni generali</h2>
                <br><br>
                <p> LOCATORE: <%=nickname%> &emsp;&emsp; PREZZO: <%= prezzo%> euro </p>
                <br>
                <p> <%= città%> &emsp;&emsp; <%= indirizzo%> </p>


            </div>
            <div class="col-md-4">
                <h2>Servizi offerti </h2>
                <br><br>

                <p> NUMERO STANZE PRESENTI: <%= nStanze%> <br>
                    NUMERO POSTI LETTO: <%= nPostiLetto%> <br><br>  SPECIFICHE: <br>

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


