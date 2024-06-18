<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
 
<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
		<title>Procurar Armazém</title>
		<style><%@include file="../../css/coletor/procurar-armazem.css"%></style>
		<style><%@include file="../../css/coletor/menu.css"%></style>
    </head>
    <body>
	    <%@ include file="menu.jsp"%>
	    <div class="text-box">
			<span> Armazéns</span>
	    	<div class="vl"></div>
		    <span>Encontre o melhor ponto de entrega para você</span>
	    </div>
	    <form class="container-search-armazem" action="resultado-procurar-armazem">
	    	<div class="item-search-armazem">
		    	<input type="text" placeholder="Pesquisar Armazém" oninput="this.className = ''" name="pesquisar" id=pesquisar>
		    </div>
		    <div class="button-search-armazem">
		    	<input type="submit" value="Buscar">
		    </div>
		</form>
	    <div class="container-armazem">
			<c:forEach var="armazem" items="${armazens}">
				<div class="item-armazem">
					<a href="perfil-externo-armazem?id=<c:out value='${armazem.id}'/>">
						<svg class="image-armazem"></svg>
					</a>
					<span id="nome-armazem">${armazem.nome}</span>
					<span>${armazem.endereco.tipoVia}. ${armazem.endereco.logradouro} ${armazem.endereco.numeroEndereco}</span>
					<span>${armazem.endereco.bairro}, ${armazem.endereco.cidade}</span>
			    	<div class="container-buttons-item-armazem">
			    		<a href="cadastro-deposito?id=<c:out value='${armazem.id}'/>">Deposite</a>
			    	</div>
		    	</div>
			</c:forEach>
		</div>
    </body>
</html>