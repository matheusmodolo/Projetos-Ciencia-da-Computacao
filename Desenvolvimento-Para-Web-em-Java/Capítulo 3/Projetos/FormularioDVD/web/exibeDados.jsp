<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DVD Obtido</title>
    </head>
    <body>
        <div>

            <h1>DVD Obtido</h1>

            <table>
                <tr>
                    <td>Número:</td>
                    <td>${requestScope.DVDObtido.numero}</td>
                </tr>
                <tr>
                    <td >Título:</td>
                    <td>${requestScope.DVDObtido.titulo}</td>
                </tr>
                <tr>
                    <td >Ator/Atriz Principal:</td>
                    <td>${requestScope.DVDObtido.atorPrincipal}</td>
                </tr>
                <tr>
                    <td >Ator/Atriz Coadjuvante:</td>
                    <td>${requestScope.DVDObtido.atorCoadjuvante}</td>
                </tr>
                <tr>
                    <td >Diretor/Diretora:</td>
                    <td>${requestScope.DVDObtido.diretor}</td>
                </tr><
                <tr>
                    <td >Ano de Lançamento:</td>
                    <td>${requestScope.DVDObtido.ano}</td>
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
