package View;

public class UtenteBean {

	private static String userid;
	private String password;
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public static String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		UtenteBean.userid = userid;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	
		
	
}


