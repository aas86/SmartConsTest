<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="v-bind" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css"
          href="../../resources/my.css"/>
    <link rel="stylesheet" type="text/css"
          href="../../resources/bootstrap.min.css"/>
    <script src="../../resources/vue.js"></script>

    <meta charset="UTF-8">
    <title>JSP</title>
</head>
<body>
<h1>Accounts</h1>
<div id="back-btn" class="container">
    <table class="tablet table table-striped table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>Account</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="accountList" scope="request" type="java.util.List"/>
        <c:forEach items="${accountList}" var="account">

            <tr>
                <td><span>${account.ownerName}</span></td>
                <td><span>${account.money}</span></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <div>
        <button type="button" @click="back" class="btn btn-primary" id="back">Back</button>
    </div>
</div>
<!--<script src="../../resources/jquery-3.2.1.js"></script>-->
<script src="../../resources/accounts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.17/dist/vue.js"></script>
<!--<script src="../../resources/vue.js"></script>-->
</body>
</html>