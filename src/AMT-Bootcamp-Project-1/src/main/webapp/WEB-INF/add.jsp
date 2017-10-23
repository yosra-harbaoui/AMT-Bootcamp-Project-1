<%-- 
  - Author: Yosra Harbaoui
  - Date: October 2017
  - Description: page to add a new car with a specific features (brand, model and color)  
  --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>AMT Bootcamp • Add</title>
  <!-- Bootstrap core CSS-->
  <link href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="${pageContext.request.contextPath}/static/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/static/css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index">AMT Bootcamp</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="index">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Cars">
          <a class="nav-link" href="cars">
            <i class="fa fa-fw fa-table"></i>
            <span class="nav-link-text">Cars</span>
          </a>
        </li>                      
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Administration">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Administration</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="generate">Generate</a>
            </li>
          </ul>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">  
        <li class="nav-item">
            <c:choose>
              <c:when test = "${not empty sessionScope.session}">  
                <a class="nav-link" href="logout"><i class="fa fa-fw fa-sign-out"></i>Logout</a>
              </c:when>
              <c:otherwise>
                <a class="nav-link" href="login"><i class="fa fa-fw fa-sign-in"></i>Login</a>
              </c:otherwise>
            </c:choose>
        </li>
      </ul>         
    </div>
  </nav>

  <div class="content-wrapper">
    <div class="container-fluid">
      <div class="row">
        <div class="col-3"> 
            <h1>Add new car</h1>            
            <c:if test = "${not empty error}">
                <div class="alert alert-danger">
                    <strong>${error}</strong>
                </div>
            </c:if>
            <c:if test = "${not empty success}">
                <div class="alert alert-success">
                    <strong>${success}</strong>
                </div>
            </c:if>
            <form method="post" action="${pageContext.request.contextPath}/add">
                <input class="form-control" type="text" placeholder="Car brand" name="brand"><br>
                <input class="form-control" type="text" placeholder="Car model" name="model"><br>
                <input class="form-control" type="text" placeholder="Car color" name="color"><br>
                <input class="btn btn-primary pull-right" type="submit" value="Add">
            </form>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright Yosra © 2017</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
      
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/popper/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/static/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/static/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/datatables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/static/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="${pageContext.request.contextPath}/static/js/sb-admin-datatables.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/sb-admin-charts.min.js"></script>
  </div>
</body>

</html>