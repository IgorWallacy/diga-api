package com.doks.diga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doks.diga.model.Produto;
import com.doks.diga.repository.Produtos;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	
	
	
	
	@Autowired
	private Produtos produtos;
	
	@GetMapping("/VoltaRedonda")
	public List<Produto> todosVoltaRedonda() {
		
		return produtos.produtoAtivoVoltaRedonda();
	}
	
	@GetMapping("/Resende")
	public List<Produto> todosResende() {
		
		return produtos.produtoAtivoResende();
	}

}
