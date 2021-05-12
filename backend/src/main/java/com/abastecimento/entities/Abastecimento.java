package com.abastecimento.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_abastecimento")
public class Abastecimento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpfMotorista;
	private Date dataDoAbastecimento;
	private String quilomentragem;
	private Combustivel combustivel;
	private int quantidadeEmLitros;
	private double valorPorLitro;
	
	public Abastecimento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfMotorista() {
		return cpfMotorista;
	}

	public void setCpfMotorista(String cpfMotorista) {
		this.cpfMotorista = cpfMotorista;
	}

	public Date getDataDoAbastecimento() {
		return dataDoAbastecimento;
	}

	public void setDataDoAbastecimento(Date dataDoAbastecimento) {
		this.dataDoAbastecimento = dataDoAbastecimento;
	}

	public String getQuilomentragem() {
		return quilomentragem;
	}

	public void setQuilomentragem(String quilomentragem) {
		this.quilomentragem = quilomentragem;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public int getQuantidadeEmLitros() {
		return quantidadeEmLitros;
	}

	public void setQuantidadeEmLitros(int quantidadeEmLitros) {
		this.quantidadeEmLitros = quantidadeEmLitros;
	}

	public double getValorPorLitro() {
		return valorPorLitro;
	}

	public void setValorPorLitro(double valorPorLitro) {
		this.valorPorLitro = valorPorLitro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfMotorista == null) ? 0 : cpfMotorista.hashCode());
		result = prime * result + ((dataDoAbastecimento == null) ? 0 : dataDoAbastecimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + quantidadeEmLitros;
		result = prime * result + ((quilomentragem == null) ? 0 : quilomentragem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorPorLitro);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Abastecimento other = (Abastecimento) obj;
		if (cpfMotorista == null) {
			if (other.cpfMotorista != null)
				return false;
		} else if (!cpfMotorista.equals(other.cpfMotorista))
			return false;
		if (dataDoAbastecimento == null) {
			if (other.dataDoAbastecimento != null)
				return false;
		} else if (!dataDoAbastecimento.equals(other.dataDoAbastecimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantidadeEmLitros != other.quantidadeEmLitros)
			return false;
		if (quilomentragem == null) {
			if (other.quilomentragem != null)
				return false;
		} else if (!quilomentragem.equals(other.quilomentragem))
			return false;
		if (Double.doubleToLongBits(valorPorLitro) != Double.doubleToLongBits(other.valorPorLitro))
			return false;
		return true;
	}

	public Abastecimento(Long id, String cpfMotorista, Date dataDoAbastecimento, String quilomentragem,
			Combustivel combustivel, int quantidadeEmLitros, double valorPorLitro) {
		super();
		this.id = id;
		this.cpfMotorista = cpfMotorista;
		this.dataDoAbastecimento = dataDoAbastecimento;
		this.quilomentragem = quilomentragem;
		this.combustivel = combustivel;
		this.quantidadeEmLitros = quantidadeEmLitros;
		this.valorPorLitro = valorPorLitro;
	}
	
	
}
