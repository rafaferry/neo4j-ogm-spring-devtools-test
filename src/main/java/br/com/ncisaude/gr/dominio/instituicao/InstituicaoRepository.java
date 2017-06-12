package br.com.ncisaude.gr.dominio.instituicao;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface InstituicaoRepository extends Neo4jRepository<Instituicao, Long> {

	public Instituicao findByNome(String nome);

	@Query("MATCH (i: Instituicao { ativa: true}) RETURN i")
	public List<Instituicao> findAtivas();

}
