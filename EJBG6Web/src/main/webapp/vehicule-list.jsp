<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Vehicule App</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <style>
        body {
            background-color: #f2f2f2;
            font-family: 'Arial', sans-serif;
            display: flex;
        }

        #sidebar {
            background-color: #00d1b2;
            padding: 1rem;
            width: 200px;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            color: #ffffff;
        }

        header {
            background-color: #00d1b2;
            padding: 1rem;
            width: 100%;
        }

        header a.navbar-brand {
            color: #ffffff;
            font-size: 1.8rem;
        }

        header ul.navbar-nav {
            margin-top: 15px;
        }

        header ul.navbar-nav li {
            margin-bottom: 5px;
        }

        .container {
            margin-top: 30px;
            flex: 1;
            padding: 20px;
        }

        table.table {
            width: 100%;
            border-collapse: collapse;
            background-color: #000 !important; /* Set the background color to black */
            color: #ffffff; /* Set the text color to white */
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        table.table th, table.table td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #444;
        }

        table.table th {
            background-color: #3273dc;
            color: #ffffff;
            border-bottom: 2px solid #444;
        }

        .btn-success {
            background-color: #23d160;
            border-color: #23d160;
        }

        .btn-success:hover {
            background-color: #20bd56;
            border-color: #20bd56;
        }

        a.edit-link, a.delete-link {
            color: #3273dc;
            text-decoration: none;
            margin-right: 10px;
        }

        a.edit-link:hover, a.delete-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div id="sidebar">
        <header>
            <a href="#" class="navbar-brand">Vehicule App</a>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list" class="navbar-item">List Vehicules</a></li>
            </ul>
        </header>
    </div>

    <div class="container">
        <h3 class="title is-3 has-text-centered">List of Vehicules</h3>
        <div class="field is-grouped is-grouped-centered">
            <p class="control">
                <a href="<%=request.getContextPath()%>/new" class="button is-success">Add Vehicule</a>
            </p>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Matricule</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vehicle" items="${listVehicule}">
                    <tr>
                        <td><c:out value="${vehicle.id}" /></td>
                        <td><c:out value="${vehicle.matricule}" /></td>
                        <td>
                            <a href="edit?id=<c:out value='${vehicle.id}' />" class="edit-link">Edit</a>
                            <a href="delete?id=<c:out value='${vehicle.id}' />" class="delete-link">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
