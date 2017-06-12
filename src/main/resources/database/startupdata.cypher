MERGE (u:Usuario { ativo: true, nome: "Administrador do sistema", email: "rafael.farias@ncisaude.com.br", senha: "dead3668ee8c5faa9fc5c4c576a5ace3"})
-[:POSSUI]->
(p:Perfil { nome: "Administrador do sistema", funcionalidades: ["listarUsuarios", "manterUsuarios"]});

MERGE (i:Instituicao {
	ativa: true,
	nome: "Santa Casa de Araraquara",
	cnpj: "12.988.574/0001-12",
	bairro: "Jardim Marivan",
	cidade: "Araraquara",
	uf: "SP"
});

MATCH (u:Usuario { email: "rafael.farias@ncisaude.com.br" })
MATCH (i:Instituicao {nome: "Santa Casa de Araraquara"})
CREATE (u)-[:POSSUI_ACESSO]->(i);
