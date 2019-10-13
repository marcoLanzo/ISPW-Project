package Thread;

import Controller.ControllerBachecaLocatore;
import Dao.AnnuncioDao;
import Entity.Annuncio;
import java.sql.Timestamp;
import java.util.ArrayList;


public  class checkTimer implements  Runnable{


        protected int counter_renting;
        protected String utente;
        protected int announce_id;
        protected Timestamp date;
        protected ArrayList<Annuncio> annunci;


        public  void run(){
            if (ControllerBachecaLocatore.getInstance().checkLock()) {
                System.out.println("Lock acquisito");
                do {
                    annunci = AnnuncioDao.timerLista(); // prendo tutti annunci locatore
                    for (Annuncio a : annunci) {
                        date = a.getDate(); // pxrendi data inserimento annuncio
                        Timestamp now = new Timestamp(System.currentTimeMillis());
                        long diff = now.getTime() - date.getTime();


                        announce_id = a.getID();
                        counter_renting = a.getCounter_renting();

                        long diffMinutes = diff / (60 * 1000) % 60;

                        System.out.println(diffMinutes);

                        if (diffMinutes >= 3 && counter_renting == 0) { //sono passati 3 minuti -> Timeout
                            if (AnnuncioDao.disattivaAnnuncio(a))
                                System.out.println("Annuncio con id " + announce_id + " è ora inattivo");
                        }
                    }
                    try {
                        Thread.sleep(50000); //auto-sospensione del thread

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } while (true);
            }
        }

    }
