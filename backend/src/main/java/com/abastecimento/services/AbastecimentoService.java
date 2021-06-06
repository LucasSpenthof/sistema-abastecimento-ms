package com.abastecimento.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.abastecimento.dto.AbastecimentoDTO;
import com.abastecimento.entities.Abastecimento;
import com.abastecimento.repositories.AbastecimentoRepository;
import com.abastecimento.services.exceptions.DataBaseException;
import com.abastecimento.services.exceptions.ResourceNotFoundException;


@Service
public class AbastecimentoService {
	
	@Autowired
	private AbastecimentoRepository repository;
	
	@Transactional()
	public List<AbastecimentoDTO> findAll() {
		List<Abastecimento> list = repository.findAll();
		return list.stream().map(abastecimento -> new AbastecimentoDTO(abastecimento)).collect(Collectors.toList());
	}
	
	@Transactional()
	public AbastecimentoDTO findById(Long id) {
		Optional<Abastecimento> obj = repository.findById(id);
		Abastecimento abastecimento  = obj.orElseThrow(() -> new ResourceNotFoundException("O abastecimento solicitado não foi encontrado"));
		return new AbastecimentoDTO(abastecimento);
	}
	
	@Transactional
	public AbastecimentoDTO insert(AbastecimentoDTO dto) {
		Abastecimento entity = new Abastecimento();
		entity.setCpfMotorista(dto.getCpfMotorista());
		entity.setDataDoAbastecimento(dto.getDataDoAbastecimento());
		entity.setQuilometragem(dto.getQuilometragem());
		entity.setCombustivel(dto.getCombustivel());
		entity.setQuantidadeEmLitros(dto.getQuantidadeEmLitros());
		entity.setValorPorLitro(dto.getValorPorLitro());
		entity.setAutoPosto(dto.getAutoPosto());
		entity.setVeiculo(dto.getVeiculo());
		entity = repository.save(entity);
		return new AbastecimentoDTO(entity);
	}
	
	@Transactional
	public AbastecimentoDTO update(Long id, AbastecimentoDTO dto) {
		try {
			Abastecimento entity = repository.getOne(id);
			entity.setCpfMotorista(dto.getCpfMotorista());
			entity.setDataDoAbastecimento(dto.getDataDoAbastecimento());
			entity.setQuilometragem(dto.getQuilometragem());
			entity.setCombustivel(dto.getCombustivel());
			entity.setQuantidadeEmLitros(dto.getQuantidadeEmLitros());
			entity.setValorPorLitro(dto.getValorPorLitro());
			entity.setAutoPosto(dto.getAutoPosto());
			entity.setVeiculo(dto.getVeiculo());
			entity = repository.save(entity);
			return new AbastecimentoDTO(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O id nao foi localizado");
		}
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
		try {
			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O id nao foi localizado");
		}catch (DataIntegrityViolationException e) {
			throw new DataBaseException("violação de integridade");
		}
		
	}

}
