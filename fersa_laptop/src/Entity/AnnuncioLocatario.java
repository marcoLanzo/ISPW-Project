package Entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

public class AnnuncioLocatario extends Annuncio {
    /* SERVIZI RICHIESTI DALL'UTENTE */
    private boolean appartamento;
    private boolean stanza;
    private boolean doccia;
    private boolean vasca;
    private String gas;
    private boolean macchinadelgas;
    private boolean frigorifero;
    private boolean lavastoviglie;
    private String riscaldamento;
    private boolean misuratoreconsumosingolaunita;
    private boolean termostato;
    private boolean wifi;
    private int postiletto;

    public AnnuncioLocatario(int ID,String announceName,String utente,int prezzo,String citta){
        super(ID,announceName,prezzo);
        this.nickname =  utente;
        this.city = citta;
    }

    public AnnuncioLocatario(String nomeAnnuncio, String utente, int prezzomin, int prezzomax, String città) {

        this.announceName = nomeAnnuncio;
        this.nickname = utente;
        this.minprice = prezzomin;
        this.maxprice = prezzomax;
        this.city = città;
    }


    public AnnuncioLocatario(String nomeAnnuncio, int id_annuncio, String utente, int prezzomassimo, int prezzominimo,
                             String citta, boolean appartamento, boolean stanza, boolean attivo, boolean segnalazione,
                             Timestamp datainserimento, String descrizione, boolean doccia, boolean vasca, String gas,
                             boolean macchinadelgas, boolean frigorifero, boolean lavastoviglie, String riscaldamento,
                             boolean misuratoreconsumosingolaunita, boolean termostato, boolean wifi, int postiletto) {

        super(nomeAnnuncio, id_annuncio, prezzominimo, prezzomassimo, citta, utente, segnalazione, attivo, descrizione, datainserimento);
        this.appartamento = appartamento;
        this.stanza = stanza;
        this.doccia = doccia;
        this.vasca = vasca;
        this.gas = gas;
        this.macchinadelgas = macchinadelgas;
        this.frigorifero = frigorifero;
        this.lavastoviglie = lavastoviglie;
        this.riscaldamento = riscaldamento;
        this.misuratoreconsumosingolaunita = misuratoreconsumosingolaunita;
        this.termostato = termostato;
        this.wifi = wifi;
        this.postiletto = postiletto;
    }

    public AnnuncioLocatario(String nickname){
        super();
        this.nickname = nickname;
    }

    public AnnuncioLocatario(String nickname, int id_annuncio) {
        this.nickname = nickname;
        this.ID = id_annuncio;
    }

    public AnnuncioLocatario(int id, String nomeAnnuncio, String utente, int prezzominimo, int prezzomassimo, String città) {
        super(id,nomeAnnuncio,prezzomassimo);
        this.nickname = utente;
        this.minprice = prezzominimo;
    }

    public boolean isAppartamento() {
        return appartamento;
    }

    public void setAppartamento(boolean appartamento) {
        this.appartamento = appartamento;
    }

    public boolean isStanza() {
        return stanza;
    }

    public void setStanza(boolean stanza) {
        this.stanza = stanza;
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

    public int getPostiletto() {
        return postiletto;
    }

    public void setPostiletto(int postiletto) {
        this.postiletto = postiletto;
    }

    @Override
    public void visualizzaAnnuncio() { // necessario il suo override

    }

    public boolean checkAnnounce(int ID){

        return new Random().nextBoolean();
    }

}
