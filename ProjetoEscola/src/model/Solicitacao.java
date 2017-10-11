package model;

import java.sql.Date;

public class Solicitacao {
	private int id;
	private int profCod;
	private String descricao;
	private String date;
	
	public Solicitacao(int profCod, String descricao,String date) {
		this.profCod = profCod;
		this.descricao = descricao;
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProfCod() {
		return profCod;
	}
	public void setProfCod(int profCod) {
		this.profCod = profCod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
