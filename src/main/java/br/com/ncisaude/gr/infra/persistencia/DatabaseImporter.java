package br.com.ncisaude.gr.infra.persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.ncisaude.gr.dominio.usuario.Usuario;

@Component
public class DatabaseImporter implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private Session session;

	@Override
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent event) {
		long entityCount = session.count(Usuario.class, Collections.emptyList());
		if (entityCount != 0) {
			return;
		}

		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("database/startupdata.cypher");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		StringBuilder scriptCompleto = new StringBuilder();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				scriptCompleto.append(line);
			}
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		String[] scripts = scriptCompleto.toString().split(";");

		Map<String, ?> parameters = new HashMap<>();
		for (String script : scripts) {
			session.query(script, parameters);
		}
	}
}
