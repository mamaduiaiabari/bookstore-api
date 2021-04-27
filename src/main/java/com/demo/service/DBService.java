package com.demo.service;

import java.util.Arrays;

import org.aspectj.internal.lang.annotation.ajcITD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.Categoria;
import com.demo.domain.Livro;
import com.demo.repositories.CategoriaRepository;
import com.demo.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null,"Informatica","Livro de TI");
		Categoria cat2 = new Categoria(null,"Ficção Cientifica","Livro de Ficção Cientifica");
		Categoria cat3 = new Categoria(null,"Biografia","Livro de Biografia");
		
		Livro l1 = new Livro(null,"Clean Code","Robert Martin","Loren Ipsum",cat1);
		Livro l2 = new Livro(null,"Engenharia de Software","Luis V. Gerstner","Loren Ipsum",cat1);
		Livro l3 = new Livro(null,"The Time Machine","H.G. Wels","Loren Ipsum",cat2);
		Livro l4 = new Livro(null,"The war of the Worlds","H.G. Wels","Loren Ipsum",cat2);
		Livro l5 = new Livro(null,"I, Robbot","Isaac Asimov","Loren Ipsum",cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
