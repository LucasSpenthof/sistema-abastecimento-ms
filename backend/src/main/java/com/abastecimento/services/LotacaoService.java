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

import com.abastecimento.dto.LotacaoDTO;
import com.abastecimento.entities.Lotacao;
import com.abastecimento.repositories.LotacaoRepository;
import com.abastecimento.services.exceptions.DataBaseException;
import com.abastecimento.services.exceptions.ResourceNotFoundException;


@Service
public class LotacaoService {
	
	@Autowired
	private LotacaoRepository repository;
	
	@Transactional()
	public List<LotacaoDTO> findAll() {
		List<Lotacao> list = repository.findAll();
		return list.stream().map(lotacao -> new LotacaoDTO(lotacao)).collect(Collectors.toList());
	}
	
	@Transactional()
	public LotacaoDTO findById(Long id) {
		Optional<Lotacao> obj = repository.findById(id);
		Lotacao lotacao  = obj.orElseThrow(() -> new ResourceNotFoundException("A Lotacao solicitada não foi encontrada"));
		return new LotacaoDTO(lotacao);
	}
	
	@Transactional
	public LotacaoDTO insert(LotacaoDTO dto) {
		Lotacao entity = new Lotacao();
		entity.setDescricao(dto.getDescricao());
		entity.setEmail(dto.getEmail());
		entity.setSite(dto.getSite());
		entity.setTelefone(dto.getTelefone());
		entity.setEndereco(dto.getEndereco());
		entity.setCidade(dto.getCidade());
		entity.setVeiculos(dto.getVeiculos());
		entity = repository.save(entity);
		return new LotacaoDTO(entity);
	}
	
	@Transactional
	public LotacaoDTO update(Long id, LotacaoDTO dto) {
		try {
			Lotacao entity = repository.getOne(id);
			entity.setDescricao(dto.getDescricao());
			entity.setEmail(dto.getEmail());
			entity.setSite(dto.getSite());
			entity.setTelefone(dto.getTelefone());
			entity.setEndereco(dto.getEndereco());
			entity.setCidade(dto.getCidade());
			entity.setVeiculos(dto.getVeiculos());
			entity = repository.save(entity);
			return new LotacaoDTO(entity);
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