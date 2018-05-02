package br.com.drummond.hellodrummond.resources;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.drummond.hellodrummond.domain.Aluno;
import br.com.drummond.hellodrummond.repository.AlunoRepository;


@RestController
public class AlunoResources {
	

	@Autowired
	private AlunoRepository alunoRepository;

	@RequestMapping(value= {"/hello","/health", "/"}, method = RequestMethod.GET)
	public ResponseEntity<?> hello()
	{
		String retorno = "Sistema ativo -" + Calendar.getInstance().getTime().toString();
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
	
	/**
	 * Obter todos os alunos
	 * @return
	 */
	@RequestMapping(value= {"/alunos"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunos()
	{
		List<Aluno> alunos;
		alunos = alunoRepository.findAll();
		if (alunos == null || alunos.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(alunos);
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}
	
	/**
	 * Obter aluno pelo idRa
	 * @param idRA
	 * @return
	 */
	@RequestMapping(value= {"/alunos/{ra}"}, method = RequestMethod.GET)
	public ResponseEntity<?> obterAlunosRa(@PathVariable("ra") int idRA )
	{
		Aluno aluno = alunoRepository.findOne(idRA);
		if (aluno == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(aluno);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(aluno);
	}
	
	
	/**
	 * Novo aluno a partir do JSON aluno...
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value= {"/alunos"}, method = RequestMethod.POST)
	public ResponseEntity<?> criarAlunosRa(@RequestBody Aluno aluno)
	{
		if (alunoRepository.exists(aluno.getRa()) )
			return ResponseEntity.status(HttpStatus.CONFLICT).body(aluno);
		
		alunoRepository.save(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}
	
	/**
	 * Alterar aluno existente a partir do JSON aluno
	 * @param aluno
	 * @return
	 */
	@RequestMapping(value= {"/alunos"}, method = RequestMethod.PUT)
	public ResponseEntity<?> alterarAlunosRa(@RequestBody Aluno aluno )
	{
		Aluno alunoAtual = alunoRepository.findOne(aluno.getRa());
		if (alunoAtual == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(aluno);
		
		alunoAtual.setNome(aluno.getNome());
		alunoAtual.setEmail(aluno.getEmail());
		
		alunoRepository.save(alunoAtual);
		return ResponseEntity.status(HttpStatus.OK).body(alunoAtual);
		
	}
	
	/**
	 *  Eliminar aluno a partir do idRA
	 * @param idRA
	 * @return
	 */
	@RequestMapping(value= {"/alunos/{ra}"}, method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAlunosRa(@PathVariable("ra") Integer idRA )
	{
		if (!alunoRepository.exists(idRA) )
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	
		alunoRepository.delete(idRA);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}


