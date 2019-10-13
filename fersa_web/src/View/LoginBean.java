package View;


import Controller.Controller;
import Exception.DatiErratiException;
import Exception.UtenteNonTrovatoException;


public class LoginBean{

    private String password;
    private String nickname;
    int type;

    private Controller controller;
    

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

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void validate() throws DatiErratiException,UtenteNonTrovatoException {
        if (this.nickname.equals("") || this.password.equals("")) {
            throw new DatiErratiException();
        }
        System.out.println("Tentativo di accesso con: "+this.nickname);
        UtenteBean ub = new UtenteBean();
        Controller controllerFisico = Controller.getInstance();
        ub.setUserid(nickname);
        ub.setPassword(password);

        if(controllerFisico.utenteEsistente(nickname)) {

            UtenteBean bean = controllerFisico.login(ub.getUserid(), ub.getPassword());
            this.type = bean.getType();
            ub.setType(type);

        }
        else{
            throw new UtenteNonTrovatoException();

        }
    }
}