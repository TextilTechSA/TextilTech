<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cadastrar Norma</title>
</head>
<body>

	<form class="container-cadastro" action="inserir-norma">
			<h1>Norma</h1>
			<div class="item-deposito">
				<label for="norma">Tipo da Norma</label>
				<input type="text" oninput="this.className = ''" name="tipo" id=norma>
			</div>
			<div class="item-deposito">
				<label for="norma">Descrição da Norma</label>
				<input type="text" oninput="this.className = ''" name="descricao" id=norma>
			</div>
			<div class="item-deposito">
				<label for="norma">Data de Abertura da Norma</label>
				<input type="date" oninput="this.className = ''" name="dataAberturaNorma" id=norma>
			</div>
			<div class="item-deposito">
				<label for="deposito">Data de Edição</label>
				<input type="date" oninput="this.className = ''" name="dataEdicaoNorma" id=norma>
			</div>
			<div class="item-deposito">
				<label for="deposito">Data de Revisão</label>
				<input type="date" oninput="this.className = ''" name="dataRevisaoNorma" id=norma>
			</div>
			<div class="item-deposito">
				<label>Homologação da Norma</label>
				<input type="text" oninput="this.className = ''" name="homologacao" id=norma>
			</div>
			<button type="submit">Adicionar Norma</button>
		</form>
	
</body>
</html>