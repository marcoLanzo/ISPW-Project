package Entity;

public class Stanza {
    private boolean doccia;
    private boolean vasca;
    private String gas;
    private boolean macchinaDelGas;
    private boolean frigorifero;
    private boolean lavastoviglie;
    private String riscaldamento;
    private boolean misuratoreConsumoSingolaUnità;
    private boolean termostato;
    private int postiLetto;
    private int stanzaId;
    private Appartamento appartamento;
    private boolean wifi;

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
        return termostato;
    }

    public void setTermostato(boolean termostato) {
        this.termostato = termostato;
    }

    public int getPostiLetto() {
        return postiLetto;
    }

    public void setPostiLetto(int postiLetto) {
        this.postiLetto = postiLetto;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public  Stanza(int id, Appartamento app){
        this.stanzaId = id;
        this.appartamento = app;
    }

    public Stanza(int stanza_id,boolean doccia, boolean vasca, String gas, boolean macchinadelgas, boolean frigorifero,
                  boolean lavastoviglie, String riscaldamento, boolean misuratoreconsumosingolaunita,
                  boolean termostato, boolean wifi, int postiletto) {

        this.doccia =doccia;
        this.vasca = vasca;
        this.gas = gas;
        this.macchinaDelGas = macchinadelgas;
        this.frigorifero = frigorifero;
        this.lavastoviglie = lavastoviglie;
        this.riscaldamento = riscaldamento;
        this.misuratoreConsumoSingolaUnità = misuratoreconsumosingolaunita;
        this.termostato = termostato;
        this.wifi = wifi;
        this.postiLetto = postiletto;
        this.stanzaId = stanza_id;

    }

    public Appartamento getAppartamento() {
        return appartamento;
    }

    public void setAppartamento(Appartamento appartamento) {
        this.appartamento = appartamento;
    }

    public int getStanzaId() {
        return stanzaId;
    }

    public void setStanzaId(int stanzaId) {
        this.stanzaId = stanzaId;
    }
}
