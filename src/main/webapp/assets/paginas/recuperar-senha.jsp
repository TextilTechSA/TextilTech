<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recuperar Senha</title>
</head>
<body>
<div>
    <a href="login" class="">Voltar</a>
    <span id="recuperarSenha">Recuperar Senha</span>
    <div>
        <label for="email1">E-mail</label>
        <input type="email" placeholder="username@gmail.com" name="email1" id="email1" onchange="validarFormulario()" oninput="this.className = ''" required>
    </div>
    <div>
        <label for="email2">Confirme seu e-mail</label>
        <input type="email" placeholder="username@gmail.com" name="email2" id="email2" onchange="validarFormulario()" oninput="this.className = ''" required>
    </div>
    <button type="submit" id="proximo1" disabled>Próximo</button>
    <script>
        function validarFormulario() {
            const email1 = document.getElementById("email1").value;
            const email2 = document.getElementById("email2").value;
            const botao = document.getElementById("proximo1");

            if (email1 === email2 && email1 != "") {
                botao.disabled = false;
            } else {
                botao.disabled = true;
            }
        }
    </script>
</div> 
<div>
    <a href="login" class="">Voltar</a>
    <span id="recuperarSenha">Recuperar Senha</span>
    <span>Informe o código que recebeu por e-mail</span>
    <input type="number" name="codigo" id="codigo1" class="codigo" min="0" max="9" oninput="this.className = ''" required>
    <input type="number" name="codigo" id="codigo2" class="codigo" min="0" max="9" oninput="this.className = ''" required>
    <input type="number" name="codigo" id="codigo3" class="codigo" min="0" max="9" oninput="this.className = ''" required>
    <input type="number" name="codigo" id="codigo4" class="codigo" min="0" max="9" oninput="this.className = ''" required>
    <button type="submit" id="recuperar">Recuperar</button>
</div>
<div>
    <a href="login" class="">Voltar</a>
    <span id="recuperarSenha">Recuperar Senha</span>
    <div class="tab">
        <label for="senha">Nova senha:</label>
        <input type="password" id="senha" placeholder="Senha" onchange="validarFormulario2()" oninput="this.className = ''" required>
        <button onclick="togglePassword()">Mostrar/Esconder Senha</button>
        <label for="outra-senha">Confirme sua nova senha:</label>
        <input type="password" id="outra-senha" placeholder="Senha" onchange="validarFormulario2()" oninput="this.className = ''" required>
        <button onclick="togglePassword2()">Mostrar/Esconder Senha</button>
        <form action =/eCO2You/login>
        <button type="submit" id="submeter" disabled>Finalizar</button>
        </form>
    </div>
    <script>
        function validarFormulario2() {
            const senha = document.getElementById("senha").value;
            const outraSenha = document.getElementById("outra-senha").value;
            const botao = document.getElementById("submeter");

            if (senha === outraSenha && senha != "") {
                botao.disabled = false;
            } else {
                botao.disabled = true;
            }
        }

        function togglePassword() {
            const senhaInput = document.getElementById("senha");
            const tipoAtual = senhaInput.type;
            senhaInput.type = (tipoAtual === "password") ? "text" : "password";
        }

        function togglePassword2() {
            const senhaInput = document.getElementById("outra-senha");
            const tipoAtual = senhaInput.type;
            senhaInput.type = (tipoAtual === "password") ? "text" : "password";
        }
    </script>
</div>
</body>
</html>
