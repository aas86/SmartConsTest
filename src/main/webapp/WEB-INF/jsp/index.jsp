<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v-bind" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <!-- <link rel="stylesheet" type="text/css"
          href="../../resources/my.css"/>-->
    <link rel="stylesheet" type="text/css"
          href="../../resources/bootstrap.min.css"/>

    <meta charset="UTF-8">
    <title>JSP</title>
</head>

<body>
<div id="first-page" class="container">

    <h1>Clients</h1>
    <table class="tablet table table-striped table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>

        </thead>
        <tbody>
        <jsp:useBean id="clientList" scope="request" type="java.util.List"/>
        <c:forEach items="${clientList}" var="client">
            <tr>
                <td>${client.id}</td>
                <td>${client.name}</td>
                <td>
                    <button id type="button" class="btn btn-primary account-btn">Account</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form>
        <div>
            <label class="form-label">
                <span class="form-field">Name</span>
                <input type="text" class="form-control input-sm form-input" id="name"/>
            </label>
        </div>
        <div>
            <button type="button" class="btn btn-primary" id="addClient">Add</button>
        </div>

    </form>

</div>
<script src="../../resources/jquery-3.2.1.js"></script>
<script src="../../resources/index.js"></script>
</body>
</html>