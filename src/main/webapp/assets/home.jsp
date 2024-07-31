<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>

<html lang="pt-br">

<head>
<meta charset="UTF-8">
<title>Textil Tech | Tech Master</title>
<link rel="icon" href="img/LogoTextil.png" type="image/x-icon"
	sizes="16x16">
 
 <style><%@include file="../../../assets/css/textilTech.css"%></style>

</head>

<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">
	<%@include file="../../../assets/menu.jsp"%>

	<div id="content-wrapper"
		class="flex-1 p-6 ml-0 lg:ml-64 transition-margin duration-300 ease-in-out">
		<section id="sobre"
			class="bg-white border-4 rounded border-blazeOrange">
			<div
				class="gap-16 items-center py-8 px-4 mx-auto max-w-screen-xl lg:grid lg:grid-cols-2 lg:py-16 lg:px-6">
				<div class="font-light text-nickel sm:text-lg">
					<h2
						class="mb-4 text-4xl tracking-estatium font-extrabold uppercase text-blazeOrange">
						Sobre nós</h2>
					<p class="mb-4">
						A Textil Tech foi criada para otimizar a cadeia de suprimentos de
						empresas, garantindo o controle de qualidade dos produtos. Nosso
						objetivo é tornar sua empresa um ambiente melhor e mais propício
						para a excelência.<br> <br>Oferecemos soluções para
						adicionar, atualizar, deletar produtos e monitorar o desempenho
						geral e de produtos específicos. Além disso, nosso sistema informa
						a última data de inspeção de cada produto, gerenciando as próximas
						inspeções necessárias.
					</p>
				</div>
				<div class="grid grid-cols-2 gap-4 mt-8">
					<img class="w-full rounded-lg"
						src="https://flowbite.s3.amazonaws.com/blocks/marketing-ui/content/office-long-2.png"
						alt="office content 1"> <img
						class="mt-4 w-full lg:mt-10 rounded-lg"
						src="https://flowbite.s3.amazonaws.com/blocks/marketing-ui/content/office-long-1.png"
						alt="office content 2">
				</div>
			</div>
		</section>
		<section>
			<div class="py-8 px-4 mx-auto max-w-screen-xl sm:py-16 lg:px-6">
				<div class="max-w-screen-md mb-8 lg:mb-16">
					<h2
						class="mb-4 text-4xl tracking-estatium font-extrabold uppercase text-blazeOrange">Linguagens
						de programação</h2>
					<p class="text-nickel sm:text-xl">
						Na Textil Tech, exploramos as linguagens de programação essenciais
						que impulsionam a criação de soluções digitais inovadoras.<br>
						<br>Desde a estruturação básica com HTML até a interatividade
						dinâmica com JavaScript, cada linguagem desempenha um papel
						crucial na construção de experiências web robustas e funcionais.
						Nosso foco principal está na otimização da cadeia de suprimentos,
						garantindo eficiência e qualidade para sua empresa.
					</p>
				</div>
				<div
					class="space-y-8 md:grid md:grid-cols-2 lg:grid-cols-3 md:gap-12 md:space-y-0">
					<div>
						<div
							class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeGray lg:h-12 lg:w-12">
							<%@include file="../../../assets/img/HTML-img.jsp"%>
						</div>
						<h3 class="mb-2 text-xl font-bold text-blazeOrange">HTML</h3>
						<p class="text-nickel">HTML permite definir a estrutura básica
							de uma página, incluindo elementos como texto, imagens e links.</p>
					</div>
					<div>
						<div
							class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeGray lg:h-12 lg:w-12">
							<%@include file="../../../assets/img/CSS-img.jsp"%>
						</div>
						<h3 class="mb-2 text-xl font-bold text-blazeOrange">CSS</h3>
						<p class="text-nickel">CSS é usado para controlar o layout, as
							cores e os estilos de todos os elementos HTML em um site.</p>
					</div>
					<div>
						<div
							class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeGray lg:h-12 lg:w-12">
							<%@include file="../../../assets/img/Java.jsp"%>
						</div>
						<h3 class="mb-2 text-xl font-bold text-blazeOrange">Java</h3>
						<p class="text-nickel">Java é amplamente utilizado em
							aplicativos corporativos, desde sistemas financeiros até
							aplicativos móveis.</p>
					</div>
					<div>
						<div
							class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeGray lg:h-12 lg:w-12">
							<%@include file="../../../assets/img/SQL-SVG.jsp"%>
						</div>
						<h3 class="mb-2 text-xl font-bold text-blazeOrange">SQL</h3>
						<p class="text-nickel">SQL é essencial para consultas
							complexas, inserções de dados e operações de atualização em
							bancos de dados..</p>
					</div>
					<div>
						<div
							class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeGray lg:h-12 lg:w-12">
							<%@include file="../../../assets/img/JSP-SVG.jsp"%>
						</div>
						<h3 class="mb-2 text-xl font-bold text-blazeOrange">JSP</h3>
						<p class="text-nickel">JSP é uma forma de implementar o
							conteúdo da página dinâmica do lado do servidor.</p>
					</div>
				</div>
			</div>
		</section>
		<section class="bg-blazeOrange rounded">
			<div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16 lg:px-6">
				<div class="max-w-screen-lg text-white sm:text-lg">
					<h2
						class="mb-4 text-4xl tracking-estatium font-extrabold text-white uppercase">Nosso
						objetivo</h2>
					<p class="mb-4 font-light">Nossa missão na Textil Tech é
						fornecer ferramentas eficazes e intuitivas que permitam às
						empresas do setor têxtil melhorar continuamente seus processos de
						produção, detectar e corrigir defeitos de maneira proativa e,
						assim, aumentar a satisfação e a confiança dos clientes. Nosso
						foco principal está na otimização da cadeia de suprimentos,
						garantindo eficiência e qualidade para sua empresa.</p>
				</div>
			</div>
		</section>
		<section>
			<div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16 lg:px-6">
				<div class="mx-auto max-w-screen-sm text-center mb-8 lg:mb-16">
					<h2
						class="mb-4 p-4 text-4xl tracking-estatium uppercase font-extrabold text-blazeOrange bg-white shadow-lg rounded-lg">
						Nosso time</h2>
				</div>
				<div class="grid gap-8 mb-6 lg:mb-16 md:grid-cols-2">
					<div
						class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange">
						<img
						src="https://media.licdn.com/dms/image/D4D03AQFqMWsbKO1ZBQ/profile-displayphoto-shrink_200_200/0/1722345969885?e=2147483647&v=beta&t=wgaGkJtDxHk66EfCyOFxQyJwkNCQVLihkPJKiAQhoJU"
						alt="Amabile Correa Baron Ferrari">
						<div class="p-5">
							<h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
								Amabile Correa Baron Ferrari</h3>
							<span class="text-blazeOrange">Líder</span>
							<p class="mt-3 mb-4 font-light text-nickel">Amabile lidera a
								equipe, garantindo a direção técnica e as iniciativas
								estratégicas da TextilTech.</p>
						</div>
					</div>
					<div
						class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange">
						<img class="w-64 rounded-lg sm:rounded-none sm:rounded-l-lg"
							src="https://media.licdn.com/dms/image/D4D03AQGxMxaXeyveIg/profile-displayphoto-shrink_200_200/0/1704750979851?e=2147483647&v=beta&t=b57Egcm90diTQzWj2DvRZYiYjG2HLBo86yDky7s9SHQ" alt="Pietra Cardoso Lenzi">
						<div class="p-5">
							<h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
								Pietra Cardoso Lenzi</h3>
							<span class="text-blazeOrange">Marketing</span>
							<p class="mt-3 mb-4 font-light text-nickel">Pietra desenvolve
								e implementa estratégias de marketing para fortalecer a
								TextilTech.</p>
						</div>
					</div>
					<div
						class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange mt-bottom">
						<img
							src="https://media.licdn.com/dms/image/D4D03AQGqNGKZNwM_Dw/profile-displayphoto-shrink_200_200/0/1722345238529?e=2147483647&v=beta&t=iX6zBPWAXQ_AS3O3BcgwG6WjVQdkCzYFmhYwHIfXZdc"
							alt="Pedro Henrique José">
						<div class="p-5">
							<h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
								Pedro Henrique José</h3>
							<span class="text-blazeOrange">Front-end</span>
							<p class="mt-3 mb-4 font-light text-nickel">Pedro Henrique é
								responsável pelo desenvolvimento front-end e pela experiência do
								usuário da TextilTech.</p>
						</div>
					</div>
					<div
						class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange mt-bottom">
						<img
							src="https://media.licdn.com/dms/image/D4D03AQHPogYqrvddIA/profile-displayphoto-shrink_200_200/0/1708396343398?e=2147483647&v=beta&t=wsOdnAqMwV1xJTndT0VEhnfnKiuB_zZe2jVYUpBHWAg"
							alt="Eduardo Hessmann Rohleder">
						<div class="p-5">
							<h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
								Eduardo Hessmann Rohleder</h3>
							<span class="text-blazeOrange">Back-end</span>
							<p class="mt-3 mb-4 font-light text-nickel">Eduardo lidera o
								desenvolvimento back-end e gerencia a infraestrutura técnica da
								TextilTech.</p>
						</div>
					</div>

				</div>
				<div
						class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange ml-left align-center mr-right mt-top">
						<img
							src="https://media.licdn.com/dms/image/D4D03AQFYsIcpRx7Wkg/profile-displayphoto-shrink_200_200/0/1722424862546?e=2147483647&v=beta&t=5zmmChia6XirFLrxNS3r7rQlpqdE0PAT9GC3KNBjOn0"
							alt="Gustavo Libório Estevão">
						<div class="p-5">
							<h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
								Gustavo Libório Estevão</h3>
							<span class="text-blazeOrange">Gustavo Libório Estevão</span>
							<p class="mt-3 mb-4 font-light text-nickel">Gustavo gerencia a
							arquitetura de banco de dados e as estratégias de gerenciamento
							de dados para a TextilTech.</p>
						</div>
				</div>
			</div>
		</section>
		<section class="bg-blazeOrange rounded">
			<div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16 lg:px-6">
				<div class="max-w-screen-lg text-white sm:text-lg">
				<style>
        .custom-list {
            list-style-type: none; /* Remove o estilo padrão das bolinhas */
            padding-left: 0; /* Remove o padding padrão */
        }

        .custom-list li {
            position: relative;
            padding-left: 1.5em; /* Espaço para a bolinha */
            margin-bottom: 0.5em; /* Espaço entre os itens */
        }

        .custom-list li::before {
            content: '\2022'; /* Unicode para a bolinha */
            position: absolute;
            left: 0;
            color: #FFFFFF; /* Cor da bolinha branca */
            font-size: 1.5em; /* Tamanho da bolinha, ajuste conforme necessário */
            line-height: 1em; /* Alinha a bolinha com o texto */
        }

        .custom-list .bold {
            font-weight: bold; /* Negrito para as palavras iniciais */
        }
    </style>
					<h2
						class="mb-4 text-4xl tracking-estatium font-extrabold text-white uppercase">Nossos
						valores</h2>
					<ol class="custom-list">
        <li><span class="bold">Inovação:</span> Comprometimento com a criação de soluções tecnológicas avançadas que atendam às necessidades em constante evolução da indústria têxtil;</li>
        <li><span class="bold">Qualidade:</span> Foco incessante na entrega de produtos e serviços que superem as expectativas dos clientes;</li>
        <li><span class="bold">Transparência:</span> Manter uma comunicação clara e honesta com nossos clientes, parceiros e colaboradores;</li>
        <li><span class="bold">Sustentabilidade:</span> Promover práticas que minimizem o impacto ambiental e contribuam para o desenvolvimento sustentável;</li>
        <li><span class="bold">Excelência no Atendimento:</span> Prover um suporte excepcional, garantindo que nossos clientes obtenham o máximo benefício de nossas soluções.</li>
    </ol>
				</div>
			</div>
		</section>
		<footer class="bg-white rounded-lg shadow m-4">
			<div
				class="w-full mx-auto max-w-screen-xl p-4 md:flex md:items-center md:justify-between">
				<span class="text-sm text-blazeOrange sm:text-center">Copyright
					&copy; 2024 | Textil Tech </span>
				<ul
					class="flex flex-wrap items-center mt-3 text-sm font-medium text-blazeOrange sm:mt-0">
					<li><a href="#sobre" class="hover:underline me-4 md:me-6">Sobre</a>
					</li>
					<li><a href="https://www.instagram.com/textiltechsa/"
						class="hover:underline">Instagram</a></li>
				</ul>
			</div>
		</footer>
	</div>
</body>

</html>