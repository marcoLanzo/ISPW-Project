package Entity;


import Bean.StanzaBean;
import Bean.UtenteBean;
import Enumerations.ApartmentStatus;

import java.util.List;

public class Appartamento {

    private String surfaceAddress;
    // private Plant p;
    private String description;
    private UtenteBean renter;
    private ApartmentStatus apartmentStatus;
    private double[] LatLong;
    private String citta;
    private int numeroStanze;
    private boolean gruppo;
    private boolean completo;

    public int getNumeroStanze() {
        return numeroStanze;
    }

    public void setNumeroStanze(int numeroStanze) {
        this.numeroStanze = numeroStanze;
    }

    public boolean isGruppo() {
        return gruppo;
    }

    public void setGruppo(boolean gruppo) {
        this.gruppo = gruppo;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public Appartamento(int appartament_id, String indirizzo, int numeroStanze, boolean gruppo, boolean completo, String descrizione, String citta) {
        this.apartmentId = appartament_id;
        this.surfaceAddress = indirizzo;
        this.numeroStanze = numeroStanze;
        this.gruppo = gruppo;
        this.completo = completo;
        this.description = descrizione;
        this.citta = citta;
    }



    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Appartamento(int aptId, String address, String citta) {
        this.apartmentId = aptId;
        this.surfaceAddress = address;
        this.citta = citta;
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

    public UtenteBean getRenter() {
        return renter;
    }

    public void setRenter(UtenteBean renter) {
        this.renter = renter;
    }

    public ApartmentStatus getApartmentStatus() {
        return apartmentStatus;
    }

    public void setApartmentStatus(ApartmentStatus apartmentStatus) {
        this.apartmentStatus = apartmentStatus;
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

    public List<StanzaBean> getRooms() {
        return rooms;
    }

    public void setRooms(List<StanzaBean> rooms) {
        this.rooms = rooms;
    }

    public boolean isApartmentGroup() {
        return apartmentGroup;
    }

    public void setApartmentGroup(boolean apartmentGroup) {
        this.apartmentGroup = apartmentGroup;
    }

    private int apartmentId;
    private List<StanzaBean> rooms;
    private boolean apartmentGroup;

    public Appartamento(int id, String address){
        this.apartmentId = id;
        this.surfaceAddress = address;
    }
    public Appartamento(){

    }
}
