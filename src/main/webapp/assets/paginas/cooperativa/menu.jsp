<header>
	<nav>
		<div class="container-logo">
			<a class="item-logo" href="perfil-cooperativa">
				<svg class="imagem-eco2you">
		        	<%@include file="../../images/eCO2You.jsp"%>
		        </svg>
			</a>
		</div>
		<div class="container-menu">
			<div class="item-menu">
				<a href="retiradas-pendentes-cooperativa">
					<svg><%@include file="../../images/pendente.jsp"%></svg>Pendentes
				</a>
			</div>
			<div class="item-menu">
				<a href="historico-retiradas-cooperativa">
					<svg><%@include file="../../images/historico.jsp"%></svg>Hist�rico
				</a>
			</div>
			<div class="item-menu">
				<a href="procurar-armazem-cooperativa" id=procurarArmazem>
					<svg><%@include file="../../images/lupa.jsp"%></svg>Procurar Armaz�m
				</a>
			</div>
			<div class="item-menu">
				<a class="perfil" href="editar-perfil-cooperativa">
					<svg><%@include file="../../images/perfil.jsp"%></svg>Ol�, ${cooperativa.nome}
				</a>
			</div>
			<div class="item-menu">
				<a href="deslogar">
					<svg><%@include file="../../images/logout.jsp"%></svg>
				</a>
			</div>
		</div>
    </nav>
    <hr/>
</header>
