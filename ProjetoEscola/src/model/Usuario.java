package model;

public class Usuario {
	private int id;
	private String login;
	private String senha;
	private int nivel_acesso;
	
	public Usuario(String login,String senha,int nivel_acesso) {
		this.login = login;
		this.senha = senha;
		this.nivel_acesso = nivel_acesso;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getNivel_acesso() {
		return nivel_acesso;
	}
	public void setNivel_acesso(int nivel_acesso) {
		this.nivel_acesso = nivel_acesso;
	}
	
}
