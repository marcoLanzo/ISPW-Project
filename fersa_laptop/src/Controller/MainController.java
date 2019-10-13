package Controller;

import Bean.AnnuncioBean;
import Bean.AppartamentoBean;
import Bean.StanzaBean;
import Bean.UtenteBean;
import Dao.AnnuncioDao;
import Entity.Annuncio;
import Entity.AnnuncioLocatario;
import Entity.AnnuncioLocatore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class MainController {

    protected static UtenteBean utentebean;
    protected static StanzaBean stanzabean;
    protected static AnnuncioBean annuncioBean;
    protected static int k = 0 ;
    protected static int i = 0;
    protected static int visualizzati = 0 ;
    protected static int pagina  = 0;

    public static int getZ() {
        return z;
    }

    public static boolean checkannounceowner(int announceId,String nickname) {
        return AnnuncioDao.checkowner(announceId,nickname);
    }



    public static void setZ(int z) {
        MainController.z = z;
    }

    protected static int z = 0;

    protected static int counter;
    public static int getCounter() {
         counter = (int) (Math.random() * 10000 + 20);
        return MainController.counter;
    }

    public static void setCounter(int counter) {
        MainController.counter = counter;
    }

    public static UtenteBean getUtentebean() {
        return utentebean;
    }

    public static void setUtentebean(UtenteBean utentebean) {
        MainController.utentebean = utentebean;
    }

    public static StanzaBean getStanzabean() {
        return stanzabean;
    }

    public static void setStanzabean(StanzaBean stanzabean) {
        MainController.stanzabean = stanzabean;
    }


    public static int getVisualizzati() {
        return visualizzati;
    }

    public static void setVisualizzati(int visualizzati) {
        MainController.visualizzati = visualizzati;
    }

    public static int getPagina() {
        return pagina;
    }

    public static void setPagina(int pagina) {
        MainController.pagina = pagina;
    }


    public static int getK() {
        return k;
    }

    public static void setK(int k) {
        MainController.k = k;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        MainController.i = i;
    }

    public static AnnuncioBean getAnnuncioBean() {
        return annuncioBean;
    }

    public static void setAnnuncioBean(AnnuncioBean annuncioBean) {
        MainController.annuncioBean = annuncioBean;
    }

    public AnnuncioBean annuncioselezionatolocatore(AnnuncioBean annuncioBean){
        AnnuncioLocatore annuncioLocatore;
        annuncioLocatore = AnnuncioDao.annuncioselezionatolocatore(annuncioBean);
        AnnuncioBean ab= new AnnuncioBean();
        AppartamentoBean ap= new AppartamentoBean();
        StanzaBean sb = new StanzaBean();
        UtenteBean ub = new UtenteBean();
        ab.setNomeAnnuncio(annuncioLocatore.getAnnounceName());
        ab.setPrezzoMax(annuncioLocatore.getMaxprice());
        ab.setAttivo(annuncioLocatore.isAttivo());
        ab.setAnnounceId(annuncioLocatore.getID());
        ab.setSignal(annuncioLocatore.isSignaled());
        ab.setDate(annuncioLocatore.getDate());
        ap.setCitta(annuncioLocatore.getAppartamento().getCitta());
        ap.setApartmentId(annuncioLocatore.getAppartamento().getApartmentId());
        ap.setStanze(annuncioLocatore.getAppartamento().getNumeroStanze());
        ap.setAppGruppo(annuncioLocatore.getAppartamento().isGruppo());
        ap.setAppcompleto(annuncioLocatore.getAppartamento().isCompleto());
        ap.setDescription(annuncioLocatore.getAppartamento().getDescription());
        ap.setSurfaceAddress(annuncioLocatore.getAppartamento().getSurfaceAddress());
        ub.setUserid(annuncioLocatore.getNickname());
        sb.setStanzaid(annuncioLocatore.getStanza().getStanzaId());
        sb.setDoccia(annuncioLocatore.getStanza().isDoccia());
        sb.setVasca(annuncioLocatore.getStanza().isVasca());
        sb.setGas(annuncioLocatore.getStanza().getGas());
        sb.setMacchinaDelGas(annuncioLocatore.getStanza().isMacchinaDelGas());
        sb.setFrigorifero(annuncioLocatore.getStanza().isFrigorifero());
        sb.setLavastoviglie(annuncioLocatore.getStanza().isLavastoviglie());
        sb.setRiscaldamento(annuncioLocatore.getStanza().getRiscaldamento());
        sb.setMisuratoreConsumoSingolaUnità(annuncioLocatore.getStanza().isMisuratoreConsumoSingolaUnità());
        sb.setTermostato(annuncioLocatore.getStanza().isTermostato());
        sb.setPostiLetto(annuncioLocatore.getStanza().getPostiLetto());
        sb.setWifi(annuncioLocatore.getStanza().isWifi());
        ab.setUser(ub);
        ab.setAppartamentoBean(ap);
        ab.setStanzabean(sb);
        return ab;

    }

    public AnnuncioBean annuncioSelezionatoLocatario(AnnuncioBean annuncioBean) {
        AnnuncioLocatario annuncioLocatario;
        annuncioLocatario = AnnuncioDao.annuncioselezionatolocatario(annuncioBean);
        AnnuncioBean ab= new AnnuncioBean();
        UtenteBean ub = new UtenteBean();
        ab.setPrezzoMax(annuncioLocatario.getMaxprice());
        ab.setAttivo(annuncioLocatario.isAttivo());
        ab.setAnnounceId(annuncioLocatario.getID());
        ab.setSignal(annuncioLocatario.isSignaled());
        ab.setDate(annuncioLocatario.getDate());
        ab.setCity(annuncioLocatario.getCity());
        ab.setStanzaboolean(annuncioLocatario.isStanza());
        ab.setAppartamentoboolean(annuncioLocatario.isAppartamento());
        ab.setPrezzoMin(annuncioLocatario.getMinprice());
        ab.setDescription(annuncioLocatario.getDescription());
        ab.setDoccia(annuncioLocatario.isDoccia());
        ab.setVasca(annuncioLocatario.isVasca());
        ab.setGas(annuncioLocatario.getGas());
        ab.setMacchinaDelGas(annuncioLocatario.isMacchinadelgas());
        ab.setFrigorifero(annuncioLocatario.isFrigorifero());
        ab.setLavastoviglie(annuncioLocatario.isLavastoviglie());
        ab.setRiscaldamento(annuncioLocatario.getRiscaldamento());
        ab.setMisuratoreConsumoSingolaUnità(annuncioLocatario.isMisuratoreconsumosingolaunita());
        ab.setTermostato(annuncioLocatario.isTermostato());
        ab.setWifi(annuncioLocatario.isWifi());
        ab.setPostiLetto(annuncioLocatario.getPostiletto());
        ub.setUserid(annuncioLocatario.getNickname());
        ab.setUser(ub);
        return ab;


    }

    public static void  increase_counter_renting(AnnuncioBean ab){
        AnnuncioDao.increase_counter_renting(ab);
    }



    public static int  getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime()- date1.getTime();
        int ageInDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return ageInDays;
    }
}



