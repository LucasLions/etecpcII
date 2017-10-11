package model;

public class Professor {
	private int idProfessor;
	private String nomeProfessor;
	private int telefoneProf;
	private String enderecoProf;
	private int cpfProf;
	private String rgProf;
	
	public Professor(String nome,int telefone, String endereco,int cpf,String rg) {
		this.nomeProfessor = nome;
		this.telefoneProf = telefone;
		this.enderecoProf = endereco;
		this.cpfProf = cpf;
		this.rgProf = rg;
	}
	
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public int getTelefoneProf() {
		return telefoneProf;
	}
	public void setTelefoneProf(int telefoneProf) {
		this.telefoneProf = telefoneProf;
	}
	public String getEnderecoProf() {
		return enderecoProf;
	}
	public void setEnderecoProf(String enderecoProf) {
		this.enderecoProf = enderecoProf;
	}
	public int getCpfProf() {
		return cpfProf;
	}
	public void setCpfProf(int cpfProf) {
		this.cpfProf = cpfProf;
	}
	public String getRgProf() {
		return rgProf;
	}
	public void setRgProf(String rgProf) {
		this.rgProf = rgProf;
	}
	
	
	
	
}
