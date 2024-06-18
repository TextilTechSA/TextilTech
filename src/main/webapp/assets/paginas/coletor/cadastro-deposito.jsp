<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Cadastro Depósito</title>
		<style><%@include file="../../css/coletor/cadastro-deposito.css"%></style>
	</head>
	<body>
		<div class="button-voltar">
			<a href="perfil-coletor">
				<svg><%@include file="../../images/voltar.jsp"%></svg>
			</a>
		</div>
		<form class="container-cadastro" action="inserir-deposito">
			<h1>Depósito</h1>
			<div class="item-deposito">
				<label for="deposito">Data de Depósito</label>
				<input type="date" oninput="this.className = ''" name="data" id=deposito>
			</div>
			<div class="item-deposito">
				<select name="id">
					<c:forEach var="armazem" items="${armazens}">
						<option value="${armazem.id}">${armazem.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="item-deposito">
				<label> Escolha a Reciclavel </label>
				<select name="reciclavel">
					<c:forEach var="reciclavel" items="${reciclaveis}">
						<option value="${reciclavel.id}">${reciclavel.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="item-deposito">
				<label>Quantidade</label>
				<input type="number" oninput="this.className = ''" name="quantidade-reciclavel" id=deposito min=1>
			</div>
			<button type="submit">Agendar</button>
		</form>
	</body>
</html>
