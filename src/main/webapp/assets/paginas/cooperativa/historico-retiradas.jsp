<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Histórico</title>
		<style><%@include file="../../css/cooperativa/historico-retiradas.css"%></style>
	</head>
	<body>
    	<a href="perfil-cooperativa" class="dropbtn" id=voltar>
			<svg>
				<%@include file="../../images/voltar.jsp"%>
			</svg>
		</a>
    	<div class="container-retiradas">
			<table>
			<caption>Histórico de Retiradas</caption>
				<thead>
					<tr>
						<th id="coluna-data">Data</th>
						<th id="coluna-armazem">Armazém</th>
	                    <th id="coluna-status">Status</th>
	                    <th id="coluna-resumo">Resumo</th>
					</tr>
				</thead>
				<c:forEach var="retirada" items="${retiradas}">
					<tr>			
						<td>${retirada.data}</td>
						<td>${retirada.armazem.nome}</td>
	                	<td>${retirada.statusDeRetirada}</td>
	                	<td>${retirada.itemRetirada.peso}kg de ${retirada.itemRetirada.material.nome}</td>
					</tr>
				</c:forEach>
			</table>
	    </div>
	</body>
</html>