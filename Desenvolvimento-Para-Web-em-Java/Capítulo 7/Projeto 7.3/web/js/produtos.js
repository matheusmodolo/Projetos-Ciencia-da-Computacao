function exibirProdutos(event) {

    let a = "listagem";

    $.ajax("processaProduto", {
        data: {
            acao: a
        },
        dataType: "json"
    }).done((data, textStatus) => {
        let $tbody = $("#tabelaProduto");
        let $cabecalhoTabela = $("#cabecalhoTabela");
        $tbody.html("");
        $cabecalhoTabela.html("");

        $cabecalhoTabela.append(
                `<tr>` +
                `<th>Id</th>` +
                `<th>Descrição</th>` +
                `<th>Estoque</th>` +
                `</tr>`
                );

        data.forEach(produto => {
            //
            $tbody.append(
                    `<tr><td>${produto.id}</td>` +
                    `<td>${produto.descricao}</td>` +
                    `<td>${produto.estoque}</td></tr>`);
        });


    }).fail((jqXHR, textStatus, errorThrown) => {
        alert("Erro: " + errorThrown + "\n" +
                "Status: " + textStatus);
    });
}