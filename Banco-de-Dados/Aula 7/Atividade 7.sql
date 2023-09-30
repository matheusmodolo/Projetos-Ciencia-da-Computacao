INSERT INTO contato (nomeContato) 
SELECT DISTINCT nomeContato
FROM testePrefeitos LEFT JOIN contato ON contato.nomeContato = testePrefeitos.nomeContato
WHERE nomeContato IS NULL;

CREATE VIEW A7
SELECT cliente.nome, setor.nomeSeteor, classificacao.nomeClassificacao,
contato.nomeContato, tipoContato.nomeTipoContato, contato.email,
enderecos.endereco, enderecos.numero, enderecos.cep, enderecos.bairro, cidade.nomeCidade
telefones.ddd, telefones.numeroFone
FROM cliente
INNER JOIN setor ON setor.idSetor = cliente.fkSetor,
INNER JOIN classificacao ON classificacao.idClassificacao = cliente.fkClassificacao,
INNER JOIN contato ON contato.fkCliente = cliente.idCliente,
INNER JOIN tipoContato ON tipoContato.idTipoContato = contato.fkTipoContato,
LEFT JOIN enderecos ON enderecos.fkCliente = cliente.idCliente,
LEFT JOIN cidade ON cidade.idCidade = enderecos.fkCidade,
LEFT JOIN telefones ON telefones.fkCliente = cliente.idCliente