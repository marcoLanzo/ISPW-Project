package patternConnessione;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DMsingleton {

	private static DMsingleton instance=null;
	private static Connection con=null;

	/*
	 * 1) Caricare il Driver
	 * 2) Aprire una Connessione al Database
	 * 3) Creare un Oggetto Statement
	 * 4) Interagire con il Database
	 * 5) Gestire e visualizzare i risultati ottenuti dalle ResultSet.
	 */


	private final  static String driverName="org.postgresql.Driver"; 	//classe del driver
	private final static String  dbName="FERSA";
	private final  static String id="postgres";
	private final  static String password="DanieleG1994";

	protected DMsingleton(){
		this.con = getCon(dbName, id, password);
	}

	public synchronized static DMsingleton getInstance(){
		try {
			if( instance == null || instance.getConnection().isClosed()){
				DMsingleton.instance = new DMsingleton();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DMsingleton.instance;
	}

	public Connection getConnection(){
		return con;
	}

	private static Connection getCon(String db_name,String user_name,String password)
	{
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection("jdbc:postgresql:" + db_name + "?user=" + user_name + "&password=" + password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}


