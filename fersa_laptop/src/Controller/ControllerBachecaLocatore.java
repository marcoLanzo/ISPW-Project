package Controller;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Dao.AnnuncioDao;
import Entity.Annuncio;
import Thread.checkTimer;
import org.apache.commons.lang3.ObjectUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ControllerBachecaLocatore extends MainController {

    private static ControllerBachecaLocatore instance = null;
    private checkTimer t1;
    private static Semaphore lock = new Semaphore(1);

    public ControllerBachecaLocatore() {
    }

    public static ControllerBachecaLocatore getInstance() {
        if (instance == null) {
            instance = new ControllerBachecaLocatore();
        }
        return instance;
    }

    /* Restituisce una lista di tutti gli annunci ti tipo locatore -> utile per riempire la bacheca e far visionare
    annunci.
     */
    public synchronized ArrayList<AnnuncioBean> displayRenterShowcase() {

        Thread t;
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();

        ArrayList<Annuncio> annunci = AnnuncioDao.getAllRenterAnnounces();

        for (Annuncio a : annunci) {

            AnnuncioBean annuncioBean = new AnnuncioBean();

            annuncioBean.setNomeAnnuncio(a.getAnnounceName());
            UtenteBean ub = new UtenteBean();
            ub.setUserid(a.getNickname());
            annuncioBean.setUser(ub);
            annuncioBean.setPrezzoMax(a.getMaxprice());
            annuncioBean.setCity(a.getCity());
            annuncioBean.setAnnounceId(a.getID());

            annunciBean.add(annuncioBean);

        }
        try {

            t1 = new checkTimer();
            t = new Thread(t1); //passo al costruttore Thread un'oggetto che implementa Runnable (checkTimer)
            t.setDaemon(true); // thread di bassa priorità che non impedirà alla JVM di chiamare Exit della classe Runtime
            t.start();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return annunciBean;
    }


    /* Al tocco del bottone a forma di cuore viene inserito l'annuncio selezionato all'interno dei preferiti di quel
    dato utente.
     */
    public boolean inserisciAnnuncioPreferiti(AnnuncioBean ab, UtenteBean ub) {

        return AnnuncioDao.inserisciAnnuncioPreferiti(ab, ub);


    }

    public boolean checkpreferiti(int announceId, String userid) {

        return AnnuncioDao.annuncioPreferitoEsistente(announceId, userid);
    }

    public boolean checkLock() {

        if (!lock.tryAcquire()) {
            System.out.println("Thread Timer già attivo");
            return false;

        } else {// prendo il lock per disattivare un annuncio se inattivo da troppo tempo
            return true;
        }

    }
}


