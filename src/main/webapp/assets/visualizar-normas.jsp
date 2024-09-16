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

    <%@include file="../../../assets/menu.jsp" %>

    <div class="lg:ml-64">
        <div class="p-4">
            <div class="header mb-6"> <!-- Adicionada margem inferior maior -->
                <h1 class="text-4xl font-bold">Adicionar Norma</h1>
                <a href="home" class="back-button">Voltar</a>
            </div>
            <!-- Barra de pesquisa -->
            <div class="search-bar-container mb-6"> <!-- Adicionada margem inferior -->
                <form action="resultado-pesquisa-norma" method="GET" class="flex w-full max-w-lg">
                    <input type="text" id="searchInput" name="nome" placeholder="Pesquisar normas..."
                        class="px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-blazeOrange focus:border-blazeOrange flex-grow">
                    <button type="submit"
                        class="ml-2 px-4 py-2 bg-blazeOrange text-white rounded-md hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-blazeOrange focus:ring-opacity-50">
                        Pesquisar
                    </button>
                </form>
            </div>
            <table class="w-full text-center mt-4 table-auto bg-white shadow-md rounded-lg">
                <thead>
                    <tr class="bg-gray-200">
                        <th class="px-4 py-2">Nome</th>
                        <th class="px-4 py-2">Tipo</th>
                        <th class="px-4 py-2">Data de Abertura</th>
                        <th class="px-4 py-2">Homologação</th>
                        <th class="px-4 py-2">Ação</th>
                        <th class="px-4 py-2">Ação</th>
                        <th class="px-4 py-2">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="norma" items="${normas}">
                        <tr>
                            <td class="border px-4 py-2">${norma.nome}</td>
                            <td class="border px-4 py-2">${norma.tipo}</td>
                            <td class="border px-4 py-2">${norma.dataAberturaNorma}</td>
                            <td class="border px-4 py-2">${norma.homologacao}</td>
                            <td class="border px-4 py-2">
                                <a href="perfil-norma?id=<c:out value='${norma.id}'/>" class="action-button">Ver Norma</a>
                            </td>
                            <td class="border px-4 py-2">
                                <a href="editar-norma?id=<c:out value='${norma.id}'/>" class="action-button">editar Norma</a>
                            </td>
                            <td class="border px-4 py-2">
                                <a href="deletar-norma?id=<c:out value='${norma.id}'/>" class="action-button">Deletar Norma</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>
