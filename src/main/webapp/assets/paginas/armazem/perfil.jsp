<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Perfil Armazem</title>
		<style><%@ include file="../../css/armazem/menu.css"%></style>
		<style><%@ include file="../../css/armazem/perfil.css"%></style>
	</head>
		<body>
		<%@include file="menu.jsp"%>
		<div class="container-info">
			<div class="container-perfil-ranking">
				<div class="container-perfil">
					<div class="item-perfil">
						<svg id="foto-coletor">
							<%@include file="../../images/perfil.jsp"%>
						</svg>
					</div>
					<div class="vl"></div>
					<div class="item-perfil">
						<div class="nome-coletor">
							<span>${armazem.nome} / #${armazem.id}</span>
						</div>
						<div class="endereco-coletor">
							<span>${armazem.endereco.bairro},
								${armazem.endereco.cidade}</span>
						</div>
					</div>
				</div>
				<div class="container-proximos">
					<div class="proximo-deposito">
					<span>Próximos Depósitos</span>
					<c:forEach var="deposito" items="${depositos}">
						<div class="item-deposito">
							<div class="info-item-deposito">
								<p>${deposito.coletor.nome}${deposito.data}</p>
							</div>
							<div class="container-acoes">
								<a id="lixeira" href="deletar-deposito?id=<c:out value='${deposito.id}'/>"><svg><%@include file="../../images/trash.jsp"%></svg></a>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="proxima-retirada">
					<span>Próximos Depósitos</span>
					<c:forEach var="retirada" items="${retiradas}">
						<div class="item-retirada">
							<div class="info-item-retirada">
								<p>${retirada.cooperativa.nome}${retirada.data}</p>
							</div>
							<div class="container-acoes">
								<a id="lixeira" href="deletar-retirada?id=<c:out value='${retirada.id}'/>"><svg><%@include file="../../images/trash.jsp"%></svg></a>
							</div>
						</div>
					</c:forEach>
				</div>
				</div>
			</div>
		</div>
	</body>
</html>