package br.com.drummond.hellodrummond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoController {
	
	@RequestMapping(value = { "/crudAluno" }, method = RequestMethod.GET)
	public ModelAndView getAlunoExemplo() {
		ModelAndView mv = new ModelAndView("crudAluno");
		return mv;
	}
}
