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
        <title>Category ${category.name}</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row justify-content-center mt-4">
            <div class="col-6">
                <h1>${category.name}</h1>
                <div class="row">
                    <div class="col">
                        <h2>Products:</h2>
                        <ul>
                            <c:forEach var="product" items="${category.products}">
                                <li><c:out value="${product.name}" /></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="col">
                        <form class="rounded border border-primary" action="/categories/${category.id}/products/add" method="post">
                            <div class="row justify-content-center">
                                <div class="col-9">
                                    <label for="productId" name="productId" class="form-label mt-3">Add Product:</label>
                                    <select class="form-select" path="products" id="productId">
                                        <c:forEach var="oneProduct" items="${productsCategoryNotIn}">
                                            <!--- Cada opción VALUE es el id del product --->
                                            <option value="${oneProduct.id}" name="productId">
                                                <!--- Esto es lo que se muestra al usuario como opción --->
                                                <c:out value="${oneProduct.name}" />
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
