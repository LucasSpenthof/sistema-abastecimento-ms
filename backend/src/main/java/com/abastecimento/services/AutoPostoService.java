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

import com.abastecimento.dto.AutoPostoDTO;
import com.abastecimento.entities.AutoPosto;
import com.abastecimento.repositories.AutoPostoRepository;
import com.abastecimento.services.exceptions.DataBaseException;
import com.abastecimento.services.exceptions.ResourceNotFoundException;

@Service
public class AutoPostoService {
	
	@Autowired
	private AutoPostoRepository repository;
	
	@Transactional()
	public List<AutoPostoDTO> findAll() {
		List<AutoPosto> list = repository.findAll();
		return list.stream().map(autoPosto -> new AutoPostoDTO(autoPosto)).collect(Collectors.toList());
	}
	
	@Transactional()
	public AutoPostoDTO findById(Long id) {
		Optional<AutoPosto> obj = repository.findById(id);
		AutoPosto autoPosto  = obj.orElseThrow(() -> new ResourceNotFoundException("O AutoPosto solicitado não foi encontrado"));
		return new AutoPostoDTO(autoPosto);
	}
	
	@Transactional
	public AutoPostoDTO insert(AutoPostoDTO dto) {
		AutoPosto entity = new AutoPosto();
		entity.setNomeFantasia(dto.getNomeFantasia());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
		entity.setCNPJ(dto.getCNPJ());
		entity.setEndereco(dto.getEndereco());
		entity.setCidade(dto.getCidade());
		entity = repository.save(entity);
		return new AutoPostoDTO(entity);
	}
	
	@Transactional
	public AutoPostoDTO update(Long id, AutoPostoDTO dto) {
		try {
			AutoPosto entity = repository.getOne(id);
			entity.setNomeFantasia(dto.getNomeFantasia());
			entity.setTelefone(dto.getTelefone());
			entity.setEmail(dto.getEmail());
			entity.setCNPJ(dto.getCNPJ());
			entity.setEndereco(dto.getEndereco());
			entity.setCidade(dto.getCidade());
			entity = repository.save(entity);
			return new AutoPostoDTO(entity);
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
