<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
		<title>Cadastro</title>
		<style><%@include file="../../css/administrador/cadastro-reciclavel.css"%></style>
    </head>
    <form action="landing-page">
	</form>
    <body>
    	 <h1 id="titulo01"> Novo Reciclável </h1>
    	<div class="container">
    		<form action="inserir-reciclavel" method="post">
                <h1> Novo Reciclável </h1>
	        <div>
                <input type="text" id="nome" name="nome" autofocus placeholder="Nome do reciclável" class="recursosReciclavel">
                <input type="number" id="peso" name="peso" autofocus placeholder="Peso do Reciclável" class="recursosReciclavel">
            </div>
	        <div>
                <select name="material" id="material">
                                <c:forEach var="material" items="${materiais}">
                                    <option value="${material.id}">${material.nome}</option>
                                </c:forEach>
                </select>
                <input type="number" id="volume" name="volume" placeholder="Volume do Reciclável (ml)">
            </div>
			<div>
                <input type="number" id="pontos-carbono" name="pontos-carbono" placeholder="Quantidade de pontos">
                <input type="text" id="instrucao-reciclavel" name="instrucao-reciclavel" placeholder="Instrução de depósito">
            </div>
	        <div><button type="submit" >Cadastrar Reciclável</button></div>
        </form>
    	</div>
    </body>
</html>