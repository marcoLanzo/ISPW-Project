package Dao;

import Model.*;
import View.AnnuncioBean;
import javafx.scene.control.Alert;
import patternConnessione.DMsingleton;

import java.sql.*;
import java.util.ArrayList;

public class AnnuncioDao {


    public static ArrayList<Annuncio> displayTenantFavoriteAnnounces;


    public static boolean inserisciAnnuncioLocatore(AnnuncioBean annuncioBean) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {

            if (annuncioAppartamentoEsistente(annuncioBean.isAttivo(), annuncioBean.getAppartamentoId()))
                return false;


            conn = DMsingleton.getInstance().getConnection();

            // annuncio appartamento con chiave esterna stanza null

            String sql = ("INSERT INTO annunciolocatore(id_annuncio, utente, appartamento, attivo," +
                    "segnalazione,datainserimento,prezzo,nome_annuncio,citta) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)");
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, annuncioBean.getAnnounceId());
            stmt.setString(2, annuncioBean.getUser().getUserid());
            stmt.setInt(3, annuncioBean.getAppartamentoId());
            stmt.setBoolean(4, annuncioBean.isAttivo());
            stmt.setBoolean(5, annuncioBean.isSignal());
            stmt.setDate(6, (Date) annuncioBean.getDate());
            stmt.setInt(7, annuncioBean.getPrezzoMax());
            stmt.setString(8, annuncioBean.getNomeAnnuncio());
            stmt.setString(9, annuncioBean.getCity());


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
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt = conn.prepareStatement(sql);

            stmt.setInt(13, annuncioBean.getPrezzoMin());
            stmt.setBoolean(18, annuncioBean.isAppartamento());
            stmt.setBoolean(21, annuncioBean.isAttivo());
            stmt.setDate(20, (Date)(annuncioBean.getDate()));
            stmt.setString(16, annuncioBean.getDescription());
            stmt.setBoolean(1, annuncioBean.isDoccia());
            stmt.setInt(15, annuncioBean.getAnnounceId());
            stmt.setInt(14, annuncioBean.getPrezzoMax());
            stmt.setBoolean(22, annuncioBean.isSignal());
            stmt.setBoolean(17, annuncioBean.isStanza());
            stmt.setString(19, annuncioBean.getUser().getUserid());
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
           // int i = 0;

            String sql = "SELECT * FROM annunciolocatore;";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                String utente = rs.getString("utente");
                int prezzo = rs.getInt("prezzo");
                String città = rs.getString("citta");
                int id_annuncio = rs.getInt("id_annuncio");

                Annuncio a = new AnnuncioLocatore(nomeAnnuncio, utente, prezzo, città, id_annuncio);

                annunci.add(a);
               // i++;

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

            String sql = "SELECT * FROM annunciolocatario;";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int idAnnuncio = rs.getInt("id");
                String nomeAnnuncio = rs.getString("nome_annuncio");
                String descrizione = rs.getString("descrizione");
                String utente = rs.getString("utente");
                int prezzominimo = rs.getInt("prezzominimo");
                int prezzomassimo = rs.getInt("prezzomassimo");
                String città = rs.getString("citta");

                Annuncio a = new AnnuncioLocatario(idAnnuncio, nomeAnnuncio, descrizione, utente, prezzominimo, prezzomassimo, città);

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
                Date datainserimento = rs.getDate("datainserimento");
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


                Stanza stanza = new Stanza(stanza_id,doccia,vasca,gas,macchinadelgas,frigorifero,lavastoviglie,
                        riscaldamento,misuratoreconsumosingolaunita,termostato,wifi,postiletto);
                Appartamento appartamento = new Appartamento(appartament_id,indirizzo,numeroStanze,gruppo,completo,
                        descrizione,citta);
                annuncioLocatore = new AnnuncioLocatore(nomeAnnuncio,utente,prezzomassimo,citta,id_annuncio,appartamento,stanza,
                        datainserimento,attivo, segnalazione);


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

            while (rs.next()) {

                String nomeAnnuncio = rs.getString("nome_annuncio");
                int id_annuncio = rs.getInt("id");
                String utente = rs.getString("utente");
                int prezzomassimo = rs.getInt("prezzomassimo");
                int prezzominimo = rs.getInt("prezzominimo");
                String citta = rs.getString("citta");
                boolean appartamento = rs.getBoolean("appartamento");
                boolean stanza = rs.getBoolean("stanza");
                boolean attivo = rs.getBoolean("attivo");
                boolean segnalazione = rs.getBoolean("segnalazione");
                Date datainserimento = rs.getDate("datainserimento");
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


                annuncioLocatario = new AnnuncioLocatario(nomeAnnuncio,id_annuncio,utente,prezzomassimo,prezzominimo,
                        citta,appartamento,stanza,attivo,segnalazione,datainserimento,descrizione,doccia,vasca,gas,
                        macchinadelgas,frigorifero,lavastoviglie,riscaldamento,misuratoreconsumosingolaunita,termostato,
                        wifi,postiletto);

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
