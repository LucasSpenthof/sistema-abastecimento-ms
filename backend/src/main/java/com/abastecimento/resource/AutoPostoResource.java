package com.abastecimento.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abastecimento.dto.AutoPostoDTO;
import com.abastecimento.services.AutoPostoService;

@RestController
@RequestMapping(value = "/autoPostos")
public class AutoPostoResource {
	
	@Autowired
	private AutoPostoService service;
	
	@GetMapping
	public ResponseEntity<List<AutoPostoDTO>> findAll(){
		List<AutoPostoDTO> lista = service.findAll();
		
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutoPostoDTO> findById(@PathVariable Long id){
		AutoPostoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
		
	}
	
	@PostMapping
	public ResponseEntity<AutoPostoDTO> insert(@Valid @RequestBody AutoPostoDTO dto){
		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AutoPostoDTO> update(@PathVariable Long id,@Valid @RequestBody AutoPostoDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<AutoPostoDTO> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}