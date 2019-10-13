package View;

import java.util.ArrayList;
import java.util.Date;

public class AppartamentoBean {


    public String getApartmentStatus() {
        return apartmentStatus;
    }

    public void setApartmentStatus(String apartmentStatus) {
        this.apartmentStatus = apartmentStatus;
    }

    // private Plant p;
    private String description;
    private UtenteBean renter;
    private String apartmentStatus;
    private double[] LatLong;
    private int apartmentId;
    protected ArrayList<StanzaBean> rooms = new ArrayList<StanzaBean>();
    private boolean appcompleto;
    private boolean appGruppo;
    private int prezzo;
    private String surfaceAddress;
    private int stanze;
    private Date data;
    private String citta;

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public ArrayList<StanzaBean> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<StanzaBean> rooms) {
        this.rooms = rooms;
    }

    public boolean isAppGruppo() {
        return appGruppo;
    }

    public void setAppGruppo(boolean appGruppo) {
        this.appGruppo = appGruppo;
    }

    public int getStanze() {
        return stanze;
    }

    public void setStanze(int stanze) {
        this.stanze = stanze;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isAppcompleto() {
        return appcompleto;
    }

    public void setAppcompleto(boolean appcompleto) {
        this.appcompleto = appcompleto;
    }

    public String getSurfaceAddress() {
        return surfaceAddress;
    }

    public void setSurfaceAddress(String surfaceAddress) {
        this.surfaceAddress = surfaceAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRooms(StanzaBean stanza) {
        this.rooms.add(stanza);
    }

    public UtenteBean getRenter() {
        return renter;
    }

    public void setRenter(UtenteBean renter) {
        this.renter = renter;
    }

    public double[] getLatLong() {
        return LatLong;
    }

    public void setLatLong(double[] latLong) {
        LatLong = latLong;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Override
    public String toString(){
        return ("Appartamento ID: "+apartmentId+", "+surfaceAddress);
    }


}
