<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Montador da Tabela</title>
    </head>
    <body>
        <div>
            <c:choose>
                <c:when test="${(param.linha gt 0) and (param.coluna gt 0)}">
                    <table>
                        <c:forEach begin="1" end="${param.linha}" varStatus="i">
                            <tr>
                                <c:forEach begin="1" end="${param.coluna}" varStatus="j">
                                    <td>*</td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>Número de linhas e/ou colunas deve ser maior que 0</p>
                </c:otherwise>
            </c:choose>

        </div>
    </body>
</html>
