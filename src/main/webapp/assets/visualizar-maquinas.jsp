<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Textil Tech | Tech Master</title>
    <link rel="icon" href="img/LogoTextil.png" type="image/x-icon" sizes="16x16">
    <style><%@include file="../../../assets/css/textilTech.css"%></style>
</head>
<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">
    
    <%@include file="../../../assets/menu.jsp"%>
    
    <div class="lg:ml-64">
        <div class="p-4">
            <div class="header mb-6"> <!-- Adicionada margem inferior maior -->
                <h1 class="text-4xl font-bold">Visualizar Máquinas</h1>
                <a href="home" class="back-button">Voltar</a>
            </div>
            <!-- Barra de pesquisa -->
            <div class="search-bar-container mb-6"> <!-- Adicionada margem inferior -->
                <form action="resultado-pesquisa-maquina" method="GET" class="flex w-full">
                    <input type="text" id="searchInput" placeholder="Pesquisar máquinas..." name="nome">
                    <button type="submit">Pesquisar</button>
                </form>
            </div>

            <table class="w-full text-center mt-4 table-auto bg-white shadow-md rounded-lg">
                <thead>
                    <tr class="bg-gray-200">
                        <th class="px-4 py-2">Nome</th>
                        <th class="px-4 py-2">Tipo</th>
                        <th class="px-4 py-2">Descrição</th>
                        <th class="px-4 py-2">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="maquina" items="${maquinas}">
                        <tr>
                            <td class="border px-4 py-2">${maquina.nome}</td>
                            <td class="border px-4 py-2">${maquina.tipo}</td>
                            <td class="border px-4 py-2">${maquina.descricao}</td>
                            <td class="border px-4 py-2">
                                <a href="perfil-maquina?id=<c:out value='${maquina.id}'/>" class="action-button">Ver Máquina</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
