<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Carros</title>
        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/carros.js"></script>
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>
    <body>

        <h1>Cadastro de Carros</h1>

        <p>
            <a href="novo.jsp">Novo Carro</a>
        </p>

        <table class="tabela">
            <thead id="cabecalhoTabela"></thead>
            <tbody id = "tabelaCarro"></tbody>
            <button id="botaoListar" onclick="exibirCarros(event)">
                Exibir carros
            </button>
            </br>
        </table>
        <p>
            <a href="novo.jsp">Novo Carro</a>
        </p>

    </body>
</html>
