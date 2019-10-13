package Bean;


public class StanzaBean {

    private boolean doccia;
    private boolean vasca;
    private String gas;
    private boolean macchinaDelGas;
    private boolean frigorifero;
    private boolean lavastoviglie;
    private String riscaldamento;
    private boolean misuratoreConsumoSingolaUnità;
    private boolean Termostato;
    private boolean wifi;
    private int postiLetto;
    private int stanzaid;
    private int prezzo_stanza;
    private String indirizzo;
    private int appartamentoId;

    public int getAppartamentoId() {
        return appartamentoId;
    }

    public void setAppartamentoId(int appartamentoId) {
        this.appartamentoId = appartamentoId;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getPrezzo_stanza() {
        return prezzo_stanza;
    }

    public void setPrezzo_stanza(int prezzo_stanza) {
        this.prezzo_stanza = prezzo_stanza;
    }

    public int getStanzaid() {
        return stanzaid;
    }

    public void setStanzaid(int stanzaid) {
        this.stanzaid = stanzaid;
    }

    public int getPostiLetto() {
        return postiLetto;
    }

    public void setPostiLetto(int postiLetto) {
        this.postiLetto = postiLetto;
    }


    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getRiscaldamento() {
        return riscaldamento;
    }

    public void setRiscaldamento(String riscaldamento) {
        this.riscaldamento = riscaldamento;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
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

    @Override
    public String toString(){
        return ("Stanza ID: "+stanzaid+", "+indirizzo);
    }

}
