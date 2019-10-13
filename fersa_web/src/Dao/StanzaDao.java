package Dao;

import View.StanzaBean;
import javafx.scene.control.Alert;
import patternConnessione.DMsingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StanzaDao {
    public static void inserisciStanza(StanzaBean stanzaBean,int appartament_id, String nickname_utente) {
            Connection conn = null;
            PreparedStatement stmt=null;
            try{
                if (stanzaEsistente(stanzaBean.getStanzaid(),appartament_id)) {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("");
                    alert.setHeaderText("Attenzione!");
                    alert.setContentText("La stanza inserita è gia esistente");
                    alert.showAndWait();
                }

                try {

                    conn = DMsingleton.getInstance().getConnection();
                    String sql=("INSERT INTO stanza(id_stanza, id_appartamento, utente_id_stanza, doccia, vasca, gas,"+
                            "macchinadelgas,frigorifero,lavastoviglie,riscaldamento,misuratoreconsumosingolaUnita," +
                            "termostato,wifi,postiletto,prezzo_stanza) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                    stmt=conn.prepareStatement(sql);
                    stmt.setInt(1, stanzaBean.getStanzaid());
                    stmt.setInt(2, appartament_id);
                    stmt.setString(3, nickname_utente);
                    stmt.setBoolean(4,stanzaBean.isDoccia());
                    stmt.setBoolean(5,stanzaBean.isVasca());
                    stmt.setString(6, stanzaBean.getGas());
                    stmt.setBoolean(7,stanzaBean.isMacchinaDelGas());
                    stmt.setBoolean(8,stanzaBean.isFrigorifero());
                    stmt.setBoolean(9,stanzaBean.isLavastoviglie());
                    stmt.setString(10, stanzaBean.getRiscaldamento());
                    stmt.setBoolean(11, stanzaBean.isMisuratoreConsumoSingolaUnità());
                    stmt.setBoolean(12, stanzaBean.isTermostato());
                    stmt.setBoolean(13, stanzaBean.isWifi());
                    stmt.setInt(14, stanzaBean.getPostiLetto());
                    stmt.setInt(15,stanzaBean.getPrezzo_stanza());

                    stmt.executeUpdate();

                    if(stmt != null)
                        stmt.close();
                    if(conn != null)
                        conn.close();

                }catch(SQLException e) {
                    e.printStackTrace();
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static boolean stanzaEsistente(int stanza_id,int appartamento_id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT id_stanza FROM stanza WHERE id_appartamento = ? and id_stanza = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, appartamento_id);
            stmt.setInt(2,stanza_id);
            ResultSet rs=stmt.executeQuery();

            if (rs.next()) {
                int  stanza_query_id = rs.getInt("id_stanza");
                if (stanza_query_id == stanza_id )
                    return true;
            }
            if (stmt != null)
                stmt.close();
            if(conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();


        }
        return false;
    }
}
