<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Histórico</title>
		<style><%@include file="../../css/coletor/historico-depositos.css"%></style>
	</head>
	<body>
    	<a href="perfil-coletor" class="dropbtn" id=voltar>
			<svg>
				<%@include file="../../images/voltar.jsp"%>
			</svg>
		</a>
    	<div class="container-depositos">
			<table>
			<caption>Histórico de Depósitos</caption>
				<thead>
					<tr>
						<th id="coluna-data">Data</th>
						<th id="coluna-armazem">Armazém</th>
	                    <th id="coluna-pontuacao">Pontuação</th>
	                    <th id="coluna-status">Status</th>
	                    <th id="coluna-resumo">Resumo</th>
					</tr>
				</thead>
				<c:forEach var="deposito" items="${depositos}">
					<tr>			
						<td>${deposito.data}</td>
						<td>${deposito.armazem.nome}</td>
	                	<td>12</td>
	                	<td>${deposito.statusDeDeposito}</td>
	                	<td>
	                	<c:forEach var="itemDeposito" items="${deposito.itensDeposito}">		
							${itemDeposito.quantidadeReciclaveis}x ${itemDeposito.reciclavel.nome} ${itemDeposito.reciclavel.volume}ml		
						</c:forEach>
	                	</td>
					</tr>
				</c:forEach>
			</table>
	    </div>
	</body>
</html>