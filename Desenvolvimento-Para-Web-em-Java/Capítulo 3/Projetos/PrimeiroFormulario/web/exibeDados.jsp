<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <meta name ="viewport" content ="width=device-width, initial-scale=1.0">
        <title>Cliente Obtido</title>
    </head>
    <body>
        <h1>Cliente Obtido</h1>
        
        <table>
            <tr>
                <td>Nome:</td>
                <td>${requestScope.clienteObtido.nome}</td>
            </tr>
            <tr>
                <td>Sobrenome:</td>
                <td>${requestScope.clienteObtido.sobrenome}</td>
            </tr>
            <tr>
                <td>CPF:</td>
                <td>${requestScope.clienteObtido.cpf}</td>
            </tr>
            <tr>
                <td>Data de Nascimento:</td>
                <td>${requestScope.clienteObtido.nascimento}</td>
            </tr>
            <tr>
                <td>Sexo:</td>
                <td>${requestScope.clienteObtido.sexo}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${requestScope.clienteObtido.email}</td>
            </tr>
            <tr>
                <td>Logradouro:</td>
                <td>${requestScope.clienteObtido.logradouro}</td>
            </tr>
            <tr>
                <td>Número:</td>
                <td>${requestScope.clienteObtido.numero}</td>
            </tr>
            <tr>
                <td>Complemento:</td>
                <td>${requestScope.clienteObtido.complemento}</td>
            </tr>
            <tr>
                <td>Cidade:</td>
                <td>${requestScope.clienteObtido.cidade}</td>
            </tr>
            <tr>
                <td>Estado:</td>
                <td>${requestScope.clienteObtido.estado}</td>
            </tr>
            <tr>
                <td>CEP:</td>
                <td>${requestScope.clienteObtido.cep}</td>
            </tr>
            <tr>
                <td>Filhos:</td>
                <td>${requestScope.clienteObtido.filhos}</td>
            </tr>
            <tr>
                <td>Observações:</td>
                <td>${requestScope.clienteObtido.observacoes}</td>
            </tr>
            <tr>
                <td colspan = "2">
                    <a href = "index.html">Voltar</a>
                </td>
            </tr>
        </table>
        
    </body>
</html>
