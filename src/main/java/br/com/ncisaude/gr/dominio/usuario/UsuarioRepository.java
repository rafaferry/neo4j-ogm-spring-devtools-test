package br.com.ncisaude.gr.dominio.usuario;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UsuarioRepository extends Neo4jRepository<Usuario, Long> {

	public Usuario findByEmail(String email);

}
