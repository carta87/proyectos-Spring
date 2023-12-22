package co.curso.spring;

public class User {
	
	@Input(min= 7, max= 15)//control de longitud de datos de entrada, se puede ajustar
	private String username;
	
	@Input(min= 8, max= 10)
	private String password;
	private String charge;
	
	public User(String username, String password, String charge) {
		super();
		this.username = username;
		this.password = password;
		this.charge = charge;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	
	

}
