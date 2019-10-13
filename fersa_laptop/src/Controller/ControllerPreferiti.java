package Controller;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Dao.AnnuncioDao;
import Entity.Annuncio;

import java.util.ArrayList;

public class ControllerPreferiti extends MainController {

    private static ControllerPreferiti instance = null;

    public static ControllerPreferiti getInstance() {
        if (instance == null) {
            instance = new ControllerPreferiti();
        }
        return instance;
    }

    public ArrayList<AnnuncioBean> displayRenterFavoriteAnnounces(String nickname) {

        ArrayList<Annuncio> annunciFavoriti = new ArrayList<Annuncio>();

        annunciFavoriti = AnnuncioDao.displayRenterFavoriteAnnounces(nickname);
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();
        for (Annuncio a : annunciFavoriti) {

            AnnuncioBean annuncioBean = new AnnuncioBean();

            annuncioBean.setNomeAnnuncio(a.getAnnounceName());
            UtenteBean ub = new UtenteBean();
            ub.setUserid(a.getNickname());
            annuncioBean.setUser(ub);
            annuncioBean.setPrezzoMin(a.getMinprice());
            annuncioBean.setPrezzoMax(a.getMaxprice());
            annuncioBean.setCity(a.getCity());

            annunciBean.add(annuncioBean);
        }

        return annunciBean;
    }

    public ArrayList<AnnuncioBean> displayTenantFavoriteAnnounces(String nickname) {

        ArrayList<Annuncio> annunciFavoriti = new ArrayList<Annuncio>();

        annunciFavoriti = AnnuncioDao.displayTenantFavoriteAnnounces(nickname);
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();
        for (Annuncio a : annunciFavoriti) {

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

    public boolean checkannouncelocatore(AnnuncioBean annuncioBean) {
        return AnnuncioDao.checkannouncelocatore(annuncioBean);

    }


}
