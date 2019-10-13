package Model;

public class Locatario implements Utente{

    private String username;
    private String password;
    private int type;

    public Locatario(String nickname, String pass, int type) {
        this.username = nickname;
        this.password = pass;
        this.type = type;
    }

    @Override
    public void pubblicaAnnuncio(){

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
}
