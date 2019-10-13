package Controller;



import Bean.UtenteBean;
import Dao.DaoUtente;
import Entity.Utente;
import Exception.DatiErratiException;


public class Controller extends MainController {


	private static Controller instance = null;
	private static UtenteBean ub;

	public static UtenteBean getUb() {
		return ub;
	}

	public UtenteBean login(String username, String password) throws DatiErratiException {

		Utente u = DaoUtente.findUtente(username, password);
		if (u == null)
				throw new DatiErratiException();
		UtenteBean Bean = new UtenteBean();
		Bean.setType(u.getType());
		Bean.setPassword(u.getPassword());
		Bean.setUserid(u.getUser());
		return Bean;
	}



	public boolean registrazione(String username, String password) {

		return DaoUtente.insertUtente(username, password, 0);

	}

	public boolean utenteEsistente(String username){

		return DaoUtente.utenteEsistente(username);
	}


	public static Controller getInstance() {
		// TODO Auto-generated method stub
		if (instance == null) {
			instance = new Controller();
		}
		return instance;
	}


}




