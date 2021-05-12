package com.abastecimento.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int ano;
	private String placa;
	private String renavan;
	private String patrimonio;
	private String chasi;
	private String versao;
	private String capacidadeTanque;
	private Combustivel tipoCombustivel;
	
	public Veiculo() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getChasi() {
		return chasi;
	}

	public void setChasi(String chasi) {
		this.chasi = chasi;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(String capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public Combustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(Combustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((capacidadeTanque == null) ? 0 : capacidadeTanque.hashCode());
		result = prime * result + ((chasi == null) ? 0 : chasi.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((patrimonio == null) ? 0 : patrimonio.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((renavan == null) ? 0 : renavan.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (ano != other.ano)
			return false;
		if (capacidadeTanque == null) {
			if (other.capacidadeTanque != null)
				return false;
		} else if (!capacidadeTanque.equals(other.capacidadeTanque))
			return false;
		if (chasi == null) {
			if (other.chasi != null)
				return false;
		} else if (!chasi.equals(other.chasi))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (patrimonio == null) {
			if (other.patrimonio != null)
				return false;
		} else if (!patrimonio.equals(other.patrimonio))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (renavan == null) {
			if (other.renavan != null)
				return false;
		} else if (!renavan.equals(other.renavan))
			return false;
		if (versao == null) {
			if (other.versao != null)
				return false;
		} else if (!versao.equals(other.versao))
			return false;
		return true;
	}

	public Veiculo(Long id, int ano, String placa, String renavan, String patrimonio, String chasi, String versao,
			String capacidadeTanque, Combustivel tipoCombustivel) {
		this.id = id;
		this.ano = ano;
		this.placa = placa;
		this.renavan = renavan;
		this.patrimonio = patrimonio;
		this.chasi = chasi;
		this.versao = versao;
		this.capacidadeTanque = capacidadeTanque;
		this.tipoCombustivel = tipoCombustivel;
	}
	

}
