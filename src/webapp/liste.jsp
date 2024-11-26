<html>
<body>
<h1>Liste des Annonces</h1>
<table>
    <tr>
        <th>Titre</th>
        <th>Prix</th>
        <th>Action</th>
    </tr>
    <c:forEach var="annonce" items="${annonces}">
        <tr>
            <td>${annonce.titre}</td>
            <td>${annonce.prix}</td>
            <td><a href="annonce-detail?id=${annonce.id}">Voir Détails</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
