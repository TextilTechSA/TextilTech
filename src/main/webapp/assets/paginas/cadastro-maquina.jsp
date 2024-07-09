<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <h1 class="text-3xl font-semibold text-blazeOrange">Adicionar Máquina</h1>
                <div class="mt-6 bg-white p-6 rounded-lg shadow-md">
                    <form id="add-machine-form" action="inserir-maquina">
                        <div class="mb-4">
                            <label for="machine-name" class="block text-sm font-medium text-gray-700">Nome da Máquina</label>
                            <input type="text" id="machine-name" required name="nome" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" >
                        </div>
                         <div class="mb-4">
                            <label for="machine-type" class="block text-sm font-medium text-gray-700">Tipo da Maquina</label>
                            <select id="machine-type" name="tipo" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                                <option value="">Selecione o tipo</option>
                                <option value="tecelagem">Tecelagem</option>
                                <option value="costura">Costura</option>
                                <option value="corte">Corte</option>
                            </select>
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Descricao da Máquina</label>
                            <input type="text" id="machine-code" name="descricao" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Funcionamento da Máquina</label>
                            <input type="text" id="machine-code" name="funcionamento" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Horário de Início da Operação</label>
                            <input type="time" id="machine-code"  name="horarioInicioOperacao" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required name="horarioInicioOperacao">
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Horário de Fechamento da Operação</label>
                            <input type="time" id="machine-code" name="horarioFechamentoOperacao" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                        </div>
                        <div class="mb-4">
                            <label for="machine-code" class="block text-sm font-medium text-gray-700">Capacidade Operação</label>
                            <input type="text" id="machine-code" name="capacidadeOperacao" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                        </div>
                        <div class="mb-4">
                            <label for="machine-danger" class="block text-sm font-medium text-gray-700">Nivel de Periculosidade</label>
                            <select id="machine-danger" name="nivelPerigo" class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm" required>
                                <option value="">Selecione o tipo</option>
                                <option value="baixo">Baixo</option>
                                <option value="medio">Médio</option>
                                <option value="alto">Alto</option>
                            </select>
                        </div>
                        <div class="flex justify-end">
                           <input type="submit" class="bg-blazeOrange text-white py-2 px-4 rounded-md hover:bg-orange-700 focus:outline-none focus:ring-2 focus:ring-blazeOrange focus:ring-opacity-50" value="Adicionar">
                        </div>
                    </form>
                </div>
            </div> 
    </div>
</body>

</html>
