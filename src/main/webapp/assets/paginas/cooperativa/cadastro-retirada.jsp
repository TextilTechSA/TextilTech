<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Cadastro Retirada</title>
		<style><%@include file="../../css/cooperativa/cadastro-retirada.css"%></style>
	</head>
	<body>
		<div class="button-voltar">
			<a href="procurar-armazem-cooperativa">
				<svg><%@include file="../../images/voltar.jsp"%></svg>
			</a>
		</div>
		<form class="container-cadastro" action="inserir-retirada">
			<span class="titulo-cadastro">Retirada</span>
			<div class="item-retirada">
				<label for="retirada">Data de Retirada</label>
				<input type="date" oninput="this.className = ''" name="data" id=retirada required>
			</div>
			<div class="item-retirada">
				<select name="id">
					<c:forEach var="armazem" items="${armazens}">
						<option value="${armazem.id}">${armazem.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="item-retirada">
				<label> Escolha o Material </label>
				<select name="material" required>
					<c:forEach var="material" items="${materiais}">
						<option value="${material.id}">${material.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="item-retirada">
				<label>Peso</label>
				<input type="number" oninput="this.className = ''" name="peso" id=retirada min=1 required>
			</div>
			<button type="submit">Agendar</button>
		</form>
	</body>
</html>
