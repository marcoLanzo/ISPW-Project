package View;

import Controller.Controller;
import Exception.DatiErratiException;
import Exception.UtenteEsistenteException;


public class RegistrazioneBean {

    int type;
    private String nickname;
    private String password;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void registra() throws UtenteEsistenteException, DatiErratiException{

        String user = this.nickname;
        String pass = this.password;
        if (user.isEmpty() || pass.isEmpty()) {

            throw new DatiErratiException();

        }else {
            UtenteBean ub = new UtenteBean();
            ub.setUserid(user);
            ub.setPassword(pass);
            System.out.println("Tentativo di registrazione con i seguenti dati:");
            System.out.println("ID:" + user + "     " + "password:" + pass);

            Controller controllerFisico = Controller.getInstance();

            if (!controllerFisico.registrazione(ub.getUserid(), ub.getPassword())) {

                throw new UtenteEsistenteException();
            }

        }
    }
}





