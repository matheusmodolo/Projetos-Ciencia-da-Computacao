<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Frutas</title>
        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/frutas.js"></script>
        <link rel="stylesheet" href="${cp}/css/estilos.css"/>
    </head>
    <body>

        <h1>Cadastro de Frutas</h1>

        <p>
            <a href="novo.jsp">Nova Fruta</a>
        </p>

        <table class="tabela">
            <thead id="cabecalhoTabela"></thead>
            <tbody id = "tabelaFruta"></tbody>
            <button id="botaoListar" onclick="exibirFrutas(event)">
                Exibir frutas
            </button>
            </br>
        </table>
        <p>
            <a href="novo.jsp">Nova Fruta</a>
        </p>

    </body>
</html>
