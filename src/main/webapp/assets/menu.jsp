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
        function toggleDropdown(dropdownId) {
            // Get all dropdowns
            const dropdowns = document.querySelectorAll('.dropdown-menu');
            // Hide all dropdowns except the one that was clicked
            dropdowns.forEach(dropdown => {
                if (dropdown.id !== dropdownId) {
                    dropdown.classList.add('hidden');
                }
            });

            // Toggle the clicked dropdown
            const element = document.getElementById(dropdownId);
            if (element.classList.contains('hidden')) {
                element.classList.remove('hidden');
            } else {
                element.classList.add('hidden');
            }
        }
    </script>
    <!-- Custom Styles -->
    <style>
        .dropdown-menu a {
            border-left: 4px solid #133a59;
        }

        .dropdown-menu a:hover {
            background-color: #FFFFFF; /* Fundo branco ao passar o mouse */
            color: #133a59; /* Texto azul ao passar o mouse */
        }
    </style>
</head>
<body class="flex flex-col min-h-screen bg-orchidBlossom font-poppins">
  
    <!-- Sidebar -->
    <aside id="default-sidebar"
        class="fixed top-0 left-0 z-40 w-64 h-screen transition-transform -translate-x-full lg:translate-x-0 bg-white">
        <div class="overflow-y-auto py-5 px-3 h-full border-r border-white">
            <!-- Logo and Title -->
            <a href="home"
                class="flex items-center uppercase tracking-estatium p-0 text-2xl text-blazeOrange group">
                <%@include file="../../../assets/img/TextilTech-SVG.jsp"%>
                <span class="ml-0 font-extrabold">Textil Tech</span>
            </a>

            <!-- Sidebar Menu -->
            <ul class="pt-5 mt-5 space-y-2 border-t border-blazeOrange">
                <!-- Home Button -->
                <li>
                    <a href="home"
                        class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                        <%@include file="../../../assets/img/Inicio-SVG.jsp"%> 
                        <span class="ml-3">In�cio</span>
                    </a>
                </li>
                <!-- M�quinas Dropdown -->
                <li>
                    <button onclick="toggleDropdown('maquinasDropdown')"
                        class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group w-full">
                        <%@include file="../../../assets/img/Adicionar-Maquina-SVG.jsp"%> 
                        <span class="ml-3">M�quinas</span>
                    </button>
                    <ul id="maquinasDropdown" class="hidden mt-2 space-y-2 pl-4 dropdown-menu">
                        <li>
                            <a href="cadastro-maquina"
                                class="flex items-center p-2 text-base text-blazeOrange bg-peach hover:bg-white group transition duration-300">
                                <svg class="w-4 h-4" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <circle cx="12" cy="12" r="12" fill="#133a59" />
                                </svg>
                                <span class="ml-3 font-semibold">Adicionar M�quinas</span>
                            </a>
                        </li>
                        <li>
                            <a href="maquinas"
                                class="flex items-center p-2 text-base text-blazeOrange bg-peach hover:bg-white group transition duration-300">
                                <svg class="w-4 h-4" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <circle cx="12" cy="12" r="12" fill="#133a59" />
                                </svg>
                                <span class="ml-3 font-semibold">Visualizar M�quinas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- Normas Dropdown -->
                <li>
                    <button onclick="toggleDropdown('normasDropdown')"
                        class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group w-full">
                        <%@include file="../../../assets/img/Adicionar-Norma-SVG.jsp"%> 
                        <span class="ml-3">Normas</span>
                    </button>
                    <ul id="normasDropdown" class="hidden mt-2 space-y-2 pl-4 dropdown-menu">
                        <li>
                            <a href="cadastro-norma"
                                class="flex items-center p-2 text-base text-blazeOrange bg-peach hover:bg-white group transition duration-300">
                                <svg class="w-4 h-4" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <circle cx="12" cy="12" r="12" fill="#133a59" />
                                </svg>
                                <span class="ml-3 font-semibold">Adicionar Normas</span>
                            </a>
                        </li>
                        <li>
                            <a href="normas"
                                class="flex items-center p-2 text-base text-blazeOrange bg-peach hover:bg-white group transition duration-300">
                                <svg class="w-4 h-4" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <circle cx="12" cy="12" r="12" fill="#133a59" />
                                </svg>
                                <span class="ml-3 font-semibold">Visualizar Normas</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- Sair Button -->
                <li>
                    <a href="home"
                        class="flex items-center p-2 text-base text-blazeOrange border border-blazeOrange rounded-lg hover:border-white hover:bg-blazeOrange hover:text-white group">
                        <%@include file="../../../assets/img/Sair-SVG.jsp"%>
                        <span class="ml-3">Sair</span>
                    </a>
                </li>
            </ul>
        </div>
    </aside>
</body>
</html>
