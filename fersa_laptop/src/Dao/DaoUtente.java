package Dao;

import Bean.UtenteBean;
import Entity.Utente;
import Entity.UtenteFactory;
import javafx.scene.control.Alert;
import patternConnessione.DMsingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtente {


    public static Utente findUtente(String inputid, String inputpassword) {

        Utente u = null;
        UtenteFactory uf;
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            //conn = DMsingleton.getConnection();
            conn = DMsingleton.getInstance().getInstance().getConnection();

            String sql = "SELECT * FROM utente WHERE nickname = ? AND password = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, inputid);
            stm.setString(2, inputpassword);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int type = rs.getInt("type");
                String nickname = rs.getString("nickname");
                String pass = rs.getString("password");

                uf = new UtenteFactory(nickname, pass, type);
                u = uf.getUtente(type, nickname, pass);
            }
            if (stm != null)
                stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public static boolean insertUtente(String username, String password, int type) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            if (utenteEsistente(username)) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("");
                alert.setHeaderText("Attenzione!");
                alert.setContentText("L'utente inserito è già esistente.");
                alert.showAndWait();

                return false;
            }

            try {

                conn = DMsingleton.getInstance().getConnection();
                String sql = ("INSERT INTO utente(nickname, password, type) " +
                        "VALUES (?,?,?)");
                stmt = conn.prepareStatement(sql);

                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setInt(3, type);

                stmt.executeUpdate();

                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public static void updateLocatore(UtenteBean user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "UPDATE utente SET type = 1 WHERE nickname = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUserid());
            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateLocatario(UtenteBean user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "UPDATE utente SET type = 2 WHERE nickname = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUserid());
            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateLocatoreLocatario(UtenteBean user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "UPDATE utente SET type = 3 WHERE nickname = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUserid());
            stmt.executeUpdate();

            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean utenteEsistente(String username) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DMsingleton.getInstance().getConnection();

            String sql = "SELECT * FROM utente WHERE nickname = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nickname = rs.getString("nickname");
                if (nickname.equals(username))
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
/*
    public static void setNotifica(String notifica, String user, Thread_Pool_Connection Tpl) {
        PreparedStatement stmt = null;
        Connection conn = null;

        try {
            conn = Tpl.getConnection();

            String sql = "update utente set notifica = ? where nickname = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, notifica);
            stmt.setString(2, user);

            stmt.executeUpdate();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();


        } catch (Exception e) {
            e.printStackTrace();

        }
        Tpl.returnConnection(conn);
    }*/
}



