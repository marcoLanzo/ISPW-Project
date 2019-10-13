package View;


import Controller.ControllerAnnuncio;
import Controller.ControllerAppartamento;
import Dao.AnnuncioDao;
import Exception.DatiErratiException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class AnnuncioBean {

    private int announceId;
    private int appartamentoId;
    private UtenteBean user;
    private String nomeAnnuncio;
    private String description;
    private int prezzoMin;
    private int prezzoMax;
    private Date date;
    private int stanza_id;
    private boolean attivo;
    private boolean isSignal;
    private boolean doccia;
    private boolean vasca;
    private String gas;
    private String immagine;
    private int counter_annuncio_id = (int) (Math.random() * 1000 + 1);


    private AppartamentoBean appartamentoBean;
    private StanzaBean stanzaBean;

    private String nickname = UtenteBean.getUserid();


    public AppartamentoBean getAppartamentoBean() {
        return appartamentoBean;
    }

    public void setAppartamentoBean(AppartamentoBean appartamentoBean) {
        this.appartamentoBean = appartamentoBean;
    }

    public StanzaBean getStanzaBean() {
        return stanzaBean;
    }

    public void setStanzaBean(StanzaBean stanzaBean) {
        this.stanzaBean = stanzaBean;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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
    private boolean appartamento;
    private boolean stanza;
    private String city;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isStanza() {
        return stanza;
    }

    public void setStanza(boolean stanza) {
        this.stanza = stanza;
    }

    public boolean isAppartamento() {
        return appartamento;
    }

    public void setAppartamento(boolean appartamento) {
        this.appartamento = appartamento;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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


    public ArrayList<AnnuncioBean> getRenterAnnounces() {

        ControllerAnnuncio cA = ControllerAnnuncio.getInstance();
        ArrayList<AnnuncioBean> ab = cA.displayRenterShowcase();

        return ab;
    }

    public ArrayList<AnnuncioBean> getTenantAnnounces() {
        ControllerAnnuncio cL = ControllerAnnuncio.getInstance();
        ArrayList<AnnuncioBean> ab = cL.displayTenantShowcase();

        return ab;
    }

    public AnnuncioBean getSelectedAnnounceRenter(AnnuncioBean annuncioBean) {

        ControllerAnnuncio cA = ControllerAnnuncio.getInstance();
        AnnuncioBean ab = cA.getRenterAnnounce(annuncioBean);

        return ab;
    }

    public AnnuncioBean getSelectedAnnounceTenant(AnnuncioBean annuncioBean) {

        ControllerAnnuncio cA = ControllerAnnuncio.getInstance();
        AnnuncioBean ab = cA.getTenantAnnounce(annuncioBean);

        return ab;
    }

    public ArrayList<AppartamentoBean> getAppartamenti() {

        nickname = UtenteBean.getUserid();
        ControllerAppartamento cA = ControllerAppartamento.getInstance();
        ArrayList<AppartamentoBean> Ab;
        Ab = cA.ottieniAppartamento(nickname);

       return Ab;
    }

    public boolean publishRenterAnnounce(AppartamentoBean appartamento, String nomeAnn, String prezzo) throws DatiErratiException, NumberFormatException {


        ControllerAnnuncio cA = ControllerAnnuncio.getInstance();

        while(AnnuncioDao.annuncioEsistente(counter_annuncio_id)){
            counter_annuncio_id++;
        }
        int price = Integer.parseInt(prezzo);
        if (price == 0 || nomeAnn.equals("")) {
            throw new DatiErratiException();
        }
        AnnuncioBean ab = new AnnuncioBean();
        ab.setAnnounceId(counter_annuncio_id);
        ab.setNomeAnnuncio(nomeAnn);
        ab.setPrezzoMax(Integer.valueOf(prezzo));
        ab.setDate(java.sql.Date.valueOf(LocalDate.now()));
        UtenteBean ub = new UtenteBean();
        ub.setUserid(nickname);
        ab.setUser(ub);
        ab.getUser().setUserid(nickname);
        ab.setAppartamentoId(appartamento.getApartmentId());
        ab.setCity(appartamento.getCitta());
        ab.setAttivo(true);
        ab.setSignal(false);

        return cA.inserisciAnnuncio(ab);

    }


}
