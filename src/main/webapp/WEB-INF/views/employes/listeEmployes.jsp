


<%@ include file="../../head.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<body>

	<h1>Liste des Employés</h1>
								<a type="button" class="btn btn-success" href="creeremp">Ajouter un employé</a>
	<c:forEach var="employe" items="${liste_employes}">
		<li> <c:out value="${employe.pr}" />
		<c:out value="${employe.matricule}" />	<c:out
				value="${employe.grade.code}" /></li>
	</c:forEach>


</body>
<%@ include file="../../footer.jsp"%>
