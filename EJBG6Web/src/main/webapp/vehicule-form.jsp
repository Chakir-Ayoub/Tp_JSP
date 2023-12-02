<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Vehicule Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Left Sidebar -->
            <nav class="col-md-2 d-none d-md-block bg-tomato sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                Vehicule App
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/list">
                                Vehicules List
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>

            <!-- Main Content -->
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <header>
                    <nav class="navbar navbar-expand-md navbar-dark bg-tomato">
                        <a href="#" class="navbar-brand"> Vehicule App </a>
                    </nav>
                </header>

                <div class="container col-md-5">
                    <div class="card">
                        <div class="card-body">
                            <c:if test="${vehicule != null}">
                                <form action="update" method="post">
                            </c:if>
                            <c:if test="${vehicule == null}">
                                <form action="insert" method="post">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${vehicule != null}">
                                        Edit Vehicule
                                    </c:if>
                                    <c:if test="${vehicule == null}">
                                        Add New Vehicule
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${vehicule != null}">
                                <input type="hidden" name="id" value="<c:out value='${vehicule.id}' />" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Vehicule Matricule</label> 
                                <input type="text" value="<c:out value='${vehicule.matricule}' />" class="form-control" name="matricule" required="required">
                            </fieldset>

                            <button type="submit" class="btn btn-success">Save</button>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
</body>
</html>
