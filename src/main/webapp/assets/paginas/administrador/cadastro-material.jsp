<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Cadastro</title>
		<style><%@include file="../../css/administrador/cadastro-material.css"%></style>
		
    </head>
    <body>
 		 <div>
            <h2>Cadastrar Material</h2>
        </div>
            <div class="box">
                        <h1> NOVO MATERIAL </h1>
                        <h4>Nome</h4>
                    <form action="inserir-material" method="post">
                        <div class="nome_material"><input type="text" id="nome_material" name="nome" autofocus maxlength="25"size="35"></div>
                        <div class="cadastrar_material"><button type="submit" name="cadastrar" id=cadastrar class="ButtonEntrar">Cadastrar material</button></div>
                    </form>
            </div>
    </body>
</html>