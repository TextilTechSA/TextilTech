<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <%@include file="../../../assets/paginas/menu.jsp"%>

    <div class="lg:ml-64">
        <div class="p-4">
            <div>
                <!-- Barra de pesquisa -->
                <div class="mb-4 flex justify-start items-center">
                    <a href="resultado-pesquisa-maquina">Pesquisar</a>
                    <input type="text" id="searchInput"
                           placeholder="Pesquisar máquinas..."
                           name="nome" class="ml-2 px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-blazeOrange focus:border-blazeOrange w-2/3">
                </div>
            </div>
        </div>
    </div>

</body>

</html>
