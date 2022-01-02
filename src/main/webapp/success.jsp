<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="includes/header.jsp"><c:param name="title" value="success"></c:param></c:import>
<a href="/SignInW-Session-Java/login?page=login" class="btn btn-secondary ms-3 mt-3">Go back</a>
<c:if test="${not empty sessionScope.email}">
	<a href="/SignInW-Session-Java/login?page=login&action=logout" class="btn btn-danger ms-3 mt-3">Logout</a>
</c:if>
<h1 class="text-center my-5">Success</h1>
<c:import url="includes/footer.jsp"></c:import>