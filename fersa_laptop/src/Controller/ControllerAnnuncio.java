package Controller;

import Bean.AnnuncioBean;
import Bean.StanzaBean;
import Bean.UtenteBean;
import Dao.AnnuncioDao;
import Dao.DaoUtente;
import Entity.Annuncio;
import Entity.AnnuncioLocatore;
import java.sql.SQLException;
import java.util.ArrayList;
import Exception.AnnuncioesistenteException;


public class ControllerAnnuncio extends MainController {

    private static ControllerAnnuncio instance = null;

    public synchronized static ControllerAnnuncio getInstance() {
        if (instance == null) {
            instance = new ControllerAnnuncio();
        }
        return instance;
    }

    public boolean inserisciAnnuncio(AnnuncioBean annuncioBean) throws AnnuncioesistenteException {

        if (AnnuncioDao.inserisciAnnuncioLocatore(annuncioBean))
            return true;
        else return false;
    }

    public boolean inserisciAnnuncioLocatario(AnnuncioBean annuncioBean) {

        if (AnnuncioDao.inserisciAnnuncioLocatario(annuncioBean)) {

            switch (annuncioBean.getUser().getType()) {
                case 0: // Sei un ospite diventi locatario
                    DaoUtente.updateLocatario(annuncioBean.getUser());
                    break;
                case 1: // sei un locatario diventi anche un locatore
                    DaoUtente.updateLocatoreLocatario(annuncioBean.getUser());
                    break;
                case 2: // 2 e 3 già sei locatore oppure locatore/locatario
                    break;
                case 3:
                    break;

            }
            return true;

        }
        return false;
    }


    public ArrayList<AnnuncioBean> displayRenterShowcase() {

        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();

        annunci = AnnuncioDao.getAllRenterAnnounces();

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

            annunciBean.add(annuncioBean);

        }

        return annunciBean;
    }

    public ArrayList<AnnuncioBean> displayHistoricalRenter(String nickname) {
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();
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

            annunciBean.add(annuncioBean);
        }

        return annunciBean;
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

            annunciBean.add(annuncioBean);

        }
        return annunciBean;

    }


    public String getCity(StanzaBean stanzaSelezionata) {

        return AnnuncioDao.getCity(stanzaSelezionata);
    }

    public boolean inserisciAnnuncioPreferiti(AnnuncioBean ab, UtenteBean ub) {

        return AnnuncioDao.inserisciAnnuncioPreferiti(ab, ub);


    }

    public boolean checkpreferiti(int announceId, String userid) {

        return AnnuncioDao.annuncioPreferitoEsistente(announceId, userid);
    }


    public ArrayList<AnnuncioBean> displayRenterActives(String nickname) {

        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();
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

            annunciBean.add(annuncioBean);
        }

        return annunciBean;
    }


    public ArrayList<AnnuncioBean> displayFavoriteAnnounces(String nickname) {

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

     public void disattivaAnnuncio(AnnuncioBean annunciobean) throws SQLException {

        Annuncio annuncio = new AnnuncioLocatore(annunciobean.getAnnounceId(),annunciobean.getNomeAnnuncio());
        AnnuncioDao.disattivaAnnuncio(annuncio);
        annuncio.setAttivo(false);

     }

}