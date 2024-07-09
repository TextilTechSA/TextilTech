<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Textil Tech | Tech Master</title>
<link rel="icon" href="img/LogoTextil.png" type="image/x-icon"
	sizes="16x16">

    <style><%@include file="../../../assets/css/textilTech.css"%></style>

</head>

<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">

	<%@include file="../../../assets/paginas/menu.jsp"%>
	
	<div class="lg:ml-64">
			<div class="p-4">
				<h1 class="text-4xl font-bold text-blazeOrange">Maquina: ${maquina.nome}</h1>
				<div class="mt-6 bg-white p-6 rounded-lg shadow-md">
					<!-- Barra de pesquisa -->
					<div class="mb-4 flex justify-center items-center">
						<button onclick="searchMachines()"
							class="px-4 py-2 bg-blazeOrange text-white rounded-md hover:bg-white hover:text-blazeOrange border border-blazeOrange focus:outline-none focus:ring focus:ring-blazeOrange focus:border-blazeOrange">
							Pesquisar</button>
						<input type="text" id="searchInput"
							placeholder="Pesquisar máquinas..."
							class="ml-2 px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-blazeOrange focus:border-blazeOrange w-2/3">
					</div>
					<table class="w-full text-center mt-4">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Tipo</th>
								<th>Descrição</th>
								<th>Data de Abertura</th>
								<th>Data de Edição</th>
								<th>data de Revisão</th>
								<th>Homologação</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="norma" items="${normas}">
								<tr>
									<td>${norma.nome}</td>
									<td>${norma.tipo}</td>
									<td>${norma.descricao}</td>
									<td></td>
									<td></td>
									<td></td>
									<td>${norma.homologacao}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
	</div>
</div>

</body>
</html>