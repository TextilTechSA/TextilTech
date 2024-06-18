<header>
	<nav>
		<div class="container-logo">
			<a class="item-logo" href="perfil-armazem">
				<svg class="imagem-eco2you">
		        	<%@include file="../../images/eCO2You.jsp"%>
		        </svg>
			</a>
		</div>
		<div class="container-menu">
			<div class="item-menu">
				<a  href="depositos-pendentes-armazem">
					<svg><%@include file="../../images/pendente.jsp"%></svg>Depositos Pendentes
				</a>
			</div>
			<div class="item-menu">
				<a href="historico-depositos-armazem">
					<svg><%@include file="../../images/historico.jsp"%></svg>Histórico Depositos
				</a>
			</div>
			<div class="item-menu">
				<a  href="retiradas-pendentes-armazem">
					<svg><%@include file="../../images/pendente.jsp"%></svg>Retiradas Pendentes
				</a>
			</div>
			<div class="item-menu">
				<a href="historico-retiradas-armazem">
					<svg><%@include file="../../images/historico.jsp"%></svg>Histórico Retiradas
				</a>
			</div>
			<div class="item-menu">
				<a class="perfil" href="editar-perfil-armazem">
					<svg><%@include file="../../images/perfil.jsp"%></svg> Olá ${armazem.nome}
				</a>
			</div>
			<div class="item-menu">
				<a class="item-menu" href="deslogar">
					<svg><%@include file="../../images/logout.jsp"%></svg>
				</a>
			</div>
		</div>
    </nav>
    <hr/>
</header>