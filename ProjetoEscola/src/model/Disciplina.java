package model;

public class Disciplina {
	private int idDisciplina;
	private String nomeDisciplina;
	private String descricaoDisciplina;
	private String diasAula;
	private String horario;
	
	public Disciplina(String nomeDisciplina,String descricaoDisciplina,String diasAula,String horario) {
		this.nomeDisciplina = nomeDisciplina;
		this.descricaoDisciplina = descricaoDisciplina;
		this.diasAula = diasAula;
		this.horario = horario;
	}
	
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public String getDescricaoDisciplina() {
		return descricaoDisciplina;
	}
	public void setDescricaoDisciplina(String descricaoDisciplina) {
		this.descricaoDisciplina = descricaoDisciplina;
	}
	public String getDiasAula() {
		return diasAula;
	}
	public void setDiasAula(String diasAula) {
		this.diasAula = diasAula;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
}
