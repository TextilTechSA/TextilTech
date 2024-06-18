<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>eCO2You</title>
		<style><%@include file="../css/landing-page.css"%></style>
		<style><%@include file="../css/menu.css"%></style>
		<style><%@include file="../css/footer.css"%></style>
	</head>
	<body>
		<%@ include file="menu.jsp"%>
		<div class="usuarios">
			<h2>Venha reciclar com a Gente</h2>
			<div class="container-usuarios">
	        	<div class="items-usuarios">
	        		<svg>
		        		<%@include file="../images/eCO2You.jsp"%>
		        	</svg>
		        	<h3 class="itens-usuario"> Coletor </h3>
			       <p class="descricao-usuario"> Os coletores são os usuários  que recolhem e
			        guardam os recicláveis,
			        depois enviam para os armazéns.</p>
			        <a href="<%=request.getContextPath()%>/cadastro-coletor">Ser um Coletor</a>
		        </div>
		        <div class="items-usuarios">
		        	<svg>
		        		<%@include file="../images/eCO2You.jsp"%>
		        	</svg>
			        <h3 class="itens-usuario"> Armazém </h3>
				   <p> Os armazéns são as empresas,
				    que se dispõem a armazenar
				    os recicláveis coletados.</p>
				    <a href="<%=request.getContextPath()%>/cadastro-armazem">Ser um Armazém</a>
		        </div>
		        <div class="items-usuarios">
		        <svg>
		        	<%@include file="../images/eCO2You.jsp"%>
		        </svg>
			        <h3 class="itens-usuario">Cooperativa</h3>
					   <p> As cooperativas são as empresas que retiram o material armazenado e, posteriormente, realizam a reciclagem. </p>
					<a href="<%=request.getContextPath()%>/cadastro-cooperativa">Ser uma Cooperativa</a>
				</div>
	    	</div>
		</div>
    	<div class="perguntas-frequentes">
    		<h2 id="titulo-perguntas-frequentes">PERGUNTAS FREQUENTES</h2>
    		<div class="container-perguntas-frequentes">
	    		<div class="items-perguntas-frequentes">
		    		<h3>O que é Ranking?</h3>
					<p class="intens-respostas-perguntas-frequentes">Além das conquistas, contamos com um sistema de Ranking Global onde os coletores são classificados de aacordo com a pontuação adiquirida atravéz de depósitos.</p>
	    		</div>
	    		<div class="vl"></div>
				<div class="items-perguntas-frequentes">
					<h3>Quais materiais são aceitos?</h3>
					<p class="intens-respostas-perguntas-frequentes">Atualmente aceitamos papelão, plástico, alumínio e vidro, mas estamos em constante evolução, trabalhando para sermos capazes de aceitarmos mais e mais materiais.</p>
				</div>
				<div class="vl"></div>
				<div class="items-perguntas-frequentes">
					<h3>E quanto custa?</h3>
					<p class="intens-respostas-perguntas-frequentes">É gratuito, não existe custo associado aos nossos serviços. Nosso objetivo é facilitar e reciclagem e melhorar a logística envolvida nesse processo.</p>
				</div>
	    	</div>
    	</div>
		<%@ include file="footer.jsp"%>
	</body>
</html>
