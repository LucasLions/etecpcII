package model;

public class Aluno {

	int idAluno;
	String nome;
	int telAluno;
	String endAluno;
	int cpf;
	String rg;
	
	public Aluno(String nome,int telAluno,String endAluno,int cpf,String rg) {
		this.nome = nome;
		this.telAluno = telAluno;
		this.endAluno = endAluno;
		this.cpf = cpf;
		this.rg = rg;
	}
	
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelAluno() {
		return telAluno;
	}
	public void setTelAluno(int telAluno) {
		this.telAluno = telAluno;
	}
	public String getEndAluno() {
		return endAluno;
	}
	public void setEndAluno(String endAluno) {
		this.endAluno = endAluno;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
}
