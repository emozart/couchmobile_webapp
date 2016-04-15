package br.com.softbit.couchmobile.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.softbit.couchmobile.database.Database;
import br.com.softbit.couchmobile.model.Profissional;

public class ProfissionalService {
	
	private Database db = new Database();
	
	public ProfissionalService(){
	}
	
	public List<Profissional> getProfissionais(){
		List<Profissional> result = new ArrayList<Profissional>();
		boolean dbConectado = db.connect();
		if(dbConectado == true){
			ResultSet resultSet = db.makeQuery("SELECT * FROM profissional ORDER BY profissional.id");
			try {
				while(resultSet.next()){
					Profissional p = new Profissional();
					p.setId(resultSet.getLong("id"));
					p.setFoto(resultSet.getString("foto"));
					p.setNome(resultSet.getString("nome"));
					p.setEmail(resultSet.getString("email"));
					//TODO: inserir esse campo na tabela dos servidores local e remoto
					//p.setSenha(resultSet.getString("senha"));
					//p.setTelefone(resultSet.getString("Telefone"));
					p.setFormacao(resultSet.getString("formacao"));
					p.setEspecializacao(resultSet.getString("especializacao"));
					p.setOndeAtua(resultSet.getString("area_de_atuacao"));
					//p.setTempoNaArea(resultSet.getDate("na_area_desde"));
					p.setFacebook(resultSet.getString("facebook"));
					
					result.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<Profissional> getProfissionaisComFiltro(String estado, String cidade, String bairro, String formacao, String especializacao, String areaDeAtuacao){
		List<Profissional> result = new ArrayList<Profissional>();
		boolean dbConectado = db.connect();
		if(dbConectado == true){
			ResultSet resultSet = db.makeQuery(queryFilter(estado, cidade, bairro, formacao, especializacao, areaDeAtuacao));
			try {
				while(resultSet.next()){
					Profissional p = new Profissional();
					p.setId(resultSet.getLong("id"));
					p.setFoto(resultSet.getString("foto"));
					p.setNome(resultSet.getString("nome"));
					p.setEmail(resultSet.getString("email"));
					//TODO: inserir esse campo na tabela dos servidores local e remoto
					//p.setSenha(resultSet.getString("senha"));
					//p.setTelefone(resultSet.getString("Telefone"));
					p.setFormacao(resultSet.getString("formacao"));
					p.setEspecializacao(resultSet.getString("especializacao"));
					p.setOndeAtua(resultSet.getString("area_de_atuacao"));
					//p.setTempoNaArea(resultSet.getDate("na_area_desde"));
					p.setFacebook(resultSet.getString("facebook"));
					
					result.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Profissional getProfissional(long id){
		return null;
	}
	
	public Profissional addProfissional(Profissional profissional){
		return null;
	}
	
	public Profissional updateProfissional(Profissional profissional){
		return null;
	}
	
	public Profissional removeProfissional(long id){
		return null;
	}
	
	private String queryFilter(String estado, String cidade, String bairro, String formacao, String especializacao, String areaDeAtuacao){
		
		int flag = 0;
		String query = "SELECT * FROM profissional INNER JOIN endereco " +
						"ON profissional.id = endereco.profissional_id WHERE ";
		
		if(estado != null){
			query += "LOWER(endereco.estado) LIKE LOWER('%" + estado + "%') ";
			flag = 1;
		}
		if(cidade != null){
			if(flag == 1){
				query += "AND LOWER(endereco.cidade) LIKE LOWER('%" + cidade + "%')";
			}else{
				query += "LOWER(endereco.cidade) LIKE LOWER('%" + cidade + "%')";
				flag = 1;
			}
		}
		if(bairro != null){
			if(flag == 1){
				query += "AND LOWER(endereco.bairro) LIKE LOWER('%" + bairro + "%')";
			}else{
				query += "LOWER(endereco.bairro) LIKE LOWER('%" + bairro + "%')";
				flag = 1;
			}
		}
		if(formacao != null){
			if(flag == 1){
				query += "AND LOWER(profissional.formacao) LIKE LOWER('%" + formacao + "%')";
			}else{
				query += "LOWER(profissional.formacao) LIKE LOWER('%" + formacao + "%')";
				flag = 1;
			}
		}
		if(especializacao != null){
			if(flag == 1){
				query += "AND LOWER(profissional.especializacao) LIKE LOWER('%" + especializacao + "%')";
			}else{
				query += "LOWER(profissional.especializacao) LIKE LOWER('%" + especializacao + "%')";
				flag = 1;
			}
		}
		if(areaDeAtuacao != null){
			if(flag == 1){
				query += "AND LOWER(profissional.area_de_atuacao) LIKE LOWER('%" + areaDeAtuacao + "%')";
			}else{
				query += "LOWER(profissional.area_de_atuacao) LIKE LOWER('%" + areaDeAtuacao + "%')";
				flag = 1;
			}
		}
		
		return query;
		
	}

}
