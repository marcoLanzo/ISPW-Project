package Bean;


import java.sql.Timestamp;
import java.util.Date;

public class AnnuncioBean {

    private int announceId;
    private int appartamentoId;
    private UtenteBean user;
    private String nomeAnnuncio;
    private String description;
    private String city;
    private String address;
    private int prezzoMin;
    private int prezzoMax;
    private Timestamp date;

    public Timestamp getDate() {
        return  date;
    }

    private int stanza_id;
    private boolean attivo;
    private boolean isSignal;
    private boolean doccia;
    private boolean vasca;
    private String gas;
    private String immagine;
    private AppartamentoBean appartamentoBean;
    private StanzaBean stanzabean;
    private int counterRenting;

    public int getCounterRenting() {
        return counterRenting;
    }

    public void setCounterRenting(int counterRenting) {
        this.counterRenting = counterRenting;
    }

    public AppartamentoBean getAppartamentoBean() {
        return appartamentoBean;
    }

    public void setAppartamentoBean(AppartamentoBean appartamentoBean) {
        this.appartamentoBean = appartamentoBean;
    }

    public StanzaBean getStanzabean() {
        return stanzabean;
    }

    public void setStanzabean(StanzaBean stanzabean) {
        this.stanzabean = stanzabean;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    private boolean macchinaDelGas;
    private boolean frigorifero;
    private boolean lavastoviglie;
    private String riscaldamento;
    private boolean misuratoreConsumoSingolaUnità;
    private boolean Termostato;
    private boolean wifi;
    private int postiLetto;
    private boolean appartamentoboolean;
    private boolean stanzaboolean;

    public boolean isAppartamentoboolean() {
        return appartamentoboolean;
    }

    public void setAppartamentoboolean(boolean appartamentoboolean) {
        this.appartamentoboolean = appartamentoboolean;
    }

    public boolean isStanzaboolean() {
        return stanzaboolean;
    }

    public void setStanzaboolean(boolean stanzaboolean) {
        this.stanzaboolean = stanzaboolean;
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

    public boolean isMacchinaDelGas() {
        return macchinaDelGas;
    }

    public void setMacchinaDelGas(boolean macchinaDelGas) {
        this.macchinaDelGas = macchinaDelGas;
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

    public boolean isMisuratoreConsumoSingolaUnità() {
        return misuratoreConsumoSingolaUnità;
    }

    public void setMisuratoreConsumoSingolaUnità(boolean misuratoreConsumoSingolaUnità) {
        this.misuratoreConsumoSingolaUnità = misuratoreConsumoSingolaUnità;
    }

    public boolean isTermostato() {
        return Termostato;
    }

    public void setTermostato(boolean termostato) {
        Termostato = termostato;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public int getPostiLetto() {
        return postiLetto;
    }

    public void setPostiLetto(int postiLetto) {
        this.postiLetto = postiLetto;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrezzoMin() {
        return prezzoMin;
    }

    public void setPrezzoMin(int prezzoMin) {
        this.prezzoMin = prezzoMin;
    }

    public int getPrezzoMax() {
        return prezzoMax;
    }

    public void setPrezzoMax(int prezzoMax) {
        this.prezzoMax = prezzoMax;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getStanza_id() {
        return stanza_id;
    }

    public void setStanza_id(int stanza_id) {
        this.stanza_id = stanza_id;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public boolean isSignal() {
        return isSignal;
    }

    public void setSignal(boolean signal) {
        this.isSignal = signal;
    }

    public String getNomeAnnuncio() {
        return nomeAnnuncio;
    }

    public void setNomeAnnuncio(String nomeAnnuncio) {
        this.nomeAnnuncio = nomeAnnuncio;
    }

    public int getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(int announceId) {
        this.announceId = announceId;
    }

    public int getAppartamentoId() {
        return appartamentoId;
    }

    public void setAppartamentoId(int appartamentoId) {
        this.appartamentoId = appartamentoId;
    }

    public UtenteBean getUser() {
        return user;
    }

    public void setUser(UtenteBean user) {
        this.user = user;
    }


}
