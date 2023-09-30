SELECT * FROM cidade WHERE idCidade NOT IN(SELECT fkCidade FROM enderecos) ORDER BY SiglaEstado, NomeCidade;
SELECT * FROM cliente WHERE idCliente NOT IN(SELECT fkCliente FROM contato) ORDER BY Nome;
SELECT * FROM cliente WHERE idCliente IN (SELECT fkCliente FROM pedido WHERE DataPedido = "2019-01-02 20:14:26") ORDER BY Nome;
SELECT * FROM contato WHERE ( (NomeContato LIKE '%Paulo%') AND (NumeroCelular IS NOT NULL) );
SELECT * FROM pedido WHERE idPedido IN (SELECT fkPedido FROM pedidoitens WHERE Quantidade > 10) ORDER BY idPedido DESC;