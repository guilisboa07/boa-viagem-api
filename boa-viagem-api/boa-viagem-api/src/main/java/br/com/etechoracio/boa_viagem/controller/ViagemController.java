package br.com.etechoracio.boa_viagem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etechoracio.boa_viagem.entity.Viagem;
import br.com.etechoracio.boa_viagem.repository.ViagemRepository;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

	@Autowired
	private ViagemRepository repository;

	@GetMapping
	public List<Viagem> listarTodos() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Viagem> buscarPorId(@PathVariable Long id) {
		Optional<Viagem> existe = repository.findById(id);
		if (existe.isPresent()) {
			return ResponseEntity.ok(existe.get());
		}
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarPorId(@PathVariable Long id) {

		boolean existe = repository.existsById(id);

		if (existe) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Viagem> inserir(@RequestBody Viagem obj) {
		repository.save(obj);
		return ResponseEntity.ok(obj);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Viagem> atualizar(@PathVariable Long id, @RequestBody Viagem viagem) {
		boolean existe = repository.existsById(id);
		if (!existe){
			return ResponseEntity.notFound().build();
		}
		repository.save(viagem);
		return ResponseEntity.ok(viagem);
		}
	
	}

