<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Procurar-coletor</title>
		<style><%@include file="../../css/coletor/procurar-coletor.css"%></style>
		<style><%@include file="../../css/coletor/menu.css"%></style>
	</head>
	<body>
	    <%@ include file="menu.jsp"%>
	    <div class="text-box">
	    	<span> Coletores</span>
	    	<div class="vl"></div>
		    <span>Conheça os coletores cadastrados</span>
	    </div>
	    <form class="container-search-coletor" action="resultado-procurar-coletor">
	    	<div class="item-search-coletor">
		    	<input type="text" placeholder="Pesquisar Coletor" oninput="this.className = ''" name="pesquisar" id=pesquisar>
		    </div>
		    <div class="button-search-coletor">
		    	<input type="submit" value="Buscar">
		    </div>
		</form>
	    <div class="container-coletor">
			<c:forEach var="coletor" items="${coletores}">
				<a class="item-coletor" href="perfil-externo-coletor?id=<c:out value='${coletor.id}'/>">
					<svg class="image-coletor"><%@include file="../../images/perfil.jsp"%></svg>
					<span id="nome-coletor">${coletor.nome} ${coletor.sobrenome}</span>
				</a>
			</c:forEach>
		</div>
	</body>
</html>