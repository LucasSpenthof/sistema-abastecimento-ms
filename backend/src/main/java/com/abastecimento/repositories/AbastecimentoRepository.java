package com.abastecimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abastecimento.entities.Abastecimento;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long>{

}
