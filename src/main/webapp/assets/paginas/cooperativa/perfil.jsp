<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Perfil Cooperativa</title>
		<style><%@ include file="../../css/cooperativa/menu.css"%></style>
		<style><%@ include file="../../css/cooperativa/perfil.css"%></style>
	</head>
	<body>
		<%@include file="menu.jsp"%>
		<div class="container-info">
			<div class="container-perfil">
					<div class="item-perfil">
						<svg id="foto-cooperativa">
							<%@include file="../../images/perfil.jsp"%>
						</svg>
					</div>
					<div class="vl"></div>
					<div class="item-perfil">
						<div class="nome-cooperativa">
							<span>${cooperativa.nome} / #${cooperativa.id}</span>
						</div>
						<div class="endereco-coletor">
							<span>${cooperativa.endereco.bairro}, ${cooperativa.endereco.cidade}</span>
						</div>
				</div>
			</div>
			<div class="proxima-retirada"> 
				<span>Próximas Retiradas</span>
				<c:forEach var="retirada" items="${retiradas}">
					<div class="item-retirada">
						<div class="container-info-retirada">
							<div class="container-foto-retirada">
								<c:choose>
									<c:when test="${retirada.itemRetirada.material.nome eq 'Alumínio'}">
										<svg id="foto-item-retirada">
									    	<%@ include file="../../images/aluminio.jsp"%>
										</svg>
									</c:when>
									<c:when test="${retirada.itemRetirada.material.nome eq 'Plástico'}">
									    <svg id="foto-item-retirada">
									    	<%@ include file="../../images/plastico.jsp"%>
										</svg>
									</c:when>
									<c:otherwise>
										<p>Opção inválida.</p>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="info-item-retirada">
								<p>${retirada.armazem.nome} ${retirada.data}</p>
								<p>${retirada.armazem.endereco.tipoVia}. ${retirada.armazem.endereco.logradouro}, ${retirada.armazem.endereco.numeroEndereco}</p>
								<p>${retirada.armazem.endereco.bairro}, ${retirada.armazem.endereco.cidade}, ${retirada.armazem.endereco.cep}</p>
								<p>${retirada.armazem.endereco.complemento}</p>
							</div>
						</div>
						<div class="container-acoes">
							<a id="lapis" href="editar-deposito?id=<c:out value='${retirada.id}'/>"><svg><%@include file="../../images/lapis.jsp"%></svg></a>
							<a id="lixeira" href="deletar?id=<c:out value='${retirada.id}'/>"><svg><%@include file="../../images/trash.jsp"%></svg></a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</body>
</html>
