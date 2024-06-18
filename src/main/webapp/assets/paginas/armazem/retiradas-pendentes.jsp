<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Pendentes</title>
	    <style><%@include file="../../css/armazem/retiradas-pendentes.css"%></style>
	</head>
	<body>
		<a href="perfil-armazem" id="voltar"><svg><%@include file="../../images/voltar.jsp"%></svg></a>
		<div class="container-retiradas">
			<div class="title">
				<span>Retiradas Agendados</span>
			</div>
			<div class="retiradas-agendadas">
				<c:forEach var="retirada" items="${retiradasAgendadas}">
					<div class="item-retirada-agendada">
						<div class="info">
							<svg class="foto-cooperativa">
								<%@include file="../../images/perfil.jsp"%>
							</svg>
							<div class="vl"></div>
							<div class="retirada-info">
								<p>Retirada #${retirada.id}</p>
								<p>${retirada.cooperativa.nome}</p>
								<p>Data: ${retirada.data}</p>
							</div>
						</div>
						<p>Resumo:</p>
						<div class="resumo-info">	
							${retirada.itemRetirada.peso}kg ${retirada.itemRetirada.material.nome}		
						</div>
						<div>
							<a href="atualizar-retirada?id=<c:out value='${retirada.id}'/>&status=CONCLUIDO">Aceitar</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="title">
				<span>Retirada Pendentes</span>
			</div>
			<div class="retiradas-pendentes">
				<c:forEach var="retirada" items="${retiradasPendentes}">
					<div class="item-retirada-agendada">
						<div class="info">
							<svg class="foto-cooperativa">
								<%@include file="../../images/perfil.jsp"%>
							</svg>
							<div class="vl"></div>
							<div class="retirada-info">
								<p>Retirada #${retirada.id}</p>
								<p>${retirada.cooperativa.nome}</p>
								<p>Data: ${retirada.data}</p>
							</div>
						</div>
						<p>Resumo:</p>
						<div class="resumo-info">	
							${retirada.itemRetirada.peso}kg ${retirada.itemRetirada.material.nome}		
						</div>
						<div>
							<a href="atualizar-retirada?id=<c:out value='${retirada.id}'/>&status=AGENDADO">Aceitar</a>
							<a href="deletar-retirada?id=<c:out value='${retirada.id}'/>">Rejeitar</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>
