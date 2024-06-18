<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pesquisar Armazem</title>
</head>
<body>

	<form action="resultado-procurar-armazem">
		<input type="text" placeholder="pesquisar armazem por nome" oninput="this.className = ''" name="pesquisar" id=pesquisar>
		<input type="submit">
	</form>
	
	<c:forEach var="armazem" items="${armazens}">
		    	<div class="item-armazem">
		    		<div id="image-armazem">
		    			<svg>
		    			
		    			</svg>
		    		</div>
			    	<span id="nome-armazem">${armazem.nome}</span>
		            <span>${armazem.endereco.tipoVia}</span>
			    	<span>${armazem.endereco.logradouro}</span>
		            <span>${armazem.endereco.bairro}</span>
		            
		    	</div>
			</c:forEach>

</body>
</html>