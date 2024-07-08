<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200..1000;1,200..1000&family=Poppins&family=Raleway:ital,wght@0,100..900;1,100..900&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>

</head>
<body>
	<a href="landing-page"></a>
	<div class="container-login">
		<form action="logar" method="post">
			<span>Login</span>
			<div class="item-login">
				<div>
					<label>E-mail</label>
				</div>
				<input type="email" id="email" name="email"
					placeholder="username@gmail.com" maxlength="65"
					class="e-mailEsenha">
			</div>
			<div class="item-login">
				<div>
					<label>Senha</label>
				</div>
				<input type="password" id="senha" name="senha" placeholder="senha"
					maxlength="25" class="e-mailEsenha">
				<p class="esqueceuSenha">
					Esqueceu a senha? <a href="recuperar-senha" id="esqueceuSenha">Recuperar</a>
				</p>
			</div>
			<div class="item-login">
				<button type="submit">Entrar</button>
				<div class="registrar">
					<p>
						Não tem Conta? <a href="cadastro-coletor">Registre-se</a>
					</p>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
