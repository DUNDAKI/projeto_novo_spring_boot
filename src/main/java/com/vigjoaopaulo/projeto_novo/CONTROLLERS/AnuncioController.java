package com.vigjoaopaulo.projeto_novo.CONTROLLERS;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vigjoaopaulo.projeto_novo.MODEL.Anuncios;
import com.vigjoaopaulo.projeto_novo.REPOSITORYS.AnuncioRepository;

@RestController
@RequestMapping("/anuncios")
public class AnuncioController {
	@Autowired
	JdbcTemplate template; //sdsfdsfdfsdfdfsf
	
	@Autowired
	private AnuncioRepository repository;
	
	public boolean verificarPorId(Long id) {
		return repository.existsById(id);
	}
	
	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Anuncios> getPerfil() {
		return repository.findAll();
	}
	
	@GetMapping("/listPosto")
	public List<Map<String, Object>> listar() {
		List<Map<String, Object>> lista = template.queryForList("SELECT nomeEmpresa, nomeProduto, preco FROM anuncios");
		return lista;
	}
	
	@GetMapping("/listar2")
	public List<Map<String, Object>> listar2() {
		List<Map<String, Object>> lista = template.queryForList("SELECT nomeEmpresa, nomeProduto, preco FROM anuncios ORDER BY nomeProduto ASC");
		return lista;
		//,  preco <= 10 ORDER BY preco ASC
	}
	

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public String addPerfil(@RequestBody Anuncios anuncio) {

		repository.save(anuncio);
		return "Inserido com sucesso id: ";

	}
	
	@GetMapping("/buscarId/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String getId(@PathVariable Long id) {

		if (verificarPorId(id) != true) {
			return "Registro não encontrado...";
		} else {

			Anuncios p = repository.findById(id).get();

			return "" + p;
		}
	}

	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String deletePerfil(@PathVariable Long id) {

		if (verificarPorId(id) != true) {
			return "Registro não encontrado";
		} else {
			repository.deleteById(id);
			return "Deletado com sucesso id: " + id;
		}

	}

	@PutMapping("/atualizar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public String updatePerfil(@PathVariable Long id, @RequestBody Anuncios anuncio) {

		if (verificarPorId(id) != true) {
			return "Registro não encontrado";
		} else {
			Anuncios newObj = repository.findById(id).get();
			
			newObj.setNomeEmpresa(anuncio.getNomeEmpresa());
			newObj.setNomeProduto(anuncio.getNomeProduto());
			newObj.setPreco(anuncio.getPreco());
			newObj.setEndereco(anuncio.getEndereco());
			newObj.setNumero(anuncio.getNumero());
			newObj.setCidade(anuncio.getCidade());
			newObj.setEstado(anuncio.getEstado());
			newObj.setNota(anuncio.getNota());
			repository.save(newObj);
			return "Deletado com sucesso id: " + id;
		}
	}

}