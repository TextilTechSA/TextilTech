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
            <h1 class="text-4xl font-bold text-blazeOrange">Máquina: ${maquina.nome}</h1>
            
            <div class="content-wrapper">
                <div class="machine-details">
                    <h4>Nome da Máquina:</h4> <span>${maquina.nome}</span>
                    <h4>Tipo da Máquina:</h4> <span>${maquina.tipo}</span>
                    <h4>Descrição:</h4> <span>${maquina.descricao}</span>
                    <h4>Funcionamento:</h4> <span>${maquina.funcionamento}</span>
                    <h4>Horário de Início de Operação:</h4> <span>${maquina.horarioInicioOperacao}</span>
                    <h4>Horário de Fechamento de Operação:</h4> <span>${maquina.horarioFechamentoOperacao}</span>
                    <h4>Capacidade de Operação:</h4> <span>${maquina.capacidadeOperacao}</span>
                    <h4>Nível de Perigo:</h4> <span>${maquina.nivelPerigo}</span>
                </div>
                
                <div class="normas-table">
                    <h4>Normas</h4>
                    <table>
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Tipo</th>
                                <th>Descrição</th>
                                <th>Data de Abertura</th>
                                <th>Homologação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="norma" items="${maquina.normas}">
                                <tr>
                                    <td>${norma.nome}</td>
                                    <td>${norma.tipo}</td>
                                    <td>${norma.descricao}</td>
                                    <td>${norma.dataAberturaNorma}</td>
                                    <td>${norma.homologacao}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
