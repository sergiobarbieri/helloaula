package br.com.drummond.hellodrummond.model;

public class Aluno {
	
	private Long RA;
	private String nome;
	private String email;
	public Long getRA() {
		return RA;
	}
	public void setRA(Long rA) {
		RA = rA;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
