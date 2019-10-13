package Controller;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Dao.AnnuncioDao;
import Entity.Annuncio;
import Entity.AnnuncioLocatore;
import Thread.*;
import java.util.ArrayList;

public class ControllerStorico extends MainController {

    private static ControllerStorico instance = null;

    public static ControllerStorico getInstance() {
        if (instance == null) {
            instance = new ControllerStorico();
        }
        return instance;
    }


    public ArrayList<AnnuncioBean> displayHistoricalTenant(String nickname) {

        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();
        annunci = AnnuncioDao.displayHistoricalTenant(nickname);

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

    public ArrayList<AnnuncioBean> displayHistoricalRenter(String nickname) {
        ArrayList<Annuncio> annunci;
        annunci = AnnuncioDao.displayHistoricalRenter(nickname);
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();
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

        return annunciBean;
    }


    public ArrayList<AnnuncioBean> displayAllHistorical(String nickname) {
        ArrayList<Annuncio> allHistoricalannounces = new ArrayList<Annuncio>();

        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();


        allHistoricalannounces.addAll(AnnuncioDao.displayHistoricalTenant(nickname));
        allHistoricalannounces.addAll(AnnuncioDao.displayHistoricalRenter(nickname));

        for (Annuncio a : allHistoricalannounces) {

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

        return annunciBean;
    }

    public boolean checkannouncelocatore(AnnuncioBean annuncioBean) {
        return AnnuncioDao.checkannouncelocatore(annuncioBean);
    }
}
