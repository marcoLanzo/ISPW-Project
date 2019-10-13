package Controller;

import Bean.AnnuncioBean;
import Bean.AppartamentoBean;
import Bean.StanzaBean;
import Bean.UtenteBean;
import Dao.AnnuncioDao;
import Entity.Annuncio;
import Entity.AnnuncioLocatario;
import Entity.AnnuncioLocatore;
import Entity.Appartamento;

import java.util.ArrayList;
import java.util.Date;

public class ControllerAnnunciAttivi extends MainController {

    private static ControllerAnnunciAttivi instance = null;

    public static ControllerAnnunciAttivi getInstance() {
        if (instance == null) {
            instance = new ControllerAnnunciAttivi();
        }
        return instance;
    }

    public ArrayList<AnnuncioBean> displayRenterActives(String nickname) {

        ArrayList<Annuncio> annunci;
        annunci = AnnuncioDao.displayActiveRenter(nickname);
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

    public ArrayList<AnnuncioBean> displayTenantActives(String nickname) {

        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();
        annunci = AnnuncioDao.displayActiveTenant(nickname);
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();
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


    public boolean checkannouncelocatore(AnnuncioBean annuncioBean) {
        return AnnuncioDao.checkannouncelocatore(annuncioBean);

    }

}
