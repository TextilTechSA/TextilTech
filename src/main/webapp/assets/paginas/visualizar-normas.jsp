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
    <button data-drawer-target="default-sidebar" data-drawer-toggle="default-sidebar" type="button"
        class="inline-flex items-center p-2 mt-2 ml-3 text-sm text-blazeOrange rounded-lg lg:hidden">
        <span class="sr-only">Abrir</span>
        <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path clip-rule="evenodd" fill-rule="evenodd"
                d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z">
            </path>
        </svg>
    </button>
    <aside id="default-sidebar"
    class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full lg:translate-x-0 bg-white">
    <div class="overflow-y-auto py-5 px-3 h-full border-r border-white">
        <a href="textiltech-index.html"
           class="flex items-center uppercase tracking-estatium p-0 text-2xl text-blazeOrange group">
            <img src="img/LogoTextil.png" alt="Favicon" class="h-16 w-16 mr-20">
            <span class="ml-0 font-extrabold">Textil Tech</span>
        </a>

        <ul class="pt-5 mt-5 space-y-2 border-t border-blazeOrange">
            <li>
                <a href="home"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Inicio.png" alt="Início"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Início</span>
                </a>
            </li>
            <li>
                <a href="cadastro-maquina"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Maquinas.png" alt="Adicionar Máquinas"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Adicionar Máquinas</span>
                </a>
            </li>
            <li>
                <a href="maquinas"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Visualizar.png" alt="Visualizar Máquinas"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Visualizar Máquinas</span>
                </a>
            </li>
            <li>
                <a href="cadastro-norma"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Normas.png" alt="Adicionar Normas"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Adicionar Normas</span>
                </a>
            </li>
            <li>
                <a href="normas"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Visualizar.png" alt="Visualizar Normas"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Visualizar Normas</span>
                </a>
            </li>
            <li>
                <a href="home"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                        <path fill-rule="evenodd"
                            d="M7.5 3.75A1.5 1.5 0 0 0 6 5.25v13.5a1.5 1.5 0 0 0 1.5 1.5h6a1.5 1.5 0 0 0 1.5-1.5V15a.75.75 0 0 1 1.5 0v3.75a3 3 0 0 1-3 3h-6a3 3 0 0 1-3-3V5.25a3 3 0 0 1 3-3h6a3 3 0 0 1 3 3V9A.75.75 0 0 1 15 9V5.25a1.5 1.5 0 0 0-1.5-1.5h-6Zm5.03 4.72a.75.75 0 0 1 0 1.06l-1.72 1.72h10.94a.75.75 0 0 1 0 1.5H10.81l1.72 1.72a.75.75 0 1 1-1.06 1.06l-3-3a.75.75 0 0 1 0-1.06l3-3a.75.75 0 0 1 1.06 0Z"
                            clip-rule="evenodd" />
                    </svg>
                    <span class="ml-3">Sair</span>
                </a>
            </li>
        </ul>
    </div>
</aside>
    <div class="lg:ml-64">
        <main class="pt-20 pb-16">
            <div class="p-4">
                <h1 class="text-3xl font-semibold text-blazeOrange">Visualizar Normas</h1>
                <div class="mt-6 bg-white p-6 rounded-lg shadow-md">
                    <!-- Barra de pesquisa -->
                    <div class="mb-4 flex">
                        <button onclick="searchNormas()"
                            class="px-4 py-2 bg-blazeOrange text-white rounded-md hover:bg-white hover:text-blazeOrange border border-blazeOrange focus:outline-none focus:ring focus:ring-blazeOrange focus:border-blazeOrange">
                            Pesquisar
                        </button>
                        <input type="text" id="searchInputNormas" placeholder="Pesquisar normas..."
                            class="ml-2 px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-blazeOrange focus:border-blazeOrange">
                    </div>

                    <!-- Tabela de normas -->
                    <table class="min-w-full divide-y divide-gray-200">
                        <thead class="bg-gray-50">
                            <tr>
                                <th scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    ID da Norma</th>
                                <th scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Tipo da Norma</th>
                                <th scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Data de Abertura</th>
                                <th scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Data de Edição</th>
                                <th scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Data de Revisão</th>
                                <th scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Homologação da Norma</th>
                                <th scope="col"
                                    class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                    Homologação da Norma</th>
                            </tr>
                        </thead>
                        <tbody id="norma-list" class="bg-white divide-y divide-gray-200">
                            <!-- Aqui será inserida a lista de normas -->
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>

    <script>
        function searchNormas() {
            const input = document.getElementById('searchInputNormas').value;
            // Adicione a lógica de pesquisa aqui
            console.log('Pesquisando normas:', input);
        }
    </script>
</body>>