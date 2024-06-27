package com.rodolfonemes.livraria.repository;

import com.rodolfonemes.livraria.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrariaRepository extends JpaRepository<LivroEntity, Long> {

  boolean existsByNameAndYear(String name, Integer year);

  LivroEntity findByNameAndYear(String name, Integer year);
}
