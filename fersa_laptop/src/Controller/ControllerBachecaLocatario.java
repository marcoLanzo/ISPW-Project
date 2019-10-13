package Controller;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Dao.AnnuncioDao;
import Entity.Annuncio;

import java.util.ArrayList;

public class ControllerBachecaLocatario extends MainController {

    private static ControllerBachecaLocatario instance = null;

    public static ControllerBachecaLocatario getInstance() {
        if (instance == null) {
            instance = new ControllerBachecaLocatario();
        }
        return instance;
    }

    public ArrayList<AnnuncioBean> displayTenantShowcase() {

        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();


        annunci = AnnuncioDao.getAllTenantAnnounces();

        for (Annuncio a : annunci) {

            AnnuncioBean annuncioBean = new AnnuncioBean();

            annuncioBean.setNomeAnnuncio(a.getAnnounceName());
            UtenteBean ub = new UtenteBean();
            ub.setUserid(a.getNickname());
            annuncioBean.setUser(ub);
            annuncioBean.setPrezzoMin(a.getMinprice());
            annuncioBean.setPrezzoMax(a.getMaxprice());
            annuncioBean.setCity(a.getCity());
            annuncioBean.setAnnounceId(a.getID());

            annunciBean.add(annuncioBean);

        }

        return annunciBean;
    }

    public boolean inserisciAnnuncioPreferiti(AnnuncioBean ab, UtenteBean ub) {

        return AnnuncioDao.inserisciAnnuncioPreferiti(ab, ub);

    }

    public boolean checkpreferiti(int announceId, String userid) {

        return AnnuncioDao.annuncioPreferitoEsistente(announceId, userid);
    }


}