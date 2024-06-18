<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Perfil Armazem</title>
		<script src="https://kit.fontawesome.com/9b206050e6.js" crossorigin="anonymous"></script>
		<style><%@include file="../../css/cooperativa/perfil-armazem.css"%></style>
	</head>
	<body>
		<a href="procurar-armazem-cooperativa" >
			<svg>
				<%@ include file="../../images/voltar.jsp" %>
			</svg>
		</a>
		<div class="container-perfil">
			<div class="item-perfil">
				<div class="funcao-perfil">
				</div>
				<div class="nome-armazem">
					<img src="#" alt="Imagem Perfil" name="imagem" id=imagem1>
				</div>
				<div class="nome-armazem">
					<span>${armazem.nome}</span>
				</div>
				<div class="status-armazem">
              		<span>${armazem.horarioAbertura} - ${armazem.horarioFechamento}</span>
				</div>
				<div class="endereco-armazem">
					<span>${armazem.descricao}</span>
					<span>${armazem.endereco.tipoVia} ${armazem.endereco.logradouro}</span>
              		<span>${armazem.endereco.bairro} </span>
             		<span>${armazem.endereco.numeroEndereco}</span>
              		<span>${armazem.endereco.cidade}, SC</span>
              	</div>
			</div>
		</div>			
	</body>
</html>
             
          