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
<style>
    /* Estilos personalizados */
    .content-wrapper {
        background: linear-gradient(to bottom, #e0f2fe, #ffffff);
        padding: 2rem;
        border-radius: 0.75rem;
        box-shadow: 0 10px 15px rgba(0, 0, 0, 0.1);
        margin-top: 2rem;
    }
    .machine-details h4 {
        color: #1f2937; /* Cor do texto: cinza-900 */
        margin-right: 1rem;
        background-color: #e0f7fa; /* Fundo azul claro */
        padding: 0.5rem 1rem;
        border-radius: 0.375rem;
        font-size: 1.125rem;
    }
    .machine-details span {
        color: #4b5563; /* Cor do texto: cinza-700 */
        font-size: 1.125rem;
    }
    .machine-details div {
        border-bottom: 1px solid #e5e7eb; /* Cor da borda: cinza-200 */
        padding: 1rem;
        margin-bottom: 1rem;
        transition: background-color 0.3s ease;
        display: flex;
        align-items: center;
        border-radius: 0.375rem;
        background-color: #ffffff;
    }
    .machine-details div:hover {
        background-color: #f0fdf4; /* Cor do fundo ao passar o mouse: verde-50 */
    }
    .header {
        background: linear-gradient(to right, #133A59, #133A59); /* Gradiente azul escuro */
        padding: 1rem;
        border-radius: 0.75rem;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .header h1 {
        color: #ffffff; /* Cor do texto: branco */
        font-size: 2rem;
    }
    .back-button {
        display: inline-block;
        padding: 0.5rem 1rem;
        background-color: #1d4ed8; /* Cor de fundo: azul-700 */
        color: #ffffff;
        border-radius: 0.375rem;
        transition: background-color 0.3s ease;
        text-decoration: none;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .back-button:hover {
        background-color: #2563eb; /* Cor de fundo ao passar o mouse: azul-600 */
    }
    .icon {
        margin-right: 0.5rem;
        color: #1d4ed8; /* Cor do ícone: azul-700 */
        font-size: 1.5rem;
    }
</style>
</head>
<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">

    <%@include file="../../../assets/menu.jsp"%>

    <div class="lg:ml-64">
        <div class="p-4">
            <div class="header">
                <h1 class="text-4xl font-bold">${maquina.nome}</h1>
                <a href="visualizarMaquinas.jsp" class="back-button">Voltar</a>
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
