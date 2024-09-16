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
            <div class="header">
                <h1 class="text-4xl font-bold">Editar Máquina</h1>
                <a href="home" class="back-button">Voltar</a>
            </div>
                <div class="mt-6 bg-white p-6 rounded-lg shadow-md">
                    <form id="add-machine-form" action="atualizar-maquina">
                        <div class="mb-4">
                            <input type="hidden" id="machine-name" required name="id" value="${maquina.id}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" >
                        </div>
                        <div class="mb-4">
                            <label for="machine-name" class="block text-sm font-medium text-gray-700">Nome da Máquina</label>
                            <input type="text" id="machine-name" required name="nome" value="${maquina.nome}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" >
                        </div>
                         <div class="mb-4">
                            <label for="machine-type" class="block text-sm font-medium text-gray-700">Tipo da Maquina</label>
                            <select id="machine-type" name="tipo" value="${maquina.tipo}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                                <option value="">Selecione o tipo</option>
                                <option value="tecelagem">Tecelagem</option>
                                <option value="costura">Costura</option>
                                <option value="corte">Corte</option>
                            </select>
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Descricao da Máquina</label>
                            <input type="text" id="machine-code" name="descricao" value="${maquina.descricao}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Funcionamento da Máquina</label>
                            <input type="text" id="machine-code" name="funcionamento" value="${maquina.funcionamento}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Horário de Início da Operação</label>
                            <input type="time" id="machine-code"  name="horarioInicioOperacao" value="${maquina.horarioInicioOperacao}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required name="horarioInicioOperacao">
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Horário de Fechamento da Operação</label>
                            <input type="time" id="machine-code" name="horarioFechamentoOperacao" value="${maquina.horarioFechamentoOperacao}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Capacidade Operação</label>
                            <input type="text" id="machine-code" name="capacidadeOperacao" value="${maquina.capacidadeOperacao}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                        </div>
                        <div class="mb-4">
                            <label for="machine-danger" class="block text-sm font-medium text-gray-700">Nivel de Periculosidade</label>
                            <select id="machine-danger" name="nivelPerigo" value="${maquina.nivelPerigo}" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                                <option value="">Selecione o tipo</option>
                                <option value="baixo">Baixo</option>
                                <option value="medio">Médio</option>
                                <option value="alto">Alto</option>
                            </select>
                        </div>
                        <div class="flex justify-end">
                           <input type="submit" class="action-button" value="salvar">
                        </div>
                    </form>
                </div>
            </div> 
    </div>
</body>

</html>
