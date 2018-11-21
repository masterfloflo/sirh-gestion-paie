<%@ include file="../../head.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>

	<h1>Cr�er Employe</h1>
	<p>Pr�fixe Matricule : ${prefixMatricule}</p>


	<div class="form-group">
		<form:form method="post" modelAttribute="employe">


			<form:input path="matricule" id="matricule"></form:input>
			
			<!-- n�cessite de red�finir la m�thode toString() de l'entit� Entreprise pour contr�ler l'affichage -->
						<!-- ici c'est la propri�t� `denomination` de chaque entreprise qui sera affich� � l'utilisateur -->
			<div class="form-group">
				<form:select path="entreprise.id" items="${liste_entreprise}"
					itemValue="id" itemLabel="denomination"></form:select>
			</div>


			<div class="form-group">
				<form:select path="profilRemuneration.id" items="${liste_profil_remuneration}" itemValue="id"
					itemLabel="code"></form:select>
			</div>

			<div class="form-group">
				<form:select path="grade.id" items="${liste_grade}" itemValue="id"
					itemLabel="code"></form:select>
			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-default" value= "submit">
			</div>

		</form:form>
	</div>

</body>
<%@ include file="../../footer.jsp"%>
