package com.abastecimento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abastecimento.entities.Lotacao;

@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao, Long>{

}
