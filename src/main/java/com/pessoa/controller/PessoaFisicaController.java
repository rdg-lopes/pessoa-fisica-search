package com.pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pessoa.service.PessoaFisicaModel;
import com.pessoa.service.SearchPessoaFisicaService;

@RestController
@RequestMapping("/v1/PessoaFisica")
public class PessoaFisicaController {

	@Autowired
	private SearchPessoaFisicaService searchPessoaService;
	
	@GetMapping()
	public List<PessoaFisicaDTO> getPessoas(@RequestParam(name = "nome", required = false) String nome, 
									        @RequestParam(name = "page", defaultValue = "0", required = false) Integer page, 
									        @RequestParam(name = "size", defaultValue = "10", required = false) Integer size){
		List<PessoaFisicaModel> listModel = this.searchPessoaService.getPessoasFisicas(nome, page, size);
		return new PessoaMapper().toList(listModel);
	}
	
}
