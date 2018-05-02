package br.com.drummond.hellodrummond.repository;

import br.com.drummond.hellodrummond.domain.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository  extends JpaRepository<Aluno, Integer> {

}
