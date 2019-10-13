package Entity;


import java.sql.Timestamp;
import java.util.Date;

public class AnnuncioLocatore extends Annuncio {


    public AnnuncioLocatore(String nomeAnnuncio, String utente, int prezzo, String citta) {
        super();
        this.announceName = nomeAnnuncio;
        this.maxprice = prezzo;
        this.nickname = utente;
        this.city= citta;
    }

    public AnnuncioLocatore(int announceId,String announceName){
        this.ID = announceId;
        this.announceName = announceName;
    }



    public AnnuncioLocatore(int id_annuncio, String utente, Timestamp data_inserimento, int counter_renting) {
        super(id_annuncio,utente,data_inserimento);
        this.counter_renting = counter_renting;
    }

    public Appartamento getAppartamento() {
        return appartamento;
    }

    public void setAppartamento(Appartamento appartamento) {
        this.appartamento = appartamento;
    }

    public Stanza getStanza() {
        return stanza;
    }

    public void setStanza(Stanza stanza) {
        this.stanza = stanza;
    }

    private Appartamento appartamento;
    private Stanza stanza;


    /* Le classi figlie che estendono la classe astratta padre (Annuncio) devono necessariamente ereditare le operazioni del padre e
        implementarle. Nella classe astratta NON esiste il metodo, ma solo l'operazione ! */

    public AnnuncioLocatore(int id_annuncio, String nomeAnnuncio, String utente, int prezzo, String città) {

        this.announceName = nomeAnnuncio;
        this.nickname = utente;
        this.maxprice = prezzo;
        this.city = città;
        this.ID = id_annuncio;
    }


    public AnnuncioLocatore(String nomeAnnuncio, String utente, int prezzo, String citta, int id_annuncio) {
        super();
        this.announceName = nomeAnnuncio;
        this.nickname = utente;
        this.maxprice = prezzo;
        this.city = citta;
        this.ID = id_annuncio;
    }

    public AnnuncioLocatore(String NomeAnnuncio, String Utente, int prezzo, String citta, int id_annuncio,
                            Appartamento app, Stanza stanza, Timestamp Data, boolean attivo, boolean segnalazione) {

        this.announceName = NomeAnnuncio;
        this.nickname = Utente;
        this.maxprice = prezzo;
        this.city = citta;
        this.ID = id_annuncio;
        this.appartamento = app;
        this.stanza = stanza;
        this.date = Data;
        this.attivo = attivo;
        this.isSignaled = segnalazione;

    }

    public AnnuncioLocatore(String nomeAnnuncio, String utente, int prezzomassimo, Appartamento appartamento, Stanza stanza, boolean attivo, boolean segnalazione, java.sql.Timestamp datainserimento) {
        super();

        this.announceName = nomeAnnuncio;
        this.nickname = utente;
        this.maxprice = prezzomassimo;
        this.appartamento = appartamento;
        this.stanza = stanza;
        this.isSignaled = segnalazione;
        this.attivo = attivo;
        this.date = datainserimento;
    }

    @Override
    public void visualizzaAnnuncio() {



    }


    public boolean publishRenterAnnounce(int apartmentId, String nickname){

        return true;
    }


}
