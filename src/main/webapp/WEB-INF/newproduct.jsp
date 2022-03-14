<%--
  Created by IntelliJ IDEA.
  User: plche
  Date: 11/03/22
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <title>New Product</title>
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row justify-content-center mt-4">
            <div class="col-3">
                <div class="row">
                    <div class="col-8">
                        <h1 class="text-primary mb-3">New Product</h1>
                    </div>
                </div>
                <form:form class="rounded border border-5 border-primary" action="/products/new" method="post" modelAttribute="newProduct">
                    <div class="row justify-content-center">
                        <div class="col-9">
                            <form:label for="name" path="name" class="form-label mt-3">Name:</form:label>
                            <form:errors path="name" cssClass="text-danger" />
                            <form:input type="text" class="form-control mb-3" id="name" path="name" aria-label="Product's name" />
                            <form:label for="description" path="description" class="form-label">Description:</form:label>
                            <form:errors path="description" cssClass="text-danger" />
                            <form:textarea cssClass="form-control mb-3" id="description" path="description" rows="3" aria-label="Product's description"></form:textarea>
                            <form:label for="price" path="price" class="form-label">Price:</form:label>
                            <form:errors path="price" cssClass="text-danger" />
                            <div class="col-4">
                                <form:input type="number" step="0.01" class="form-control mb-3" id="price" path="price" aria-label="Product's price"/>
                            </div>
                            <div class="d-flex justify-content-end">
                                <button type="submit" class="btn btn-primary mb-3">Create</button>
                            </div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
