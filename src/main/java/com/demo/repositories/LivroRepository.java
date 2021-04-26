package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
