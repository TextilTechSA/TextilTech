<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Textil Tech | Tech Master</title>
<link rel="icon" type="image/x-icon" href="../../../assets/img/TextilTech-SVG.jsp">
<style><%@include file="../../../assets/css/textilTech.css"%></style>
<script src="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"></script>
<script>
function toggleDropdown(id) {
    var element = document.getElementById(id);
    if (element.classList.contains('hidden')) {
        element.classList.remove('hidden');
    } else {
        element.classList.add('hidden');
    }
}
</script>
</head>
<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">
	<aside id="default-sidebar"
		class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full lg:translate-x-0 bg-white">
		<div class="overflow-y-auto py-5 px-3 h-full border-r border-white">
			<a href="home"
				class="flex items-center uppercase tracking-estatium p-0 text-2xl text-blazeOrange group">
				<%@include file="../../../assets/img/TextilTech-SVG.jsp"%>
				<span class="ml-0 font-extrabold">Textil Tech</span>
			</a>

			<ul class="pt-5 mt-5 space-y-2 border-t border-blazeOrange">
				<li><a href="home"
					class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
						<%@include file="../../../assets/img/Inicio-SVG.jsp"%> 
						<span class="ml-3">Início</span>
				</a>
				</li>
				<li>
                    <button onclick="toggleDropdown('maquinasDropdown')"
                        class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group w-full">
                         <%@include file="../../../assets/img/Adicionar-Maquina-SVG.jsp"%> 
                         <span class="ml-3">Máquinas</span>
                    </button>
                    <ul id="maquinasDropdown" class="hidden mt-2 space-y-2 pl-4">
                        <li><a href="cadastro-maquina"
                            class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                                <%@include file="../../../assets/img/Adicionar-Maquina-SVG.jsp"%>
                                <span class="ml-3">Adicionar Máquinas</span>
                        </a></li>
                        <li><a href="maquinas"
                            class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                                <%@include file="../../../assets/img/Visualizar-Maquina-SVG.jsp"%>
                                <span class="ml-3">Visualizar Máquinas</span>
                        </a></li>
                    </ul>
                </li>
                <li>
                    <button onclick="toggleDropdown('normasDropdown')"
                        class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group w-full">
                        <%@include file="../../../assets/img/Adicionar-Norma-SVG.jsp"%> 
                        <span class="ml-3">Normas</span>
                    </button>
                    <ul id="normasDropdown" class="hidden mt-2 space-y-2 pl-4">
                        <li><a href="cadastro-norma"
                            class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                                <%@include file="../../../assets/img/Adicionar-Norma-SVG.jsp"%>  
                                <span class="ml-3">Adicionar Normas</span>
                        </a></li>
                        <li><a href="normas"
                            class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                                <%@include file="../../../assets/img/Visualizar-Norma-SVG.jsp"%> 
                                <span class="ml-3">Visualizar Normas</span>
                        </a></li>
                    </ul>
                </li>
				<li><a href="home"
					class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
						<%@include file="../../../assets/img/Sair-SVG.jsp"%>
						<span class="ml-3">Sair</span>
				</a></li>
			</ul>
		</div>
	</aside>
</body>
</html>