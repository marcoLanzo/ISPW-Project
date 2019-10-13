package Entity;

public class Locatore implements Utente{

    private String username;
    private String password;
    private int type;

    public Locatore(String nickname, String pass, int type) {
        this.username = nickname;
        this.password = pass;
        this.type = type;
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

    @Override
    public void pubblicaAnnuncio(){

    }

    @Override
    public void update(String user, String nomeannuncio, boolean attivo) {

    }


}
