<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Perfil Coletor</title>
		<style><%@include file="../../css/coletor/perfil.css"%></style>
		<style><%@include file="../../css/coletor/menu.css"%></style>
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
							<span>${coletor.nome} ${coletor.sobrenome} / #${coletor.id}</span>
						</div>
						<div class="endereco-coletor">
							<span>${coletor.endereco.bairro},
								${coletor.endereco.cidade}</span>
						</div>
					</div>
				</div>
				<div class="proximo-deposito">
					<span>Próximos Depósitos</span>
					<c:forEach var="deposito" items="${deposito}">
						<div class="item-deposito">
							<div class="info-item-deposito">
								<p>${deposito.armazem.nome}${deposito.data}</p>
								<p>${deposito.armazem.endereco.tipoVia}. ${deposito.armazem.endereco.logradouro}, ${deposito.armazem.endereco.numeroEndereco}</p>
								<p>${deposito.armazem.endereco.bairro}, ${deposito.armazem.endereco.cidade}, ${deposito.armazem.endereco.cep}</p>
								<p>${deposito.armazem.endereco.complemento}</p>
							</div>
							<div class="container-acoes">
								<a id="lixeira" href="deletar-deposito?id=<c:out value='${deposito.id}'/>"><svg><%@include file="../../images/trash.jsp"%></svg></a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="ranking">
				<span>Ranking</span>
				<div class="container-ranking">
					<c:forEach var="coletor" items="${coletores}">
						<div class="item-ranking">
							# ${coletor.nome} ${coletor.sobrenome} / ${coletor.pontos}pts
						</div>
					</c:forEach>
				</div>
				<div class="container-coletor-ranking">
					#${coletor.nome} ${coletor.sobrenome} / ${coletor.pontos}pts
				</div>
			</div>
		</div>
	</body>
</html>
