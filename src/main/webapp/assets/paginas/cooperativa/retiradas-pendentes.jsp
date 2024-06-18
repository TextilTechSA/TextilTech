<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Pendentes</title>
	    <style><%@include file="../../css/cooperativa/retiradas-pendentes.css"%></style>
	</head>
	<body>
		<a href="perfil-cooperativa" id="voltar"><svg><%@include file="../../images/voltar.jsp"%></svg></a>
		<div class="container-retiradas">
			<div class="title">
				<span>Retiradas Agendados</span>
			</div>
			<div class="retiradas-agendadas">
				<c:forEach var="retirada" items="${retiradasAgendadas}">
					<div class="item-retirada-agendada">
						<div class="info">
							<svg class="foto-armazem">
								<%@include file="../../images/perfil.jsp"%>
							</svg>
							<div class="vl"></div>
							<div class="retirada-info">
								<p>Retirada #${retirada.id}</p>
								<p>${retirada.armazem.nome}</p>
								<p>Data: ${retirada.data}</p>
							</div>
						</div>
						<p>Endereço:</p>
						<div class="endereco-info">
							<p>${retirada.armazem.endereco.tipoVia}. ${retirada.armazem.endereco.logradouro}, ${retirada.armazem.endereco.numeroEndereco}</p>
							<p>${retirada.armazem.endereco.bairro}, ${retirada.armazem.endereco.cidade}, ${retirada.armazem.endereco.cep}</p>
							<p>${retirada.armazem.endereco.complemento}</p>
						</div>
						<p>Resumo:</p>
						<div class="resumo-info">	
							${retirada.itemRetirada.peso}kg ${retirada.itemRetirada.material.nome}		
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
							<svg class="foto-armazem">
								<%@include file="../../images/perfil.jsp"%>
							</svg>
							<div class="vl"></div>
							<div class="retirada-info">
								<p>Retirada #${retirada.id}</p>
								<p>Retirada: ${retirada.armazem.nome}</p>
								<p>Data: ${retirada.data}</p>
							</div>
						</div>
						<p>Endereço:</p>
						<div class="endereco-info">
							<p>${retirada.armazem.endereco.tipoVia}. ${retirada.armazem.endereco.logradouro}, ${retirada.armazem.endereco.numeroEndereco}</p>
							<p>${retirada.armazem.endereco.bairro}, ${retirada.armazem.endereco.cidade}, ${retirada.armazem.endereco.cep}</p>
							<p>${retirada.armazem.endereco.complemento}</p>
						</div>
						<p>Resumo:</p>
						<div class="resumo-info">	
							${retirada.itemRetirada.peso}kg ${retirada.itemRetirada.material.nome}		
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>
