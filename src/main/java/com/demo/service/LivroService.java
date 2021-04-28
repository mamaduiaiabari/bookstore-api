package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Livro;
import com.demo.repositories.CategoriaRepository;
import com.demo.repositories.LivroRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id)  throws ObjectNotFoundException {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado " + " Id= " + id + " Tipo " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) throws ObjectNotFoundException {
		categoriaService.findById(id_cat);
		return livroRepository.findAllByCategoria(id_cat);
	}
}
