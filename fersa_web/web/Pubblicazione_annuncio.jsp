<%@ page import="Exception.DatiErratiException" %>
<%@ page import="View.AnnuncioBean" %>
<%@ page import="View.AppartamentoBean" %>
<%@ page import="java.util.ArrayList" %>

<jsp:useBean id="AnnuncioBean" scope="request" class="View.AnnuncioBean" />
<jsp:setProperty name="AnnuncioBean" property="*" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>

<%! AnnuncioBean annuncioBean = new AnnuncioBean();
Integer x = 0;%>
<%! ArrayList<AppartamentoBean> appartamenti = annuncioBean.getAppartamenti();
%>

<form action="Pubblicazione_annuncio.jsp" name="myform" method="POST">

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Pubblica il tuo immobile</h1>


        <div class="form-group">

            <label for=nomeAnnuncio> Nome Annuncio *</label>
            <input type="text" class="form-control" id="nomeAnnuncio" name="nomeAnnuncio" placeholder="Inserisci un nome per l'annuncio" />

            <label for=prezzoMax> Prezzo *</label>
            <input type="text" class="form-control" id="prezzoMax" name="prezzoMax" placeholder="inserisci un prezzo numerico" />

        </div>

        <div class="form-group">
            <select class="form-control" name="appartamenti">
                <%if(appartamenti != null){ %>
                <%for (x= 0; x < appartamenti.size(); x++){
                %>
                <option value="<%=x%>"> <%= ("APPARTAMENTO "+ appartamenti.get(x).getApartmentId()) + ", "+ appartamenti.get(x).getSurfaceAddress() %> </option>
                        <%}%>
            </select>


       <% }else{ %>
        Non ci sono appartamenti da pubblicare!
        <%}%>
<br><br>
            <input type="submit" class="btn btn-alarm" name="pubblica" value="Pubblica" id="pubblicaBtn">

        </div>

    </div>


    </div>
</div>

</form>

<%if(request.getParameter("pubblica") != null) {
    try{
        String prezzo = request.getParameter("prezzoMax");
        String nomeAnn = request.getParameter("nomeAnnuncio");
        if (annuncioBean.publishRenterAnnounce(appartamenti.get(0), nomeAnn, prezzo)) {%>
            <div class="alert alert-success alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong> Grazie! </strong> Annuncio Inserito correttamente
            </div>
        <%
        }
        else{ %>

            <div class="alert alert-warning alert-dismissible" role="alert">
                 <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <strong> Attenzione! </strong> L'immobile inserito già esiste!
            </div>
       <% }

}catch(DatiErratiException e){
        %>
    <div class="alert alert-danger alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <strong> Errore</strong> Inserire i dati correttamente!
    </div>
    <%}
    catch(NumberFormatException e){
    %>
<div class="alert alert-danger alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <strong> Errore</strong> Inserire un prezzo numerico!
</div>
<%}
}
%>

</body>
</html>
