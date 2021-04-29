package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Categoria;
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

	public Livro update(Integer id, Livro obj) throws ObjectNotFoundException {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return livroRepository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setNome_autor(obj.getNome_autor());
		newObj.setTexto(obj.getTexto());
		
	}

	public Livro create(Integer id_cat, Livro obj) throws ObjectNotFoundException {
		obj.setId(null);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return livroRepository.save(obj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		Livro obj = findById(id);
		livroRepository.delete(obj);
		
	}
}
