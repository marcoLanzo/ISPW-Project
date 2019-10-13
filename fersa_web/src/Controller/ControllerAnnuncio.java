package Controller;

import Dao.AnnuncioDao;
import Dao.DaoUtente;
import Model.Annuncio;
import Model.AnnuncioLocatario;
import Model.AnnuncioLocatore;
import View.AnnuncioBean;
import View.AppartamentoBean;
import View.StanzaBean;
import View.UtenteBean;

import java.util.ArrayList;

public class ControllerAnnuncio extends MainController {

    private static ControllerAnnuncio instance = null;

    public static ControllerAnnuncio getInstance() {
        if (instance == null) {
            instance = new ControllerAnnuncio();
        }
        return instance;
    }

    public boolean inserisciAnnuncio(AnnuncioBean annuncioBean) {

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
                default: // 2 e 3 già sei locatore oppure locatore/locatario
                    break;

            }
            return true;

        }
        return false;
    }

    public ArrayList<AnnuncioBean> displayRenterShowcase() {

        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();
        ArrayList<AnnuncioBean> annunciBean = new ArrayList<AnnuncioBean>();
        UtenteBean ub = new UtenteBean();

        annunci = AnnuncioDao.getAllRenterAnnounces();

        for (Annuncio a : annunci) {

            AnnuncioBean annuncioBean = new AnnuncioBean();

            annuncioBean.setNomeAnnuncio(a.getAnnounceName());
            ub.setUserid(a.getNickname());
            annuncioBean.setUser(ub);
            annuncioBean.setDescription(a.getDescription());
            annuncioBean.setPrezzoMax(a.getMaxprice());
            annuncioBean.setCity(a.getCity());
            annuncioBean.setAnnounceId(a.getID());
            annuncioBean.setAddress(a.getIndirizzo());

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
            annuncioBean.setAnnounceId(a.getID());
            UtenteBean ub = new UtenteBean();
            ub.setUserid(a.getNickname());
            annuncioBean.setUser(ub);
            annuncioBean.setPrezzoMin(a.getMinprice());
            annuncioBean.setPrezzoMax(a.getMaxprice());
            annuncioBean.setCity(a.getCity());
            annuncioBean.setDescription(a.getDescription());

            annunciBean.add(annuncioBean);

        }

        return annunciBean;
    }

   public AnnuncioBean getRenterAnnounce(AnnuncioBean annuncioBean) {

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
        ab.setStanzaBean(sb);

        return ab;
    }

    public AnnuncioBean getTenantAnnounce(AnnuncioBean annuncioBean) {

        AnnuncioLocatario annuncioLocatario;
        annuncioLocatario = AnnuncioDao.annuncioselezionatolocatario(annuncioBean);

        AnnuncioBean ab= new AnnuncioBean();
        AppartamentoBean ap= new AppartamentoBean();
        StanzaBean sb = new StanzaBean();
        UtenteBean ub = new UtenteBean();
        ab.setNomeAnnuncio(annuncioLocatario.getAnnounceName());
        ap.setDescription(annuncioLocatario.getDescription());
        ab.setPrezzoMax(annuncioLocatario.getMaxprice());
        ab.setAttivo(annuncioLocatario.isAttivo());
        ab.setAnnounceId(annuncioLocatario.getID());
        ab.setSignal(annuncioLocatario.isSignaled());
        ab.setDate(annuncioLocatario.getDate());
        ap.setCitta(annuncioLocatario.getCity());
        ap.setStanze(annuncioLocatario.getnPostiLetto());
        ub.setUserid(annuncioLocatario.getNickname());
        sb.setDoccia(annuncioLocatario.isDoccia());
        sb.setVasca(annuncioLocatario.isVasca());
        sb.setGas(annuncioLocatario.getGas());
        sb.setMacchinaDelGas(annuncioLocatario.isMacchinadelgas());
        sb.setFrigorifero(annuncioLocatario.isFrigorifero());
        sb.setLavastoviglie(annuncioLocatario.isLavastoviglie());
        sb.setRiscaldamento(annuncioLocatario.getRiscaldamento());
        sb.setMisuratoreConsumoSingolaUnità(annuncioLocatario.isMisuratoreconsumosingolaunita());
        sb.setTermostato(annuncioLocatario.isTermostato());
        sb.setWifi(annuncioLocatario.isWifi());
        sb.setPostiLetto(annuncioLocatario.getPostiletto());
        ab.setUser(ub);
        ab.setAppartamentoBean(ap);
        ab.setStanzaBean(sb);

        return ab;
    }


}