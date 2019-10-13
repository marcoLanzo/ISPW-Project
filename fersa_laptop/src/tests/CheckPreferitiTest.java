package tests;

import Bean.AnnuncioBean;
import Bean.UtenteBean;
import Dao.AnnuncioDao;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import patternConnessione.DMsingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class )
public class CheckPreferitiTest {

        /* GENERO STRINGHE E INTERI RANDOMICi SU CUI EFFETTUARE TEST IN MANIERA OPPORTUNA */
        private static String nickname1_preferito = RandomStringUtils.randomAlphabetic(10);
        private static String nickname2_preferito = RandomStringUtils.randomAlphabetic(10);
        private static String nickname3_preferito = RandomStringUtils.randomAlphabetic(10);
        private static Integer annuncio_preferito = RandomUtils.nextInt();
        private static Integer annuncio_preferito_2 = RandomUtils.nextInt();
        private static Integer annuncio_preferito_3 = RandomUtils.nextInt();


        private  static String nickname;
        private  static  int annuncio;


        @Parameterized.Parameters
        public static Collection<Object[]> getParameters() {
            return Arrays.asList(new Object[][]{
                    {nickname1_preferito, annuncio_preferito},
                    {nickname2_preferito, annuncio_preferito_2},
                    {nickname3_preferito,annuncio_preferito_3},
            });
        }

        public CheckPreferitiTest(String nickname,int annuncio) {
            this.nickname = nickname;
            this.annuncio = annuncio;
        }

        public boolean insert_in_db() {
            AnnuncioBean ab = new AnnuncioBean();
            UtenteBean ub = new UtenteBean();
            ab.setAnnounceId(annuncio);
            ub.setUserid(nickname);
            System.out.println("nickname: "+ nickname);
            System.out.println("annuncio_preferito" + annuncio + "\n");

            return AnnuncioDao.inserisciAnnuncioPreferiti(ab,ub);

        }

        @Test
        public void test() {
            boolean p = AnnuncioDao.annuncioPreferitoEsistente(annuncio,nickname);
            assertFalse(p);

            System.out.println("Test 1 effettuato con successo , annuncio non presente nel db e quindi function return false\n \n ");
        }

        @Test
        public void test2(){
                boolean ins = insert_in_db();
                assertTrue(ins);

            System.out.println("Test 2 effettuato con successo -> Inserimento annunci randomici andato a buon fine" +
                    "verifica correttezza funzione\n\n\n");
        }

        @Test
        public void test3(){
            boolean a = AnnuncioDao.annuncioPreferitoEsistente(annuncio,nickname);
            assertTrue(a);

            System.out.println("Test 3 effettuato con successo -> Dopo l'inserimento ora verifico la presenza in db, check!\n");
        }

        @AfterClass
        public static void deletePreferito(){

            Connection conn = null;
            PreparedStatement stmt = null;
            AnnuncioBean a = new AnnuncioBean();
            a.setAnnounceId(annuncio);

            try {
                conn = DMsingleton.getInstance().getConnection();
                String sql = ("delete  from annuncipreferiti where id_preferito = ? ");
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, annuncio);
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

            System.out.println("annuncio rimosso dal db con successo");
        }

    }
