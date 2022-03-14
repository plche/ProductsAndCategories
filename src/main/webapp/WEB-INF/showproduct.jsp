<%--
  Created by IntelliJ IDEA.
  User: plche
  Date: 11/03/22
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Product ${product.name}</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row justify-content-center mt-4">
            <div class="col-6">
                <h1>${product.name}</h1>
                <div class="row">
                    <div class="col">
                        <h2>Categories:</h2>
                        <ul>
                            <c:forEach var="category" items="${product.categories}">
                                <li><c:out value="${category.name}" /></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col">
                        <form class="rounded border border-primary" action="/products/${product.id}/categories/add" method="post">
                            <div class="row justify-content-center">
                                <div class="col-9">
                                    <label for="categoryId" name="categoryId" class="form-label mt-3">Add Category:</label>
                                    <select class="form-select" name="categoryId" id="categoryId">
                                        <c:forEach var="oneCategory" items="${categoriesProductNotIn}">
                                            <!--- Cada opción VALUE es el id del category --->
                                            <option value="${oneCategory.id}" name="categoryId">
                                                <!--- Esto es lo que se muestra al usuario como opción --->
                                                <c:out value="${oneCategory.name}" />
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <div class="d-flex justify-content-end">
                                        <button type="submit" class="btn btn-primary my-3">Add</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
