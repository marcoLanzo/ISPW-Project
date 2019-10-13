package Entity;

public class UtenteFactory {

    private String nickname;
    private String pass;
    private int type;


    public UtenteFactory(String userid, String password, int type) {
        this.nickname = userid;
        this.pass = password;
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Utente getUtente(int type, String nickname, String pass) { /* Vale il principio di sostituibilità di Liskov */

        if (type == 0)
            return new Ospite(nickname,pass,type);

        if (type == 1 || type == 3)
            return new Locatore(nickname, pass, type);

        if (type == 2 ) /* 3 significa che sono sia locatore che locatario */
            return new Locatario(nickname, pass, type);

        else return null;
    }
}
