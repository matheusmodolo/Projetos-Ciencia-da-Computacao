function exibirCarros(event) {

    let a = "listagem";

    $.ajax("processaCarro", {
        data: {
            acao: a
        },
        dataType: "json"
    }).done((data, textStatus) => {
        let $tbody = $("#tabelaCarro");
        let $cabecalhoTabela = $("#cabecalhoTabela");
        $tbody.html("");
        $cabecalhoTabela.html("");

        $cabecalhoTabela.append(
                `<tr>` +
                `<th>Id</th>` +
                `<th>Nome</th>` +
                `<th>Modelo</th>` +
                `<th>Ano</th>` +
                `</tr>`
                );

        data.forEach(carro => {
            //
            $tbody.append(
                    `<tr><td>${carro.id}</td>` +
                    `<td>${carro.nome}</td>` +
                    `<td>${carro.modelo}</td>` +
                    `<td>${carro.ano}</td></tr>`);
        });


    }).fail((jqXHR, textStatus, errorThrown) => {
        alert("Erro: " + errorThrown + "\n" +
                "Status: " + textStatus);
    });
}
