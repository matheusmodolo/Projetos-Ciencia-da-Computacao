<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/produtos.js"></script>
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>
    <body>

        <h1>Cadastro de Produtos</h1>

        <p>
            <a href="novo.jsp">Novo Produto</a>
        </p>

        <table class="tabela">
            <thead id="cabecalhoTabela"></thead>
            <tbody id = "tabelaProduto"></tbody>
            <button id="botaoListar" onclick="exibirProdutos(event)">
                Exibir Produtos
            </button>
            </br>
        </table>
        <p>
            <a href="novo.jsp">Novo Produto</a>
        </p>

    </body>
</html>
