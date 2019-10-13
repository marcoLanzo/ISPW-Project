package Model;


import java.sql.Date;

public class AnnuncioLocatore extends Annuncio {

    private Appartamento appartamento;
    private Stanza stanza;


    /* Le classi figlie che estendono la classe astratta padre (Annuncio) devono necessariamente ereditare le operazioni del padre e
        implementarle. Nella classe astratta NON esiste il metodo, ma solo l'operazione ! */

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


    public AnnuncioLocatore(String nomeAnnuncio, String utente, int prezzo, String città, int id_annuncio) {

        super(nomeAnnuncio, utente, prezzo, città, id_annuncio);
    }



    public AnnuncioLocatore(String NomeAnnuncio, String Utente, int prezzo, String citta, int id_annuncio, Appartamento appartamento, Stanza stanza, Date datainserimento, boolean attivo, boolean segnalazione) {


        super(NomeAnnuncio, Utente, prezzo, citta, id_annuncio, datainserimento, attivo, segnalazione);
        this.appartamento = appartamento;
        this.stanza = stanza;

    }

    @Override
    public void visualizzaAnnuncio() {


    }

    public boolean publishRenterAnnounce(int apartmentId, String nickname){

        return true;
    }

}
