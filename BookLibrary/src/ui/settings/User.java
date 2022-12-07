package ui.settings;

public class User {
	public final static String FILE = "information.txt";
	public String username;
	public String password;
	
	public User() {
		username = "Cynthia";
		password = "1234";
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
	
	public static User getInformation() {
		return new User();
	}
	
	public String toString() {
		return username + "\n" + password;
	}
}
