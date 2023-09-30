<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Dados Obtidos</title>
    </head>
    <body>
        <div>
            <h1>Dados Obtidos</h1>
            <table>
                <tr>
                    <td>Nome:</td>
                    <td>${param.nome}</td>
                </tr>
                <tr>
                    <td>Idade:</td>
                    <td>${param.idade}</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a href="index.html">Voltar</a>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
