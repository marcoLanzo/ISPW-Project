package Model;

import java.util.Date;

/*

Le classi ASTRATTE sono utili per modellare contesti in cui un insieme di classi include operazioni con la stessa semantica
ma che saranno implementate da metodi differenti -> override

 */

public abstract class Annuncio {

    /* Gli attributi per essere ereditati dalle sottoclassi devono essere PROTECTED! */
    protected int ID;
    protected String announceName;
    protected Date date;
    protected int minprice;
    protected int maxprice;
    protected String city;
    protected String nickname;
    protected boolean isSignaled;// ricevuta una segnalazione di tale annuncio da qualche utente
    protected boolean attivo;
    protected String description;
    protected String indirizzo;
    protected int nPostiLetto;
    protected boolean doccia;
    protected boolean vasca;
    protected String gas;
    protected boolean macchinadelgas;
    protected boolean frigorifero;
    protected boolean lavastoviglie;
    protected String riscaldamento;
    protected boolean misuratoreconsumosingolaunita;
    protected boolean termostato;
    protected boolean wifi;

    public Annuncio(String nomeAnnuncio, String utente, int prezzo, String città, int id_annuncio) {
        this.announceName = nomeAnnuncio;
        this.nickname = utente;
        this.maxprice = prezzo;
        this.city = città;
        this.ID = id_annuncio;

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
        this.date = datainserimento;
    }

    public Annuncio(int idAnnuncio, String nomeAnnuncio, String descrizione, String utente, int prezzomin, int prezzomax, String città) {
        this.ID = idAnnuncio;
        this.announceName = nomeAnnuncio;
        this.description = descrizione;
        this.nickname = utente;
        this.minprice = prezzomin;
        this.maxprice = prezzomax;
        this.city = città;
    }

    public Annuncio(String nomeAnnuncio, String utente, int prezzo, String citta, int id_annuncio, java.sql.Date datainserimento, boolean attivo, boolean segnalazione) {

        this.announceName = nomeAnnuncio;
        this.ID = id_annuncio;
        this.maxprice = prezzo;
        this.city = citta;
        this.nickname = utente;
        this.isSignaled = segnalazione;
        this.attivo = attivo;
        this.date = datainserimento;
    }

    public boolean isDoccia() {
        return doccia;
    }

    public void setDoccia(boolean doccia) {
        this.doccia = doccia;
    }

    public boolean isVasca() {
        return vasca;
    }

    public void setVasca(boolean vasca) {
        this.vasca = vasca;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public boolean isMacchinadelgas() {
        return macchinadelgas;
    }

    public void setMacchinadelgas(boolean macchinadelgas) {
        this.macchinadelgas = macchinadelgas;
    }

    public boolean isFrigorifero() {
        return frigorifero;
    }

    public void setFrigorifero(boolean frigorifero) {
        this.frigorifero = frigorifero;
    }

    public boolean isLavastoviglie() {
        return lavastoviglie;
    }

    public void setLavastoviglie(boolean lavastoviglie) {
        this.lavastoviglie = lavastoviglie;
    }

    public String getRiscaldamento() {
        return riscaldamento;
    }

    public void setRiscaldamento(String riscaldamento) {
        this.riscaldamento = riscaldamento;
    }

    public boolean isMisuratoreconsumosingolaunita() {
        return misuratoreconsumosingolaunita;
    }

    public void setMisuratoreconsumosingolaunita(boolean misuratoreconsumosingolaunita) {
        this.misuratoreconsumosingolaunita = misuratoreconsumosingolaunita;
    }

    public boolean isTermostato() {
        return termostato;
    }

    public void setTermostato(boolean termostato) {
        this.termostato = termostato;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public int getnPostiLetto() {
        return nPostiLetto;
    }

    public void setnPostiLetto(int nPostiLetto) {
        this.nPostiLetto = nPostiLetto;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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


    public boolean isAttivo() {
        return attivo;
    }


}
