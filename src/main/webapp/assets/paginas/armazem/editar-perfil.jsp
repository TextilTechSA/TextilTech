<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
	<meta charset="UTF-8">
		<title>Editar Perfil</title>
		<script src="https://kit.fontawesome.com/9b206050e6.js" crossorigin="anonymous"></script>
		<style><%@include file="../../../assets/css/armazem/editar-perfil.css"%></style>
	</head>
    	<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&family=Poppins&family=Raleway:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <body>
        <div class="container-form">
        	<div class="item-form">
	        	<div  class="container-head">
	        		<div class="item-head">
	        			<span>Editar Perfil</span>
	        		</div>
	        		<div class="item-head">
	        			<div id="back">
	        				<a href="perfil-armazem" id="voltar"><svg><%@include file="../../images/xmark.jsp"%></svg></a>
	        			</div>
	        		</div>
	        	</div>
	        	<form action="atualizar-armazem">
					<div class="container-inputs">
						<div>
							<input class= "input" type="text" value="${armazem.nome}"id="nome" name="nome" placeholder="Informe seu nome">
						</div>
				        	<input class= "input" type="email" value="${armazem.email}" id="email" name="email" placeholder="Informe seu Email">
				        	<input class= "input" type="text" value="${armazem.senha}" id="senha" name="senha" placeholder="Digite uma senha">
				        
				       <div>
				       		<div>
				       		<input class= "input" type="text" value="${armazem.cnpj}" id="cpf" name="cpf" placeholder="Informe seu CPF">
				       		<input class= "input" type="tel" value="${armazem.endereco.telefone}" id="telefone" name="telefone" placeholder="Informe seu telefone">        
				        </div> 
				        	<div>
				        	<input class= "input" type="text" value="${armazem.endereco.cidade}" id="cidade" name="cidade" placeholder="Informe a sua Cidade">
				        	<input class= "input" type="text" value="${armazem.endereco.bairro}" id="bairro" name="bairro" placeholder="Informe seu bairro">
				        </div>
				        <div>
				       	 	<input class= "input" type="text" value="${armazem.endereco.tipoVia}" id="tipoVia" name="tipoVia" placeholder="Informe o tipo de via">
				        	<input class= "input" type="number" value="${armazem.endereco.numeroEndereco}" id="numeroEndereco" name="numeroEndereco" placeholder="Informe o número de residência">
				        </div>
				       	<div>
				       		<input class= "input" type="text" value="${armazem.endereco.logradouro}" id="logradouro" name="logradouro" placeholder="Informe seu logradouro">
				        	<input class= "input" type="text" value="${armazem.endereco.cep}" id="cep" name="cep" placeholder="Informe seu CEP">
				        <div>
				        	<input class= "input" type="text" value="${armazem.endereco.complemento}" id="complemento" name="complemento" placeholder="Complementos">
				        </div>
				        
				        </div>
			        </div>
			        </div>
			        <div class="conteiner-buttons">
						<a href="deslogar" id="deslogar">Deslogar</a>
						<a href="deletar-coletor" id="excuir">Excluir Conta</a>
						<a href="recuperar-senha" id="recuperar">Atualizar Senha</a>
					<input type="submit" value="Salvar" id="salvar" class="conteiner-buttons">
				</div> 
			</form>
	       </div>      	
	     </div>
    </body>
</html>