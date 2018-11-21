<%@ include file="../../head.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>

<h1>Liste des Bulletin</h1>
													<a type="button" class="btn btn-success" href="creerbull">Ajouter un bulletin</a>
					

<c:forEach var="bulletin" items="${liste_bulletins}">
		<li> <c:out value="${bulletin.db}" /> 

		<c:out value="${bulletin.periode.dateDebutFin}"/>	
		<c:out value="${bulletin.remunerationEmploye.matricule}" />
	<!-- 			<c:out value="${calcul.salaireBrut}" />							 -->	

		</li>
	</c:forEach>



</body>

<%@ include file="../../footer.jsp"%>
