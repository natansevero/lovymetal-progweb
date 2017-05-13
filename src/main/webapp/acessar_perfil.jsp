<%-- 
    Document   : acessar_perfil
    Created on : 13/05/2017, 00:18:10
    Author     : natan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Acessar Perfil</h1>
        <p>${requestScope.acessoPerfil.id}</p>
        <p>${requestScope.acessoPerfil.nome_completo}</p>
        <p><img src="${requestScope.acessoPerfil.foto_perfil}"></p>
    </body>
</html>
