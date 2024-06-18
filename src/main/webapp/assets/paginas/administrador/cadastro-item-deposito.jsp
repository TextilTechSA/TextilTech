<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
		<title>Cadastro</title>
    </head>
    <form action="landing-page">
		<button type="submit" name="voltar" id=voltar>Voltar</button>
	</form>
    <body>
    	<form action="inserir-item-deposito" method="post">
	        <h1> Novo Item Depósito </h1>
	        <br>
	        <br>
	        <select name="reciclavel">
	        	<c:forEach var="reciclavel" items="${reciclaveis}">
	        		<option value="<c:out value="${reciclavel.id}" />"><c:out value="${reciclavel.nome}" /><option>
	        	</c:forEach>
	        </select>
	        <br>
	        <br>
	        <input type="number" id="quantidade-reciclaveis" name="quantidade-reciclaveis" autofocus placeholder="quantidade" maxlength="25" required size="20">
	        <br>
	        <br>
	        <button type="submit" name="cadastrar" id=cadastrar class="ButtonEntrar">Cadastrar Item Depósito</button>
	        <br>
	        <br>
	        <h2>Faça parte dessa mudança!</h2>
			<Pre>Conecte-se a uma comunidade<br> comprometida com a <br>sustentabilidade e preservação<br> do meio ambiente.</Pre>
        </form>
    </body>
</html>