package Bean;

public class UtenteBean {

	private String userid;
	private String password;
	private int type;
	private double evaluation;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public double getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(double evaluation) {
		this.evaluation = evaluation;
	}
}


