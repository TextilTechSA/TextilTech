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

<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

<style><%@include file="../../../assets/css/textilTech.css"%></style>

</head>
<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">

    <%@include file="../../../assets/menu.jsp"%>

    <div class="lg:ml-64">
        <div class="p-4">
            <div class="header">
                <h1 class="text-4xl font-bold">${maquina.nome}</h1>
                <a href="maquinas" class="back-button">Voltar</a>
            </div>
            
            <div class="content-wrapper mt-6">
                <div class="machine-details grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div class="flex items-center">
                        <i class="icon fas fa-cogs"></i>
                        <h4 class="font-semibold">Nome da Máquina:</h4>
                        <span>${maquina.nome}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-tags"></i>
                        <h4 class="font-semibold">Tipo da Máquina:</h4>
                        <span>${maquina.tipo}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-info-circle"></i>
                        <h4 class="font-semibold">Descrição:</h4>
                        <span>${maquina.descricao}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-wrench"></i>
                        <h4 class="font-semibold">Funcionamento:</h4>
                        <span>${maquina.funcionamento}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-clock"></i>
                        <h4 class="font-semibold">Horário de Início de Operação:</h4>
                        <span>${maquina.horarioInicioOperacao}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-clock"></i>
                        <h4 class="font-semibold">Horário de Fechamento de Operação:</h4>
                        <span>${maquina.horarioFechamentoOperacao}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-tachometer-alt"></i>
                        <h4 class="font-semibold">Capacidade de Operação:</h4>
                        <span>${maquina.capacidadeOperacao}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-exclamation-triangle"></i>
                        <h4 class="font-semibold">Nível de Perigo:</h4>
                        <span>${maquina.nivelPerigo}</span>
                    </div>
                </div>
                
                <div class="normas-table mt-6">
                    <h4 class="text-2xl font-bold mb-4">Normas</h4>
                    <table class="table-auto w-full bg-white shadow-md rounded-lg">
                        <thead>
                            <tr class="bg-gray-200">
                                <th class="px-4 py-2">Nome</th>
                                <th class="px-4 py-2">Tipo</th>
                                <th class="px-4 py-2">Descrição</th>
                                <th class="px-4 py-2">Data de Abertura</th>
                                <th class="px-4 py-2">Homologação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="norma" items="${maquina.normas}">
                                <tr>
                                    <td class="border px-4 py-2">${norma.nome}</td>
                                    <td class="border px-4 py-2">${norma.tipo}</td>
                                    <td class="border px-4 py-2">${norma.descricao}</td>
                                    <td class="border px-4 py-2">${norma.dataAberturaNorma}</td>
                                    <td class="border px-4 py-2">${norma.homologacao}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>
