package br.com.drummond.hellodrummond.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResources {

	@RequestMapping(value= {"/hello","/health", "/"}, method = RequestMethod.GET)
	public ResponseEntity<?> hello()
	{
		String retorno = "Olá alunos!";
		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}
}
