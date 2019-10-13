package Model;


public class Ospite implements Utente {

    private String username;
    private String password;
    private int type;



    public Ospite (String nickname, String pass, int type) {
        this.username = nickname;
        this.password = pass;
        this.type = type;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getUser() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void pubblicaAnnuncio(){

    }
}
