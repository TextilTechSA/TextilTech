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
            <h1 class="text-4xl font-bold text-blazeOrange">${norma.nome}</h1>
            
            <div class="content-wrapper mt-6">
                <div class="norma-details grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div class="flex items-center">
                        <h4 class="font-semibold mr-2">Nome da Norma:</h4>
                        <span>${norma.nome}</span>
                    </div>
                    <div class="flex items-center">
                        <h4 class="font-semibold mr-2">Tipo da Norma:</h4>
                        <span>${norma.tipo}</span>
                    </div>
                    <div class="flex items-center">
                        <h4 class="font-semibold mr-2">Descrição:</h4>
                        <span>${norma.descricao}</span>
                    </div>
                    <div class="flex items-center">
                        <h4 class="font-semibold mr-2">Data de Abertura:</h4>
                        <span>${norma.dataAberturaNorma}</span>
                    </div>
                    <div class="flex items-center">
                        <h4 class="font-semibold mr-2">Homologação:</h4>
                        <span>${norma.homologacao}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
