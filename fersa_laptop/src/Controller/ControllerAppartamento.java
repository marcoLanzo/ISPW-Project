package Controller;

import Bean.AppartamentoBean;
import Bean.StanzaBean;
import Bean.UtenteBean;
import Dao.AppartamentoDao;
import Dao.DaoUtente;
import Dao.StanzaDao;
import Entity.Appartamento;
import Entity.Stanza;

import java.util.ArrayList;

public class ControllerAppartamento extends MainController {

    private static ControllerAppartamento instance = null;
    private static  StanzaBean stanzaBean;
    private static UtenteBean ubean;


    public static UtenteBean getUbean() {
        return ubean;
    }

    public static void setUbean(UtenteBean ubean) {
        ControllerAppartamento.ubean = ubean;
    }

    private ControllerAppartamento() {
    }

    //pattern singleton
    public synchronized static ControllerAppartamento getInstance() {
        if (instance == null) {
            instance = new ControllerAppartamento();
        }
        return instance;
    }

    public boolean inserisciAppartamento(AppartamentoBean apbean) {

        ArrayList<StanzaBean> sB;
        sB = apbean.getRooms();


        if (AppartamentoDao.inserisciAppartamento(apbean)) {
            for (int i = 0; i < apbean.getStanze(); i++) {
                StanzaDao.inserisciStanza(sB.get(i), apbean.getApartmentId(), apbean.getRenter().getUserid());
                if (i == apbean.getStanze() - 1) {
                    switch (apbean.getRenter().getType()) {
                        case 0: // Sei un ospite diventi locatore
                            DaoUtente.updateLocatore(apbean.getRenter());
                            break;
                        case 2: // sei un locatario diventi anche un locatore
                            DaoUtente.updateLocatoreLocatario(apbean.getRenter());
                            break;
                        default: // 1 e 3 già sei locatore oppure locatore/locatario
                            break;
                    }
                } else {
                    continue;

                }
            }
            return true;
        }else
            return false;
    }

    public ArrayList<AppartamentoBean> ottieniAppartamento(String nickname){

        ArrayList<Appartamento> App = new ArrayList<Appartamento>();
        App = AppartamentoDao.ottieniAppartamento(nickname);
        ArrayList<AppartamentoBean> aB = new ArrayList<AppartamentoBean>();
        AppartamentoBean ab[] = new AppartamentoBean[App.size()];
        for (int i = 0; i<App.size();i++){
            System.out.println(App.get(i).getApartmentId());
            ab[i] = new AppartamentoBean();
            ab[i].setApartmentId(App.get(i).getApartmentId());
            ab[i].setSurfaceAddress(App.get(i).getSurfaceAddress());
            ab[i].setCitta(App.get(i).getCitta());
            aB.add(ab[i]);
        }

        return aB;
    }

    public ArrayList<StanzaBean> ottieniStanza(String nickname){

        ArrayList<Stanza> Stanze = new ArrayList<Stanza>();
        ArrayList<Appartamento> App = new ArrayList<Appartamento>();
        App = AppartamentoDao.ottieniAppartamento(nickname);
        for (int i = 0; i<App.size();i++){
            Stanze.addAll(AppartamentoDao.ottieniStanze(nickname,App.get(i).getApartmentId()));
        }

        ArrayList<StanzaBean> sB = new ArrayList<StanzaBean>();
        StanzaBean sb[] = new StanzaBean[Stanze.size()];
        for (int i = 0; i<Stanze.size();i++){
            sb[i] = new StanzaBean();
            sb[i].setStanzaid(Stanze.get(i).getStanzaId());
            sb[i].setAppartamentoId(Stanze.get(i).getAppartamento().getApartmentId());
            sb[i].setIndirizzo(Stanze.get(i).getAppartamento().getSurfaceAddress());
            sB.add(sb[i]);
        }

        return sB;
    }

}


