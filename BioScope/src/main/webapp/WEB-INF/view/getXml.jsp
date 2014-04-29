<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<Movies>
<c:if test="${not empty lists}">
 
		<Movie>
			<c:forEach var="listValue" items="${lists}">
				<name>${listValue.movieName}</name>
			</c:forEach>
		</Movie>
 
	</c:if>
</Movie>
</Movies>