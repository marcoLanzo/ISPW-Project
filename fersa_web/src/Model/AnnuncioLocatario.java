package Model;

import java.sql.Date;

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

    @Override
    public boolean isDoccia() {
        return doccia;
    }

    @Override
    public void setDoccia(boolean doccia) {
        this.doccia = doccia;
    }

    @Override
    public boolean isVasca() {
        return vasca;
    }

    @Override
    public void setVasca(boolean vasca) {
        this.vasca = vasca;
    }

    @Override
    public String getGas() {
        return gas;
    }

    @Override
    public void setGas(String gas) {
        this.gas = gas;
    }

    @Override
    public boolean isMacchinadelgas() {
        return macchinadelgas;
    }

    @Override
    public void setMacchinadelgas(boolean macchinadelgas) {
        this.macchinadelgas = macchinadelgas;
    }

    @Override
    public boolean isFrigorifero() {
        return frigorifero;
    }

    @Override
    public void setFrigorifero(boolean frigorifero) {
        this.frigorifero = frigorifero;
    }

    @Override
    public boolean isLavastoviglie() {
        return lavastoviglie;
    }

    @Override
    public void setLavastoviglie(boolean lavastoviglie) {
        this.lavastoviglie = lavastoviglie;
    }

    @Override
    public String getRiscaldamento() {
        return riscaldamento;
    }

    @Override
    public void setRiscaldamento(String riscaldamento) {
        this.riscaldamento = riscaldamento;
    }

    @Override
    public boolean isMisuratoreconsumosingolaunita() {
        return misuratoreconsumosingolaunita;
    }

    @Override
    public void setMisuratoreconsumosingolaunita(boolean misuratoreconsumosingolaunita) {
        this.misuratoreconsumosingolaunita = misuratoreconsumosingolaunita;
    }

    @Override
    public boolean isTermostato() {
        return termostato;
    }

    @Override
    public void setTermostato(boolean termostato) {
        this.termostato = termostato;
    }

    @Override
    public boolean isWifi() {
        return wifi;
    }

    @Override
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public int getPostiletto() {
        return postiletto;
    }

    public void setPostiletto(int postiletto) {
        this.postiletto = postiletto;
    }

    public AnnuncioLocatario(int idAnnuncio, String nomeAnnuncio, String descrizione, String utente, int prezzomin, int prezzomax, String città) {

        super(idAnnuncio, nomeAnnuncio, descrizione, utente, prezzomin, prezzomax, città);

    }




    public AnnuncioLocatario(String nomeAnnuncio, int id_annuncio, String utente, int prezzomassimo, int prezzominimo,
                             String citta, boolean appartamento, boolean stanza, boolean attivo, boolean segnalazione,
                             Date datainserimento, String descrizione, boolean doccia, boolean vasca, String gas,
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

    @Override
    public void visualizzaAnnuncio() { // necessario il suo override

    }


}
