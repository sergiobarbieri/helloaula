package br.com.drummond.hellodrummond.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.drummond.hellodrummond.model.Aluno;

@RestController
public class StudentResources {

	@RequestMapping(value= {"/hello","/health", "/"}, method = RequestMethod.GET)
	public ResponseEntity<?> hello()
	{
		String retorno = "Olá alunos!";
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
	
	/*
	 * Obter todos os alunos
	 */
	@RequestMapping(value= {"/alunos"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunos()
	{
		String retorno = "Alunos - Obter";
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
	
	/*
	 * Obter aluno especifico
	 */
	
	@RequestMapping(value= {"/alunos/{ra}"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunosRa(@PathVariable("ra") Long idRA )
	{
		if (idRA > 99999999)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
		}
		
		// busca do aluno e retornou na classe
		
		Aluno aluno;
		aluno = new Aluno();
		aluno.setRA(idRA);
		aluno.setNome("Jean Marques");
		aluno.setEmail("mrjean@company.uk");
		
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	/*
	 * Novo aluno
	 */
	
	@RequestMapping(value= {"/alunos"}, method = RequestMethod.POST)
	public ResponseEntity<?> criarAlunosRa(@RequestBody Aluno aluno )
	{
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}
	
	
	/*
	 * Alterar aluno existente
	 */
	
	@RequestMapping(value= {"/alunos"}, method = RequestMethod.PUT)
	public ResponseEntity<?> alterarAlunosRa(@RequestBody Aluno aluno )
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	/*
	 * Eliminar aluno
	 */
	
	@RequestMapping(value= {"/alunos/{ra}"}, method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAlunosRa(@PathVariable("ra") Long idRA )
	{
		Aluno aluno = new Aluno();
		if (idRA > 99999999)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
		}
	
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(aluno);
	}
}


