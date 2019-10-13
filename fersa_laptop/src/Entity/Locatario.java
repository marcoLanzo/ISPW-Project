package Entity;

public class Locatario implements Utente{

    private String username;
    private String password;
    private int type;
    private String notifiche;



    public Locatario(String nickname, String pass, int type) {
        this.username = nickname;
        this.password = pass;
        this.type = type;
    }

    @Override
    public void pubblicaAnnuncio(){

    }

    public String getNotifiche() {
        return notifiche;
    }

    public void setNotifiche(String notifiche) {
        this.notifiche = notifiche;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public String getUser() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public Locatario(String nickname, int id_annuncio){
        this.username = nickname;
    }

    @Override
    public void update(String nickname, String AnnounceName,boolean attivo) {
        this.username = nickname;
        this.notifiche =  ("Utente"+" " + nickname +" " + AnnounceName + " è stato disattivato e rimosso dai tuoi preferiti");
        System.out.println(notifiche);

    }

}
