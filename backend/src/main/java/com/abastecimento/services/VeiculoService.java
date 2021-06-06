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

import com.abastecimento.dto.VeiculoDTO;
import com.abastecimento.entities.Veiculo;
import com.abastecimento.repositories.VeiculoRepository;
import com.abastecimento.services.exceptions.DataBaseException;
import com.abastecimento.services.exceptions.ResourceNotFoundException;


@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repository;
	
	@Transactional()
	public List<VeiculoDTO> findAll() {
		List<Veiculo> list = repository.findAll();
		return list.stream().map(veiculo -> new VeiculoDTO(veiculo)).collect(Collectors.toList());
	}
	
	@Transactional()
	public VeiculoDTO findById(Long id) {
		Optional<Veiculo> obj = repository.findById(id);
		Veiculo veiculo  = obj.orElseThrow(() -> new ResourceNotFoundException("O Veiculo solicitado não foi encontrado"));
		return new VeiculoDTO(veiculo);
	}
	
	@Transactional
	public VeiculoDTO insert(VeiculoDTO dto) {
		Veiculo entity = new Veiculo();
		entity.setAno(dto.getAno());
		entity.setPlaca(dto.getPlaca());
		entity.setRenavan(dto.getRenavan());
		entity.setPatrimonio(dto.getPatrimonio());
		entity.setChassi(dto.getChassi());
		entity.setVersao(dto.getVersao());
		entity.setCapacidadeTanque(dto.getCapacidadeTanque());
		entity.setTipoCombustivel(dto.getTipoCombustivel());
		entity.setTipo(dto.getTipo());
		entity = repository.save(entity);
		return new VeiculoDTO(entity);
	}
	
	@Transactional
	public VeiculoDTO update(Long id, VeiculoDTO dto) {
		try {
			Veiculo entity = repository.getOne(id);
			entity.setAno(dto.getAno());
			entity.setPlaca(dto.getPlaca());
			entity.setRenavan(dto.getRenavan());
			entity.setPatrimonio(dto.getPatrimonio());
			entity.setChassi(dto.getChassi());
			entity.setVersao(dto.getVersao());
			entity.setCapacidadeTanque(dto.getCapacidadeTanque());
			entity.setTipoCombustivel(dto.getTipoCombustivel());
			entity.setTipo(dto.getTipo());
			entity = repository.save(entity);
			return new VeiculoDTO(entity);
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