package br.com.softbit.couchmobile.service;

import javax.ws.rs.QueryParam;

public class ProfissionalFilterBean {
	
	private @QueryParam(value = "estado") String estado;
	private @QueryParam(value = "cidade")String cidade;
	private @QueryParam(value = "bairro")String bairro;
	private @QueryParam(value = "formacao")String formacao;
	private @QueryParam(value = "especializacao")String especializacao;
	private @QueryParam(value = "areaDeAtuacao")String areaDeAtuacao;
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getFormacao() {
		return formacao;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public String getEspecializacao() {
		return especializacao;
	}
	
	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}
	
	public String getAreaDeAtuacao() {
		return areaDeAtuacao;
	}
	
	public void setAreaDeAtuacao(String areaDeAtuacao) {
		this.areaDeAtuacao = areaDeAtuacao;
	}
	
}
