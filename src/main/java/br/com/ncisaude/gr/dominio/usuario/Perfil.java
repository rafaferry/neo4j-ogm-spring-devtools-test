package br.com.ncisaude.gr.dominio.usuario;


import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import br.com.ncisaude.gr.dominio.Entidade;

@NodeEntity
public class Perfil extends Entidade {


	private Set<Funcionalidade> funcionalidades = new HashSet<>();

	@Index(primary = false, unique = true)
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFuncionalidades(Set<Funcionalidade> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	public String getNome() {
		return nome;
	}

	public Set<Funcionalidade> getFuncionalidades() {
		return funcionalidades;
	}

}
