package ccc.hut.c2.model;

public class Login {
	private Integer id;
	private String name;
	private String password;
	private boolean role;
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(boolean role) {
		this.role = role;
	}
	/**
	 * @return the role
	 */
	public boolean getRole() {
		return this.role;
	}
	
}
