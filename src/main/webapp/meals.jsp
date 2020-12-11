<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Meal overview"/>
</jsp:include>

<!-- Our overview jsp file shows the overview all meals -->
<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="persons"/>
</jsp:include>

<div class="container">
    <main>
       <!-- <a href="index.jsp"> Terug naar index</a>  -->
        <h1>Gerechten overview</h1>
        <c:choose>
            <c:when test="${not empty meals}">
                <table class="table table-striped">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Meal</th>
                        <th>Type</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Vegetarisch</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="meal" items="${meals}">
                        <tr>
                            <td class="productName">${meal.productName}</td>
                            <td class="typeName">${meal.typeName}</td>
                            <td>${meal.price}</td>
                            <td>${meal.description}</td>
                            <td>${meal.vegetarisch}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p id="empty">Er zijn geen maaltijden op het menu</p>
            </c:otherwise>
        </c:choose>
    </main>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>