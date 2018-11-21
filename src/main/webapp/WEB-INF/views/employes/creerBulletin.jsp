<%@ include file="../../head.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>


	<h1>Créer un Bulletin de Salaire</h1>
	<!--   <p>Préfixe Matricule : ${prefixMatricule}</p>   -->


	<div class="form-group">
		<form:form method="post" modelAttribute="bulletin">



			<div class="form-group">
				<form:select path="periode.id" items="${liste_periode}"
					itemValue="id" itemLabel="DateDebutFin"></form:select>

			</div>

			<div class="form-group">
				<form:select path="remunerationEmploye.id"
					items="${liste_employes}" itemValue="id" itemLabel="matricule"></form:select>
			</div>


			<div class="form-group">
				<form:input path="primeExceptionnelle" id="primeExceptionnelle"></form:input>

			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-default" value="submit">
			</div>

		</form:form>
	</div>


</body>

<%@ include file="../../footer.jsp"%>
