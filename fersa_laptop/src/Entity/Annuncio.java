package Entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/*

Le classi ASTRATTE sono utili per modellare contesti in cui un insieme di classi include operazioni con la stessa semantica
ma che saranno implementate da metodi differenti -> override

 */

public abstract class Annuncio{

    /* Gli attributi per essere ereditati dalle sottoclassi devono essere PROTECTED! */
    protected int ID;
    protected String announceName;
    protected Timestamp date;
    protected int minprice;
    protected int maxprice;
    protected String city;
    protected String nickname;
    protected boolean isSignaled;// ricevuta una segnalazione di tale annuncio da qualche utente
    protected boolean attivo;
    protected String description;
    protected int counter_renting;


    private final Object MUTEX = new Object();

    public Annuncio() {

    }


    public int getCounter_renting() {
        return counter_renting;
    }

    public void setCounter_renting(int counter_renting) {
        this.counter_renting = counter_renting;
    }

    /* Classe astratta non può essere direttamente istanziata ma può essere istanziata tramite classe figlia,
        posso richiamare il suo costruttore all'interno di una classe figlia tramite l'operatore super();
         */
    public Annuncio(String nomeAnnuncio,int ID,Date date,int minprice,int maxprice,
                    String city,String nickname,boolean segnalazione,boolean attivo) {
        this.announceName = nomeAnnuncio;
        this.ID = ID;
        this.date = (Timestamp) date;
        this.minprice = minprice;
        this.maxprice=maxprice;
        this.city = city;
        this.nickname = nickname;
        this.isSignaled = segnalazione;
        this.attivo = attivo;

    }
    public Annuncio(int ID,String announceName,int maxprice){
        this.ID = ID;
        this.announceName = announceName;
        this.maxprice = maxprice;
    }

    public Annuncio(String nomeAnnuncio, int id_annuncio, int prezzominimo, int prezzomassimo, String citta, String utente, boolean segnalazione, boolean attivo,String descrizione,Date datainserimento) {
        this.announceName = nomeAnnuncio;
        this.ID = id_annuncio;
        this.minprice = prezzominimo;
        this.maxprice = prezzomassimo;
        this.city = citta;
        this.nickname = utente;
        this.isSignaled = segnalazione;
        this.attivo = attivo;
        this.description = descrizione;
        this.date = (Timestamp) datainserimento;
    }

    public Annuncio(int id_annuncio, String utente, Timestamp data_inserimento) {
        this.ID = id_annuncio;
        this.nickname = utente;
        this.date = data_inserimento;
    }


    public boolean isAttivo() {
        return attivo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAnnounceName() {
        return announceName;
    }

    public void setAnnounceName(String announceName) {
        this.announceName = announceName;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getMinprice() {
        return minprice;
    }

    public void setMinprice(int minprice) {
        this.minprice = minprice;
    }

    public int getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(int maxprice) {
        this.maxprice = maxprice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isSignaled() {
        return isSignaled;
    }

    public void setSignaled(boolean signaled) {
        isSignaled = signaled;
    }

    public boolean isAnnounceStatus() {
        return announceStatus;
    }

    public void setAnnounceStatus(boolean announceStatus) {
        this.announceStatus = announceStatus;
    }




    protected boolean announceStatus; // 1: attivo, 0: non attivo
    /* Operazioni comuni ai due tipi di annuncio: locatore e locatario */



    public abstract void visualizzaAnnuncio(); /* Essendo una operazione astratta, deve necessariamente essere implementata
                                                   tramite override da TUTTE le classi figlie */

    /* public void ciao ();   --> Non è possibile scrivere un'operazione non astratta senza implementazione ! */

    /* public void prova{    ---> Questo metodo può essere overraidato da una o più classi che ereditano Annuncio, anche in modo differente
        }
     */


}
