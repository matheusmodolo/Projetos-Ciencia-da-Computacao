select cliente.* , classificacao.nomeClassificacao, setor.nomeSetor, usuario.nomeUsuario
from cliente, classificacao, setor, usuario
where cliente.fkClassificacao = classificacao.idClassificacao
and cliente.fkSetor = setor.idSetor
and cliente.fkUsuario = usuario.idUsuario
order by (cliente.Nome);

select cliente.Nome, enderecos.cep, enderecos.endereco, enderecos.bairro, enderecos.complemento, telefones.ddd, telefones.numeroFone, cidade.siglaEstado, cidade.nomeCidade
from cliente, enderecos, telefones, cidade
where enderecos.fkCliente = cliente.idCliente
and enderecos.fkCidade = cidade.idCidade
and telefones.fkCliente = cliente.idCliente
order by (cidade.nomeCidade), (cliente.nome);

select cliente.nome, contato.nomeContato, tipocontato.nomeTipoContato, contato.email
from cliente, contato, tipocontato
where contato.fkCliente = cliente.idCliente
and contato.fkTipoContato = tipocontato.idTipoContato
order by (cliente.nome), (contato.nomeContato);


select cliente.nome, pedido.idPedido, pedido.dataPedido, pedido.previsaoEntrega, produto.nomeProduto, pedidoitem.quantidade, produto.valorUnitario, pedido.valorTotal
from cliente, pedido, pedidoitem, produto
where pedido.fkCliente = cliente.idCliente
and pedidoitem.fkProduto = produto.idProduto
and pedidoitem.fkPedido = pedido.idPedido
and cliente.nome like('%agua%')
and pedido.dataPedido like ('%2020%')
and pedido.previsaoEntrega like ('%2021%')
order by (pedido.previsaoEntrega), (pedido.valorTotal);