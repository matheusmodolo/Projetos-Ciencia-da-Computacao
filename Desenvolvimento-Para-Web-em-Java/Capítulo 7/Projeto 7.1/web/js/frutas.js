function exibirFrutas(event) {

    let a = "listagem";

    $.ajax("processaFruta", {
        data: {
            acao: a
        },
        dataType: "json"
    }).done((data, textStatus) => {
        let $tbody = $("#tabelaFruta");//como se fosse um import do html
        let $cabecalhoTabela = $("#cabecalhoTabela");
        $tbody.html(""); //renderização, etc, importante para não haver repetição
        $cabecalhoTabela.html("");

        $cabecalhoTabela.append(
                `<tr>` +
                `<th>Id</th>` +
                `<th>Nome</th>` +
                `<th>Cor</th>` +
                `</tr>`
                );

        data.forEach(fruta => {
            //
            $tbody.append(
                    `<tr><td>${fruta.id}</td>` +
                    `<td>${fruta.nome}</td>` +
                    `<td>${fruta.cor}</td></tr>`);
        });


    }).fail((jqXHR, textStatus, errorThrown) => {
        alert("Erro: " + errorThrown + "\n" +
                "Status: " + textStatus);
    });
}
