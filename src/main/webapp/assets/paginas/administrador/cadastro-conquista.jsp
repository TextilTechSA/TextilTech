<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&family=Poppins&family=Raleway:ital,wght@0,100..900;1,100..900&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Cadastro</title>
<style><%@ include file="../../css/administrador/cadastro-conquista.css" %></style>
<script src="https://kit.fontawesome.com/9b206050e6.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<form action="inserir-conquista" method="post">

		<h2>Nova Conquista</h2>

		<div id="conteiner">
			<h1 id="h1Titulo">NOVA CONQUISTA</h1>
			<div class="h2InDiv">
				<h4 id="nome1">Nome</h4>
			</div>
			<input type="text" id="nome" name="nome" autofocus maxlength="25"
				size="15" class="box">
			<div class="h2InDiv">
				<h4 id="pontos1">Pontos da conquista</h4>
			</div>
			<input type="number" id="pontos" name="pontos" autofocus
				maxlength="25" size="15" class="box">
			<div class="h2InDiv">
				<h4 id="descricao1">Descrição da conquista</h4>
			</div>
			<input type="text" id="descricao" name="descricao" autofocus
				maxlength="25" size="15" class="box">
			<div>
				<button type="submit" name="cadastrar" id=cadastrar
					class="ButtonEntrar">Cadastrar Conquista</button>
			</div>
	</form>
</body>
</html>
