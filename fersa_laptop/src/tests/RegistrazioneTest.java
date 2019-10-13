package tests;

import Bean.UtenteBean;
import Dao.DaoUtente;
import Entity.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.sql.*;
import java.util.Arrays;
import java.util.Collection;

import patternConnessione.DMsingleton;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class )
public class RegistrazioneTest {
    /* GENERO STRINGHE RANDOMICHE SU CUI EFFETTUARE TEST IN MANIERA OPPORTUNA */
    private static String nickname1 = RandomStringUtils.randomAlphabetic(10);
    private static String nickname2 = RandomStringUtils.randomAlphabetic(10);
    private static String nickname3 = RandomStringUtils.randomAlphabetic(10);
    private static String pwd1 = RandomStringUtils.randomAlphabetic(10);
    private static String pwd2 = RandomStringUtils.randomAlphabetic(10);
    private static String pwd3 = RandomStringUtils.randomAlphabetic(10);

    private static String nickname;
    private String pwd;
    int type;
    private Utente u;


    @Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {nickname1, pwd1, 0},
                {nickname2, pwd2, 1},
                {nickname3, pwd3, 2},
        });
    }

    public RegistrazioneTest(String nickname, String pwd, int type) {
        this.nickname = nickname;
        this.pwd = pwd;
        this.type = type;
    }

    public boolean insert_in_db() {
        UtenteBean ub = new UtenteBean();
        ub.setUserid(nickname);
        ub.setPassword(pwd);
        ub.setType(type);

        System.out.println("nickname: "+ nickname);
        System.out.println("password: "+ pwd);
        System.out.println("type: "+ type);

        return DaoUtente.insertUtente(nickname, pwd, type);

    }

    @Test
    public void test() {

        Connection conn = null;
        PreparedStatement stmt = null;

        if (insert_in_db()) {
            try {
                conn = DMsingleton.getInstance().getConnection();
                String sql = ("select * from utente where nickname = ?");
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nickname);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Assert.assertEquals(nickname, rs.getString("nickname"));
                    Assert.assertEquals(pwd, rs.getString("password"));
                    Assert.assertEquals(type, rs.getInt("type"));
                }

                System.out.println(u instanceof Ospite);

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Test effettuato con successo");
    }

    @Test
    public void  check_utente_type(){ //caso di test: jUnit crea una istanza per parametro
        UtenteFactory uf = new UtenteFactory(nickname,pwd,type);
        u = uf.getUtente(type,nickname,pwd);
        if (type == 0) {
            assertTrue(u instanceof Ospite);
            System.out.println("Verificato utente di tipo 0 --> Ospite");
        }
        else if(type == 1) {
            assertTrue(u instanceof Locatore);
            System.out.println("Verificato utente di tipo 1 --> Locatore");
        }
        if (type == 2) {
            assertTrue(u instanceof Locatario);
            System.out.println("Verificato utente di tipo 2 --> Locatario");
        }

    }

    @AfterClass //viene effettuato una sola volta a fine test
    public static void deleteUtente(){

        Connection conn = null;
        PreparedStatement stmt = null;

            try {
                conn = DMsingleton.getInstance().getConnection();
                String sql = ("delete  from utente where nickname = ? ");
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, nickname);
                stmt.executeUpdate();

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        System.out.println("Utente rimosso dal db con successo");
        }

    }

