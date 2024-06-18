<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Perfil do ${coletor.nome} ${coletor.sobrenome}</title>
		<script src="https://kit.fontawesome.com/9b206050e6.js" crossorigin="anonymous"></script>
		<style><%@include file="../../css/coletor/perfil-externo-coletor.css"%></style>
		<style><%@include file="../../css/coletor/menu.css"%></style>
	</head>
	<body>
		<a href="procurar-coletor" >
			<svg>
				<%@ include file="../../images/voltar.jsp" %>
			</svg>
		</a>
		<div class="container-info">
			<div class="container-perfil">
				<div class="item-perfil">
					<svg id="foto-coletor">
						<%@include file="../../images/perfil.jsp"%>
					</svg>
				</div>
				<div class="vl"></div>
				<div class="item-perfil">
					<div class="nome-coletor">
						<span>${coletor.nome} ${coletor.sobrenome} / #${coletor.id}</span>
					</div>
					<div class="endereco-coletor">
						<span>${coletor.endereco.bairro}, ${coletor.endereco.cidade}</span>
					</div>
					<div class="funcao-perfil">
						<span id="pontos-coletor">859Pts</span>    
					</div>
				</div>	
				<div  class="ranking">
					Ranking
				</div>
			</div>
		</div>	
	</body>
</html>