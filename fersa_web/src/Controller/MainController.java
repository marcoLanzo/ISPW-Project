package Controller;

import Dao.AnnuncioDao;
import Model.Annuncio;
import View.AnnuncioBean;
import View.StanzaBean;
import View.UtenteBean;

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
    protected ArrayList<Annuncio> annunci ;

    public static int getZ() {
        return z;
    }

    public static boolean checkannounceowner(int announceId,String nickname) {
        return AnnuncioDao.checkowner(announceId,nickname);
    }

    public ArrayList<Annuncio> getAnnunci() {
        return annunci;
    }

    public void setAnnunci(ArrayList<Annuncio> annunci) {
        this.annunci = annunci;
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



    public static int  getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime()- date1.getTime();
        int ageInDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return ageInDays;
    }
}



