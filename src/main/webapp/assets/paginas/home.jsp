<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Textil Tech | Tech Master</title>
    <link rel="icon" href="img/LogoTextil.png" type="image/x-icon" sizes="16x16">
    <style><%@include file="../../../assets/css/textilTech.css"%></style>
</head>

<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">
    <button data-drawer-target="default-sidebar" data-drawer-toggle="default-sidebar" type="button"
        class="inline-flex items-center p-2 mt-2 ml-3 text-sm text-blazeOrange rounded-lg lg:hidden">
        <span class="sr-only">Abrir</span>
        <svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
            <path clip-rule="evenodd" fill-rule="evenodd"
                d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z">
            </path>
        </svg>
    </button>
    <aside id="default-sidebar"
    class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full lg:translate-x-0 bg-white">
    <div class="overflow-y-auto py-5 px-3 h-full border-r border-white">
        <a href="textiltech-index.html"
           class="flex items-center uppercase tracking-estatium p-0 text-2xl text-blazeOrange group">
            <img src="img/LogoTextil.png" alt="Favicon" class="h-16 w-16 mr-20">
            <span class="ml-0 font-extrabold">Textil Tech</span>
        </a>

        <ul class="pt-5 mt-5 space-y-2 border-t border-blazeOrange">
            <li>
                <a href="home"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Inicio.png" alt="Início"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Início</span>
                </a>
            </li>
            <li>
                <a href="cadastro-maquina"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Maquinas.png" alt="Adicionar Máquinas"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Adicionar Máquinas</span>
                </a>
            </li>
            <li>
                <a href="maquinas"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Visualizar.png" alt="Visualizar Máquinas"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Visualizar Máquinas</span>
                </a>
            </li>
            <li>
                <a href="cadastro-norma"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Normas.png" alt="Adicionar Normas"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Adicionar Normas</span>
                </a>
            </li>
            <li>
                <a href="normas"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <img src="img/Visualizar.png" alt="Visualizar Normas"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                    <span class="ml-3">Visualizar Normas</span>
                </a>
            </li>
            <li>
                <a href="home"
                    class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor"
                        class="w-6 h-6 text-blazeOrange transition duration-75">
                        <path fill-rule="evenodd"
                            d="M7.5 3.75A1.5 1.5 0 0 0 6 5.25v13.5a1.5 1.5 0 0 0 1.5 1.5h6a1.5 1.5 0 0 0 1.5-1.5V15a.75.75 0 0 1 1.5 0v3.75a3 3 0 0 1-3 3h-6a3 3 0 0 1-3-3V5.25a3 3 0 0 1 3-3h6a3 3 0 0 1 3 3V9A.75.75 0 0 1 15 9V5.25a1.5 1.5 0 0 0-1.5-1.5h-6Zm5.03 4.72a.75.75 0 0 1 0 1.06l-1.72 1.72h10.94a.75.75 0 0 1 0 1.5H10.81l1.72 1.72a.75.75 0 1 1-1.06 1.06l-3-3a.75.75 0 0 1 0-1.06l3-3a.75.75 0 0 1 1.06 0Z"
                            clip-rule="evenodd" />
                    </svg>
                    <span class="ml-3">Sair</span>
                </a>
            </li>
        </ul>
    </div>
</aside>

    <div id="content-wrapper" class="flex-1 p-6 ml-0 lg:ml-64 transition-margin duration-300 ease-in-out">
        <main class="flex-1 p-6">
            <section id="sobre" class="bg-white border-4 rounded border-blazeOrange">
                <div
                    class="gap-16 items-center py-8 px-4 mx-auto max-w-screen-xl lg:grid lg:grid-cols-2 lg:py-16 lg:px-6">
                    <div class="font-light text-nickel sm:text-lg">
                        <h2 class="mb-4 text-4xl tracking-estatium font-extrabold uppercase text-blazeOrange">
                            Sobre
                            nós</h2>
                        <p class="mb-4">A Textil Tech foi criada para otimizar a cadeia de suprimentos de empresas, garantindo o controle de qualidade dos produtos. Nosso objetivo é tornar sua empresa um ambiente melhor e mais propício para a excelência.<br><br>Oferecemos soluções para adicionar, atualizar, deletar produtos e monitorar o desempenho geral e de produtos específicos. Além disso, nosso sistema informa a última data de inspeção de cada produto, gerenciando as próximas inspeções necessárias.</p>
                    </div>
                    <div class="grid grid-cols-2 gap-4 mt-8">
                        <img class="w-full rounded-lg"
                            src="https://flowbite.s3.amazonaws.com/blocks/marketing-ui/content/office-long-2.png"
                            alt="office content 1">
                        <img class="mt-4 w-full lg:mt-10 rounded-lg"
                            src="https://flowbite.s3.amazonaws.com/blocks/marketing-ui/content/office-long-1.png"
                            alt="office content 2">
                    </div>
                </div>
            </section>
            <section>
                <div class="py-8 px-4 mx-auto max-w-screen-xl sm:py-16 lg:px-6">
                    <div class="max-w-screen-md mb-8 lg:mb-16">
                        <h2 class="mb-4 text-4xl tracking-estatium font-extrabold uppercase text-blazeOrange">Linguagens
                            de
                            programação</h2>
                        <p class="text-nickel sm:text-xl">Na Textil Tech, exploramos as linguagens de programação essenciais que impulsionam a criação de soluções digitais inovadoras.<br><br>Desde a estruturação básica com HTML até a interatividade dinâmica com JavaScript, cada linguagem desempenha um papel crucial na construção de experiências web robustas e funcionais. Nosso foco principal está na otimização da cadeia de suprimentos, garantindo eficiência e qualidade para sua empresa.</p>
                    </div>
                    <div class="space-y-8 md:grid md:grid-cols-2 lg:grid-cols-3 md:gap-12 md:space-y-0">
                        <div>
                            <div
                                class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeOrange lg:h-12 lg:w-12">
                                <img class="w-6 h-6 lg:w-8 lg:h-8 invert" src="img/estatium-html5.svg" alt="HTML">
                            </div>
                            <h3 class="mb-2 text-xl font-bold text-blazeOrange">HTML</h3>
                            <p class="text-nickel">HTML permite definir a estrutura básica de uma página, incluindo
                                elementos como texto, imagens e links.</p>
                        </div>
                        <div>
                            <div
                                class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeOrange lg:h-12 lg:w-12">
                                <img class="w-6 h-6 lg:w-8 lg:h-8 invert" src="img/estatium-css3.svg" alt="CSS">
                            </div>
                            <h3 class="mb-2 text-xl font-bold text-blazeOrange">CSS</h3>
                            <p class="text-nickel">CSS é usado para controlar o layout, as cores e os estilos de
                                todos os elementos HTML em um site.</p>
                        </div>
                        <div>
                            <div
                                class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeOrange lg:h-12 lg:w-12">
                                <img class="w-6 h-6 lg:w-8 lg:h-8 invert" src="img/estatium-js.svg" alt="JavaScript">
                            </div>
                            <h3 class="mb-2 text-xl font-bold text-blazeOrange">JavaScript</h3>
                            <p class="text-nickel">JavaScript permite criar funcionalidades avançadas, como
                                animações, validações de formulários e atualizações de conteúdo em tempo real.</p>
                        </div>
                        <div>
                            <div
                                class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeOrange lg:h-12 lg:w-12">
                                <img class="w-6 h-6 lg:w-8 lg:h-8 invert" src="img/estatium-java.svg" alt="Java">
                            </div>
                            <h3 class="mb-2 text-xl font-bold text-blazeOrange">Java</h3>
                            <p class="text-nickel">Java é amplamente utilizado em aplicativos corporativos, desde
                                sistemas financeiros até aplicativos móveis.</p>
                        </div>
                        <div>
                            <div
                                class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeOrange lg:h-12 lg:w-12">
                                <img class="w-6 h-6 lg:w-8 lg:h-8 invert" src="img/estatium-sql.svg" alt="SQL">
                            </div>
                            <h3 class="mb-2 text-xl font-bold text-blazeOrange">SQL</h3>
                            <p class="text-nickel">SQL é essencial para consultas complexas, inserções de dados e
                                operações de atualização em bancos de dados..</p>
                        </div>
                        <div>
                            <div
                                class="flex justify-center items-center mb-4 w-10 h-10 rounded-full bg-blazeOrange lg:h-12 lg:w-12">
                                <img class="w-6 h-6 lg:w-8 lg:h-8 invert" src="img/estatium-jsp.svg" alt="JSP">
                            </div>
                            <h3 class="mb-2 text-xl font-bold text-blazeOrange">JSP</h3>
                            <p class="text-nickel">JSP é uma forma de implementar o conteúdo da página dinâmica do lado
                                do servidor.</p>
                        </div>
                    </div>
                </div>
            </section>
            <section class="bg-blazeOrange rounded">
                <div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16 lg:px-6">
                    <div class="max-w-screen-lg text-white sm:text-lg">
                        <h2 class="mb-4 text-4xl tracking-estatium font-extrabold text-white uppercase">Nosso objetivo
                        </h2>
                        <p class="mb-4 font-light">
                            Nossa missão na Textil Tech é fornecer ferramentas eficazes e intuitivas que permitam às empresas do setor têxtil melhorar continuamente seus processos de produção, detectar e corrigir defeitos de maneira proativa e, assim, aumentar a satisfação e a confiança dos clientes. Nosso foco principal está na otimização da cadeia de suprimentos, garantindo eficiência e qualidade para sua empresa.
                        </p>
                    </div>
                </div>
            </section>
            <section>
                <div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16 lg:px-6">
                    <div class="mx-auto max-w-screen-sm text-center mb-8 lg:mb-16">
                        <h2
                            class="mb-4 p-4 text-4xl tracking-estatium uppercase font-extrabold text-blazeOrange bg-white shadow-lg rounded-lg">
                            Nosso time
                        </h2>
                    </div>
                    <div class="grid gap-8 mb-6 lg:mb-16 md:grid-cols-2">
                        <div class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange">
                            <img class="w-64 rounded-lg sm:rounded-none sm:rounded-l-lg" src="img/estatium-henrique.png" alt="Líder">
                            <div class="p-5">
                                <h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
                                    Amabile Correa Baron Ferrari
                                </h3>
                                <span class="text-blazeOrange">Líder</span>
                                <p class="mt-3 mb-4 font-light text-nickel">Amabile lidera a equipe, garantindo a direção técnica e as iniciativas estratégicas da TextilTech.</p>
                            </div>
                        </div>
                        <div class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange">
                            <img class="w-64 rounded-lg sm:rounded-none sm:rounded-l-lg" src="img/estatium-miguel.png" alt="Marketing">
                            <div class="p-5">
                                <h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
                                    Pietra Cardoso Lenzi
                                </h3>
                                <span class="text-blazeOrange">Marketing</span>
                                <p class="mt-3 mb-4 font-light text-nickel">Pietra desenvolve e implementa estratégias de marketing para fortalecer a TextilTech.</p>
                            </div>
                        </div>
                        <div class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange">
                            <img class="w-64 rounded-lg sm:rounded-none sm:rounded-l-lg" src="img/estatium-enzo.png" alt="Front-end">
                            <div class="p-5">
                                <h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
                                    Pedro Henrique José
                                </h3>
                                <span class="text-blazeOrange">Front-end</span>
                                <p class="mt-3 mb-4 font-light text-nickel">Pedro Henrique é responsável pelo desenvolvimento front-end e pela experiência do usuário da TextilTech.</p>
                            </div>
                        </div>
                        <div class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange">
                            <img class="w-64 rounded-lg sm:rounded-none sm:rounded-l-lg" src="img/estatium-mick.png" alt="Back-end">
                            <div class="p-5">
                                <h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
                                    Eduardo Hessmann
                                </h3>
                                <span class="text-blazeOrange">Back-end</span>
                                <p class="mt-3 mb-4 font-light text-nickel">Eduardo lidera o desenvolvimento back-end e gerencia a infraestrutura técnica da TextilTech.</p>
                            </div>
                        </div>
                        <div class="items-center bg-white rounded-lg shadow-lg sm:flex border-4 border-blazeOrange">
                            <img class="w-64 rounded-lg sm:rounded-none sm:rounded-l-lg" src="img/estatium-kaht.png" alt="Banco de dados">
                            <div class="p-5">
                                <h3 class="text-xl font-bold tracking-estatium text-blazeOrange">
                                    Gustavo Libório Estevão
                                </h3>
                                <span class="text-blazeOrange">Banco de dados</span>
                                <p class="mt-3 mb-4 font-light text-nickel">Gustavo gerencia a arquitetura de banco de dados e as estratégias de gerenciamento de dados para a TextilTech.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="bg-blazeOrange rounded">
                <div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16 lg:px-6">
                    <div class="max-w-screen-lg text-white sm:text-lg">
                        <h2 class="mb-4 text-4xl tracking-estatium font-extrabold text-white uppercase">Nossos valores
                        </h2>
                        <ol class="mb-4 font-light">
                            <li>Inovação: Comprometimento com a criação de soluções tecnológicas avançadas que atendam às necessidades em constante evolução da indústria têxtil;<br></li><br>
                            <li>Qualidade: Foco incessante na entrega de produtos e serviços que superem as expectativas dos clientes;<br></li><br>
                            <li>Transparência: Manter uma comunicação clara e honesta com nossos clientes, parceiros e colaboradores;<br></li><br>
                            <li>Sustentabilidade: Promover práticas que minimizem o impacto ambiental e contribuam para o desenvolvimento sustentável;<br></li><br>
                            <li>Excelência no Atendimento: Prover um suporte excepcional, garantindo que nossos clientes obtenham o máximo benefício de nossas soluções.</li>
                          </ol>
                    </div>
                </div>
            </section>
        </main>
        <footer class="bg-white rounded-lg shadow m-4">
            <div class="w-full mx-auto max-w-screen-xl p-4 md:flex md:items-center md:justify-between">
                <span class="text-sm text-blazeOrange sm:text-center">Copyright &copy; 2024 | Textil Tech
                </span>
                <ul class="flex flex-wrap items-center mt-3 text-sm font-medium text-blazeOrange sm:mt-0">
                    <li>
                        <a href="#sobre" class="hover:underline me-4 md:me-6">Sobre</a>
                    </li>
                    <li>
                        <a href="https://www.instagram.com/textiltechsa/"
                            class="hover:underline">Instagram</a>
                    </li>
                </ul>
            </div>
        </footer>
    </div>
    <script src="js/estatium.js"></script>
</body>

</html>