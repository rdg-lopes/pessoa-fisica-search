package com.pessoa.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pessoa.repository.PessoaFisicaEntity;
import com.pessoa.repository.PessoaFisicaRepository;

@Service
public class SearchPessoaFisicaService {

	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	public List<PessoaFisicaModel> getPessoasFisicas(String nome, int page, int size){
		Pageable pag = PageRequest.of(page, size);
		List<PessoaFisicaEntity> listPessoas;
		if(Objects.nonNull(nome)) {
			listPessoas = this.pessoaFisicaRepository.findByNomeContaining(nome, pag);
		} else {
			Page<PessoaFisicaEntity> pessoas = this.pessoaFisicaRepository.findAll(pag);
			listPessoas = pessoas.getContent();
		}
		return new PessoaMapper().mapList(listPessoas);
	}
	
}
