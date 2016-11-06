<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Çağatay Han
  Date: 2.11.2016
  Time: 01:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management</title>
    <spring:url value="/resources/static/css/bootstrap.min.css" var="bootstrapResource"/>
    <spring:url value="/resources/static/css/main.css" var="mainResource"/>
    <spring:url value="/resources/static/js/jquery-3.1.1.min.js" var="jqueryResource"/>
    <spring:url value="/resources/static/js/bootstrap.min.js" var="bootstrapJsResource"/>
    <spring:url value="/resources/static/js/main.js" var="mainJs"/>
    <link media="screen" rel="stylesheet" href="${bootstrapResource}" type="text/css"/>
    <link media="screen" rel="stylesheet" href="${mainResource}" type="text/css"/>
    <script src="${jqueryResource}"></script>
    <script src="${bootstrapJsResource}"></script>
    <script src="${mainJs}"></script>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<script type="text/javascript">


</script>
<body>
<div class="container">
    <div class="page-header" id="banner">
        <div class="row">
            <div class="col-lg-8 col-md-7 col-sm-6">
                <h1>User Management</h1>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Phone</th>
                    </tr>
                    </thead>
                    <tbody class="tableBody">
                        <tr class="data-row">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
                                <div class="updateButton">
                                    <button class="btn btn-primary upButton" data-toggle="modal" data-target="#myModal">Update</button>
                                </div>
                            </td>
                            <td>
                                <div class="removeButton">
                                    <button class="btn btn-primary deleteButton" data-toggle="modal" data-target="#deleteModal">Remove</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <%--Delete Modal--%>
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    Are you sure want to remove this user ?
                </div>
            </div>
            <div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary modalDeleteButton"data-dismiss="modal">Delete</button>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <!-- Button trigger Add User Modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" onclick="$('#addModal').modal('show')">
        Add User
    </button>

    <!-- Add User Modal -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Add New User</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-9 col-md-7 col-sm-6">
                            <form id="addModalForm">
                                <fieldset>
                                    <div class="form-group">
                                        <label class="col-lg-5 control-label">Name:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control nameDataAdd" name="name" placeholder="Enter name"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-5 control-label">Surname:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control surnameDataAdd" name="surname" placeholder="Enter surname"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-5 control-label">Phone:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control phoneDataAdd" name="phone" placeholder="Enter phone"/>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                            <div class="col-lg-9">
                                <div class="g-recaptcha"
                                     data-sitekey="6Lem-QoUAAAAACnXT3P4v3b-5nBoTuQec_XNXbbi"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" form="addModalForm" class="btn btn-primary modalFormSubmit" onclick="$('#addModal').modal('hide')">Add</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Update User Modal -->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="updateModalLabel">Update User</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-9 col-md-7 col-sm-6">
                            <form id="updateModalForm">
                                <fieldset>
                                    <div class="form-group">
                                        <label class="col-lg-5 control-label">Name:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control nameData" name="name"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-5 control-label">Surname:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control surnameData" name="surname"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-5 control-label">Phone:</label>
                                        <div class="col-lg-9">
                                            <input type="text" class="form-control phoneData" name="phone"/>
                                        </div>
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" form="updateModalForm" class="btn btn-primary modalFormSubmit" onclick="$('#updateModal').modal('hide')">Update</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
