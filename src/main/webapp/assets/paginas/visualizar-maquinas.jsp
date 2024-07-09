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
				<h1 class="text-4xl font-bold text-blazeOrange">Visualizar
					Máquinas</h1>
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
							</tr>
						</thead>
						<tbody>
							<c:forEach var="maquina" items="${maquinas}">
								<tr>
									<td>${maquina.nome}</td>
									<td>${maquina.tipo}</td>
									<td>${maquina.descricao}</td>
									<td><a href="perfil-maquina?id=<c:out value='${maquina.id}'/>">Deposite</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	</div>

	<script>
		// Função para buscar as máquinas do servidor
		async function fetchMachines() {
			try {
				const response = await fetch('../../../assets/paginas/visualizar-maquinas.jsp'); // Substitua pelo seu endpoint real
				const machines = await response.json();
				return machines;
			} catch (error) {
				console.error('Erro ao buscar máquinas:', error);
				return [];
			}
		}

		// Exibir a lista de máquinas na tabela
		async function displayMachines() {
			const machineList = document.getElementById('machine-list').getElementsByTagName('tbody')[0];
			machineList.innerHTML = ''; // Limpar a tabela

			const machines = await fetchMachines();
			machines.forEach((machine) => {
				const row = document.createElement('tr');
				row.innerHTML = 
					`<td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">${machine.nome}</td>
					<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.tipo}</td>
					<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.descricao}</td>
					<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.horarioInicioOperacao}</td>
					<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.horarioFechamentoOperacao}</td>
					<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.capacidadeOperacao}</td>
					<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.nivelPerigo}</td>`;
				machineList.appendChild(row);
			});
		}

		// Função para pesquisar máquinas na tabela
		async function searchMachines() {
			const searchTerm = document.getElementById('searchInput').value.toLowerCase();
			const machines = await fetchMachines();
			const machineList = document.getElementById('machine-list').getElementsByTagName('tbody')[0];
			machineList.innerHTML = '';

			machines.forEach(machine => {
				if (machine.nome.toLowerCase().includes(searchTerm)) {
					const row = document.createElement('tr');
					row.innerHTML = 
						`<td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">${machine.nome}</td>
						<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.tipo}</td>
						<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.descricao}</td>
						<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.horarioInicioOperacao}</td>
						<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.horarioFechamentoOperacao}</td>
						<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.capacidadeOperacao}</td>
						<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">${machine.nivelPerigo}</td>`;
					machineList.appendChild(row);
				}
			});
		}

		// Inicialmente exibir todas as máquinas
		displayMachines();
	</script>

</body>

</html>
