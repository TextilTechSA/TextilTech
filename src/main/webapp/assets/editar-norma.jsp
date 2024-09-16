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

	<%@include file="../../../assets/menu.jsp"%>

	<div class="lg:ml-64">
        <div class="p-4">
            <div class="header">
                <h1 class="text-4xl font-bold">Editar Norma</h1>
                <a href="home" class="back-button">Voltar</a>
            </div>
				<div class="mt-6 bg-white p-6 rounded-lg shadow-md">
					<form id="add-norm-form" action="inserir-norma">
					<div class="mb-4">
						 <input type="hidden" id="norm-type" name="id" value="${norma.id}"
								class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm"
								required>
						</div>

						<div class="mb-4">
							<label for="norm-type"
								class="block text-sm font-medium text-gray-700">Escolha Maquina
							</label> 
							<select id="norm-homologation" name="id_maquina"
								class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm"
								required>
								<option value="">Selecione a Maquina</option>
								<c:forEach var="maquina" items="${maquinas}">
								<option value="${maquina.id}"> ${maquina.nome}</option>
								</c:forEach>
							</select>
						</div>
						<div class="mb-4">
							<label for="norm-type"
								class="block text-sm font-medium text-gray-700">Nome da
								Norma</label> <input type="text" id="norm-type" name="nome" value="${norma.nome}"
								class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm"
								required>
						</div>
						<div class="mb-4">
							<label for="norm-type"
								class="block text-sm font-medium text-gray-700">Tipo de
								Norma</label> <select id="norm-homologation" name="tipo" value="${norma.tipo}"
								class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm"
								required>
								<option value="">Selecione o tipo</option>
								<option value="procedimnto">Procedimento</option>
								<option value="terminilogia">Terminologia</option>
								<option value="simbologia">Simbologia</option>
							</select>
						</div>
						<div class="mb-4">
							<label for="norm-description"
								class="block text-sm font-medium text-gray-700">Descrição
								da Norma</label>
							<textarea id="norm-description" name="descricao" value="${norma.descricao}"
								class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm"
								rows="4" required></textarea>
						</div>
						<div class="mb-4">
							<label for="norm-homologation"
								class="block text-sm font-medium text-gray-700">Homologação
								da Norma</label> <select id="norm-homologation" name="homologacao" value="${norma.homologacao}"
								class="mt-1 block w-full p-2 border border-gray-300 rounded-md shadow-sm focus:ring-blazeOrange focus:border-blazeOrange sm:text-sm"
								required>
								<option value="">Selecione o tipo</option>
								<option value="ativa">Norma Ativa</option>
								<option value="inativa">Norma Inativa</option>
							</select>
						</div>
						<div class="flex justify-end">
							<button type="submit"
								class="action-button">
								Salvar</button>
						</div>
					</form>
				</div>
			</div>
	</div>
</body>
</html>
