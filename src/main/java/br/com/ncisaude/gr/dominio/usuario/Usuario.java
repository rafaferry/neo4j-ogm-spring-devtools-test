
package br.com.ncisaude.gr.dominio.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

import br.com.ncisaude.gr.dominio.Entidade;
import br.com.ncisaude.gr.dominio.instituicao.Instituicao;

@NodeEntity
public class Usuario extends Entidade {

	private boolean ativo = true;

	@NotEmpty
	@Index(primary = false)
	private String nome;

	@NotEmpty
	@Email
	@Index(primary = true, unique = true)
	private String email;

	private String senha;

	@Size(min = 1)
	@Relationship(type = "POSSUI")
	private Set<Perfil> perfis = new HashSet<>();

	@Size(min = 1)
	@Relationship(type = "POSSUI_ACESSO")
	private Set<Instituicao> instituicoes = new HashSet<>();

	@Transient
	private Instituicao instituicaoLogado;

	public Instituicao getInstituicaoLogado() {
		return instituicaoLogado;
	}

	public void setInstituicaoLogado(Instituicao instituicaoLogado) {
		this.instituicaoLogado = instituicaoLogado;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void ativar() {
		this.ativo = true;
	}

	public void desativar() {
		this.ativo = false;
	}

	public Set<Instituicao> getInstituicoes() {
		return instituicoes;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

	public void setInstituicoes(Set<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + "]";
	}

}
