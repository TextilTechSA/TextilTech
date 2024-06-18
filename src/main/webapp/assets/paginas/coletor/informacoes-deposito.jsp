<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&family=Poppins&family=Raleway:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
		<meta charset="UTF-8">
		<title>Editar Depósito</title>
		<style><%@include file="../../../assets/css/coletor/editar-perfil.css"%></style>
	</head>
    <body>
        <div class="container-form">
        	<div class="item-form">
	        	<div  class="container-head">
	        		<div class="item-head">
	        			<span>Editar Depósito</span>
	        		</div>
	        		<div class="item-head">
	        			<div id="back">
	        				<a href="perfil-coletor" id="voltar"><svg><%@include file="../../images/xmark.jsp"%></svg></a>
	        			</div>
	        		</div>
	        	</div>
	        	<form action="atualizar-deposito">
					<div class="container-inputs">
						<div>
							<input class="input" type="date" value="${deposito.data}" id="data" name="data">
						</div>
						<div class="armazem">
							<select name="idArmazem">
								<c:forEach var="armazem" items="${armazens}">
									<option value="${armazem.id}">${armazem.nome}</option>
								</c:forEach>
							</select>
						</div> 
						<div class="item-deposito">
							<select name="idReciclavel">
								<c:forEach var="reciclavel" items="${reciclaveis}">
									<option value="${reciclavel.id}">${reciclavel.nome}</option>
								</c:forEach>
							</select>
							<input class="input" type="number" value="${deposito.itensDeposito.quantidadeReciclaveis}" id="quantidadeReciclaveis" name="quantidadeReciclaveis">
						</div>
			        </div>
			        <input type="submit" value="Salvar" id="salvar" class="conteiner-buttons">
				</form>
	        </div>      	
	        </div>
    </body>
</html>