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
    .norma-details h4 {
        color: #ffffff; /* Cor do texto: cinza-900 */
        margin-right: 1rem;
        background-color: #133a59; /* Fundo azul claro */
        padding: 0.5rem 1rem;
        border-radius: 0.375rem;
        font-size: 1.125rem;
    }
    .norma-details span {
        color: #133a59; /* Cor do texto: cinza-700 */
        font-size: 1.125rem;
    }
    .norma-details div {
        border-bottom: 1px solid #e5e7eb; /* Cor da borda: cinza-200 */
        padding: 1rem;
        margin-bottom: 1rem;
        transition: background-color 0.3s ease;
        display: flex;
        align-items: center;
        border-radius: 0.375rem;
        background-color: #e5e7eb;
    }
    .norma-details div:hover {
        background-color: #969696; /* Cor do fundo ao passar o mouse: verde-50 */
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
                <h1 class="text-4xl font-bold">${norma.nome}</h1>
                <a href="normas" class="back-button">Voltar</a>
            </div>
            
            <div class="content-wrapper mt-6">
                <div class="norma-details grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div class="flex items-center">
                        <i class="icon fas fa-file-alt"></i>
                        <h4 class="font-semibold">Nome da Norma:</h4>
                        <span>${norma.nome}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-tags"></i>
                        <h4 class="font-semibold">Tipo da Norma:</h4>
                        <span>${norma.tipo}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-check-circle"></i>
                        <h4 class="font-semibold">Homologação:</h4>
                        <span>${norma.homologacao}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-calendar-alt"></i>
                        <h4 class="font-semibold">Data de Abertura:</h4>
                        <span>${norma.dataAberturaNorma}</span>
                    </div>
                    <div class="flex items-center">
                        <i class="icon fas fa-info-circle"></i>
                        <h4 class="font-semibold">Descrição:</h4>
                        <span>${norma.descricao}</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>
