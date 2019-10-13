package Dao;

import Bean.AppartamentoBean;
import Entity.Appartamento;
import Entity.Stanza;
import javafx.scene.control.Alert;
import patternConnessione.DMsingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppartamentoDao {


    private final static String status = "Disponibile";

    public static boolean inserisciAppartamento(AppartamentoBean apbean) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            if (appartamentoEsistente(apbean.getApartmentId())) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Attenzione!");
                alert.setContentText("L'appartamento inserito è già esistente.");
                alert.showAndWait();

                return false;
            }

            try {

                conn = DMsingleton.getInstance().getConnection();
                String sql = ("INSERT INTO appartamento(id, utente_id, status, descrizione, indirizzo, periodo," +
                        "stanze,completo,gruppo,citta) VALUES (?,?,?,?,?,?,?,?,?,?)");
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, apbean.getApartmentId());
                stmt.setString(2, apbean.getRenter().getUserid());
                stmt.setString(3, status);
                stmt.setString(4, apbean.getDescription());
                stmt.setString(5, apbean.getSurfaceAddress());
                stmt.setDate(6, (java.sql.Date) apbean.getData());
                stmt.setInt(7, apbean.getStanze());
                stmt.setBoolean(8, apbean.isAppcompleto());
                stmt.setBoolean(9, apbean.isAppGruppo());
                stmt.setString(10,apbean.getCitta());

                stmt.executeUpdate();

                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();

            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Attenzione!");
                alert.setHeaderText("Inserimento non andato a buon fine");
                alert.showAndWait();
                alert.close();

                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public static boolean appartamentoEsistente(int Id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT id FROM appartamento WHERE id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int aptmId = rs.getInt("id");
                if (aptmId == Id)
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

    public static ArrayList<Appartamento>  ottieniAppartamento(String nickname) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Appartamento> Appartamenti = new ArrayList<Appartamento>();
        try {
            conn = DMsingleton.getInstance().getConnection();
            String sql = "SELECT * from appartamento where utente_id = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            ResultSet rs = stmt.executeQuery();

            int i = 0;
            Appartamento app[] = new Appartamento[50];
            while(rs.next()) {
                int aptId = rs.getInt("id");
                String address = rs.getString("indirizzo");
                String citta = rs.getString("citta");
                app[i] = new Appartamento(aptId,address,citta);
                System.out.println(citta);
                Appartamenti.add(app[i]);
                i++;
            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return Appartamenti;
    }

    public static ArrayList<Stanza> ottieniStanze(String nickname, int apartmentId)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ArrayList<Stanza> Stanze = new ArrayList<Stanza>();
        try {
            conn = DMsingleton.getInstance().getConnection();
            String sql = "select * from stanza s join appartamento a   " +
                    "on s.id_appartamento = a.id " +
                    "where s.utente_id_stanza = ? and s.id_appartamento = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nickname);
            stmt.setInt(2,apartmentId);
            ResultSet rs = stmt.executeQuery();

            int i = 0;
            while(rs.next()) {
                int stanza_id = rs.getInt("id_stanza");
                String  indirizzo = rs.getString("indirizzo");
                Appartamento app = new Appartamento(apartmentId,indirizzo);
                Stanza stanza = new Stanza(stanza_id,app);
                Stanze.add(i,stanza);
                i++;
            }
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return Stanze;
    }

}
