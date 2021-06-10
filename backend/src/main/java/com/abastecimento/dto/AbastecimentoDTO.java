package com.abastecimento.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.abastecimento.entities.Abastecimento;
import com.abastecimento.entities.AutoPosto;
import com.abastecimento.entities.Veiculo;
import com.abastecimento.entities.enums.Combustivel;

public class AbastecimentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@CPF
	@NotBlank(message="O campo é obrigatório")
	private String cpfMotorista;
	@NotBlank(message="O campo é obrigatório")
	private Instant dataDoAbastecimento;
	@NotBlank(message="O campo é obrigatório")
	private Long quilometragem;
	@NotBlank(message="O campo é obrigatório")
	private Combustivel combustivel;
	@NotBlank(message="O campo é obrigatório")
	private Integer quantidadeEmLitros;	
	@NotBlank(message="O campo é obrigatório")
	private Double valorPorLitro;
	@NotBlank(message="O campo é obrigatório")
	private AutoPosto autoPosto;
	@NotBlank(message="O campo é obrigatório")
	private Veiculo veiculo;
	
	public AbastecimentoDTO() {
		
	}
	
	

	public AbastecimentoDTO(Long id, String cpfMotorista, Instant dataDoAbastecimento, Long quilometragem,
			Combustivel combustivel, Integer quantidadeEmLitros, Double valorPorLitro, AutoPosto autoPosto,
			Veiculo veiculo) {
		this.id = id;
		this.cpfMotorista = cpfMotorista;
		this.dataDoAbastecimento = dataDoAbastecimento;
		this.quilometragem = quilometragem;
		this.combustivel = combustivel;
		this.quantidadeEmLitros = quantidadeEmLitros;
		this.valorPorLitro = valorPorLitro;
		this.autoPosto = autoPosto;
		this.veiculo = veiculo;
	}
	
	public AbastecimentoDTO(Abastecimento entity) {
		this.id = entity.getId();
		this.cpfMotorista = entity.getCpfMotorista();
		this.dataDoAbastecimento = entity.getDataDoAbastecimento();
		this.quilometragem = entity.getQuilometragem();
		this.combustivel = entity.getCombustivel();
		this.quantidadeEmLitros = entity.getQuantidadeEmLitros();
		this.valorPorLitro = entity.getValorPorLitro();
		this.autoPosto = entity.getAutoPosto();
		this.veiculo = entity.getVeiculo();
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

	public Instant getDataDoAbastecimento() {
		return dataDoAbastecimento;
	}

	public void setDataDoAbastecimento(Instant dataDoAbastecimento) {
		this.dataDoAbastecimento = dataDoAbastecimento;
	}

	public Long getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Long quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getQuantidadeEmLitros() {
		return quantidadeEmLitros;
	}

	public void setQuantidadeEmLitros(Integer quantidadeEmLitros) {
		this.quantidadeEmLitros = quantidadeEmLitros;
	}

	public Double getValorPorLitro() {
		return valorPorLitro;
	}

	public void setValorPorLitro(Double valorPorLitro) {
		this.valorPorLitro = valorPorLitro;
	}

	public AutoPosto getAutoPosto() {
		return autoPosto;
	}

	public void setAutoPosto(AutoPosto autoPosto) {
		this.autoPosto = autoPosto;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

