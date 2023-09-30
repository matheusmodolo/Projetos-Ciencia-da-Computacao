<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Novo Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/produtos.js"></script>
        <link rel="stylesheet"
              href="${cp}/css/estilos.css"/>
    </head>

    <body>

        <h1>Novo Produto</h1>

        <form method="post" action="${cp}/processaProduto">

            <input name="acao" type="hidden" value="inserir"/>

            <table>
                <tr>
                    <td class="alinharDireita">Descrição:</td>
                    <td>
                        <input name="descricao"
                               type="text"
                               size="20"
                               maxlength="30"
                               required/>
                    </td>
                </tr>
                <tr>
                    <td class="alinharDireita">Estoque:</td>
                    <td>
                        <input name="estoque"
                               type="num"
                               size="20"
                               maxlength="30"
                               required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="index.jsp">
                            Voltar
                        </a>
                    </td>
                    <td class="alinharDireita">
                        <input type="submit" value="Salvar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>