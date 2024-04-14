<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab5</title>
</head>
<body>
    <form action="files" method="POST">
        <input type="submit" value="Выйти" id="logoutButton">
    </form>
    <p>Страница создана: ${generationTime}</p>
    <h1>${currentDir}</h1>
    <c:url value="files" var="upUrl">
        <c:param name="path" value="${parentDirPath}"/>
    </c:url>
    <a href="${upUrl}" style="font-size: 1.5rem">Вверх</a>
    <style type="text/css">
        BODY {
            background: white;
        }

        TABLE {
            width: 100%;
            border-collapse: collapse;
            border: 3px solid #007180;
        }

        TD, TH {
            padding: 20px;
            border: 1px solid maroon;
            text-align: left;
        }

        #logoutButton {
            float: right; /* Выравнивание кнопки вправо */
        }
    </style>
    <table>
        <tr>
            <th>File</th>
            <th>Size</th>
            <th>Date</th>
        </tr>

        <c:forEach var="listElement" items="${list}">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${fn:endsWith(listElement.name, '/')}">
                            <c:url value="files" var="downUrl">
                                <c:param name="path" value="${listElement.path}"/>
                            </c:url>
                            <a href="${downUrl}">"${listElement.name}"</a>
                        </c:when>
                        <c:otherwise>
                            <c:url value="load" var="loadUrl">
                                <c:param name="path" value="${listElement.path}"/>
                            </c:url>
                            <a href="${loadUrl}">"${listElement.name}"</a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${listElement.size}</td>
                <td>${listElement.date}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
