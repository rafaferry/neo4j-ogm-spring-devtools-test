package br.com.ncisaude.gr.dominio.instituicao;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.ncisaude.gr.dominio.Entidade;

public class Instituicao extends Entidade implements Comparable<Instituicao> {

	@NotEmpty
	private String nome;

	@NotEmpty
	private String cnpj;

	@NotEmpty
	private String bairro;

	@NotEmpty
	private String cidade;

	@NotNull
	private UF uf;

	private boolean ativa = true;

	@Override
	public int compareTo(Instituicao o) {
		return this.nome.compareTo(o.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

}
