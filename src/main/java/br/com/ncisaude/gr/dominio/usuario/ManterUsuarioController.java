package br.com.ncisaude.gr.dominio.usuario;

import org.neo4j.ogm.annotation.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.util.IterableUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ncisaude.gr.infra.jsend.JSENDResponse;
import br.com.ncisaude.gr.infra.jsend.SucessoResponse;

@RestController
@Transient
public class ManterUsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("usuarios")
	public JSENDResponse listarUsuarios() {
		Iterable<Usuario> usuarios = IterableUtils.toList(usuarioRepository.findAll());
		return new SucessoResponse().addObject("usuarios", usuarios);
	}

}
