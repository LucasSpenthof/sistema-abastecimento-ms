package com.abastecimento.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.abastecimento.entities.Cidade;
import com.abastecimento.entities.Lotacao;
import com.abastecimento.entities.Veiculo;

public class LotacaoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotBlank(message="O campo é obrigatório")
	private String descricao;
	@Email
	@NotBlank(message="O campo é obrigatório")
	private String email;
	@NotBlank(message="O campo é obrigatório")
	private String site;
	@NotBlank(message="O campo é obrigatório")
	private String telefone;
	@NotBlank(message="O campo é obrigatório")
	private String endereco;
	@NotBlank(message="O campo é obrigatório")
	private Cidade cidade;
	Set<Veiculo> veiculos = new HashSet<>();
	
	public LotacaoDTO() {
		
	}
	
	

	public LotacaoDTO(Long id, String descricao, String email, String site, String telefone, String endereco,
			Cidade cidade, Set<Veiculo> veiculos) {
		this.id = id;
		this.descricao = descricao;
		this.email = email;
		this.site = site;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.veiculos = veiculos;
	}
	
	public LotacaoDTO(Lotacao entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.email = entity.getEmail();
		this.site = entity.getSite();
		this.telefone = entity.getTelefone();
		this.endereco = entity.getEndereco();
		this.cidade = entity.getCidade();
		this.veiculos = entity.getVeiculos();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Set<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Set<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
