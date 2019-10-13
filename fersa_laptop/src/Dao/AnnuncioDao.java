package Dao;

import Bean.AnnuncioBean;
import Bean.StanzaBean;
import Bean.UtenteBean;
import Entity.*;
import javafx.scene.control.Alert;
import patternConnessione.DMsingleton;
import patternConnessione.DMsingletonThread;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import Exception.AnnuncioesistenteException;



@SuppressWarnings("ALL")
public class AnnuncioDao {


    public static ArrayList<Annuncio> displayTenantFavoriteAnnounces;
    static Semaphore s = new Semaphore(2);

    public static boolean inserisciAnnuncioLocatore(AnnuncioBean annuncioBean) throws AnnuncioesistenteException{

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            if (annuncioBean.getStanza_id() == 0) { //annuncio appartamento
                if (annuncioAppartamentoEsistente(annuncioBean.isAttivo(), annuncioBean.getAppartamentoId())) {


                    throw new AnnuncioesistenteException();
                }
            } else { //annuncio stanza
                if (annuncioStanzaEsistente(annuncioBean.isAttivo(), annuncioBean.getStanza_id())) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("");
                    alert.setHeaderText("Attenzione!");
                    alert.setContentText("L'annuncio sulla stanza inserita è già esistente.");
                    alert.showAndWait();

                    return false;
                }

            }

            conn = DMsingleton.getInstance().getConnection();

            if (annuncioBean.getStanza_id() != 0) { //annuncio stanza

                String sql = ("INSERT INTO annunciolocatore(id_annuncio, utente, appartamento, stanza, attivo," +
                        "segnalazione,datainserimento,prezzo,nome_annuncio,citta, counter_renting) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                stmt = conn.prepareStatement(sql);

                stmt.setInt(1, annuncioBean.getAnnounceId());
                stmt.setString(2, annuncioBean.getUser().getUserid());
                stmt.setInt(3, annuncioBean.getAppartamentoId());
                stmt.setInt(4, annuncioBean.getStanza_id());
                stmt.setBoolean(5, annuncioBean.isAttivo());
                stmt.setBoolean(6, annuncioBean.isSignal());
                stmt.setTimestamp(7, annuncioBean.getDate());
                stmt.setInt(8, annuncioBean.getPrezzoMax());
                stmt.setString(9, annuncioBean.getNomeAnnuncio());
                stmt.setString(10, annuncioBean.getCity());
                stmt.setInt(11, annuncioBean.getCounterRenting());
                } else { // annuncio appartamento con chiave esterna stanza null

                String sql = ("INSERT INTO annunciolocatore(id_annuncio, utente, appartamento, attivo," +
                        "segnalazione,datainserimento,prezzo,nome_annuncio,citta, counter_renting) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?)");
                stmt = conn.prepareStatement(sql);

                stmt.setInt(1, annuncioBean.getAnnounceId());
                stmt.setString(2, annuncioBean.getUser().getUserid());
                stmt.setInt(3, annuncioBean.getAppartamentoId());
                stmt.setBoolean(4, annuncioBean.isAttivo());
                stmt.setBoolean(5, annuncioBean.isSignal());
                stmt.setTimestamp(6,  annuncioBean.getDate());
                stmt.setInt(7, annuncioBean.getPrezzoMax());
                stmt.setString(8, annuncioBean.getNomeAnnuncio());
                stmt.setString(9, annuncioBean.getCity());
                stmt.setInt(10, annuncioBean.getCounterRenting());

            }

            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


        return true;

    }


    public static boolean inserisciAnnuncioLocatore(int id, String nickname) {

        Connection conn = null;
        PreparedStatement stmt = null;

        boolean t = true;
        boolean f = false;
        String s = "Il mio annuncio";
        LocalDate locald = LocalDate.now();
        Date d = Date.valueOf(locald);

        try {

            conn = DMsingleton.getInstance().getConnection();

            if (id != 0) { //annuncio stanza

                String sql = ("SELECT * from appartamento where id = ? and utente_id = ? ");
                stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.setString(2, nickname);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {

                    String sql2 = ("INSERT INTO annunciolocatore(id_annuncio, utente, appartamento, attivo, " +
                            "segnalazione,datainserimento,prezzo,nome_annuncio,citta) " + "VALUES(?,?,?,?,?,?,?,?,?)");

                    PreparedStatement stmt2 = conn.prepareStatement(sql2);

                    stmt2.setInt(1, (int) (Math.random() * 1000 + 1));
                    stmt2.setString(2, nickname);
                    stmt2.setInt(3, id);
                    stmt2.setBoolean(4, t);
                    stmt2.setBoolean(5, f);
                    stmt2.setDate(6, d);
                    stmt2.setInt(7, rs.getInt("prezzo"));
                    stmt2.setString(8, s);
                    stmt2.setString(9, rs.getString("citta"));


                    stmt2.executeUpdate();

                    if (stmt2 != null)
                        stmt2.close();
                }

            } else { // annuncio appartamento

                String sql = ("SELECT * from stanza where id_stanza = ? and utente_id_stanza = ? ");
                stmt = conn.prepareStatement(sql);

                stmt.setInt(1, id);
                stmt.setString(2, nickname);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {

                    String sql2 = ("INSERT INTO annunciolocatore(id_annuncio, utente, appartamento, attivo, " +
                            "segnalazione,datainserimento,prezzo,nome_annuncio,citta,stanza) " + "VALUES(?,?,?,?,?,?,?,?,?,?)");

                    PreparedStatement stmt2 = conn.prepareStatement(sql2);

                    stmt2.setInt(1, (int) (Math.random() * 1000 + 1));
                    stmt2.setString(2, nickname);
                    stmt2.setInt(3, id);
                    stmt2.setBoolean(4, t);
                    stmt2.setBoolean(5, f);
                    stmt2.setDate(6, d);
                    stmt2.setInt(7, rs.getInt("prezzo"));
                    stmt2.setString(8, s);
                    stmt2.setString(9, rs.getString("citta"));
                    stmt2.setInt(10, rs.getInt("stanza"));

                    stmt2.executeUpdate();

                    if (stmt2 != null)
                        stmt2.close();

                }
            }

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


        return true;

    }


    public static boolean inserisciAnnuncioLocatario(AnnuncioBean annuncioBean) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            if (annuncioEsistente(annuncioBean.getAnnounceId())) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Attenzione!");
                alert.setContentText("L'annuncio inserito è già esistente.");
                alert.showAndWait();

                return false;
            }

            conn = DMsingleton.getInstance().getConnection();
            String sql = ("INSERT INTO annunciolocatario(doccia,vasca,gas,macchinadelgas,frigorifero,"
                    + "lavastoviglie,riscaldamento,misuratoreconsumosingolaunita,termostato,wifi,citta,postiletto," +
                    "prezzominimo,prezzomassimo,id,descrizione,stanza,"
                    + "appartamento,utente,datainserimento,attivo,segnalazione, nome_annuncio)" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt = conn.prepareStatement(sql);

            stmt.setBoolean(1, annuncioBean.isDoccia());
            stmt.setBoolean(2, annuncioBean.isVasca());
            stmt.setString(3, annuncioBean.getGas());
            stmt.setBoolean(4, annuncioBean.isMacchinaDelGas());
            stmt.setBoolean(5, annuncioBean.isFrigorifero());
            stmt.setBoolean(6, annuncioBean.isLavastoviglie());
            stmt.setString(7, annuncioBean.getRiscaldamento());
            stmt.setBoolean(8, annuncioBean.isMisuratoreConsumoSingolaUnità());
            stmt.setBoolean(9, annuncioBean.isTermostato());
            stmt.setBoolean(10, annuncioBean.isWifi());
            stmt.setString(11, annuncioBean.getCity());
            stmt.setInt(12, annuncioBean.getPostiLetto());
            stmt.setInt(13, annuncioBean.getPrezzoMin());
            stmt.setInt(14, annuncioBean.getPrezzoMax());
            stmt.setInt(15, annuncioBean.getAnnounceId());
            stmt.setString(16, annuncioBean.getDescription());
            stmt.setBoolean(17, annuncioBean.isStanzaboolean());
            stmt.setBoolean(18, annuncioBean.isAppartamentoboolean());
            stmt.setString(19, annuncioBean.getUser().getUserid());
            stmt.setTimestamp(20, annuncioBean.getDate());
            stmt.setBoolean(21, annuncioBean.isAttivo());
            stmt.setBoolean(22, annuncioBean.isSignal());
            stmt.setString(23, annuncioBean.getNomeAnnuncio());


            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean annuncioStanzaEsistente(boolean attivo, int idStanza) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatore WHERE stanza = ? and attivo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idStanza);
            stmt.setBoolean(2, attivo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return false;
    }

    public static boolean annuncioAppartamentoEsistente(boolean attivo, int idAppartamento) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatore WHERE appartamento = ? and attivo = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAppartamento);
            stmt.setBoolean(2, attivo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return false;
    }

    public static boolean annuncioEsistente(int announce_id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT id_annuncio FROM annunciolocatore WHERE id_annuncio = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, announce_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return false;
    }

    public static ArrayList<Annuncio> getAllRenterAnnounces() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatore where attivo = true;";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                String utente = rs.getString("utente");
                int prezzo = rs.getInt("prezzo");
                String citta = rs.getString("citta");
                int id_annuncio = rs.getInt("id_annuncio");

                Annuncio a = new AnnuncioLocatore(nomeAnnuncio, utente, prezzo, citta, id_annuncio);

                annunci.add(a);

            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return annunci;
    }

    public static ArrayList<Annuncio> getAllTenantAnnounces() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatario where attivo = true;";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                String utente = rs.getString("utente");
                int prezzominimo = rs.getInt("prezzominimo");
                int prezzomassimo = rs.getInt("prezzomassimo");
                String città = rs.getString("citta");
                int id = rs.getInt("id");

                Annuncio a = new AnnuncioLocatario(id,nomeAnnuncio, utente, prezzominimo, prezzomassimo, città);

                annunci.add(a);

            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return annunci;
    }

    public static ArrayList<Annuncio> displayHistoricalRenter(String nickname) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatore where utente = ? and attivo = 'false';";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                String utente = rs.getString("utente");
                int prezzo = rs.getInt("prezzo");
                String citta = rs.getString("citta");
                int id = rs.getInt("id_annuncio");

                Annuncio a = new AnnuncioLocatore(id,nomeAnnuncio, utente, prezzo, citta);

                annunci.add(a);

            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return annunci;
    }

    public static ArrayList<Annuncio> displayHistoricalTenant(String nickname) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingleton.getInstance().getConnection();
            String sql = "SELECT * FROM annunciolocatario where utente = ? and attivo = 'false';";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("descrizione");
                String utente = rs.getString("utente");
                int prezzominimo = rs.getInt("prezzominimo");
                int prezzomassimo = rs.getInt("prezzomassimo");
                String città = rs.getString("citta");
                int id = rs.getInt("id");

                Annuncio a = new AnnuncioLocatario(id,nomeAnnuncio, utente, prezzominimo, prezzomassimo, città);

                annunci.add(a);

            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return annunci;
    }

    public static String getCity(StanzaBean stanzaSelezionata) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String citta = null;

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT citta from appartamento where id =?";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, stanzaSelezionata.getAppartamentoId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                citta = rs.getString("citta");
            }

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return citta;
    }

    public static boolean inserisciAnnuncioPreferiti(AnnuncioBean ab, UtenteBean ub) {
        try {
            s.acquire(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            if (annuncioPreferitoEsistente(ab.getAnnounceId(), ub.getUserid())) {
                return deleteAnnuncioPreferiti(ab, ub);
            }
            conn = DMsingleton.getInstance().getConnection();

            String sql = ("INSERT INTO annuncipreferiti(id_preferito,utente_preferito) values (?,?) ");

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ab.getAnnounceId());
            stmt.setString(2, ub.getUserid());
            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        s.release(1);
        return true;
    }

    private static boolean deleteAnnuncioPreferiti(AnnuncioBean ab, UtenteBean ub) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "delete from  annuncipreferiti WHERE id_preferito = ? and utente_preferito = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ab.getAnnounceId());
            stmt.setString(2, ub.getUserid());

            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return false;
    }

    public static boolean annuncioPreferitoEsistente(int id_preferito, String userid) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DMsingleton.getInstance().getConnection();


            String sql = "select * from  annuncipreferiti WHERE id_preferito = ? and utente_preferito = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_preferito);
            stmt.setString(2, userid);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return false;
    }


    public static ArrayList<Annuncio> displayActiveRenter(String nickname) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatore where utente = ? and attivo = 'true';";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                String utente = rs.getString("utente");
                int prezzo = rs.getInt("prezzo");
                String citta = rs.getString("citta");
                int id_annuncio = rs.getInt("id_annuncio");

                Annuncio a = new AnnuncioLocatore(id_annuncio, nomeAnnuncio, utente, prezzo, citta);

                annunci.add(a);

            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return annunci;
    }

    public static ArrayList<Annuncio> displayActiveTenant(String nickname) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatario where utente = ? and attivo = 'true';";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                String utente = rs.getString("utente");
                int prezzominimo = rs.getInt("prezzominimo");
                int prezzomassimo = rs.getInt("prezzomassimo");
                String citta = rs.getString("citta");
                int id = rs.getInt("id");

                Annuncio a = new AnnuncioLocatario(id,nomeAnnuncio, utente, prezzominimo, prezzomassimo, citta);

                annunci.add(a);

            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        System.out.println(annunci);
        return annunci;
    }


    public static ArrayList<Annuncio> displayRenterFavoriteAnnounces(String nickname) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annuncipreferiti join annunciolocatario on  id_preferito = id where utente = ? ";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                String utente = rs.getString("utente");
                int prezzomassimo = rs.getInt("prezzomassimo");
                String citta = rs.getString("citta");
                int id = rs.getInt("id");

                Annuncio a = new AnnuncioLocatario(id, nomeAnnuncio, utente, prezzomassimo, citta);


                annunci.add(a);

            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        System.out.println(annunci);
        return annunci;
    }

    public static ArrayList<Annuncio> displayTenantFavoriteAnnounces(String nickname) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annuncipreferiti join annunciolocatore on id_preferito = id where utente_preferito = ? ";


            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                String utente = rs.getString("utente");
                int prezzo = rs.getInt("prezzo");
                String citta = rs.getString("citta");
                int id = rs.getInt("id");


                Annuncio a = new AnnuncioLocatore(id, nomeAnnuncio, utente, prezzo, citta);

                annunci.add(a);

            }

            System.out.println(annunci);
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        System.out.println(annunci);
        return annunci;
    }

    public static boolean checkannouncelocatore(AnnuncioBean annuncioBean) {
        Connection conn = null;
        PreparedStatement stmt = null;


        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatore where id_annuncio = ? ;";


            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, annuncioBean.getAnnounceId());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return false;
    }


    public static AnnuncioLocatore annuncioselezionatolocatore(AnnuncioBean annuncioBean) {

        Connection conn = null;
        PreparedStatement stmt = null;
        AnnuncioLocatore annuncioLocatore = null;
        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "select * from annunciolocatore join appartamento on appartamento = id " +
                    " join stanza on  id = id_appartamento and id_annuncio = ?  LIMIT 1; ";


            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, annuncioBean.getAnnounceId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                int id_annuncio = rs.getInt("id_annuncio");
                String utente = rs.getString("utente");
                int prezzomassimo = rs.getInt("prezzo");
                String citta = rs.getString("citta");
                int appartament_id = rs.getInt("appartamento");
                int stanza_id = rs.getInt("stanza");
                boolean attivo = rs.getBoolean("attivo");
                boolean segnalazione = rs.getBoolean("segnalazione");
                Timestamp datainserimento = rs.getTimestamp("datainserimento");
                String indirizzo = rs.getString("indirizzo");
                int numeroStanze = rs.getInt("stanze");
                boolean gruppo = rs.getBoolean("gruppo");
                boolean completo = rs.getBoolean("completo");
                String descrizione = rs.getString("descrizione");
                boolean doccia = rs.getBoolean("doccia");
                boolean vasca = rs.getBoolean("vasca");
                String gas = rs.getString("gas");
                boolean macchinadelgas = rs.getBoolean("macchinadelgas");
                boolean frigorifero = rs.getBoolean("frigorifero");
                boolean lavastoviglie = rs.getBoolean("lavastoviglie");
                String riscaldamento = rs.getString("riscaldamento");
                boolean misuratoreconsumosingolaunita = rs.getBoolean("misuratoreconsumosingolaunita");
                boolean termostato = rs.getBoolean("termostato");
                boolean wifi = rs.getBoolean("wifi");
                int postiletto = rs.getInt("postiletto");


                Stanza stanza = new Stanza(stanza_id, doccia, vasca, gas, macchinadelgas, frigorifero, lavastoviglie,
                        riscaldamento, misuratoreconsumosingolaunita, termostato, wifi, postiletto);
                Appartamento appartamento = new Appartamento(appartament_id, indirizzo, numeroStanze, gruppo, completo,
                        descrizione, citta);
                annuncioLocatore = new AnnuncioLocatore(nomeAnnuncio, utente, prezzomassimo, citta, id_annuncio, appartamento, stanza,
                        datainserimento, attivo, segnalazione);


            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return annuncioLocatore;
    }

    public static AnnuncioLocatario annuncioselezionatolocatario(AnnuncioBean annuncioBean) {

        Connection conn = null;
        PreparedStatement stmt = null;
        AnnuncioLocatario annuncioLocatario = null;
        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "select * from annunciolocatario where id = ?  LIMIT 1; ";


            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, annuncioBean.getAnnounceId());
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                int id = rs.getInt("id");
                String utente = rs.getString("utente");
                int prezzomassimo = rs.getInt("prezzomassimo");
                int prezzominimo = rs.getInt("prezzominimo");
                String citta = rs.getString("citta");
                boolean appartamento = rs.getBoolean("appartamento");
                boolean stanza = rs.getBoolean("stanza");
                boolean attivo = rs.getBoolean("attivo");
                boolean segnalazione = rs.getBoolean("segnalazione");
                Timestamp datainserimento = rs.getTimestamp("datainserimento");
                String descrizione = rs.getString("descrizione");
                boolean doccia = rs.getBoolean("doccia");
                boolean vasca = rs.getBoolean("vasca");
                String gas = rs.getString("gas");
                boolean macchinadelgas = rs.getBoolean("macchinadelgas");
                boolean frigorifero = rs.getBoolean("frigorifero");
                boolean lavastoviglie = rs.getBoolean("lavastoviglie");
                String riscaldamento = rs.getString("riscaldamento");
                boolean misuratoreconsumosingolaunita = rs.getBoolean("misuratoreconsumosingolaunita");
                boolean termostato = rs.getBoolean("termostato");
                boolean wifi = rs.getBoolean("wifi");
                int postiletto = rs.getInt("postiletto");


                annuncioLocatario = new AnnuncioLocatario(nomeAnnuncio, id, utente, prezzomassimo, prezzominimo,
                        citta, appartamento, stanza, attivo, segnalazione, datainserimento, descrizione, doccia, vasca, gas,
                        macchinadelgas, frigorifero, lavastoviglie, riscaldamento, misuratoreconsumosingolaunita, termostato,
                        wifi, postiletto);

            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return annuncioLocatario;
    }

    public static ArrayList<Annuncio> timerLista() {
        Connection conn = null;
        PreparedStatement stmt = null;
        AnnuncioLocatore annuncioLocatore;
        ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();

        try {
            conn = DMsingletonThread.getInstance().getConnection();

            String sql = "SELECT * FROM annunciolocatore WHERE attivo = true;";


            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                int id_annuncio = rs.getInt("id_annuncio");
                String utente = rs.getString("utente");
                Timestamp data_inserimento = rs.getTimestamp("datainserimento");
                int counter_renting = rs.getInt("counter_renting");
                annuncioLocatore = new AnnuncioLocatore(id_annuncio, utente, data_inserimento, counter_renting);

                annunci.add(annuncioLocatore);


            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return annunci;
    }

    public static void increase_counter_renting(AnnuncioBean ab) {


        Connection conn = null;
        PreparedStatement stmt = null;


        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = " UPDATE annunciolocatore SET counter_renting  = counter_renting + 1 WHERE id_annuncio =?;";


            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ab.getAnnounceId());
            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
    }

    public static boolean disattivaAnnuncio(Annuncio annuncio) {
        Connection conn = null;
        PreparedStatement stmt = null;


        try {
            conn = DMsingletonThread.getInstance().getConnection();

            String sql = " UPDATE annunciolocatore SET attivo = false WHERE id_annuncio =?;";


            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, annuncio.getID());
            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();
            return false;


        }

        return true;
    }

    public static ArrayList<Locatario> Utentinteressati(int announceId) {

        Connection conn = null;
        PreparedStatement stmt = null;
        String nickname;
        int id_annuncio;
        ArrayList<Locatario> locatari = new ArrayList<Locatario>();


        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = " select * from  annuncipreferiti where id_preferito =?;";


            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, announceId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                nickname = rs.getString("utente_preferito");
                id_annuncio = rs.getInt("id_preferito");

                Locatario l = new Locatario(nickname, id_annuncio);
                locatari.add(l);

            }

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return locatari;
    }

    /*public static boolean deletePreferiti(int id_annuncio) {

        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            conn = DMsingleton_storico.getInstance().getConnection();
            String sql = " delete from annuncipreferiti where id_preferito = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_annuncio);
            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }

        return true;
    }
*/
    public static boolean checkowner(int announceId, String nickname) {

        PreparedStatement stmt = null;
        Connection conn = null;


        try {
            conn = DMsingleton.getInstance().getConnection();
            String sql = " select * from annunciolocatore where id_annuncio = ? and utente = ?";


            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, announceId);
            stmt.setString(2, nickname);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
                return true;

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return false;
    }

}


